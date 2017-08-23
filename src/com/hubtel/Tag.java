package com.hubtel;


/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class Tag {

    private String key;
    private String value;

    public Tag() {
    }

    public Tag(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "key":
                    this.setKey(val.asString());
                    break;
                case "value":
                    this.setValue(val.asString());
                    break;
            }

        }
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
