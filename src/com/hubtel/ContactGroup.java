package com.hubtel;

/**
 * Represents an API contact group.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class ContactGroup {

    private String accountId;
    private long contactCount;
    private long groupId;
    private String name;

    /**
     * Initializes a new instance of this class.
     */
    public ContactGroup() {
    }

    /**
     * Initializes the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public ContactGroup(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "contactcount":
                    this.contactCount = val.asLong();
                    break;
                case "groupid":
                    this.groupId = val.asLong();
                    break;
                case "name":
                    this.name = val.asString();
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API contact group.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Gets the contact count of this API contact group.
     *
     * @return the contact count.
     */
    public long getContactCount() {
        return this.contactCount;
    }

    /**
     * Gets the ID of this API contact group.
     *
     * @return the ID.
     */
    public long getGroupId() {
        return this.groupId;
    }

    /**
     * Gets the name of this API contact group.
     *
     * @return the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this API contact group.
     *
     * @param value the name.
     * @return instance of this API contact group.
     */
    public ContactGroup setName(String value) {
        this.name = value;
        return this;
    }

    /**
     * toJson.
     */
    public String toJson() {
        return new JsonObject().add("Name", this.name).toString();
    }
}
