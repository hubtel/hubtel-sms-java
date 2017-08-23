package com.hubtel;


/**
 * Represenets an API number plan item.
 *
 * @author Arsene
 */
public class NumberPlanItem {

    private long id;
    private String network;
    private double payout;
    private double reversePayout;
    private String shortCode;

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guarateed instance of com.smsgh.json.JsonObject.
     */
    public NumberPlanItem(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "id":
                    this.id = val.asLong();
                    break;
                case "network":
                    this.network = val.asString();
                    break;
                case "payout":
                    this.payout = val.asDouble();
                    break;
                case "reversepayout":
                    this.reversePayout = val.asDouble();
                    break;
                case "shortcode":
                    this.shortCode = val.asString();
                    break;
            }
        }
    }

    /**
     * Gets the ID of this API number plan item.
     *
     * @return the ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Gets the network of this API number plan item.
     *
     * @return the network.
     */
    public String getNetwork() {
        return this.network;
    }

    /**
     * Gets the payout of this API number plan item.
     *
     * @return the payout.
     */
    public double getPayout() {
        return this.payout;
    }

    /**
     * Gets the reverse payout of this API number plan item.
     *
     * @return the reverse payout.
     */
    public double getReversePayout() {
        return this.reversePayout;
    }

    /**
     * Gets the short code of this API number plan item.
     *
     * @return the short code.
     */
    public String getShortCode() {
        return this.shortCode;
    }
}
