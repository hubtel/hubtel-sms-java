/**
 * *****************************************************************************
 * Copyright (c) 2013 EclipseSource. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ralf Sternberg - initial implementation and API
 * ****************************************************************************
 */
package com.hubtel;

import java.util.Date;
import java.util.UUID;

import java.text.SimpleDateFormat;
import java.io.IOException;

@SuppressWarnings("serial") // use default serial UID
class JsonString extends JsonValue {

    private final String string;

    JsonString(String string) {
        if (string == null) {
            throw new NullPointerException("string is null");
        }
        this.string = string;
    }

    @Override
    protected void write(JsonWriter writer) throws IOException {
        writer.writeString(string);
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String asString() {
        return string;
    }

    @Override
    public Date asDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(string);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public UUID asUUID() {
        String s = string;
        StringBuilder buf = new StringBuilder();
        if (s.length() == 32) {
            buf
                    .append(s.substring(0, 8))
                    .append('-')
                    .append(s.substring(8, 12))
                    .append('-')
                    .append(s.substring(12, 16))
                    .append('-')
                    .append(s.substring(16, 20))
                    .append('-')
                    .append(s.substring(20));
            s = buf.toString();
        }
        return UUID.fromString(s);
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        JsonString other = (JsonString) object;
        return string.equals(other.string);
    }

}
