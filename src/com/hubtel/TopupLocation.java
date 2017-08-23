/**
 *
 */
package com.hubtel;

/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public class TopupLocation {

    private Long id;
    private String city;
    private String area;
    private String region;
    private String details;
    private String description;
    private Double latitude;
    private Double longitude;

    /**
     *
     */
    public TopupLocation() {
    }

    public TopupLocation(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "id":
                    this.id = val.asLong();
                    break;
                case "city":
                    this.city = val.asString();
                    break;
                case "area":
                    this.area = val.asString();
                    break;
                case "region":
                    this.region = val.asString();
                    break;
                case "details":
                    this.details = val.asString();
                    break;
                case "description":
                    this.description = val.asString();
                    break;
                case "latitude":
                    this.latitude = val.asDouble();
                    break;
                case "longitude":
                    this.longitude = val.asDouble();
                    break;
            }
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
