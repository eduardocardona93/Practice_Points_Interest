package com.example.practice_points_interest;

public class Place{
    private String name;
    private String image;
    private String country;
    private String details;

    public Place(String name, String image, String country, String details) {
        this.name = name;
        this.image = image;
        this.country = country;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}