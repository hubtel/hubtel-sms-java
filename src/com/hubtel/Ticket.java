/**
 *
 */
package com.hubtel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Arsene
 *
 */
public class Ticket {

    private long id;
    private String accountId;
    private long supportDepartmentId;
    private long supportCategoryId;
    private long supportStatusId;
    private long priority;
    private String source;
    private String recipients;
    private Date timeAdded;
    private Date timeClosed;
    private Date timeAssigned;
    private Date lastUpdated;
    private String subject;
    private String content;
    private String attachment;
    private String assignedTo;
    private long rating;
    private List<TicketResponse> responses;

    public Ticket() {
    }

    /**
     *
     */
    public Ticket(JsonObject json) {
        JsonValue val;
        this.responses = new ArrayList<TicketResponse>();
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "id":
                    this.id = val.asLong();
                    break;
                case "accountid":
                    this.accountId = val.asString();
                    break;
                case "assignedto":
                    this.assignedTo = val.asString();
                    break;
                case "supportdepartmentid":
                    this.supportDepartmentId = val.asLong();
                    break;
                case "supportcategoryid":
                    this.supportCategoryId = val.asLong();
                    break;
                case "supportstatusid":
                    this.supportStatusId = val.asLong();
                    break;
                case "priority":
                    this.priority = val.asLong();
                    break;
                case "source":
                    this.source = val.asString();
                    break;
                case "recipients":
                    this.recipients = val.asString();
                    break;
                case "timeadded":
                    this.timeAdded = val.asDate();
                    break;
                case "timeclosed":
                    this.timeClosed = val.asDate();
                    break;
                case "timeassigned":
                    this.timeAssigned = val.asDate();
                    break;
                case "lastupdated":
                    this.lastUpdated = val.asDate();
                    break;
                case "subject":
                    this.subject = val.asString();
                    break;
                case "content":
                    this.content = val.asString();
                    break;
                case "attachment":
                    this.attachment = val.asString();
                    break;
                case "rating":
                    this.rating = val.asLong();
                    break;
                case "responses":
                    for (JsonValue o : val.asArray()) {
                        this.responses.add(new TicketResponse(o.asObject()));
                    }
                    break;
            }
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public long getSupportDepartmentId() {
        return supportDepartmentId;
    }

    public void setSupportDepartmentId(long supportDepartmentId) {
        this.supportDepartmentId = supportDepartmentId;
    }

    public long getSupportCategoryId() {
        return supportCategoryId;
    }

    public void setSupportCategoryId(long supportCategoryId) {
        this.supportCategoryId = supportCategoryId;
    }

    public long getSupportStatusId() {
        return supportStatusId;
    }

    /*
     * public void setSupportStatusId(long supportStatusId) {
     * this.supportStatusId = supportStatusId; }
     */
    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getRecipients() {
        return recipients;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public Date getTimeClosed() {
        return timeClosed;
    }

    public Date getTimeAssigned() {
        return timeAssigned;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public String getAttachment() {
        return attachment;
    }

    public long getRating() {
        return rating;
    }

    public List<TicketResponse> getResponses() {
        return responses;
    }

    public String toJson() {
        JsonObject json = new JsonObject();
        json.add("SupportDepartmentId", this.supportDepartmentId);
        json.add("SupportCategoryId", this.supportCategoryId);
        json.add("Priority", this.priority);
        json.add("Source", source);
        json.add("Subject", subject);
        json.add("Content", content);

        return json.toString();
    }

    public String getAssignedTo() {
        return assignedTo;
    }
}
