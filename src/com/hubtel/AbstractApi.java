/**
 *
 */
package com.hubtel;

/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public abstract class AbstractApi {

    private final ApiHost apiHost;
    protected final BasicHttpClient httpClient;

    /**
     *
     */
    public AbstractApi(ApiHost apiHost) {
        this.apiHost = apiHost;

        // Set the baseUrl for the http client
        String baseUrl = this.apiHost.isSecuredConnection() ? "https://" : "http://";
        baseUrl += this.apiHost.getHostname();
        if (this.apiHost.getPort() > 0) {
            baseUrl += ":" + this.apiHost.getPort();
        }
        if (this.apiHost.getContextPath() != null && this.apiHost.getContextPath().length() != 0) {
            baseUrl += "/" + this.apiHost.getContextPath();
        }

        // baseUrl += "/";
        this.httpClient = new BasicHttpClient(baseUrl, this.apiHost.isConsoleLogEnabled());

        // Add additional headers to process requests
        this.httpClient.addHeader("Authorization", this.apiHost.getAuthenticator().getCredentials());
        this.httpClient.addHeader("Accept", "application/json");
        httpClient.setConnectionTimeout(this.apiHost.getTimeout());
        httpClient.setReadTimeout(this.apiHost.getTimeout());
    }

}
