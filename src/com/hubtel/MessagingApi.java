/**
 *
 */
package com.hubtel;

import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public class MessagingApi extends AbstractApi {

    /**
     * @param apiHost
     */
    public MessagingApi(ApiHost apiHost) {
        super(apiHost);
    }

    /**
     * Sends a message or Schedules a message by setting the message time
     * property.
     *
     * @param mesg the message to send.
     * @return instance of MessageResponse or null. Null does not mean that
     * there is necessary errors it can also mean that the requested object does
     * not exist. To be sure of that just check whether there is an exception
     * thrown
     */
    public MessageResponse sendMessage(Message mesg) throws HttpRequestException {
        if (mesg == null) {
            throw new NullPointerException("mesg");
        }
        String resource = "/messages/";
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, mesg.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new MessageResponse(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Sends a quick SMS message.
     *
     * @param from sender address of the message.
     * @param to recipient phone number of the message.
     * @param content content of the message.
     * @return instance of MessageResponse or null. Null does not mean that
     * there is necessary errors it can also mean that the requested object does
     * not exist. To be sure of that just check whether there is an exception
     * thrown
     */
    public MessageResponse sendQuickMessage(String from, String to, String content, String billingInfo,boolean registeredDelivery) throws HttpRequestException {
        Message mesg = new Message();
        mesg.setFrom(from).setTo(to).setContent(content);
        mesg.setBillingInfo(billingInfo);
        mesg.setRegisteredDelivery(registeredDelivery);
        return sendMessage(mesg);
    }

    /**
     * Reschedule a scheduled message.
     *
     * @param mesgId ID of the scheduled message.
     * @param time new date and time to send the message.
     * @return instance of MessageResponse or null. Null does not mean that
     * there is necessary errors it can also mean that the requested object does
     * not exist. To be sure of that just check whether there is an exception
     * thrown
     */
    public MessageResponse scheduleMessage(UUID mesgId, Date time) throws HttpRequestException {
        if (mesgId == null) {
            throw new NullPointerException("mesgId");
        }
        if (time == null) {
            throw new NullPointerException("time");
        }
        String resource = "/messages/" + mesgId.toString().replace("-", "");
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, new JsonObject().add("Time", time).toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MessageResponse(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public MessageResponse scheduleMessage(String mesgId, Date time) throws HttpRequestException {
        if (mesgId == null) {
            throw new NullPointerException("mesgId");
        }
        if (time == null) {
            throw new NullPointerException("time");
        }
        String resource = "/messages/" + mesgId.replace("-", "");
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, new JsonObject().add("Time", time).toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MessageResponse(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves details of a message.
     *
     * @param messageId ID of the message.
     * @return instance of Message or null. Null does not mean that there is
     * necessary errors it can also mean that the requested object does not
     * exist. To be sure of that just check whether there is an exception thrown
     */
    public Message getMessage(UUID messageId) throws HttpRequestException {
        if (messageId == null) {
            throw new NullPointerException("messageId");
        }

        String resource = "/messages/" + messageId.toString().replace("-", "");
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Message(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves details of a message.
     *
     * @param messageId ID of the message.
     * @return instance of Message or null. Null does not mean that there is
     * necessary errors it can also mean that the requested object does not
     * exist. To be sure of that just check whether there is an exception thrown
     */
    public Message getMessage(String messageId) throws HttpRequestException {
        if (messageId == null) {
            throw new NullPointerException("messageId");
        }

        String resource = "/messages/" + messageId.replace("-", "");
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Message(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves messages by several parameters.
     *
     * @param start the date to start querying from.
     * @param end the last possible time in the query.
     * @param index the number of results to skip from the result set.
     * @param limit the maximum number of results to return.
     * @param pending indicates if only scheduled messages should be returned.
     * @param direction an in or out value used to filter
     * @return ApiList of Message.Null does not mean that there is necessary
     * errors it can also mean that the requested object does not exist. To be
     * sure of that just check whether there is an exception thrown
     */
    public ApiList<Message> getMessages(Date start, Date end, int index, int limit, boolean pending, String direction) throws HttpRequestException {
        String resource = "/messages/";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ParameterMap params = this.httpClient.newParams();
        if (start != null) {
            params.add("start", dateFormat.format(start));
        }
        if (end != null) {
            params.add("end", dateFormat.format(end));
        }
        if (index > 0) {
            params.add("index", String.valueOf(index));
        }
        if (limit > 0) {
            params.add("limit", String.valueOf(limit));
        }
        if (pending) {
            params.add("pending", "true");
        }
        if (direction != null && !direction.isEmpty()) {
            params.add("direction", direction.trim());
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<Message>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get the senders IDs list by page and page size
     *
     * @param page The page Index or number
     * @param pageSize The number of items to display on a page
     * @return ApiList of Sender
     */
    public ApiList<Sender> getSenderIds(int page, int pageSize) throws HttpRequestException {
        String resource = "/senders/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }

        if (page <= 0 && pageSize <= 0) {
            params = null;
        }

        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<Sender>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get the overall list of Senders IDs
     *
     * @return
     */
    public ApiList<Sender> getSenderIds() throws HttpRequestException {
        return getSenderIds(-1, -1);
    }

    /**
     * Get Sender ID by id
     *
     * @param senderId the Sender ID id
     * @return an instance of Sender
     */
    public Sender getSenderId(long senderId) throws HttpRequestException {
        String resource = "/senders/" + senderId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Sender(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Create a Sender ID
     *
     * @param sender the Sender ID object
     * @return instance of Sender
     */
    public Sender addSenderId(Sender sender) throws HttpRequestException {
        String resource = "/senders/";
        if (sender == null) {
            throw new NullPointerException("sender");
        }
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, sender.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Sender(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Update Sender Id
     *
     * @param sender The Sender Id to update
     * @return Updated sender
     */
    public Sender updateSenderId(Sender sender) throws HttpRequestException {
        if (sender == null) {
            throw new NullPointerException("sender");
        }

        // Set the PUT resource
        String resource = "/senders/" + sender.getId();
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, sender.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Sender(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Delete a Sender
     *
     * @param senderId The Sender ID to delete
     * @return true or false
     */
    public boolean deleteSenderId(long senderId) throws HttpRequestException {
        String resource = "/senders/" + senderId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves message templates by page and page size
     *
     * @param page The page Index or number
     * @param pageSize The number of items to display on a page
     * @return ApiList of Template
     */
    public ApiList<MessageTemplate> getMessageTemplates(int page, int pageSize) throws HttpRequestException {
        String resource = "/templates/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }

        if (page <= 0 && pageSize <= 0) {
            params = null;
        }

        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<MessageTemplate>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all message templates.
     *
     * @return ApiList of Template
     */
    public ApiList<MessageTemplate> getMessageTemplates() throws HttpRequestException {
        return getMessageTemplates(-1, -1);
    }

    /**
     * Retrieves message template by ID.
     *
     * @param templateId the ID of message template to query.
     * @return instance of Template representing the queried template.
     */
    public MessageTemplate getMessageTemplate(long templateId) throws HttpRequestException {
        String resource = "/templates/" + templateId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MessageTemplate(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Create a Message Template
     *
     * @param template the Template object
     * @return instance of Template
     */
    public MessageTemplate addMessageTemplate(MessageTemplate template) throws HttpRequestException {
        String resource = "/templates/";
        if (template == null) {
            throw new HttpRequestException(new NullPointerException("template"));
        }
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, template.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MessageTemplate(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Update Message Template
     *
     * @param template The template to update
     * @return Updated template
     */
    public MessageTemplate updateMessageTemplate(MessageTemplate template) throws HttpRequestException {
        if (template == null) {
            throw new NullPointerException("template");
        }

        // Set the PUT resource
        String resource = "/templates/" + template.getId();
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, template.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MessageTemplate(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Delete a Message Template
     *
     * @param templateId The Message Template to delete
     * @return true or false
     */
    public boolean deleteMessageTemplate(long templateId) throws HttpRequestException {
        String resource = "/templates/" + templateId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves number plans by page and page size and type
     *
     * @param page one-based index of the page to query.
     * @param pageSize maximum number of entries on a page.
     * @param type number plan type
     * @return ApiList of NumberPlan
     */
    public ApiList<NumberPlan> getNumberPlans(int page, int pageSize, int type) throws HttpRequestException {
        String resource = "/numberplans/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }
        if (type >= 0) {
            params.add("Type", String.valueOf(type));
        }

        if (page <= 0 && pageSize <= 0 && type < 0) {
            params = null;
        }

        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<NumberPlan>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all number plans.
     *
     * @return ApiList of NumberPlan
     */
    public ApiList<NumberPlan> getNumberPlans() throws HttpRequestException {
        return getNumberPlans(-1, -1, -1);
    }

    /**
     * Retrieves number plan keywords by page and page size.
     *
     * @param numberPlanId ID of the number plan to query.
     * @param page one-based index of the page to query.
     * @param pageSize maximum number of entries on a page.
     * @return ApiList of MoKeyWord
     */
    public ApiList<MoKeyWord> getNumberPlanMoKeywords(long numberPlanId, int page, int pageSize) throws HttpRequestException {
        String resource = "/numberplans/" + numberPlanId + "/keywords/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }
        if (page <= 0 && pageSize <= 0) {
            params = null;
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<MoKeyWord>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all keywords for a particular number plan.
     *
     * @param numberPlanId ID of the number plan to query.
     * @return ApiList of MoKeyWord
     */
    public ApiList<MoKeyWord> getNumberPlanMoKeywords(long numberPlanId) throws HttpRequestException {
        return getNumberPlanMoKeywords(numberPlanId, -1, -1);
    }

    /**
     * Retrieves campaign keywords by page and page size.
     *
     * @param campaignId ID of the campaign to query.
     * @param page one-based index of the page to query.
     * @param pageSize maximum number of entries on a page.
     * @return ApiList of MoKeyWord
     */
    public ApiList<MoKeyWord> getCampaignMoKeywords(long campaignId, int page, int pageSize) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/keywords/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }
        if (page <= 0 && pageSize <= 0) {
            params = null;
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<MoKeyWord>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all keywords for a particular campaign.
     *
     * @param campaignId ID of the campaign to query.
     * @return ApiList of MoKeyWord
     */
    public ApiList<MoKeyWord> getCampaignMoKeywords(long campaignId) throws HttpRequestException {
        return getCampaignMoKeywords(campaignId, -1, -1);
    }

    /**
     * Retrieves campaigns by page and page size and type
     *
     * @param page one-based index of the page to query.
     * @param pageSize maximum number of entries on a page.
     * @param type number plan type
     * @return ApiList of Campaign
     */
    public ApiList<Campaign> getCampaigns(int page, int pageSize) throws HttpRequestException {
        String resource = "/campaigns/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }

        if (page <= 0 && pageSize <= 0) {
            params = null;
        }

        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<Campaign>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all Campaigns.
     *
     * @return ApiList of Campaign
     */
    public ApiList<Campaign> getCampaigns() throws HttpRequestException {
        return getCampaigns(-1, -1);
    }

    /**
     * Get Campaign by id
     *
     * @param campaignId ID of the campaign to query.
     * @return an instance of Campaign
     */
    public Campaign getCampaign(long campaignId) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get NumberPlan by id
     *
     * @param numberPlanId
     * @return an instance of NumberPlan
     */
    public NumberPlan getNumberPlan(long numberPlanId) throws HttpRequestException {
        String resource = "/numberplans/" + numberPlanId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new NumberPlan(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves MoKeyWords by page and page size and type
     *
     * @param page one-based index of the page to query.
     * @param pageSize maximum number of entries on a page.
     * @param type number plan type
     * @return ApiList of MoKeyWord
     */
    public ApiList<MoKeyWord> getMoKeywords(int page, int pageSize) throws HttpRequestException {
        String resource = "/keywords/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }

        if (page <= 0 && pageSize <= 0) {
            params = null;
        }

        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<MoKeyWord>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all MO keywords
     *
     * @return ApiList of MoKeyWord
     */
    public ApiList<MoKeyWord> getMoKeywords() throws HttpRequestException {
        return getMoKeywords(-1, -1);
    }

    /**
     * Get Keyword by id
     *
     * @param keywordId
     * @return an instance of MoKeyWord
     */
    public MoKeyWord getMoKeyword(long keywordId) throws HttpRequestException {
        String resource = "/keywords/" + keywordId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MoKeyWord(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Creates a new campaign.
     *
     * @param campaign campaign to create
     * @return instance of created campaign or null
     */
    public Campaign addCampaign(Campaign campaign) throws HttpRequestException {
        String resource = "/campaigns/";
        if (campaign == null) {
            throw new NullPointerException("campaign");
        }
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, campaign.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates a campaign.
     *
     * @param campaign campaign to update.
     * @return instance of the updated campaign or null
     */
    public Campaign updateCampaign(Campaign campaign) throws HttpRequestException {
        if (campaign == null) {
            throw new NullPointerException("campaign");
        }

        // Set the PUT resource
        String resource = "/campaigns/" + campaign.getCampaignId();
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, campaign.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes a campaign.
     *
     * @param campaignId ID of the campaign to delete
     * @return true when deleted and false when deletion fails
     */
    public boolean deleteCampaign(long campaignId) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Creates a new MO keyword.
     *
     * @param keyword the MO keyword to create.
     * @return instance of MoKeyWord or null
     */
    public MoKeyWord addMoKeyword(MoKeyWord keyword) throws HttpRequestException {
        String resource = "/keywords/";
        if (keyword == null) {
            throw new NullPointerException("keyword");
        }
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, keyword.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MoKeyWord(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates an MO keyword.
     *
     * @param keyword the MO keyword to update.
     * @return instance of updated MoKeyWord
     */
    public MoKeyWord updateMoKeyword(MoKeyWord keyword) throws HttpRequestException {
        if (keyword == null) {
            throw new NullPointerException("keyword");
        }

        // Set the PUT resource
        String resource = "/keywords/" + keyword.getId();
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, keyword.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new MoKeyWord(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes an MO keyword.
     *
     * @param keywordId ID of the keyword to delete
     * @return true when deleted or false when deletion fails
     */
    public boolean deleteMoKeyword(long keywordId) throws HttpRequestException {
        String resource = "/keywords/" + keywordId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_NO_CONTENT) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     *
     * @param campaignId ID of the campaign to have the MO keyword
     * @param keywordId ID of the MO keyword to add to campaign.
     * @return instance of Campaign represented the campaign to which the MO
     * keyword was added or null in case of errors
     */
    public Campaign setCampaignMoKeyword(long campaignId, long keywordId) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/keywords/" + keywordId;
        HttpResponse response = this.httpClient.put(resource, null, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     *
     * @param campaignId ID of the campaign having the MO keyword.
     * @param keywordId ID of the keyword to remove from the campaign.
     * @return instance of Campaign represented the campaign from which the MO
     * keyword was removed or null in case of errors
     */
    public Campaign deleteCampaignMoKeyword(long campaignId, long keywordId) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/keywords/" + keywordId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves actions on a campaign by page and page size.
     *
     * @param campaignId ID of the campaign to query.
     * @param page page one-based index of the page to query.
     * @param pageSize pageSize maximum number of entries in a page.
     * @return ApiList of Action
     */
    public ApiList<Action> getCampaignActions(long campaignId, int page, int pageSize) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/actions/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }
        if (page <= 0 && pageSize <= 0) {
            params = null;
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<Action>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all actions on a campaign.
     *
     * @param campaignId ID of the campaign to query.
     * @return ApiList of Action
     */
    public ApiList<Action> getCampaignActions(long campaignId) throws HttpRequestException {
        return getCampaignActions(campaignId, -1, -1);
    }

    /**
     * Adds a default reply text action to campaign.
     *
     * @param campaignId ID of the campaign to add the action to.
     * @param message he default reply action text to add
     * @return instance of Campaign represented the campaign to which the action
     * was added or null in case of errors
     */
    public Campaign setCampaignDefaultReplyTextAction(long campaignId, String message) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/actions/default_reply";
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, new JsonObject().add("message", message).toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Adds a dynamic URL action, with send response, to campaign.
     *
     * @param campaignId ID of the campaign to add the action to.
     * @param url the dynamic URL to add.
     * @param sendResponse a Yes or No value.
     * @return instance of Campaign represented the campaign to which the action
     * was added or null in case of errors
     */
    public Campaign setCampaignDynamicUrlAction(long campaignId, String url, String sendResponse) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/actions/dynamic_url";
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, new JsonObject().add("url", url).add("send_response", sendResponse).toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Adds a dynamic URL action, with no send response, to campaign.
     *
     * @param campaignId ID of the campaign to add the action to.
     * @param url the dynamic URL to add.
     * @return instance of Campaign represented the campaign to which the action
     * was added or null in case of errors
     */
    public Campaign setCampaignDynamicUrlAction(long campaignId, String url) throws HttpRequestException {
        return setCampaignDynamicUrlAction(campaignId, url, "No");
    }

    /**
     * Adds an email address action to campaign.
     *
     * @param campaignId ID of the campaign to add the action to.
     * @param address the email address to add.
     * @return instance of Campaign represented the campaign to which the action
     * was added or null in case of errors
     */
    public Campaign setCampaignEmailAddressAction(long campaignId, String address) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/actions/email";
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, new JsonObject().add("address", address).toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Adds a forward-to-mobile action to campaign.
     *
     * @param campaignId ID of the campaign to add the action to.
     * @param number the mobile phone number to add.
     * @return instance of Campaign represented the campaign to which the action
     * was added or null in case of errors
     */
    public Campaign setCampaignForwardToMobileAction(long campaignId, String number) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/actions/phone";
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, new JsonObject().add("number", number).toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Adds a forward-to-SMPP action to campaign.
     *
     * @param campaignId ID of the campaign to add the action to.
     * @param smppApiId the smpp api id
     * @return instance of Campaign represented the campaign to which the action
     * was added or null in case of errors
     */
    public Campaign setCampaignForwardToSmppAction(long campaignId, String smppApiId) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/actions/smpp";
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, new JsonObject().add("api_id", smppApiId).toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Removes an action from a campaign.
     *
     * @param campaignId ID of the campaign to remove the action from.
     * @param actionId ID of the action to remove from campaign.
     * @return instance of Campaign representing the campaign the action was
     * removed from.
     */
    public Campaign deleteCampaignAction(long campaignId, long actionId) throws HttpRequestException {
        String resource = "/campaigns/" + campaignId + "/actions/" + actionId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Campaign(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

}
