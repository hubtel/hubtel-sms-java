package com.hubtel;


/**
 * Represents an API service type.
 *
 * @author Arsene
 */
public class ServiceType {

    private String descriptor;
    private boolean isCreditBased;
    private boolean isPrepaid;
    private String name;
    private double rate;
    private boolean requiresActivation;

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public ServiceType(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "descriptor":
                    this.descriptor = val.asString();
                    break;
                case "iscreditbased":
                    this.isCreditBased = val.asBoolean();
                    break;
                case "isprepaid":
                    this.isPrepaid = val.asBoolean();
                    break;
                case "name":
                    this.name = val.asString();
                    break;
                case "rate":
                    this.rate = val.asDouble();
                    break;
                case "requiresactivation":
                    this.requiresActivation = val.asBoolean();
                    break;
            }
        }
    }

    /**
     * Gets the descriptor of this API service type.
     *
     * @return the descriptor.
     */
    public String getDescriptor() {
        return this.descriptor;
    }

    /**
     * Indicates whether this API service type is credit based.
     *
     * @return the boolean state.
     */
    public boolean isCreditBased() {
        return this.isCreditBased;
    }

    /**
     * Indicates whether this API service type is prepaid.
     *
     * @return the boolean state.
     */
    public boolean isPrepaid() {
        return this.isPrepaid;
    }

    /**
     * Gets the name of this API service type.
     *
     * @return the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the rate of this API service type.
     *
     * @return the rate.
     */
    public double getRate() {
        return this.rate;
    }

    /**
     * Indicates whether this API service type requires activation.
     *
     * @return the boolean state.
     */
    public boolean getRequiresActivation() {
        return this.requiresActivation;
    }
}
