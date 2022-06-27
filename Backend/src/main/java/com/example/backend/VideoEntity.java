package com.example.backend;

import java.sql.Blob;

public class VideoEntity {
    private  int id;
    private  String name;
    private  String description;
    private  int allVotes;
    private  int positiveVotes;
    private String url;
    private String thumbnailUrl;
    private String alternateImage;

    public VideoEntity(String name, String description, int allVotes, int positiveVotes, String url, String thumbnailUrl) {

        this.name = name;
        this.description = description;
        this.allVotes = allVotes;
        this.positiveVotes = positiveVotes;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public VideoEntity(int id, String name, String description, int allVotes, int positiveVotes, String url, String thumbnailUrl, String alternateImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.allVotes = allVotes;
        this.positiveVotes = positiveVotes;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.alternateImage = alternateImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAllVotes() {
        return allVotes;
    }

    public void setAllVotes(int allVotes) {
        this.allVotes = allVotes;
    }

    public int getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(int positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAlternateImage() {
        return alternateImage;
    }

    public void setAlternateImage(String alternateImage) {
        this.alternateImage = alternateImage;
    }
}
