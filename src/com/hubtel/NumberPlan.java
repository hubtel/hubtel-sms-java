package com.hubtel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Represents an API number plan.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class NumberPlan {

    private String accountId;
    private Date dateActivated;
    private Date dateCreated;
    private Date dateDeactivated;
    private Date dateExpiring;
    private String description;
    private long id;
    private double initialCost;
    private boolean isActive;
    private boolean isPremium;
    private int maxAllowedKeywords;
    private List<MoKeyWord> moKeyWords;
    private String notes;
    private List<NumberPlanItem> numberPlanItems;
    private double periodicCostBasis;
    private ServiceType serviceType;

    /**
     * Used internally to intialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public NumberPlan(JsonObject json) {
        JsonValue val;
        this.moKeyWords = new ArrayList<MoKeyWord>();
        this.numberPlanItems = new ArrayList<NumberPlanItem>();
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "dateactivated":
                    this.dateActivated = val.asDate();
                    break;
                case "datecreated":
                    this.dateCreated = val.asDate();
                    break;
                case "datedeactivated":
                    this.dateDeactivated = val.asDate();
                    break;
                case "dateexpiring":
                    this.dateExpiring = val.asDate();
                    break;
                case "description":
                    this.description = val.asString();
                    break;
                case "id":
                    this.id = val.asLong();
                    break;
                case "initialcost":
                    this.initialCost = val.asDouble();
                    break;
                case "isactive":
                    this.isActive = val.asBoolean();
                    break;
                case "ispremium":
                    this.isPremium = val.asBoolean();
                    break;
                case "maxallowedkeywords":
                    this.maxAllowedKeywords = val.asInt();
                    break;
                case "mokeywords":
                    for (JsonValue o : val.asArray()) {
                        this.moKeyWords.add(new MoKeyWord(o.asObject()));
                    }
                    break;
                case "notes":
                    this.notes = val.asString();
                    break;
                case "numberplanitems":
                    for (JsonValue o : val.asArray()) {
                        this.numberPlanItems.add(new NumberPlanItem(o.asObject()));
                    }
                    break;
                case "periodiccostbasis":
                    this.periodicCostBasis = val.asDouble();
                    break;
                case "servicetype":
                    this.serviceType = new ServiceType(val.asObject());
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API number plan.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Gets the activated date of this API number plan.
     *
     * @return the activated date.
     */
    public Date getDateActivated() {
        return this.dateActivated;
    }

    /**
     * Gets the created date of this API number plan.
     *
     * @return the created date.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Gets the deactivated date of this API number plan.
     *
     * @return the deactivated date.
     */
    public Date getDateDeactivated() {
        return this.dateDeactivated;
    }

    /**
     * Gets the expiring date of this API number plan.
     *
     * @return the expiring date.
     */
    public Date getDateExpiring() {
        return this.dateExpiring;
    }

    /**
     * Gets the description of this API number plan.
     *
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the ID of this API number plan.
     *
     * @return the ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Gets the initial cost of this API number plan.
     *
     * @return the initial cost.
     */
    public double getInitialCost() {
        return this.initialCost;
    }

    /**
     * Indicates whether this API number plan is active.
     *
     * @return the boolean state.
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Indicates whether this API number plan is premium.
     *
     * @return the boolean state.
     */
    public boolean isPremium() {
        return this.isPremium;
    }

    /**
     * Gets the maximum allowed keywords on this API number plan.
     *
     * @return the maximum allowed keywords.
     */
    public int getMaxAllowedKeywords() {
        return this.maxAllowedKeywords;
    }

    /**
     * Gets the MO keywords of this API number plan.
     *
     * @return list of MO keywords.
     */
    public List<MoKeyWord> getMoKeyWords() {
        return this.moKeyWords;
    }

    /**
     * Gets the notes of this API number plan.
     *
     * @return the notes.
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * Gets the number plan items of this API number plan.
     *
     * @return list of number plan items.
     */
    public List<NumberPlanItem> getNumberPlanItems() {
        return this.numberPlanItems;
    }

    /**
     * Gets the periodic cost basis of this API number plan.
     *
     * @return the periodic cost basis.
     */
    public double getPeriodicCostBasis() {
        return this.periodicCostBasis;
    }

    /**
     * Gets the service type of this API number plan.
     *
     * @return instance of ApiServiceType.
     */
    public ServiceType getServiceType() {
        return this.serviceType;
    }
}
