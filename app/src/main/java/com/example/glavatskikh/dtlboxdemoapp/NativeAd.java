package com.example.glavatskikh.dtlboxdemoapp;

import android.graphics.Bitmap;

/**
 * Interface for working with native ads
 */
public interface NativeAd {

    /**
     * Get title of native ad
     *
     * @return title string
     */
    String getTitle();

    /**
     * Get call to action string of native ad, to show on the button
     *
     * @return call to action string
     */
    String getCallToAction();

    /**
     * Get native ad rating
     *
     * @return ad rating
     */
    float getRating();

    /**
     * Get description of native ad
     *
     * @return description string
     */
    String getDescription();

    /**
     * Get main image bitmap of native ad
     *
     * @return main image bitmap
     */
    Bitmap getImage();

    /**
     * Get icon bitmap of native ad
     *
     * @return icon bitmap
     */
    Bitmap getIcon();

    /**
     * Get main image url
     *
     * @return main image url
     */
    String getImageUrl();

    /**
     * Get icon url
     *
     * @return icon url
     */
    String getIconUrl();

    /**
     * Check if native ad contains video
     *
     * @return {@code true} if contains video
     */
    boolean containsVideo();
}