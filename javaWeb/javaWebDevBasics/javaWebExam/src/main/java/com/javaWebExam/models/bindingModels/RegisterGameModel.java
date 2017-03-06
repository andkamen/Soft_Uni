package com.javaWebExam.models.bindingModels;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterGameModel {

    @Pattern(regexp = "[A-Z].{3,100}", message = "Title has to begin with uppercase letter and has length between 3 and 100 symbols (inclusive)")
    private String title;

    @Size(min = 20, message = "Description – must be at least 20 symbols")
    private String description;

    private String imageThumbnail;

    @Pattern(regexp = "^[+]?[0-9]*\\.[0-9]{2}$", message = "Price must be a positive number with precision up to 2 digits after floating point")
    private String price;

    @Pattern(regexp = "^[+]?[0-9]*\\.[0-9]$", message = "Size must be a positive number with precision up to 1 digit after floating point")
    private String size;

    @Pattern(regexp = "^.{11}$", message = "Youtube id was invalid. Must be exactly 11 characters long")
    private String trailer;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "yyyy-MM-dd is the only valid date format style")
    private String releaseDate;

    public RegisterGameModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
