package com.hubtel;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class ContentLibrary {

    private UUID libraryId;
    private String accountId;
    private String name;
    private String shortName;
    private Date dateCreated;
    private Date dateModified;
    private long folderId;

    public ContentLibrary() {
    }

    public ContentLibrary(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "libraryid":
                    this.libraryId = val.asUUID();
                    break;
                case "datecreated":
                    this.dateCreated = val.asDate();
                    break;
                case "datemodified":
                    this.dateModified = val.asDate();
                    break;
                case "name":
                    this.name = val.asString();
                    break;
                case "shortname":
                    this.shortName = val.asString();
                    break;
                case "folderid":
                    this.folderId = val.asLong();
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API campaign.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * @return the libraryId
     */
    public UUID getLibraryId() {
        return libraryId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
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
     * @return the folderId
     */
    public long getFolderId() {
        return folderId;
    }

    /**
     * @param name the name to set
     * @return
     */
    public ContentLibrary setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @param shortName the shortName to set
     * @return
     */
    public ContentLibrary setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String toJson() {
        return new JsonObject().add("Name", this.name).add("ShortName", this.shortName).toString();
    }
}
