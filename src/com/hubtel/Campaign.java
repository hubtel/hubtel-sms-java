package com.hubtel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Represents an API campaign.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class Campaign {

    private String accountId;
    private List<Action> actions;
    private String brief;
    private long campaignId;
    private Date dateCreated;
    private Date dateEnded;
    private String description;
    private boolean enabled;
    private boolean isDefault;
    private List<MoKeyWord> moKeyWords;
    private boolean pendingApproval;

    /**
     * Initializes a new instance of this class.
     */
    public Campaign() {
    }

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public Campaign(JsonObject json) {
        JsonValue val;
        this.actions = new ArrayList<Action>();
        this.moKeyWords = new ArrayList<MoKeyWord>();

        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "actions":
                    for (JsonValue v : val.asArray()) {
                        this.actions.add(new Action(v.asObject()));
                    }
                    break;
                case "brief":
                    this.brief = val.asString();
                    break;
                case "campaignid":
                    this.campaignId = val.asLong();
                    break;
                case "datecreated":
                    this.dateCreated = val.asDate();
                    break;
                case "dateended":
                    this.dateEnded = val.asDate();
                    break;
                case "description":
                    this.description = val.asString();
                    break;
                case "enabled":
                    this.enabled = val.asBoolean();
                    break;
                case "isdefault":
                    this.isDefault = val.asBoolean();
                    break;
                case "mokeywords":
                    for (JsonValue v : val.asArray()) {
                        this.moKeyWords.add(new MoKeyWord(v.asObject()));
                    }
                    break;
                case "pendingapproval":
                    this.pendingApproval = val.asBoolean();
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API campaign.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Gets the actions of this API campaign.
     *
     * @return list of API actions.
     */
    public List<Action> getActions() {
        return this.actions;
    }

    /**
     * Gets the brief of this API campaign.
     *
     * @return the brief.
     */
    public String getBrief() {
        return this.brief;
    }

    /**
     * Gets the ID of this API campaign.
     *
     * @return the ID.
     */
    public long getCampaignId() {
        return this.campaignId;
    }

    /**
     * Gets the created date of this API campaign.
     *
     * @return the created date.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Gets the end date of this API campaign.
     *
     * @return the end date.
     */
    public Date getDateEnded() {
        return this.dateEnded;
    }

    /**
     * Gets the description of this API campaign.
     *
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Indicates whether this API campaign is enabled.
     *
     * @return the boolean enabled state.
     */
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * Indicates whether this API campaign is the default.
     *
     * @return the boolean default state.
     */
    public boolean isDefault() {
        return this.isDefault;
    }

    /**
     * Gets the MO keywords of this API campaign.
     *
     * @return list of MO keywords.
     */
    public List<MoKeyWord> getMoKeyWords() {
        return this.moKeyWords;
    }

    /**
     * Indicates whether this API campaign is pending approval.
     *
     * @return the boolean pending-approval state.
     */
    public boolean isPendingApproval() {
        return this.pendingApproval;
    }

    /**
     * Sets the brief of this API campaign.
     *
     * @param value the brief.
     * @return this instance of API campaign.
     */
    public Campaign setBrief(String value) {
        this.brief = value;
        return this;
    }

    /**
     * Sets the description of this API campaign.
     *
     * @param value the description.
     * @return this instance of API campaign.
     */
    public Campaign setDescription(String value) {
        this.description = value;
        return this;
    }

    /**
     * Sets the created date of this API campaign.
     *
     * @param value the created date.
     * @return this instance of API campaign.
     */
    public Campaign setDateCreated(Date value) {
        this.dateCreated = value;
        return this;
    }

    /**
     * Sets the end date of this API campaign.
     *
     * @param value the end date.
     * @return this instance of API campaign.
     */
    public Campaign setDateEnded(Date value) {
        this.dateEnded = value;
        return this;
    }

    /**
     * toJson.
     */
    public String toJson() {
        return new JsonObject().add("Brief", this.brief).add("DateCreated", this.dateCreated).add("DateEnded", this.dateEnded).add("Description", this.description).toString();
    }
}
