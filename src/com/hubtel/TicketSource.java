/**
 *
 */
package com.hubtel;

/**
 * @author Administrator
 *
 */
public enum TicketSource {

    PHONE("Phone"), EMAIL("Email"), FORUM("Forum"), IN_PERSON("In Person"), CHAT(
            "Chat"), SOCIAL_NETWORK("Social Network");

    private String source;

    private TicketSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }
}
