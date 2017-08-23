/**
 *
 */
package com.hubtel;

/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public class Topup {

    private Long purchasedCredit;
    private Double actualCredit;

    /**
     *
     */
    public Topup() {
    }

    public Topup(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "purchasedcredit":
                    this.purchasedCredit = val.asLong();
                    break;
                case "actualcredit":
                    this.actualCredit = val.asDouble();
                    break;
            }
        }
    }

    public Long getPurchasedCredit() {
        return purchasedCredit;
    }

    public Double getActualCredit() {
        return actualCredit;
    }

}
