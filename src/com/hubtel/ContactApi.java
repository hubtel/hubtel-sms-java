/**
 *
 */
package com.hubtel;

import java.net.HttpURLConnection;


/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public class ContactApi extends AbstractApi {

    /**
     * @param apiHost
     */
    public ContactApi(ApiHost apiHost) {
        super(apiHost);
    }

    /**
     * Retrieves contacts by page, page size, group ID and filter.
     *
     * @param page Page number
     * @param pageSize maximum number of entries on a page.
     * @param groupId the ID of contact group to search within.
     * @param filter name filter to apply to contacts.
     * @return ApiList of Contact or null. Null does not mean that there is
     * necessary errors it can also mean that the requested object does not
     * exist. To be sure of that just check whether there is an exception thrown
     */
    public ApiList<Contact> getContacts(int page, int pageSize, long groupId, String filter) throws HttpRequestException {
        String resource = "/contacts/";
        ParameterMap params = this.httpClient.newParams();
        if (page > 0) {
            params.add("Page", String.valueOf(page));
        }
        if (pageSize > 0) {
            params.add("PageSize", String.valueOf(pageSize));
        }
        if (groupId > 0) {
            params.add("GroupId", String.valueOf(groupId));
        }
        if (filter != null) {
            params.add("Search", filter);
        }

        if (page <= 0 && pageSize <= 0 && groupId <= 0 && (filter == null || filter.length() == 0)) {
            params = null;
        }
        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ApiList<Contact>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves contacts by page and page size.
     *
     * @param page Page number
     * @param pageSize maximum number of entries on a page.
     * @return ApiList of Contact null. Null does not mean that there is
     * necessary errors it can also mean that the requested object does not
     * exist. To be sure of that just check whether there is an exception thrown
     */
    public ApiList<Contact> getContacts(int page, int pageSize) throws HttpRequestException {
        return getContacts(page, pageSize, -1, null);
    }

    /**
     * Retrieves contacts by group ID and filter.
     *
     * @param groupId the ID of the group to search within.
     * @param filter name filter to apply to contacts.
     * @return ApiList of Contact when successful or null. Null does not mean
     * that there is necessary errors it can also mean that the requested object
     * does not exist. To be sure of that just check whether there is an
     * exception thrown
     */
    public ApiList<Contact> getContacts(int groupId, String filter) throws HttpRequestException {
        return getContacts(-1, -1, groupId, filter);
    }

    public ApiList<Contact> getContacts(int page, int pageSize, int groupId) throws HttpRequestException {
        return getContacts(page, pageSize, groupId, null);
    }

    public ApiList<Contact> getContacts(int page, int pageSize, String filter) throws HttpRequestException {
        return getContacts(page, pageSize, -1, filter);
    }

    public ApiList<Contact> getContacts(int groupId) throws HttpRequestException {
        return getContacts(-1, -1, groupId, null);
    }

    public ApiList<Contact> getContacts(String filter) throws HttpRequestException {
        return getContacts(-1, -1, -1, filter);
    }

    /**
     * List all contacts
     *
     * @return ApiList of Contact when successful or null. Null does not mean
     * that there is necessary errors it can also mean that the requested object
     * does not exist. To be sure of that just check whether there is an
     * exception thrown
     */
    public ApiList<Contact> getContacts() throws HttpRequestException {
        return getContacts(-1, -1, -1, null);
    }

    /**
     * Retrieves a contact by ID.
     *
     * @param contactId ID of the contact to query.
     * @return instance of Contact representing the queried contact or null.
     * Null does not mean that there is necessary errors it can also mean that
     * the requested object does not exist. To be sure of that just check
     * whether there is an exception thrown
     */
    public Contact getContact(long contactId) throws HttpRequestException {
        String resource = "/contacts/" + contactId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Contact(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Creates a new contact.
     *
     * @param contact the contact to create.
     * @return instance of Contact representing the queried contact or null.
     * Null does not mean that there is necessary errors it can also mean that
     * the requested object does not exist. To be sure of that just check
     * whether there is an exception thrown
     */
    public Contact addContact(ParameterMap contact) throws HttpRequestException {
        String resource = "/contacts/";
        if (contact == null) {
            throw new NullPointerException("contact");
        }
        HttpResponse response = this.httpClient.post(resource, contact);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new Contact(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public Contact addContact(Contact contact) throws HttpRequestException {
        String resource = "/contacts/";
        if (contact == null) {
            throw new NullPointerException("contact");
        }
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, contact.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new Contact(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates details of a contact.
     *
     * @param contact the contact to update.
     * @return true or false
     */
    public boolean updateContact(Contact contact) throws HttpRequestException {
        if (contact == null) {
            throw new NullPointerException("contact");
        }

        // Set the PUT resource
        String resource = "/contacts/" + contact.getContactId();
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, contact.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public boolean updateContact(long contactId, Contact contact) throws HttpRequestException {
        if (contact == null) {
            throw new NullPointerException("contact");
        }

        // Set the PUT resource
        String resource = "/contacts/" + contactId;
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, contact.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public boolean updateContact(long contactId, ParameterMap contact) throws HttpRequestException {
        if (contact == null) {
            throw new NullPointerException("contact");
        }

        // Set the PUT resource
        String resource = "/contacts/" + contactId;
        HttpResponse response = this.httpClient.put(resource, contact);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes a contact.
     *
     * @param contactId ID of the contact to delete.
     * @return true or false
     */
    public boolean deleteContact(long contactId) throws HttpRequestException {
        String resource = "/contacts/" + contactId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves contact groups by page and page size.
     *
     * @param page The Page Number
     * @param pageSize The number of data to display on a page
     * @return ApiList of ContactGroup or null. Null does not mean that there is
     * necessary errors it can also mean that the requested object does not
     * exist. To be sure of that just check whether there is an exception thrown
     */
    public ApiList<ContactGroup> getContactGroups(int page, int pageSize) throws HttpRequestException {
        String resource = "/contacts/groups/";
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
            return new ApiList<ContactGroup>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Retrieves all contact groups.
     *
     * @return ApiList of ContactGroup or null. Null does not mean that there is
     * necessary errors it can also mean that the requested object does not
     * exist. To be sure of that just check whether there is an exception thrown
     */
    public ApiList<ContactGroup> getContactGroups() throws HttpRequestException {
        return getContactGroups(-1, -1);
    }

    /**
     * Retrieves a contact Group by ID.
     *
     * @param groupId ID of the contact group to query.
     * @return instance of ContactGroup representing the queried contact or
     * null. Null does not mean that there is necessary errors it can also mean
     * that the requested object does not exist. To be sure of that just check
     * whether there is an exception thrown
     */
    public ContactGroup getContactGroup(long groupId) throws HttpRequestException {
        String resource = "/contacts/groups/" + groupId;
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new ContactGroup(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Creates a new contact group.
     *
     * @param group the contact group to create.
     * @return instance of ContactGroup representing the queried contact or
     * null. Null does not mean that there is necessary errors it can also mean
     * that the requested object does not exist. To be sure of that just check
     * whether there is an exception thrown
     * @throws com.hubtel.HttpRequestException
     */
    public ContactGroup addContactGroup(ContactGroup group) throws HttpRequestException {
        String resource = "/contacts/groups/";
        if (group == null) {
            throw new NullPointerException("group");
        }
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, group.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContactGroup(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ContactGroup addContactGroup(String groupName) throws HttpRequestException {
        String resource = "/contacts/groups/";
        if (groupName == null || groupName.length() == 0) {
            throw new NullPointerException("groupName");
        }
        ParameterMap params = this.httpClient.newParams();
        params.add("Name", groupName);
        HttpResponse response = this.httpClient.post(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContactGroup(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public ContactGroup addContactGroup(ParameterMap group) throws HttpRequestException {
        String resource = "/contacts/groups/";
        if (group == null) {
            throw new NullPointerException("group");
        }
        HttpResponse response = this.httpClient.post(resource, group);
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return new ContactGroup(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Updates details of a contact group.
     *
     * @param group the contact group to update.
     * @return true or false
     * @throws com.hubtel.HttpRequestException
     */
    public boolean updateContactGroup(ContactGroup group) throws HttpRequestException {
        if (group == null) {
            throw new NullPointerException("group");
        }

        // Set the PUT resource
        String resource = "/contacts/groups/" + group.getGroupId();
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, group.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public boolean updateContactGroup(long groupId, ParameterMap group) throws HttpRequestException {
        if (group == null) {
            throw new NullPointerException("group");
        }

        // Set the PUT resource
        String resource = "/contacts/groups/" + groupId;
        HttpResponse response = this.httpClient.put(resource, group);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public boolean updateContactGroup(long groupId, ContactGroup group) throws HttpRequestException {
        if (group == null) {
            throw new NullPointerException("group");
        }

        // Set the PUT resource
        String resource = "/contacts/groups/" + groupId;
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, group.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    public boolean updateContactGroup(long groupId, String groupName) throws HttpRequestException {
        if (groupName == null || groupName.length() == 0) {
            throw new NullPointerException("group");
        }

        // Set the PUT resource
        String resource = "/contacts/groups/" + groupId;
        ParameterMap params = this.httpClient.newParams();
        params.add("Name", groupName);

        HttpResponse response = this.httpClient.put(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Deletes a contact group.
     *
     * @param groupId ID of the contact group to delete.
     * @return true or false
     */
    public boolean deleteContactGroup(long groupId) throws HttpRequestException {
        String resource = "/contacts/groups/" + groupId;
        HttpResponse response = this.httpClient.delete(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }
}
