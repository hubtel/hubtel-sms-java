package com.hubtel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class ContentFolder {

    private long contentFolderId;
    private UUID contentLibraryId;
    private String folderName;
    private String absolutePath;
    private Date dateCreated;
    private Date dateModified;
    private long parentId;
    private long subFolderCount;
    private long contentMediaCount;
    private List<ContentFolder> folders;
    private List<ContentMedia> medias;
    public ContentFolder() {
    }

    public ContentFolder(JsonObject json) {
        JsonValue val;
        folders = new ArrayList<ContentFolder>();
        medias = new ArrayList<ContentMedia>();
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "subfolders":
                    for (JsonValue v : val.asArray()) {
                        this.folders.add(new ContentFolder(v.asObject()));
                    }
                    break;
                case "contentmedias":
                    for (JsonValue v : val.asArray()) {
                        this.medias.add(new ContentMedia(v.asObject()));
                    }
                    break;
                case "foldername":
                    this.folderName = val.asString();
                    break;
                case "contentfolderid":
                    this.contentFolderId = val.asLong();
                    break;
                case "datecreated":
                    this.dateCreated = val.asDate();
                    break;
                case "datemodified":
                    this.dateModified = val.asDate();
                    break;
                case "absolutepath":
                    this.absolutePath = val.asString();
                    break;
                case "parentid":
                    this.parentId = val.asLong();
                    break;
                case "subfoldercount":
                    this.subFolderCount = val.asLong();
                    break;
                case "contentmediacount":
                    this.contentMediaCount = val.asLong();
                    break;
                case "contentlibraryid":
                    this.contentLibraryId = val.asUUID();
                    break;
            }
        }
    }

    /**
     * @return the contentFolderId
     */
    public long getContentFolderId() {
        return contentFolderId;
    }

    /**
     * @return the contentLibraryId
     */
    public UUID getContentLibraryId() {
        return contentLibraryId;
    }

    /**
     * @return the folderName
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * @return the absolutePath
     */
    public String getAbsolutePath() {
        return absolutePath;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @return the dateModified
     */
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * @return the parentId
     */
    public long getParentId() {
        return parentId;
    }

    /**
     * @return the subFolderCount
     */
    public long getSubFolderCount() {
        return subFolderCount;
    }

    /**
     * @return the contentMediaCount
     */
    public long getContentMediaCount() {
        return contentMediaCount;
    }

    /**
     * @return the folders
     */
    public List<ContentFolder> getFolders() {
        return folders;
    }

    /**
     * @return the medias
     */
    public List<ContentMedia> getMedias() {
        return medias;
    }

}
