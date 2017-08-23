package com.hubtel;


/**
 * Represents an API account contact.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class AccountContact {

    private long accountContactId;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String firstName;
    private String lastName;
    private String province;
    private String postalCode;
    private String primaryEmail;
    private String primaryPhone;
    private String privateNote;
    private String publicNote;
    private String secondaryEmail;
    private String secondaryPhone;

    /**
     * Initializes an instance of the ApiAccountContact class.
     */
    public AccountContact() {
    }

    /**
     * An internal constructor to initialize the data fields of an already
     * instantiated API account account.
     *
     * @param json a guaranteed instance of com.smsgh.json.JsonObject.
     */
    public AccountContact(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountcontactid":
                    this.accountContactId = val.asLong();
                    break;
                case "address1":
                    this.address1 = val.asString();
                    break;
                case "address2":
                    this.address2 = val.asString();
                    break;
                case "city":
                    this.city = val.asString();
                    break;
                case "country":
                    this.country = val.asString();
                    break;
                case "firstname":
                    this.firstName = val.asString();
                    break;
                case "lastname":
                    this.lastName = val.asString();
                    break;
                case "province":
                    this.province = val.asString();
                    break;
                case "postalcode":
                    this.postalCode = val.asString();
                    break;
                case "primaryemail":
                    this.primaryEmail = val.asString();
                    break;
                case "primaryphone":
                    this.primaryPhone = val.asString();
                    break;
                case "privatenote":
                    this.privateNote = val.asString();
                    break;
                case "publicnote":
                    this.publicNote = val.asString();
                    break;
                case "secondaryemail":
                    this.secondaryEmail = val.asString();
                    break;
                case "secondaryphone":
                    this.secondaryPhone = val.asString();
                    break;
            }
        }
    }

    /**
     * Gets the account contact ID of this API account contact.
     *
     * @return the account contact ID or 0 if not set.
     */
    public long getAccountContactId() {
        return this.accountContactId;
    }

    /**
     * Gets the address 1 of this API account contact.
     *
     * @return the address 1 or null if not set.
     */
    public String getAddress1() {
        return this.address1;
    }

    /**
     * Gets the address 2 of this API account contact.
     *
     * @return the address 2 or null if not set.
     */
    public String getAddress2() {
        return this.address2;
    }

    /**
     * Gets the city of this API account contact.
     *
     * @return the city or null if not set.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Gets the country of this API account contact.
     *
     * @return the country or null if not set.
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Gets the first name of this API account contact.
     *
     * @return the first name or null if not set.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of this API account contact.
     *
     * @return the last name or null if not set.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the province of this API account contact.
     *
     * @return the province or null if not set.
     */
    public String getProvince() {
        return this.province;
    }

    /**
     * Gets the postal code of this API account contact.
     *
     * @return the postal code or null if not set.
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * Gets the primary email of this API account contact.
     *
     * @return the primary email or null if not set.
     */
    public String getPrimaryEmail() {
        return this.primaryEmail;
    }

    /**
     * Gets the primary phone number of this API account contact.
     *
     * @return the primary phone number or null if not set.
     */
    public String getPrimaryPhone() {
        return this.primaryPhone;
    }

    /**
     * Gets the private note of this API account contact.
     *
     * @return the private note or null if not set.
     */
    public String getPrivateNote() {
        return this.privateNote;
    }

    /**
     * Gets the public note of this API account contact.
     *
     * @return the public note or null if not set.
     */
    public String getPublicNote() {
        return this.publicNote;
    }

    /**
     * Gets the secondary email of this API account contact.
     *
     * @return the secondary email or null if not set.
     */
    public String getSecondaryEmail() {
        return this.secondaryEmail;
    }

    /**
     * Gets the secondary phone number of this API account contact.
     *
     * @return the secondary phone number or null if not set.
     */
    public String getSecondaryPhone() {
        return this.secondaryPhone;
    }

    /**
     * Sets the address 1 of this API account contact.
     *
     * @param value the address 1.
     * @return the instance of this API account contact.
     */
    public AccountContact setAddress1(String value) {
        this.address1 = value;
        return this;
    }

    /**
     * Sets the address 2 of this API account contact.
     *
     * @param value the address 2.
     * @return the instance of this API account contact.
     */
    public AccountContact setAddress2(String value) {
        this.address2 = value;
        return this;
    }

    /**
     * Sets the city of this API account contact.
     *
     * @param value the city of.
     * @return the instance of this API account contact.
     */
    public AccountContact setCity(String value) {
        this.city = value;
        return this;
    }

    /**
     * Sets the country of this API account contact.
     *
     * @param value the country.
     * @return the instance of this API account contact.
     */
    public AccountContact setCountry(String value) {
        this.country = value;
        return this;
    }

    /**
     * Sets the first name of this API account contact.
     *
     * @param value the first name.
     * @return the instance of this API account contact.
     */
    public AccountContact setFirstName(String value) {
        this.firstName = value;
        return this;
    }

    /**
     * Sets the last name of this API account contact.
     *
     * @param value the last name.
     * @return the instance of this API account contact.
     */
    public AccountContact setLastName(String value) {
        this.lastName = value;
        return this;
    }

    /**
     * Sets the province of this API account contact.
     *
     * @param value the province.
     * @return the instance of this API account contact.
     */
    public AccountContact setProvince(String value) {
        this.province = value;
        return this;
    }

    /**
     * Sets the postal code of this API account contact.
     *
     * @param value the postal code.
     * @return the instance of this API account contact.
     */
    public AccountContact setPostalCode(String value) {
        this.postalCode = value;
        return this;
    }

    /**
     * Sets the primary email of this API account contact.
     *
     * @param value the primary email.
     * @return the instance of this API account contact.
     */
    public AccountContact setPrimaryEmail(String value) {
        this.primaryEmail = value;
        return this;
    }

    /**
     * Sets the primary phone number of this API account contact.
     *
     * @param value the primary phone number.
     * @return the instance of this API account contact.
     */
    public AccountContact setPrimaryPhone(String value) {
        this.primaryPhone = value;
        return this;
    }

    /**
     * Sets the private note of this API account contact.
     *
     * @param value the private note.
     * @return the instance of this API account contact.
     */
    public AccountContact setPrivateNote(String value) {
        this.privateNote = value;
        return this;
    }

    /**
     * Sets the public note of this API account contact.
     *
     * @param value the public note.
     * @return the instance of this API account contact.
     */
    public AccountContact setPublicNote(String value) {
        this.publicNote = value;
        return this;
    }

    /**
     * Sets the secondary email of this API account contact.
     *
     * @param value the secondary email.
     * @return the instance of this API account contact.
     */
    public AccountContact setSecondaryEmail(String value) {
        this.secondaryEmail = value;
        return this;
    }

    /**
     * Sets the secondary phone number of this API account contact.
     *
     * @param value the secondary phone number.
     * @return the instance of this API account contact.
     */
    public AccountContact setSecondaryPhone(String value) {
        this.secondaryPhone = value;
        return this;
    }

    /**
     * Returns a JSON representation of this API account contact containing only
     * the writable properties. Don't call this method in your own code.
     *
     * @return JSON of this object.
     */
    public String toJson() {
        return new JsonObject().add("Address1", this.address1).add("Address2", this.address2).add("City", this.city).add("Country", this.country).add("FirstName", this.firstName).add("LastName", this.lastName).add("Province", this.province).add("PostalCode", this.postalCode).add("PrimaryEmail", this.primaryEmail).add("PrimaryPhone", this.primaryPhone).add("PrivateNote", this.privateNote).add("PublicNote", this.publicNote).add("SecondaryEmail", this.secondaryEmail).add("SecondaryPhone", this.secondaryPhone).toString();
    }
}
