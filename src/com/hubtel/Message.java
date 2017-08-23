package com.hubtel;

import java.util.Date;
import java.util.UUID;


/**
 * Represents an API message.
 *
 * @author Arsene
 */
public class Message {

    private int type;
    private String clientReference;
    private String content;
    private String direction;
    private boolean flashMessage;
    private String from;
    private UUID messageId;
    private String networkId;
    private double rate;
    private boolean registeredDelivery;
    private String status;
    private Date time;
    private String to;
    private String udh;
    private double units;
    private Date updateTime;
    private String billingInfo;

    /**
     * Initializes a new instance of this class.
     */
    public Message() {
    }

    /**
     * Used internally to intitialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public Message(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "type":
                    this.type = val.asInt();
                    break;
                case "clientreference":
                    this.clientReference = val.asString();
                    break;
                case "content":
                    this.content = val.asString();
                    break;
                case "direction":
                    this.content = val.asString();
                    break;
                case "flashmessage":
                    this.flashMessage = val.asBoolean();
                    break;
                case "from":
                    this.from = val.asString();
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
                case "registereddelivery":
                    this.registeredDelivery = val.asBoolean();
                    break;
                case "status":
                    this.status = val.asString();
                    break;
                case "time":
                    this.time = val.asDate();
                    break;
                case "to":
                    this.to = val.asString();
                    break;
                case "udh":
                    this.udh = val.asString();
                    break;
                case "units":
                    this.units = val.asDouble();
                    break;
                case "updatetime":
                    this.updateTime = val.asDate();
                    break;
                case "billinginfo":
                	this.billingInfo = val.asString();
                	break;
            }
        }
    }

    /**
     * Gets the API message type of this API message.
     *
     * @return the API message type.
     */
    public int getType() {
        return this.type;
    }

    /**
     * Gets the client reference of this API message.
     *
     * @return the client reference.
     */
    public String getClientReference() {
        return this.clientReference;
    }

    /**
     * Gets the content of this API message.
     *
     * @return the content.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Gets the direction of this API message.
     *
     * @return the direction.
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * Indicates whether this API message is flash.
     *
     * @return the boolean state.
     */
    public boolean getFlashMessage() {
        return this.flashMessage;
    }

    /**
     * Gets the sender of this API message.
     *
     * @return the sender.
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Gets the ID of this API message.
     *
     * @return the ID.
     */
    public UUID getMessageId() {
        return this.messageId;
    }

    /**
     * Gets the network ID of this API message.
     *
     * @return the network ID.
     */
    public String getNetworkId() {
        return this.networkId;
    }

    /**
     * Gets the rate of this API message.
     *
     * @return the rate.
     */
    public double getRate() {
        return this.rate;
    }

    /**
     * Indicates whether this API message is registered delivery.
     *
     * @return the boolean state.
     */
    public boolean getRegisteredDelivery() {
        return this.registeredDelivery;
    }

    /**
     * Gets the status of this API message.
     *
     * @return the status.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Gets the time of this API message.
     *
     * @return the time.
     */
    public Date getTime() {
        return this.time;
    }

    /**
     * Gets the recipient of this API message.
     *
     * @return the recipient.
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Gets the UDH of this API message.
     *
     * @return the UDH.
     */
    public String getUdh() {
        return this.udh;
    }

    /**
     * Gets the units of this API message.
     *
     * @return the units.
     */
    public double getUnits() {
        return this.units;
    }

    /**
     * Gets the update time of this API message.
     *
     * @return the update time.
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * Sets the API message type of this API message.
     *
     * @param value the API message type.
     * @return this instance of API message.
     */
    public Message setType(int value) {
        this.type = value;
        return this;
    }

    /**
     * Sets the client reference of this API message.
     *
     * @param value the client reference.
     * @return this instance of API message.
     */
    public Message setClientReference(String value) {
        this.clientReference = value;
        return this;
    }

    /**
     * Sets the content of this API message.
     *
     * @param value the content.
     * @return this instance of API message.
     */
    public Message setContent(String value) {
        this.content = value;
        return this;
    }

    /**
     * Sets a value indicating whether this API message is flash.
     *
     * @param value the boolean state.
     * @return this instance of API message.
     */
    public Message setFlashMessage(boolean value) {
        this.flashMessage = value;
        return this;
    }

    /**
     * Sets the sender of this API message.
     *
     * @param value the sender.
     * @return this instance of API message.
     */
    public Message setFrom(String value) {
        this.from = value;
        return this;
    }

    /**
     * Sets a value indicating whether this API message is registered delivery.
     *
     * @param value the boolean state.
     * @return this instance of API message.
     */
    public Message setRegisteredDelivery(boolean value) {
        this.registeredDelivery = value;
        return this;
    }

    /**
     * Sets the time of this API message.
     *
     * @param value the time.
     * @return this instance of API message.
     */
    public Message setTime(Date value) {
        this.time = value;
        return this;
    }

    /**
     * Sets the recipient number of this API message.
     *
     * @param value the recipient number.
     * @return this instance of API message.
     */
    public Message setTo(String value) {
        this.to = value;
        return this;
    }

    /**
     * Sets the UDH of this API message.
     *
     * @param value the UDH.
     * @return this instance of API message.
     */
    public Message setUdh(String value) {
        this.udh = value;
        return this;
    }

    /**
     * toJson
     */
    public String toJson() {
        return new JsonObject().add("Type", this.type).add("ClientReference", this.clientReference)
        		.add("Content", this.content).add("FlashMessage", this.flashMessage).add("From", this.from)
        		.add("RegisteredDelivery", this.registeredDelivery).add("Time", this.time).add("To", this.to)
        		.add("BillingInfo", this.billingInfo)
        		.add("Udh", this.udh).toString();
    }

	public String getBillingInfo() {
		return billingInfo;
	}

	public Message setBillingInfo(String billingInfo) {
		this.billingInfo = billingInfo;
		return this;
	}
}
