package com.example.as_c4_sp1_retrofit_task3;

import java.util.List;

public class CPhotos
{
    private List<Photo> photos;

public CPhotos(List<Photo> photos)
{
this.photos = photos;
}
    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
