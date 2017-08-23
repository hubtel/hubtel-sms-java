/**
 * Logger {@link RequestLogger} used by {@link SdkHttpClient}. It helps to log
 * the Htp request on the console
 */
package com.hubtel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public class ApiConsoleRequestLogger implements RequestLogger {

    private final boolean logRequest;

    /**
     *
     */
    public ApiConsoleRequestLogger(boolean logRequest) {
        this.logRequest = logRequest;
    }

    @Override
    public boolean isLoggingEnabled() {
        return this.logRequest;
    }

    @Override
    public void log(String msg) {
        System.out.println(msg);
    }

    @Override
    public void logRequest(HttpURLConnection urlConnection, Object content) throws IOException {
        log("=== HTTP Request ===");
        log(urlConnection.getRequestMethod() + " " + urlConnection.getURL().toString());
        if (content instanceof String) {
            log("Content: " + (String) content);
        }
        logHeaders(urlConnection.getRequestProperties());
    }

    @Override
    public void logResponse(HttpResponse httpResponse) {
        if (httpResponse != null) {
            log("=== HTTP Response ===");
            log("Receive url: " + httpResponse.getUrl());
            log("Status: " + httpResponse.getStatus());
            logHeaders(httpResponse.getHeaders());
            log("Content:\n" + httpResponse.getBodyAsString());
        }
    }

    /**
     * Iterate over request or response headers and log them.
     *
     * @param map
     */
    private void logHeaders(Map<String, List<String>> map) {
        if (map != null) {
            for (String field : map.keySet()) {
                List<String> headers = map.get(field);
                for (String header : headers) {
                    log(field + ":" + header);
                }
            }
        }
    }

}
