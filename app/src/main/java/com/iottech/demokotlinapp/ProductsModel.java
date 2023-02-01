package com.iottech.demokotlinapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("commingSoon")
    @Expose
    private List<Object> commingSoon;
    @SerializedName("trending")
    @Expose
    private List<Trending> trending;
    @SerializedName("onSale")
    @Expose
    private List<OnSale> onSale;
    @SerializedName("bannerImage")
    @Expose
    private List<BannerImage> bannerImage;

    public ProductsModel(List<Object> commingSoon, List<Trending> trending, List<OnSale> onSale, List<BannerImage> bannerImage) {
        this.commingSoon = commingSoon;
        this.trending = trending;
        this.onSale = onSale;
        this.bannerImage = bannerImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getCommingSoon() {
        return commingSoon;
    }

    public void setCommingSoon(List<Object> commingSoon) {
        this.commingSoon = commingSoon;
    }

    public List<Trending> getTrending() {
        return trending;
    }

    public void setTrending(List<Trending> trending) {
        this.trending = trending;
    }

    public List<OnSale> getOnSale() {
        return onSale;
    }

    public void setOnSale(List<OnSale> onSale) {
        this.onSale = onSale;
    }

    public List<BannerImage> getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(List<BannerImage> bannerImage) {
        this.bannerImage = bannerImage;
    }
    public class BannerImage {

        @SerializedName("path")
        @Expose
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

    }

    public class OnSale {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("hi_name")
        @Expose
        private String hiName;
        @SerializedName("primary_image")
        @Expose
        private String primaryImage;
        @SerializedName("special_price")
        @Expose
        private String specialPrice;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("rating")
        @Expose
        private Integer rating;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHiName() {
            return hiName;
        }

        public void setHiName(String hiName) {
            this.hiName = hiName;
        }

        public String getPrimaryImage() {
            return primaryImage;
        }

        public void setPrimaryImage(String primaryImage) {
            this.primaryImage = primaryImage;
        }

        public String getSpecialPrice() {
            return specialPrice;
        }

        public void setSpecialPrice(String specialPrice) {
            this.specialPrice = specialPrice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

    }



    public class Trending {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("hi_name")
        @Expose
        private String hiName;
        @SerializedName("primary_image")
        @Expose
        private String primaryImage;
        @SerializedName("special_price")
        @Expose
        private String specialPrice;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("rating")
        @Expose
        private Integer rating;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHiName() {
            return hiName;
        }

        public void setHiName(String hiName) {
            this.hiName = hiName;
        }

        public String getPrimaryImage() {
            return primaryImage;
        }

        public void setPrimaryImage(String primaryImage) {
            this.primaryImage = primaryImage;
        }

        public String getSpecialPrice() {
            return specialPrice;
        }

        public void setSpecialPrice(String specialPrice) {
            this.specialPrice = specialPrice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

    }
}

