package com.hubtel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class ContentMedia {

    private UUID id;
    private String accounId;
    private String name;
    private UUID libraryId;
    private String locationPath;
    private List<Tag> tags;
    private String type;
    private String preference;
    private boolean drmProtect;
    private String encodingStatus;
    private boolean streamable;
    private String displayText;
    private String contentText;
    private boolean approved;
    private boolean deleted;
    private Date dateCreated;
    private Date dateModified;
    private Date dateDeleted;
    private String callbackUrl;

    public ContentMedia() {
    }

    public ContentMedia(JsonObject json) {
        JsonValue val;
        tags = new ArrayList<Tag>();
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "id":
                    this.id = val.asUUID();
                    break;
                case "accountid":
                    this.accounId = val.asString();
                    break;
                case "name":
                    this.name = val.asString();
                    break;
                case "datecreated":
                    this.dateCreated = val.asDate();
                    break;
                case "datemodified":
                    this.dateModified = val.asDate();
                    break;
                case "datedeleted":
                    this.dateDeleted = val.asDate();
                    break;
                case "libraryid":
                    this.libraryId = val.asUUID();
                    break;
                case "locationpath":
                    this.locationPath = val.asString();
                    break;
                case "tags":
                    for (JsonValue v : val.asArray()) {
                        this.tags.add(new Tag(v.asObject()));
                    }
                    break;
                case "type":
                    this.type = val.asString();
                    break;
                case "preference":
                    this.preference = val.asString();
                    break;
                case "drmprotect":
                    this.drmProtect = val.asBoolean();
                    break;
                case "encodingstatus":
                    this.encodingStatus = val.asString();
                    break;
                case "streamable":
                    this.streamable = val.asBoolean();
                    break;
                case "displaytext":
                    this.displayText = val.asString();
                    break;
                case "contenttext":
                    this.contentText = val.asString();
                    break;
                case "approved":
                    this.approved = val.asBoolean();
                    break;
                case "callbackurl":
                    this.callbackUrl = val.asString();
                    break;
            }

        }
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the accounId
     */
    public String getAccounId() {
        return accounId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the libraryId
     */
    public UUID getLibraryId() {
        return libraryId;
    }

    /**
     * @return the locationPath
     */
    public String getLocationPath() {
        return locationPath;
    }

    /**
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the preference
     */
    public String getPreference() {
        return preference;
    }

    /**
     * @return the drmProtect
     */
    public boolean isDrmProtect() {
        return drmProtect;
    }

    /**
     * @return the encodingStatus
     */
    public String getEncodingStatus() {
        return encodingStatus;
    }

    /**
     * @return the streamable
     */
    public boolean isStreamable() {
        return streamable;
    }

    /**
     * @return the displayText
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * @return the contentText
     */
    public String getContentText() {
        return contentText;
    }

    /**
     * @return the approved
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * @return the deleted
     */
    public boolean isDeleted() {
        return deleted;
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
     * @return the dateDeleted
     */
    public Date getDateDeleted() {
        return dateDeleted;
    }

    /**
     * @return the callbackUrl
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }
}
