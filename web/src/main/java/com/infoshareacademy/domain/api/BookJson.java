package com.infoshareacademy.domain.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class BookJson {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("full_sort_key")
    private String fullSortKey;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("cover_color")
    private String coverColor;

    @JsonProperty("author")
    private String author;

    @JsonProperty("cover")
    private String cover;

    @JsonProperty("epoch")
    private String epoch;

    @JsonProperty("href")
    private String href;

    @JsonProperty("has_audio")
    private Boolean hasAudio;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("simple_thumb")
    private String simpleThumb;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("cover_thumb")
    private String coverThumb;

    @JsonProperty("liked")
    private Object liked;

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("full_sort_key")
    public String getFullSortKey() {
        return fullSortKey;
    }

    @JsonProperty("full_sort_key")
    public void setFullSortKey(String fullSortKey) {
        this.fullSortKey = fullSortKey;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("cover_color")
    public String getCoverColor() {
        return coverColor;
    }

    @JsonProperty("cover_color")
    public void setCoverColor(String coverColor) {
        this.coverColor = coverColor;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("cover")
    public String getCover() {
        return cover;
    }

    @JsonProperty("cover")
    public void setCover(String cover) {
        this.cover = cover;
    }

    @JsonProperty("epoch")
    public String getEpoch() {
        return epoch;
    }

    @JsonProperty("epoch")
    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("has_audio")
    public Boolean getHasAudio() {
        return hasAudio;
    }

    @JsonProperty("has_audio")
    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("simple_thumb")
    public String getSimpleThumb() {
        return simpleThumb;
    }

    @JsonProperty("simple_thumb")
    public void setSimpleThumb(String simpleThumb) {
        this.simpleThumb = simpleThumb;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("cover_thumb")
    public String getCoverThumb() {
        return coverThumb;
    }

    @JsonProperty("cover_thumb")
    public void setCoverThumb(String coverThumb) {
        this.coverThumb = coverThumb;
    }

    @JsonProperty("liked")
    public Object getLiked() {
        return liked;
    }

    @JsonProperty("liked")
    public void setLiked(Object liked) {
        this.liked = liked;
    }
}