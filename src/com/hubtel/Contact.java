package com.hubtel;


/**
 * Represents an API contact.
 *
 * @author Arsene
 */
public class Contact {

    private long contactId;
    private String custom1;
    private String custom2;
    private String custom3;
    private String firstName;
    private long groupId;
    private String groupName;
    private String mobileNumber;
    private String owner;
    private String surname;
    private String title;

    /**
     * Initializes a new instance of this class.
     */
    public Contact() {
    }

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public Contact(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "contactid":
                    this.contactId = val.asLong();
                    break;
                case "custom1":
                    this.custom1 = val.asString();
                    break;
                case "custom2":
                    this.custom2 = val.asString();
                    break;
                case "custom3":
                    this.custom3 = val.asString();
                    break;
                case "firstname":
                    this.firstName = val.asString();
                    break;
                case "groupid":
                    this.groupId = val.asLong();
                    break;
                case "groupname":
                    this.groupName = val.asString();
                    break;
                case "mobilenumber":
                    this.mobileNumber = val.asString();
                    break;
                case "owner":
                    this.owner = val.asString();
                    break;
                case "surname":
                    this.surname = val.asString();
                    break;
                case "title":
                    this.title = val.asString();
                    break;
            }
        }
    }

    /**
     * Gets the ID of this API contact.
     *
     * @return the ID.
     */
    public long getContactId() {
        return this.contactId;
    }

    /**
     * Gets the custom 1 of this API contact.
     *
     * @return the custom 1.
     */
    public String getCustom1() {
        return this.custom1;
    }

    /**
     * Gets the custom 2 of this API contact.
     *
     * @return the custom 2.
     */
    public String getCustom2() {
        return this.custom2;
    }

    /**
     * Gets the custom 3 of this API contact.
     *
     * @return the custom 3.
     */
    public String getCustom3() {
        return this.custom3;
    }

    /**
     * Gets the first name of this API contact.
     *
     * @return the first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the group ID of this API contact.
     *
     * @return the group ID.
     */
    public long getGroupId() {
        return this.groupId;
    }

    /**
     * Gets the group name of this API contact.
     *
     * @return the group name.
     */
    public String getGroupName() {
        return this.groupName;
    }

    /**
     * Gets the mobile number of this API contact.
     *
     * @return the mobile number.
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * Gets the owner of this API contact.
     *
     * @return the owner.
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * Gets the surname of this API contact.
     *
     * @return the surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Gets the title of this API contact.
     *
     * @return the title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the custom 1 of this API contact.
     *
     * @param value the custom 1.
     * @return this instance of API contact.
     */
    public Contact setCustom1(String value) {
        this.custom1 = value;
        return this;
    }

    /**
     * Sets the custom 2 of this API contact.
     *
     * @param value the custom 2.
     * @return this instance of API contact.
     */
    public Contact setCustom2(String value) {
        this.custom2 = value;
        return this;
    }

    /**
     * Sets the custom 3 of this API contact.
     *
     * @param value the custom 3.
     * @return this instance of API contact.
     */
    public Contact setCustom3(String value) {
        this.custom3 = value;
        return this;
    }

    /**
     * Sets the first name of this API contact.
     *
     * @param value the first name.
     * @return this instance of API contact.
     */
    public Contact setFirstName(String value) {
        this.firstName = value;
        return this;
    }

    /**
     * Sets the group ID of this API contact.
     *
     * @param value the group ID.
     * @return this instance of API contact.
     */
    public Contact setGroupId(long value) {
        this.groupId = value;
        return this;
    }

    /**
     * Sets the mobile number of this API contact.
     *
     * @param value the mobile number.
     * @return this instance of API contact.
     */
    public Contact setMobileNumber(String value) {
        this.mobileNumber = value;
        return this;
    }

    /**
     * Sets the surname of this API contact.
     *
     * @param value the surname.
     * @return this instance of API contact.
     */
    public Contact setSurname(String value) {
        this.surname = value;
        return this;
    }

    /**
     * Sets the title of this API contact.
     *
     * @param value the title.
     * @return this instance of API contact.
     */
    public Contact setTitle(String value) {
        this.title = value;
        return this;
    }

    /**
     * toJson.
     */
    public String toJson() {
        return new JsonObject().add("Custom1", this.custom1).add("Custom2", this.custom2).add("Custom3", this.custom3).add("FirstName", this.firstName).add("GroupId", this.groupId).add("MobileNumber", this.mobileNumber).add("Surname", this.surname).add("Title", this.title).toString();
    }
}
