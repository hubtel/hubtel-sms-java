package com.hubtel;

import java.util.UUID;


/**
 * Represents an API message response.
 *
 * @author Arsene
 */
public class MessageResponse {

    private String clientReference;
    private String detail;
    private UUID messageId;
    private String networkId;
    private int status;
    private double rate;

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public MessageResponse(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "clientreference":
                    this.clientReference = val.asString();
                    break;
                case "detail":
                    // this.detail = val.asString();
                    break;
                case "messageid":
                    this.messageId = val.asUUID();
                    break;
                case "networkid":
                    this.networkId = val.asString();
                    break;
                case "rate":
                    this.rate = val.asDouble();
                    break;
                case "status":
                    this.status = val.asInt();
                    break;
            }
        }
    }

    /**
     * Gets the client reference of this API message response.
     *
     * @return the client reference.
     */
    public String getClientReference() {
        return this.clientReference;
    }

    /**
     * Gets the detail of this API message response.
     *
     * @return the detail.
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * Gets the message ID of this API message response.
     *
     * @return the message ID.
     */
    public UUID getMessageId() {
        return this.messageId;
    }

    /**
     * Gets the network ID of this API message response.
     *
     * @return the network ID.
     */
    public String getNetworkId() {
        return this.networkId;
    }

    /**
     * Gets the rate of this API message response.
     *
     * @return the rate.
     */
    public double getRate() {
        return this.rate;
    }

    /**
     * Gets the status of this API message response.
     *
     * @return the status.
     */
    public int getStatus() {
        return this.status;
    }
}
