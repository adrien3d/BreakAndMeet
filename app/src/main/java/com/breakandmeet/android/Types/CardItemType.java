package com.breakandmeet.android.Types;

/**
 * Created by adrien on 14/11/2015.
 */
public class CardItemType {
    private String text;
    private String imageUrl;

    public CardItemType(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
