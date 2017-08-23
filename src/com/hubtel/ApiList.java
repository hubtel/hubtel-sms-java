package com.hubtel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Represents an API list.
 *
 * @author Arsene Tochemey
 */
public class ApiList<T> implements Iterable<T> {

    private long count;
    private long totalPages;
    private List<T> items;

    /**
     * Used internally to initialize the data fields of this instance.
     *
     * @param json guaranteed instance of com.smsgh.json.JsonObject.
     */
    @SuppressWarnings("unchecked")
    public ApiList(JsonObject json) {
        this.items = new ArrayList<T>();
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "count":
                    this.count = val != null ? val.asLong() : 0;
                    break;
                case "totalpages":
                    this.totalPages = val != null ? val.asLong() : 0;
                    break;

                case "actionlist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new Action(o.asObject()));
                    }
                    break;

                case "campaignlist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new Campaign(o.asObject()));
                    }
                    break;

                case "contactlist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new Contact(o.asObject()));
                    }
                    break;

                case "grouplist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new ContactGroup(o.asObject()));
                    }
                    break;

                case "invoicestatementlist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new Invoice(o.asObject()));
                    }
                    break;

                case "messagetemplatelist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new MessageTemplate(o.asObject()));
                    }
                    break;

                case "mokeywordlist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new MoKeyWord(o.asObject()));
                    }
                    break;

                case "numberplanlist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new NumberPlan(o.asObject()));
                    }
                    break;

                case "senderaddresseslist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new Sender(o.asObject()));
                    }
                    break;

                case "servicelist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new Service(o.asObject()));
                    }
                    break;

                case "ticketlist":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new Ticket(o.asObject()));
                    }
                    break;
                case "libraries":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new ContentLibrary(o.asObject()));
                    }
                    break;
                case "folders":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new ContentFolder(o.asObject()));
                    }
                    break;
                case "medias":
                    for (JsonValue o : val.asArray()) {
                        this.items.add((T) new ContentMedia(o.asObject()));
                    }
                    break;
            }
        }
    }

    /**
     * Gets the count of this API list.
     *
     * @return the count.
     */
    public long getCount() {
        return this.count;
    }

    /**
     * Gets the total pages of this API list.
     *
     * @return the total pages.
     */
    public long getTotalPages() {
        return this.totalPages;
    }

    /**
     * Gets the items in this API list.
     *
     * @return the items.
     */
    public List<T> getItems() {
        return this.items;
    }

    /**
     * iterator
     */
    public Iterator<T> iterator() {
        return items.iterator();
    }
}
