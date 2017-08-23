/**
 *
 */
package com.hubtel;


/**
 * @author Administrator
 *
 */
public class OAuth implements IAuth {

    private String bearerToken;

    /**
     *
     */
    public OAuth(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    /**
     * @return the bearerToken
     */
    private String getBearerToken() {
        return bearerToken;
    }

    @Override
    public String getCredentials() {
        return String.format("Bearer %s", getBearerToken());
    }

}
