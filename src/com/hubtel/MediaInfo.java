package com.hubtel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class MediaInfo {

    private String contentName;
    private UUID libraryId;
    private String destinationFolder;
    private String preference;
    private int width;
    private int height;
    private boolean drmProtect;
    private Map<String, String> tags;
    private boolean streamable;
    private String contentText;
    private String displayText;

    public MediaInfo() {
        this.width = 0;
        this.height = 0;
        this.streamable = false;
        this.drmProtect = false;
        this.tags = new HashMap<>();
        this.contentName = "";
        this.displayText = "";
        this.contentText = "";
        this.destinationFolder = "";
        this.preference = "";
    }

    /**
     * @return the contentName
     */
    public String getContentName() {
        return contentName;
    }

    /**
     * @param contentName the contentName to set
     */
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    /**
     * @return the libraryId
     */
    public UUID getLibraryId() {
        return libraryId;
    }

    /**
     * @param libraryId the libraryId to set
     */
    public void setLibraryId(UUID libraryId) {
        this.libraryId = libraryId;
    }

    /**
     * @return the destinationFolder
     */
    public String getDestinationFolder() {
        return destinationFolder;
    }

    /**
     * @param destinationFolder the destinationFolder to set
     */
    public void setDestinationFolder(String destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    /**
     * @return the preference
     */
    public String getPreference() {
        return preference;
    }

    /**
     * @param preference the preference to set
     */
    public void setPreference(String preference) {
        this.preference = preference;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the drmProtect
     */
    public boolean isDrmProtect() {
        return drmProtect;
    }

    /**
     * @param drmProtect the drmProtect to set
     */
    public void setDrmProtect(boolean drmProtect) {
        this.drmProtect = drmProtect;
    }

    /**
     * @return the tags
     */
    public Map<String, String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    /**
     * @return the streamable
     */
    public boolean isStreamable() {
        return streamable;
    }

    /**
     * @param streamable the streamable to set
     */
    public void setStreamable(boolean streamable) {
        this.streamable = streamable;
    }

    /**
     * @return the contentText
     */
    public String getContentText() {
        return contentText;
    }

    /**
     * @param contentText the contentText to set
     */
    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    /**
     * @return the displayText
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * @param displayText the displayText to set
     */
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
