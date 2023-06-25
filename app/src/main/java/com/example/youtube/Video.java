package com.example.youtube;

public class Video {
    private String id;
    private String photoUrl;

    public Video(String id, String photoUrl) {
        this.id = id;
        this.photoUrl = photoUrl;
    }

    public String getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
