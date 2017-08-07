
package com.example.mathias.ismdrunning.json_objects.stationnames_request;

import java.util.List;

public class Overview {

    private List<Genre> genres = null;
    private List<Searchtype> searchtypes = null;
    private List<Channel> channels = null;
    private String imageServer;
    private String channelBasePath;
    private Integer channelsPerRequest;
    private Integer watchItemLimit;
    private Integer coupon;
    private String epgDataQS;
    private String epgDataUrl;
    private Ads ads;
    private Boolean ratePopup;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Searchtype> getSearchtypes() {
        return searchtypes;
    }

    public void setSearchtypes(List<Searchtype> searchtypes) {
        this.searchtypes = searchtypes;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public String getChannelBasePath() {
        return channelBasePath;
    }

    public void setChannelBasePath(String channelBasePath) {
        this.channelBasePath = channelBasePath;
    }

    public Integer getChannelsPerRequest() {
        return channelsPerRequest;
    }

    public void setChannelsPerRequest(Integer channelsPerRequest) {
        this.channelsPerRequest = channelsPerRequest;
    }

    public Integer getWatchItemLimit() {
        return watchItemLimit;
    }

    public void setWatchItemLimit(Integer watchItemLimit) {
        this.watchItemLimit = watchItemLimit;
    }

    public Integer getCoupon() {
        return coupon;
    }

    public void setCoupon(Integer coupon) {
        this.coupon = coupon;
    }

    public String getEpgDataQS() {
        return epgDataQS;
    }

    public void setEpgDataQS(String epgDataQS) {
        this.epgDataQS = epgDataQS;
    }

    public String getEpgDataUrl() {
        return epgDataUrl;
    }

    public void setEpgDataUrl(String epgDataUrl) {
        this.epgDataUrl = epgDataUrl;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }

    public Boolean getRatePopup() {
        return ratePopup;
    }

    public void setRatePopup(Boolean ratePopup) {
        this.ratePopup = ratePopup;
    }

}
