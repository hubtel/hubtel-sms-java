/**
 *
 */
package com.hubtel;

/**
 * @author Arsene
 *
 */
public class ApiHost {

    private IAuth iAuth;
    private String hostname;
    private int port;
    private String contextPath;
    private boolean securedConnection;
    private boolean consoleLogEnabled;
    private int timeout;

    /**
     *
     */
    public ApiHost() {
        this.hostname = "smsc.hubtel.com";
        this.iAuth = null;
        this.consoleLogEnabled = false;
        this.contextPath = "v1";
        this.port = -1;
        this.timeout = 5000;
        this.securedConnection = true;
    }


    public ApiHost(IAuth iauth) {
        this();
        this.iAuth = iauth;
    }    

    /**
     * @return the authorization
     */
    public IAuth getAuthenticator() {
        return iAuth;
    }

    /**
     * @param authorization the authorization to set
     * @return
     */
    public ApiHost setAuthorization(IAuth authorization) {
        this.iAuth = authorization;
        return this;
    }

    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     * @return
     */
    public ApiHost setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     * @return
     */
    public ApiHost setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * @return the contextPath
     */
    public String getContextPath() {
        return contextPath;
    }

    /**
     * @param contextPath the contextPath to set
     * @return
     */
    public ApiHost setContextPath(String contextPath) {
        this.contextPath = contextPath;
        return this;
    }

    /**
     * @return the securedConnection
     */
    public boolean isSecuredConnection() {
        return securedConnection;
    }

    /**
     * @param securedConnection the securedConnection to set
     * @return
     */
    public ApiHost setSecuredConnection(boolean securedConnection) {
        this.securedConnection = securedConnection;
        return this;
    }

    /**
     * @return the consoleLogEnabled
     */
    public boolean isConsoleLogEnabled() {
        return consoleLogEnabled;
    }

    /**
     * @param consoleLogEnabled the consoleLogEnabled to set
     * @return
     */
    public ApiHost setConsoleLogEnabled(boolean consoleLogEnabled) {
        this.consoleLogEnabled = consoleLogEnabled;
        return this;
    }

    /**
     * @return the timeout
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * @param timeout the timeout to set
     * @return
     */
    public ApiHost setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

}
