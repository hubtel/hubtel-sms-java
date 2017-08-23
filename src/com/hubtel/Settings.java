package com.hubtel;


/**
 * Represents an API settings.
 *
 * @author Arsene Tochemey GANDOTE
 */
public class Settings {

    private String accountId;
    private String countryCode;
    private String deliveryReportNotificationUrl;
    private boolean emailDailySummary;
    private boolean emailInvoiceReminders;
    private boolean emailMaintenance;
    private boolean emailNewInvoice;
    private boolean smsFortnightBalance;
    private boolean smsLowBalanceNotification;
    private boolean smsMaintenance;
    private boolean smsPromotionalMessages;
    private boolean smsTopUpNotification;
    private String timeZone;

    /**
     * Used internally to initialize the data fields of this instance.
     */
    public Settings(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "countrycode":
                    this.countryCode = val.asString();
                    break;
                case "deliveryreportnotificationurl":
                    this.deliveryReportNotificationUrl = val.asString();
                    break;
                case "emaildailysummary":
                    this.emailDailySummary = val.asBoolean();
                    break;
                case "emailinvoicereminders":
                    this.emailInvoiceReminders = val.asBoolean();
                    break;
                case "emailmaintenance":
                    this.emailMaintenance = val.asBoolean();
                    break;
                case "emailnewinvoice":
                    this.emailNewInvoice = val.asBoolean();
                    break;
                case "smsfortnightbalance":
                    this.smsFortnightBalance = val.asBoolean();
                    break;
                case "smslowbalancenotification":
                    this.smsLowBalanceNotification = val.asBoolean();
                    break;
                case "smsmaintenance":
                    this.smsMaintenance = val.asBoolean();
                    break;
                case "smspromotionalmessages":
                    this.smsPromotionalMessages = val.asBoolean();
                    break;
                case "smstopupnotification":
                    this.smsTopUpNotification = val.asBoolean();
                    break;
                case "timezone":
                    this.timeZone = val.asString();
                    break;
            }
        }
    }

    /**
     * Gets the account ID of this API settings.
     *
     * @return the account ID.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Gets the country code of this API settings.
     *
     * @return the country code.
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Gets the delivery report notification URL of this API settings.
     *
     * @return the delivery report notification URL.
     */
    public String getDeliveryReportNotificationUrl() {
        return this.deliveryReportNotificationUrl;
    }

    /**
     * Gets the email daily summary state of this API settings.
     *
     * @return the email daily summary state.
     */
    public boolean getEmailDailySummary() {
        return this.emailDailySummary;
    }

    /**
     * Gets the email invoice reminders state of this API settings.
     *
     * @return the email invoice reminders state.
     */
    public boolean getEmailInvoiceReminders() {
        return this.emailInvoiceReminders;
    }

    /**
     * Gets the email maintenance state of this API settings.
     *
     * @return the email maintenance state.
     */
    public boolean getEmailMaintenance() {
        return this.emailMaintenance;
    }

    /**
     * Gets the email new invoice state of this API settings.
     *
     * @return the email new invoice state.
     */
    public boolean getEmailNewInvoice() {
        return this.emailNewInvoice;
    }

    /**
     * Gets the SMS fornight balance state of this API settings.
     *
     * @return the SMS fornight balance state.
     */
    public boolean getSmsFortnightBalance() {
        return this.smsFortnightBalance;
    }

    /**
     * Gets the SMS low balance notification state of this API settings.
     *
     * @return the SMS low balance notification state.
     */
    public boolean getSmsLowBalanceNotification() {
        return this.smsLowBalanceNotification;
    }

    /**
     * Gets the SMS maintenance state of this API settings.
     *
     * @return the SMS maintenance state.
     */
    public boolean getSmsMaintenance() {
        return this.smsMaintenance;
    }

    /**
     * Gets the SMS promotional messages state of this API settings.
     *
     * @return the SMS promotional messages state.
     */
    public boolean getSmsPromotionalMessages() {
        return this.smsPromotionalMessages;
    }

    /**
     * Gets the SMS topup notification state of this API settings.
     *
     * @return the SMS topup notification state.
     */
    public boolean getSmsTopUpNotification() {
        return this.smsTopUpNotification;
    }

    /**
     * Gets the time zone of this API settings.
     *
     * @return the time zone.
     */
    public String getTimeZone() {
        return this.timeZone;
    }

    /**
     * toJson
     */
    public String toJson() {
        return new JsonObject().add("CountryCode", this.countryCode).add("DeliveryReportNotificationUrl", this.deliveryReportNotificationUrl).add("EmailDailySummary", this.emailDailySummary).add("EmailInvoiceReminders", this.emailInvoiceReminders).add("EmailMaintenance", this.emailMaintenance).add("EmailNewInvoice", this.emailNewInvoice).add("SmsFortnightBalance", this.smsFortnightBalance).add("SmsLowBalanceNotification", this.smsLowBalanceNotification).add("SmsMaintenance", this.smsMaintenance).add("SmsPromotionalMessages", this.smsPromotionalMessages).add("SmsTopUpNotification", this.smsTopUpNotification).add("TimeZone", this.timeZone).toString();
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDeliveryReportNotificationUrl(String deliveryReportNotificationUrl) {
        this.deliveryReportNotificationUrl = deliveryReportNotificationUrl;
    }

    public void setEmailDailySummary(boolean emailDailySummary) {
        this.emailDailySummary = emailDailySummary;
    }

    public void setEmailInvoiceReminders(boolean emailInvoiceReminders) {
        this.emailInvoiceReminders = emailInvoiceReminders;
    }

    public void setEmailMaintenance(boolean emailMaintenance) {
        this.emailMaintenance = emailMaintenance;
    }

    public void setEmailNewInvoice(boolean emailNewInvoice) {
        this.emailNewInvoice = emailNewInvoice;
    }

    public void setSmsFortnightBalance(boolean smsFortnightBalance) {
        this.smsFortnightBalance = smsFortnightBalance;
    }

    public void setSmsLowBalanceNotification(boolean smsLowBalanceNotification) {
        this.smsLowBalanceNotification = smsLowBalanceNotification;
    }

    public void setSmsMaintenance(boolean smsMaintenance) {
        this.smsMaintenance = smsMaintenance;
    }

    public void setSmsPromotionalMessages(boolean smsPromotionalMessages) {
        this.smsPromotionalMessages = smsPromotionalMessages;
    }

    public void setSmsTopUpNotification(boolean smsTopUpNotification) {
        this.smsTopUpNotification = smsTopUpNotification;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
