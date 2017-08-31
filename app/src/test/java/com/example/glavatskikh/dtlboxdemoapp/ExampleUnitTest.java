package com.example.glavatskikh.dtlboxdemoapp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyString;

public class ExampleUnitTest {

    private SDKDemoClass sdkDemoClass;
    private Gson gson;
    private String s = "{\n" +
            "\"ad\":{\n" +
            "\"title\":\"Appodeal\",\n" +
            "\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ante justo, condimentum porta volutpat at, pellentesque blandit nulla. Nunc tortor massa, aliquam et auctor et, facilisis vitae orci. Aliquam at nisl neque. Proin fermentum convallis hendrerit. Etiam sit amet lectus ante. Aenean id augue ligula. Sed et facilisis neque. Aliquam a ante volutpat, faucibus nunc eu, malesuada orci. Nulla id neque metus.\",\n" +
            "\"button\":\"Learn more\",\n" +
            "\"rating\":\"5\",\n" +
            "\"image\":\"https://image-cdn-max.appodeal.com/appodeal-images/appodea-image.png\",\n" +
            "\"icon\":\"https://image-cdn-max.appodeal.com/appodeal-images/appodeal_icon.png\",\n" +
            "\"click_url\":\"https://www.google.com/\",\n" +
            "\"video_url\":\"https://image-cdn-max.appodeal.com/appodeal-campaign-images/test_banners/video.mp4\"\n" +
            "}\n" +
            "}\n";

    @Before
    public void init() {
        sdkDemoClass = new SDKDemoClass();
        gson = new Gson();
    }

    @After
    public void tearDown() {
        sdkDemoClass = null;
        gson = null;
    }

    private JsonObject getAnyJson(String s) {
        if (s == null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject subJsonObject = new JsonObject();
            subJsonObject.addProperty("title", anyString());
            subJsonObject.addProperty("description", anyString());
            subJsonObject.addProperty("button", anyString());
            subJsonObject.addProperty("rating", anyFloat());
            subJsonObject.addProperty("image", anyString());
            subJsonObject.addProperty("icon", anyString());
            subJsonObject.addProperty("click_url", anyString());
            subJsonObject.addProperty("video_url", anyString());
            jsonObject.add("ad", subJsonObject);
            return jsonObject;
        } else {
            return gson.fromJson(s, JsonObject.class);
        }
    }

    @Test
    public void getAdTest() {
        JsonObject o = getAnyJson(s);
        NativeAd nativeAd = sdkDemoClass.getAd(o);

        assertTrue(nativeAd.getTitle().length() >= 0);

        assertTrue(nativeAd.getCallToAction().length() >= 0);

        assertTrue(nativeAd.getRating() >= 0);

        assertTrue(nativeAd.getDescription().length() >= 0);

        assertFalse(nativeAd.getImage() != null);

        assertFalse(nativeAd.getIcon() != null);

        assertTrue(nativeAd.getImageUrl().length() >= 0);

        assertTrue(nativeAd.getIconUrl().length() >= 0);

        assertTrue(nativeAd.containsVideo());
    }

    @Test
    public void getAdTestAnyData() {
        JsonObject o = getAnyJson(null);
        NativeAd nativeAd = sdkDemoClass.getAd(o);

        assertTrue(nativeAd.getTitle().length() >= 0);

        assertTrue(nativeAd.getCallToAction().length() >= 0);

        assertTrue(nativeAd.getRating() >= 0);

        assertTrue(nativeAd.getDescription().length() >= 0);

        assertFalse(nativeAd.getImage() != null);

        assertFalse(nativeAd.getIcon() != null);

        assertTrue(nativeAd.getImageUrl().length() >= 0);

        assertTrue(nativeAd.getIconUrl().length() >= 0);

        assertTrue(nativeAd.containsVideo());
    }

    @Test
    public void getAdTestNullData() {
        NativeAd nativeAd = sdkDemoClass.getAd(null);
        assertEquals(null, nativeAd);
    }
}