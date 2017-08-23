package com.hubtel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents an API service.
 *
 * @author Arsene
 */
public class Service {

    private String accountId;
    private Date billDate;
    private long billingCycleId;
    private Date dateCreated;
    private String description;
    private boolean isCreditBased;
    private boolean isPrepaid;
    private BigDecimal rate;
    private long serviceId;
    private long serviceStatusTypeId;
    private long serviceTypeId;

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    public Service(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "billdate":
                    this.billDate = val.asDate();
                    break;
                case "billingcycleid":
                    this.billingCycleId = val.asLong();
                    break;
                case "datecreated":
                    this.dateCreated = val.asDate();
                    break;
                case "description":
                    this.description = val.asString();
                    break;
                case "iscreditbased":
                    this.isCreditBased = val.asBoolean();
                    break;
                case "isprepaid":
                    this.isPrepaid = val.asBoolean();
                    break;
                case "rate":
                    this.rate = new BigDecimal(val.toString());
                    break;
                case "serviceid":
                    this.serviceId = val.asLong();
                    break;
                case "servicestatustypeid":
                    this.serviceStatusTypeId = val.asLong();
                    break;
                case "servicetypeid":
                    this.serviceTypeId = val.asLong();
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API service.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Gets the bill date of this API service.
     *
     * @return the bill date.
     */
    public Date getBillDate() {
        return this.billDate;
    }

    /**
     * Gets the billing cycle ID of this API service.
     *
     * @return the billing cycle ID.
     */
    public long getBillingCycleId() {
        return this.billingCycleId;
    }

    /**
     * Gets the created date of this API service.
     *
     * @return the created date.
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Gets the description of this API service.
     *
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Indicates whether this API service is credit based.
     *
     * @return the boolean state.
     */
    public boolean isCreditBased() {
        return this.isCreditBased;
    }

    /**
     * Indicates whether this API service is prepaid.
     *
     * @return the boolean state.
     */
    public boolean isPrepaid() {
        return this.isPrepaid;
    }

    /**
     * Gets the rate of this API service.
     *
     * @return the rate.
     */
    public BigDecimal getRate() {
        return this.rate;
    }

    /**
     * Gets the service ID of this API service.
     *
     * @return the service ID.
     */
    public long getServiceId() {
        return this.serviceId;
    }

    /**
     * Gets the service status type ID of this API service.
     *
     * @return the service status type ID.
     */
    public long getServiceStatusTypeId() {
        return this.serviceStatusTypeId;
    }

    /**
     * Gets the service type ID of this API service.
     *
     * @return the service type ID.
     */
    public long getServiceTypeId() {
        return this.serviceTypeId;
    }
}
