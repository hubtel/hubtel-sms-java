package com.hubtel;

import java.util.Date;

/**
 * Represents an API invoice.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class Invoice {

    private double amount;
    private Date created;
    private String description;
    private Date dueDate;
    private double ending;
    private long id;
    private boolean isPaid;
    private String type;

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guranteed instance of com.smsgh.json.JsonObject.
     */
    public Invoice(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "amount":
                    this.amount = val.asDouble();
                    break;
                case "created":
                    this.created = val.asDate();
                    break;
                case "description":
                    this.description = val.asString();
                    break;
                case "duedate":
                    this.dueDate = val.asDate();
                    break;
                case "ending":
                    this.ending = val.asDouble();
                    break;
                case "id":
                    this.id = val.asLong();
                    break;
                case "ispaid":
                    this.isPaid = val.asBoolean();
                    break;
                case "type":
                    this.type = val.asString();
                    break;
            }
        }
    }

    /**
     * Gets the amount of this API invoice.
     *
     * @return the amount.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Gets the created date of this API invoice.
     *
     * @return the created date.
     */
    public Date getCreated() {
        return this.created;
    }

    /**
     * Gets the description of this API invoice.
     *
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the due date of this API invoice.
     *
     * @return the due date.
     */
    public Date getDueDate() {
        return this.dueDate;
    }

    /**
     * Gets the ending of this API invoice.
     *
     * @return the ending.
     */
    public double getEnding() {
        return this.ending;
    }

    /**
     * Gets the ID of this API invoice.
     *
     * @return the ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Indicates whether this API invoice is paid.
     *
     * @return the boolean state.
     */
    public boolean isPaid() {
        return this.isPaid;
    }

    /**
     * Gets the type of this API invoice.
     *
     * @return the type.
     */
    public String getType() {
        return this.type;
    }
}
