package com.hubtel;


/**
 * Represents an API MO keyword.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class MoKeyWord {

    private String alias1;
    private String alias2;
    private String alias3;
    private String alias4;
    private String alias5;
    private long id;
    private boolean isActive;
    private boolean isDefault;
    private String keyword;
    private long numberPlanId;

    /**
     * Initializes a new instance of this class.
     */
    public MoKeyWord() {
    }

    /**
     * Used internally to initialize the data fields of this class.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public MoKeyWord(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "alias1":
                    this.alias1 = val.asString();
                    break;
                case "alias2":
                    this.alias2 = val.asString();
                    break;
                case "alias3":
                    this.alias3 = val.asString();
                    break;
                case "alias4":
                    this.alias4 = val.asString();
                    break;
                case "alias5":
                    this.alias5 = val.asString();
                    break;
                case "id":
                    this.id = val.asLong();
                    break;
                case "isactive":
                    this.isActive = val.asBoolean();
                    break;
                case "isdefault":
                    this.isDefault = val.asBoolean();
                    break;
                case "keyword":
                    this.keyword = val.asString();
                    break;
                case "numberplanid":
                    this.numberPlanId = val.asLong();
                    break;
            }
        }
    }

    /**
     * Gets the alias 1 of this API MO keyword.
     *
     * @return the alias 1.
     */
    public String getAlias1() {
        return this.alias1;
    }

    /**
     * Gets the alias 2 of this API MO keyword.
     *
     * @return the alias 2.
     */
    public String getAlias2() {
        return this.alias2;
    }

    /**
     * Gets the alias 3 of this API MO keyword.
     *
     * @return the alias 3.
     */
    public String getAlias3() {
        return this.alias3;
    }

    /**
     * Gets the alias 4 of this API MO keyword.
     *
     * @return the alias 4.
     */
    public String getAlias4() {
        return this.alias4;
    }

    /**
     * Gets the alias 5 of this API MO keyword.
     *
     * @return the alias 5.
     */
    public String getAlias5() {
        return this.alias5;
    }

    /**
     * Gets the ID of this API MO keyword.
     *
     * @return the ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Indicates whether this API MO keyword is active.
     *
     * @return the boolean state.
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Indicates whether this API MO keyword is default.
     *
     * @return the boolean state.
     */
    public boolean isDefault() {
        return this.isDefault;
    }

    /**
     * Gets the keyword of this API MO keyword.
     *
     * @return the keyword.
     */
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * Gets the number plan ID of this API MO keyword.
     *
     * @return the number plan ID.
     */
    public long getNumberPlanId() {
        return this.numberPlanId;
    }

    /**
     * Sets the alias 1 of this API MO keyword.
     *
     * @param value the alias 1.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setAlias1(String value) {
        this.alias1 = value;
        return this;
    }

    /**
     * Sets the alias 2 of this API MO keyword.
     *
     * @param value the alias 2.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setAlias2(String value) {
        this.alias2 = value;
        return this;
    }

    /**
     * Sets the alias 3 of this API MO keyword.
     *
     * @param value the alias 3.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setAlias3(String value) {
        this.alias3 = value;
        return this;
    }

    /**
     * Sets the alias 4 of this API MO keyword.
     *
     * @param value the alias 4.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setAlias4(String value) {
        this.alias4 = value;
        return this;
    }

    /**
     * Sets the alias 5 of this API MO keyword.
     *
     * @param value the alias 5.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setAlias5(String value) {
        this.alias5 = value;
        return this;
    }

    /**
     * Sets a value indicating whether this API MO keyword is active.
     *
     * @param value the boolean state.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setActive(boolean value) {
        this.isActive = value;
        return this;
    }

    /**
     * Sets a value indicating whether this API MO keyword is default.
     *
     * @param value the boolean state.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setDefault(boolean value) {
        this.isDefault = value;
        return this;
    }

    /**
     * Sets the keyword of this API MO keyword.
     *
     * @param value the keyword.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setKeyword(String value) {
        this.keyword = value;
        return this;
    }

    /**
     * Sets the number plan ID of this API MO keyword.
     *
     * @param value the number plan ID.
     * @return this instance of API MO keyword.
     */
    public MoKeyWord setNumberPlanId(long value) {
        this.numberPlanId = value;
        return this;
    }

    /**
     * toJson.
     */
    public String toJson() {
        return new JsonObject().add("Alias1", this.alias1).add("Alias2", this.alias2).add("Alias3", this.alias3).add("Alias4", this.alias4).add("Alias5", this.alias5).add("IsActive", this.isActive).add("IsDefault", this.isDefault).add("Keyword", this.keyword).add("NumberPlanId", this.numberPlanId).toString();
    }
}
