/**
 *
 */
package com.hubtel;


/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public class BasicHttpClient extends AbstractHttpClient {

    private boolean loggingOption;

    static {
        ensureCookieManager();
    }

    /**
     *
     * @param baseUrl
     * @param requestHandler
     * @param loggingOption
     */
    public BasicHttpClient(String baseUrl, RequestHandler requestHandler, boolean loggingOption) {
        super(baseUrl, requestHandler);
        this.requestLogger = new ApiConsoleRequestLogger(loggingOption);
    }

    /**
     * @param baseUrl
     * @param requestHandler
     */
    public BasicHttpClient(String baseUrl, RequestHandler requestHandler) {
        super(baseUrl, requestHandler);
    }

    /**
     * Constructs the default client with empty baseUrl.
     */
    public BasicHttpClient() {
        this("");
    }

    /**
     * Constructs the default client with baseUrl.
     *
     * @param baseUrl
     */
    public BasicHttpClient(String baseUrl) {
        this(baseUrl, new BasicRequestHandler() {
        });
    }

    /**
     */
    public BasicHttpClient(String baseUrl, boolean loggingOption) {
        this(baseUrl, new BasicRequestHandler() {
        }, loggingOption);
    }

    /**
     * @return the loggingOption
     */
    public boolean isLoggingOption() {
        return loggingOption;
    }

    /**
     * @param loggingOption the loggingOption to set
     */
    public void setLoggingOption(boolean loggingOption) {
        this.loggingOption = loggingOption;
    }
}
