package com.hubtel;

import java.util.Date;


/**
 * Represents an API message template.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class MessageTemplate {

    private String accountId;
    private Date dateCreated;
    private long id;
    private String name;
    private String text;

    /**
     * Initializes a new instance of this class.
     */
    public MessageTemplate() {
    }

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public MessageTemplate(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "datecreated":
                    this.dateCreated = val.asDate();
                    break;
                case "id":
                    this.id = val.asLong();
                    break;
                case "name":
                    this.name = val.asString();
                    break;
                case "text":
                    this.text = val.asString();
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API message template.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Gets the created date of this API message template.
     *
     * @return the created date.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Gets the ID of this API message template.
     *
     * @return the ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Gets the name of this API message template.
     *
     * @return the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the text of this API message template.
     *
     * @return the text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Sets the name of this API message template.
     *
     * @param value the name.
     * @return this instance of API message template.
     */
    public MessageTemplate setName(String value) {
        this.name = value;
        return this;
    }

    /**
     * Sets the text of this API message template.
     *
     * @param value the text.
     * @return this instance of API message template.
     */
    public MessageTemplate setText(String value) {
        this.text = value;
        return this;
    }

    /**
     * toJson.
     */
    public String toJson() {
        return new JsonObject().add("Name", this.name).add("Text", this.text).toString();
    }
}
