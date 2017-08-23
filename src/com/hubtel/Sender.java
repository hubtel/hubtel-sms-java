package com.hubtel;

import java.util.Date;


/**
 * Represents an API sender.
 *
 * @author Arsene Tochemey
 */
public class Sender {

    private String accountId;
    private String address;
    private long id;
    private boolean isDeleted;
    private Date timeAdded;
    private Date timeDeleted;

    /**
     * Initializes a new instance of this class.
     */
    public Sender() {
    }

    /**
     * Used internally to initialize the data fields of this instance.
     */
    public Sender(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "address":
                    this.address = val.asString();
                    break;
                case "id":
                    this.id = val.asLong();
                    break;
                case "isdeleted":
                    this.isDeleted = val.asBoolean();
                    break;
                case "timeadded":
                    this.timeAdded = val.asDate();
                    break;
                case "timedeleted":
                    this.timeDeleted = val.asDate();
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API sender.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Gets the address of this API sender.
     *
     * @return the address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the ID of this API sender.
     *
     * @return the ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Indicates whether this API sender is deleted.
     *
     * @return the boolean state.
     */
    public boolean isDeleted() {
        return this.isDeleted;
    }

    /**
     * Gets the added time of this API sender.
     *
     * @return the added time.
     */
    public Date getTimeAdded() {
        return this.timeAdded;
    }

    /**
     * Gets the deleted time of this API sender.
     *
     * @return the deleted time.
     */
    public Date getTimeDeleted() {
        return this.timeDeleted;
    }

    /**
     * Sets the address of this API sender.
     *
     * @param value the address.
     * @return this instance of API sender.
     */
    public Sender setAddress(String value) {
        this.address = value;
        return this;
    }

    /**
     * toJson.
     */
    public String toJson() {
        return new JsonObject().add("Address", this.address).toString();
    }
}
