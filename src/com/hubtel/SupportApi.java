/**
 *
 */
package com.hubtel;

import java.net.HttpURLConnection;

/**
 * @author ARsene Tochemey GANDOTE
 *
 */
public class SupportApi extends AbstractApi {

    /**
     *
     */
    public SupportApi(ApiHost apiHost) {
        super(apiHost);
    }

    /**
     * Get the paginated list of support tickets
     *
     * @param page The Page Number
     * @param pageSize The number of data to display on a page
     * @return ApiList of Ticket
     */
    public ApiList<Ticket> getSupportTickets(int page, int pageSize) throws HttpRequestException {
        String resource = "/tickets/";
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
            return new ApiList<Ticket>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get the list of all support tickets
     *
     * @return ApiList of Ticket
     */
    public ApiList<Ticket> getSupportTickets() throws HttpRequestException {
        return getSupportTickets(-1, -1);
    }

    /**
     * Get a ticket by id
     *
     * @param ticketId ticket id
     * @return instance of Ticket
     */
    public Ticket getSupportTicket(long ticketId) throws HttpRequestException {
        String resource = "/tickets/" + ticketId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Ticket(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Create a new Support Ticket
     *
     * @param ticket the ticket to create.
     * @return instance of Ticket
     */
    public Ticket addSupportTicket(Ticket ticket) throws HttpRequestException {
        String resource = "/tickets/";
        if (ticket == null) {
            throw new NullPointerException("ticket");
        }
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, ticket.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Ticket(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Add a reply to a ticket
     *
     * @param ticketId Ticket Id
     * @param reply the reply to add
     * @return instance of Ticket representing the ticket that has been replied
     */
    public Ticket updateSupportTicket(long ticketId, TicketResponse reply) {
        if (reply == null) {
            throw new NullPointerException("reply");
        }

        String resource = "/tickets/" + ticketId;
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, reply.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Ticket(JsonObject.readFrom(response.getBodyAsString()));
        }
        return null;
    }
}
