/**
 *
 */
package com.hubtel;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;



/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public class AccountApi extends AbstractApi {

    /**
     *
     * @param apiHost
     */
    public AccountApi(ApiHost apiHost) {
        super(apiHost);
    }

    /**
     * Gets the Account Profile
     *
     * @return AccountProfile
     * @throws Exception
     */
    public AccountProfile getProfile() throws Exception {
        // Let us set the resource to access
        String resource = "/account/profile/";
        try {
            HttpResponse response = this.httpClient.get(resource, null);
            if (response.getStatus() == HttpURLConnection.HTTP_OK) {
                return new AccountProfile(JsonObject.readFrom(response.getBodyAsString()));
            } else {
                throw new HttpRequestException(new Exception("Request Failed"), response);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Get the Primary Account Contact
     *
     * @return instance of AccountContact
     * @throws Exception
     */
    public AccountContact getPrimaryContact() throws Exception {
        // Let us set the resource to access
        String resource = "/account/primary_contact/";
        try {
            HttpResponse response = this.httpClient.get(resource, null);
            if (response.getStatus() == HttpURLConnection.HTTP_OK) {
                return new AccountContact(JsonObject.readFrom(response.getBodyAsString()));
            } else {
                throw new HttpRequestException(new Exception("Request Failed"), response);
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Get the Billing Account Contact
     *
     * @return instance of AccountContact
     * @throws Exception
     */
    public AccountContact getBillingContact() throws Exception {
        // Let us set the resource to access
        String resource = "/account/billing_contact/";
        try {
            HttpResponse response = this.httpClient.get(resource, null);
            if (response.getStatus() == HttpURLConnection.HTTP_OK) {
                return new AccountContact(JsonObject.readFrom(response.getBodyAsString()));
            } else {
                throw new HttpRequestException(new Exception("Request Failed"), response);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Get the Technical Account Contact
     *
     * @return instance of AccountContact
     * @throws HttpRequestException
     */
    public AccountContact getTechnicalContact() throws HttpRequestException {
        // Let us set the resource to access
        String resource = "/account/technical_contact/";
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new AccountContact(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get the Account Contacts List
     *
     * @return List of AccountContact
     * @throws HttpRequestException
     */
    public List<AccountContact> getContacts() throws HttpRequestException {
        // Let us set the resource to access
        String resource = "/account/contacts/";
        List<AccountContact> contacts = new ArrayList<AccountContact>();
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            JsonArray array = JsonArray.readFrom(response.getBodyAsString());
            for (JsonValue jsonValue : array) {
                contacts.add(new AccountContact(jsonValue.asObject()));
            }
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
        return contacts;
    }

    /**
     * Update an Account Contact
     *
     * @param accountContact
     * @return true when it is successful or an exception when it fails
     * @throws HttpRequestException
     */
    public boolean updateAccountContact(AccountContact accountContact) throws HttpRequestException {
        if (accountContact == null) {
            throw new NullPointerException("accountContact");
        }

        // Set the PUT resource
        String resource = "/account/contacts/" + accountContact.getAccountContactId();
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, accountContact.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get the list of services associated with the Account by page and page
     * size
     *
     * @param page The page Index or number
     * @param pageSize The number of items to display on a page
     * @return ApiList of Service
     * @throws HttpRequestException
     */
    public ApiList<Service> getServices(int page, int pageSize) throws HttpRequestException {
        String resource = "/account/services/";
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
            return new ApiList<Service>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get the overall list of services associated with the account
     *
     * @return ApiList of Service
     */
    public ApiList<Service> getServices() throws HttpRequestException {
        return getServices(-1, -1);
    }

    /**
     * Get the settings attached to the account.
     *
     * @return an instance of Settings
     */
    public Settings getSettings() throws HttpRequestException {
        String resource = "/account/settings/";
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Settings(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);

        }
    }

    /**
     * Update Account Contact settings
     *
     * @param settings
     * @return Updated settings
     */
    public Settings updateAccountSettings(Settings settings) throws HttpRequestException {
        if (settings == null) {
            throw new NullPointerException("settings");
        }

        // Set the PUT resource
        String resource = "/account/settings/";
        String contentType = "application/json";
        HttpResponse response = this.httpClient.put(resource, contentType, settings.toJson().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Settings(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get account invoices by page and page size
     *
     * @param page
     * @param pageSize
     * @return ApiList of Invoice
     */
    public ApiList<Invoice> getInvoices(int page, int pageSize) throws HttpRequestException {
        String resource = "/account/invoices/";
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
            return new ApiList<Invoice>(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get the overall list of invoices attached with the account
     *
     * @return ApiList of Invoice
     */
    public ApiList<Invoice> getInvoices() throws HttpRequestException {
        return getInvoices(-1, -1);
    }

    /**
     * Get the five nearest TopUpLocations
     *
     * @param longitude
     * @param latitude
     * @return List of TopUpLocation
     */
    public List<TopupLocation> getTopupLocations(double longitude, double latitude) throws HttpRequestException {
        String resource = "/topup/voucher/vendors/";
        ParameterMap params = this.httpClient.newParams();
        params.add("Latitude", String.valueOf(latitude));
        params.add("Longitude", String.valueOf(longitude));

        List<TopupLocation> locs = new ArrayList<TopupLocation>(0);

        HttpResponse response = this.httpClient.get(resource, params);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            JsonObject jo = JsonObject.readFrom(response.getBodyAsString());
            String key = jo.names().iterator().next();
            if (key != null && key.equals("Locations")) {
                JsonValue val = jo.get(key);
                for (JsonValue o : val.asArray()) {
                    locs.add(new TopupLocation(o.asObject()));
                }
                return locs;
            }
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
        return null;
    }

    /**
     * Credit account with voucher
     *
     * @param voucherNumber The voucher Number
     * @return TopUp object
     */
    public Topup getVoucher(String voucherNumber) throws HttpRequestException {
        String resource = "/topup/voucher/";
        if (voucherNumber == null || voucherNumber.isEmpty()) {
            throw new IllegalArgumentException("voucher number is required");
        }

        resource += voucherNumber.trim();
        HttpResponse response = this.httpClient.get(resource, null);
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            return new Topup(JsonObject.readFrom(response.getBodyAsString()));
        } else {
            throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }
}
