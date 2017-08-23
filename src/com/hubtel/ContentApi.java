package com.hubtel;

import java.io.File;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.UUID;


/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class ContentApi extends AbstractApi {

    public ContentApi(ApiHost apiHost) {
        super(apiHost);
    }

    /**
     * Fetches a paginated list of content medias with additional query string
     * parameters as filters.
     *
     * @param page The page number
     * @param pageSize The number of items on a page
     * @return ApiList<ContentLibrary> list of ContentLibrary
     * @throws HttpRequestException
     */
    public ApiList<ContentLibrary> getContentLibraries(int page, int pageSize) throws HttpRequestException {
        String resource = "/libraries/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }

        if (page <= 0 && pageSize <= 0) {
            params = null;
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<ContentLibrary>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ApiList<ContentLibrary> getContentLibraries() throws HttpRequestException {
        return getContentLibraries(-1, -1);
    }

    /**
     * Gets a content library
     *
     * @param libraryId The content library Id
     * @return ContentLibrary
     * @throws HttpRequestException
     */
    public ContentLibrary getContentLibrary(UUID libraryId) throws HttpRequestException {
        String resource = "/libraries/";
        resource += libraryId.toString().replace("-", "");
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Gets a content library
     *
     * @param libraryId The content library Id
     * @return ContentLibrary
     * @throws HttpRequestException
     */
    public ContentLibrary getContentLibrary(String libraryId) throws HttpRequestException {
        String resource = "/libraries/";
        if (libraryId == null) {
            throw new HttpRequestException(new NullPointerException("libraryId"));
        }

        resource += libraryId.replace("-", "");
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Creates a new content library
     *
     * @param library The ContentLibrary object.
     * @return ContentLibary
     * @throws HttpRequestException
     */
    public ContentLibrary addContentLibrary(ContentLibrary library) throws HttpRequestException {
        String resource = "/libraries/";
        String contentType = "application/json";
        if (library == null) {
            throw new HttpRequestException(new NullPointerException("library"));
        }
        HttpResponse response = this.httpClient.post(resource, contentType, library.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Creates a new content library (recommended way to creates a content
     * library)
     *
     * @param name The content library name
     * @param shortName The content library shortName
     * @return ContentLibrary
     * @throws HttpRequestException
     */
    public ContentLibrary addContentLibrary(String name, String shortName) throws HttpRequestException {
        final String resource = "/libraries/";
        if (name == null || shortName == null) {
            throw new HttpRequestException(new NullPointerException("Parameter 'name' and 'shortName' cannot be null."));
        }
        ParameterMap params = this.httpClient.newParams();
        params.add("Name", name).add("ShortName", shortName);
        HttpResponse response = this.httpClient.post(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ContentLibrary addContentLibrary(ParameterMap params) throws HttpRequestException {
        final String resource = "/libraries/";
        if (params == null) {
            throw new HttpRequestException(new NullPointerException("Parameter 'params' cannot be null."));
        }
        HttpResponse response = this.httpClient.post(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates a content library
     *
     * @param libraryId The content library
     * @param params The updated data
     * @return ContentLibrary
     * @throws HttpRequestException
     */
    public ContentLibrary updateContentLibrary(UUID libraryId, ParameterMap params) throws HttpRequestException {
        String resource = "/libraries/";
        if (params == null) {
            throw new HttpRequestException(new NullPointerException("Parameter 'params' cannot be null."));
        }
        resource += libraryId.toString().replace("-", "");
        HttpResponse response = this.httpClient.put(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates a content library
     *
     * @param libraryId The content library
     * @param params The updated data
     * @return ContentLibrary
     * @throws HttpRequestException
     */
    public ContentLibrary updateContentLibrary(String libraryId, ParameterMap params) throws HttpRequestException {
        String resource = "/libraries/";
        if (libraryId == null) {
            throw new HttpRequestException(new NullPointerException("libraryId"));
        }
        resource += libraryId.replace("-", "");
        HttpResponse response = this.httpClient.put(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates a content library(This is the recommended way to update a content
     * library)
     *
     * @param libraryId The content library
     * @param name The new content library name
     * @param shortName The new content library shortName
     * @return ContentLibrary
     * @throws HttpRequestException
     */
    public ContentLibrary updateContentLibrary(String libraryId, String name, String shortName) throws HttpRequestException {
        String resource = "/libraries/";
        if (libraryId == null) {
            throw new HttpRequestException(new NullPointerException("libraryId"));
        }
        resource += libraryId.replace("-", "");
        ParameterMap params = this.httpClient.newParams();
        params.add("Name", name).add("ShortName", shortName);
        HttpResponse response = this.httpClient.put(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentLibrary(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes a content library
     *
     * @param libraryId The content library Id
     * @return boolean
     * @throws HttpRequestException
     */
    public boolean deleteContentLibrary(UUID libraryId) throws HttpRequestException {
        String resource = "/libraries/";
        resource += libraryId.toString().replace("-", "");
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes a content library
     *
     * @param libraryId The content library Id
     * @return boolean
     * @throws HttpRequestException
     */
    public boolean deleteContentLibrary(String libraryId) throws HttpRequestException {
        String resource = "/libraries/";
        if (libraryId == null) {
            throw new HttpRequestException(new NullPointerException("libraryId"));
        }
        resource += libraryId.replace("-", "");
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Fetches a paginated list of content folders
     *
     * @param page The page number
     * @param pageSize The number of items on a page.
     * @return ApiList<ContentFolder> ContentFolder list
     * @throws HttpRequestException
     */
    public ApiList<ContentFolder> getContentFolders(int page, int pageSize) throws HttpRequestException {
        final String resource = "/folders/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }

        if (page <= 0 && pageSize <= 0) {
            params = null;
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<ContentFolder>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ApiList<ContentFolder> getContentFolders() throws HttpRequestException {
        return getContentFolders(-1, -1);
    }

    /**
     * Get a content folder
     *
     * @param folderId The content folder id
     * @return ContentFolder
     * @throws HttpRequestException
     */
    public ContentFolder getContentFolder(long folderId) throws HttpRequestException {
        String resource = "/folders/" + folderId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentFolder(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Creates a new content folder
     *
     * @param folderName The content folder name
     * @param libraryId The content library Id
     * @param parentFolder The content parent folder
     * @return ContentFolder
     * @throws HttpRequestException
     */
    public ContentFolder addContentFolder(String folderName, UUID libraryId, String parentFolder) throws HttpRequestException {
        final String resource = "/folders/";
        if (folderName == null) {
            throw new HttpRequestException(new Exception("Parameter 'folderName' cannot be null."));
        } else if (folderName.length() == 0) {
            throw new HttpRequestException(new Exception("Parameter 'folderName' cannot be null."));
        } else if (!CommonValidator.checkFilename(folderName, false)) {
            throw new HttpRequestException(new Exception("Parameter 'folderName' must be valid folder name."));
        }

        if (parentFolder != null && parentFolder.length() > 0) {
            if (!CommonValidator.checkNumeric(parentFolder) && !CommonValidator.checkFilename(parentFolder, false)) {
                throw new HttpRequestException(new Exception("Parameter 'parentFolder' must be valid folder name."));
            }
        }

        ParameterMap params = this.httpClient.newParams();
        params.add("FolderName", folderName).add("LibraryId", libraryId.toString()).add("Parent", parentFolder);
        HttpResponse response = this.httpClient.post(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContentFolder(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ContentFolder addContentFolder(String folderName, String libraryId, String parentFolder) throws HttpRequestException {
        final String resource = "/folders/";
        if (folderName == null) {
            throw new HttpRequestException(new Exception("Parameter 'folderName' cannot be null."));
        } else if (folderName.length() == 0) {
            throw new HttpRequestException(new Exception("Parameter 'folderName' cannot be null."));
        } else if (!CommonValidator.checkFilename(folderName, false)) {
            throw new HttpRequestException(new Exception("Parameter 'folderName' must be valid folder name."));
        }

        if (libraryId == null) {
            throw new HttpRequestException(new NullPointerException("libraryId"));
        }

        if (parentFolder != null && parentFolder.length() > 0) {
            if (!CommonValidator.checkNumeric(parentFolder) && !CommonValidator.checkFilename(parentFolder, false)) {
                throw new HttpRequestException(new Exception("Parameter 'parentFolder' must be valid folder name."));
            }
        }

        ParameterMap params = this.httpClient.newParams();
        params.add("FolderName", folderName).add("LibraryId", libraryId).add("Parent", parentFolder);
        HttpResponse response = this.httpClient.post(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContentFolder(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates a content folder
     *
     * @param folderId The content folder id
     * @param folderName The new content folder name
     * @param libraryId The new content library Id
     * @param parentFolder he new content parent folder
     * @return ContentFolder
     * @throws HttpRequestException
     */
    public ContentFolder updateContentFolder(long folderId, String folderName, String libraryId, String parentFolder) throws HttpRequestException {
        String resource = "/folders/" + folderId;

        if (folderName != null && folderName.length() > 0 && !CommonValidator.checkFilename(folderName, false)) {
            throw new HttpRequestException(new Exception("Parameter 'folderName' must be valid folder name."));
        }

        if (parentFolder != null && parentFolder.length() > 0) {
            if (!CommonValidator.checkNumeric(parentFolder) && !CommonValidator.checkFilename(parentFolder, false)) {
                throw new HttpRequestException(new Exception("Parameter 'parentFolder' must be valid folder name."));
            }
        }

        ParameterMap params = this.httpClient.newParams();
        params.add("FolderName", folderName).add("LibraryId", libraryId != null ? libraryId.toString() : "").add("Parent", parentFolder);
        HttpResponse response = this.httpClient.put(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentFolder(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes a content folder
     *
     * @param folderId The content folder id
     * @return boolean
     * @throws HttpRequestException
     */
    public boolean deleteContentFolder(long folderId) throws HttpRequestException {
        String resource = "/folders/" + folderId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Fetches a paginated list of content medias with additional query string
     * parameters as filters.
     *
     * @param page The page number
     * @param pageSize The number of items on a page
     * @param filters additional query string parameters
     * @return ApiList<ContentMedia> list of ContentMedia
     * @throws HttpRequestException
     */
    public ApiList<ContentMedia> getContentMedias(int page, int pageSize, Map<String, String> filters) throws HttpRequestException {
        final String resource = "/media/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }

        if (filters != null && !filters.isEmpty()) {
            for (Map.Entry<String, String> map : filters.entrySet()) {
                params.add(map.getKey(), map.getValue());
            }
        }

        if (page <= 0 && pageSize <= 0 && filters == null) {
            params = null;
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<ContentMedia>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ApiList<ContentMedia> getContentMedias() throws HttpRequestException {
        return getContentMedias(-1, -1, null);
    }

    public ApiList<ContentMedia> getContentMedias(Map<String, String> filters) throws HttpRequestException {
        return getContentMedias(-1, -1, filters);
    }

    /**
     * Gets a content media by ID
     *
     * @param contentMediaId The content media ID
     * @return ContentMedia
     * @throws HttpRequestException
     */
    public ContentMedia getContentMedia(UUID contentMediaId) throws HttpRequestException {
        String resource = "/media/" + contentMediaId.toString().replace("-", "");
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentMedia(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ContentMedia getContentMedia(String contentMediaId) throws HttpRequestException {
        String resource = "/media/";
        if (contentMediaId == null) {
            throw new HttpRequestException(new NullPointerException("contentMediaId"));
        }

        resource += contentMediaId.replace("-", "");
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentMedia(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Uploads a new content media
     *
     * @param filePath The content media file
     * @param mediaInfo The content media metadata
     * @return ContentMedia newly created content media
     * @throws HttpRequestException
     */
    public ContentMedia addContentMedia(String filePath, MediaInfo mediaInfo) throws HttpRequestException {
        final String resource = "/media/";
        if (mediaInfo == null) {
            throw new HttpRequestException(new Exception("Parameter 'mediaInfo' cannot be null."));
        }
        ParameterMap params = this.httpClient.newParams();
        params.add("ContentName", mediaInfo.getContentName())
                .add("LibraryId", mediaInfo.getLibraryId().toString())
                .add("DestinationFolder", mediaInfo.getDestinationFolder() != null && mediaInfo.getDestinationFolder().length() > 0 ? mediaInfo.getDestinationFolder() : "")
                .add("Preference", mediaInfo.getPreference())
                .add("Width", String.valueOf(mediaInfo.getWidth()))
                .add("Height", String.valueOf(mediaInfo.getHeight()))
                .add("DrmProtect", mediaInfo.isDrmProtect() ? "true" : "false")
                .add("Streamable", mediaInfo.isStreamable() ? "true" : "false")
                .add("DisplayText", (mediaInfo.getDisplayText() != null && mediaInfo.getDisplayText().length() > 0) ? mediaInfo.getDisplayText() : "")
                .add("ContentText", (mediaInfo.getContentText() != null && mediaInfo.getContentText().length() > 0) ? mediaInfo.getContentText() : "");

        if (mediaInfo.getTags() != null && !mediaInfo.getTags().isEmpty()) {
            JsonObject json = new JsonObject();
            for (Map.Entry<String, String> map : mediaInfo.getTags().entrySet()) {
                json.add(map.getKey(), map.getValue());
            }

            params.add("Tags", json.toString());
        } else {
            params.add("Tags", "");
        }

        // Let us build the file to upload
        UploadFile uploadFile = new UploadFile("MediaFile", new File(filePath));
        UploadFile[] files = {uploadFile};

        HttpResponse response = this.httpClient.postFiles(resource, params, files);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContentMedia(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ContentMedia addContentMedia(MediaInfo mediaInfo) throws HttpRequestException {
        final String resource = "/media/";
        if (mediaInfo == null) {
            throw new HttpRequestException(new Exception("Parameter 'mediaInfo' cannot be null."));
        }
        ParameterMap params = this.httpClient.newParams();
        params.add("ContentName", mediaInfo.getContentName())
                .add("LibraryId", mediaInfo.getLibraryId().toString())
                .add("DestinationFolder", mediaInfo.getDestinationFolder() != null && mediaInfo.getDestinationFolder().length() > 0 ? mediaInfo.getDestinationFolder() : "")
                .add("Preference", mediaInfo.getPreference())
                .add("DisplayText", mediaInfo.getDisplayText() != null && mediaInfo.getDisplayText().length() > 0 ? mediaInfo.getDisplayText() : "")
                .add("ContentText", mediaInfo.getContentText() != null && mediaInfo.getContentText().length() > 0 ? mediaInfo.getContentText() : "");

        if (mediaInfo.getTags() != null && !mediaInfo.getTags().isEmpty()) {
            JsonObject json = new JsonObject();
            for (Map.Entry<String, String> map : mediaInfo.getTags().entrySet()) {
                json.add(map.getKey(), map.getValue());
            }

            params.add("Tags", json.toString());
        } else {
            params.add("Tags", "");
        }
        HttpResponse response = this.httpClient.post(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContentMedia(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes an existing content media
     *
     * @param contentMediaId The content media ID
     * @return boolean
     * @throws HttpRequestException
     */
    public boolean deleteContentMedia(UUID contentMediaId) throws HttpRequestException {
        String resource = "/media/" + contentMediaId.toString().replace("-", "");
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public boolean deleteContentMedia(String contentMediaId) throws HttpRequestException {
        String resource = "/media/";
        if (contentMediaId == null) {
            throw new HttpRequestException(new NullPointerException("contentMediaId"));
        }

        resource += contentMediaId.replace("-", "");
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates the details of an existing content media
     *
     * @param contentMediaId The content media ID
     * @param mediaInfo The content media data.
     * @return ContentMedia
     * @throws HttpRequestException
     */
    public ContentMedia updateContentMedia(UUID contentMediaId, MediaInfo mediaInfo) throws HttpRequestException {
        String resource = "/media/" + contentMediaId.toString().replace("-", "");
        ParameterMap params = this.httpClient.newParams();
        params.add("ContentName", mediaInfo.getContentName())
                .add("LibraryId", mediaInfo.getLibraryId().toString())
                .add("DestinationFolder", mediaInfo.getDestinationFolder() != null && mediaInfo.getDestinationFolder().length() > 0 ? mediaInfo.getDestinationFolder() : "")
                .add("Preference", mediaInfo.getPreference())
                .add("DrmProtect", mediaInfo.isDrmProtect() ? "true" : "false")
                .add("DisplayText", mediaInfo.getDisplayText() != null && mediaInfo.getDisplayText().length() > 0 ? mediaInfo.getDisplayText() : "")
                .add("ContentText", mediaInfo.getContentText() != null && mediaInfo.getContentText().length() > 0 ? mediaInfo.getContentText() : "");

        if (mediaInfo.getTags() != null && !mediaInfo.getTags().isEmpty()) {
            JsonObject json = new JsonObject();
            for (Map.Entry<String, String> map : mediaInfo.getTags().entrySet()) {
                json.add(map.getKey(), map.getValue());
            }

            params.add("Tags", json.toString());
        } else {
            params.add("Tags", "");
        }
        HttpResponse response = this.httpClient.put(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentMedia(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates the details of an existing content media
     *
     * @param contentMediaId The content media ID
     * @param mediaInfo The content media data.
     * @return ContentMedia
     * @throws HttpRequestException
     */
    public ContentMedia updateContentMedia(String contentMediaId, MediaInfo mediaInfo) throws HttpRequestException {
        String resource = "/media/";
        if (contentMediaId == null) {
            throw new HttpRequestException(new NullPointerException("contentMediaId"));
        }

        resource += contentMediaId.replace("-", "");
        ParameterMap params = this.httpClient.newParams();
        params.add("ContentName", mediaInfo.getContentName())
                .add("LibraryId", mediaInfo.getLibraryId().toString())
                .add("DestinationFolder", mediaInfo.getDestinationFolder() != null && mediaInfo.getDestinationFolder().length() > 0 ? mediaInfo.getDestinationFolder() : "")
                .add("Preference", mediaInfo.getPreference())
                .add("DrmProtect", mediaInfo.isDrmProtect() ? "true" : "false")
                .add("DisplayText", mediaInfo.getDisplayText() != null && mediaInfo.getDisplayText().length() > 0 ? mediaInfo.getDisplayText() : "")
                .add("ContentText", mediaInfo.getContentText() != null && mediaInfo.getContentText().length() > 0 ? mediaInfo.getContentText() : "");

        if (mediaInfo.getTags() != null && !mediaInfo.getTags().isEmpty()) {
            JsonObject json = new JsonObject();
            for (Map.Entry<String, String> map : mediaInfo.getTags().entrySet()) {
                json.add(map.getKey(), map.getValue());
            }

            params.add("Tags", json.toString());
        } else {
            params.add("Tags", "");
        }
        HttpResponse response = this.httpClient.put(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContentMedia(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }
}
