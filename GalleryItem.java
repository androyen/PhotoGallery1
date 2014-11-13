package com.androyen.photogallery;

/**
 * Created by rnguyen on 11/13/14.
 */
//Model class to store Flickr XML
public class GalleryItem {

    private String mCaption;
    private String mId;
    private String mUrl;

    public String toString() {
        return mCaption; // Return photo caption
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
