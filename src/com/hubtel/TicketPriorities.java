/**
 *
 */
package com.hubtel;

/**
 * @author Administrator
 *
 */
public enum TicketPriorities {

    LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4);

    private int value;

    private TicketPriorities(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
