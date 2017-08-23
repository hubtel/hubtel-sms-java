package com.hubtel;

import java.io.File;

/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class UploadFile {

    private String fieldName;
    private File file;

    public UploadFile() {
    }

    public UploadFile(String fieldName, File file) {
        this.fieldName = fieldName;
        this.file = file;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }
}
