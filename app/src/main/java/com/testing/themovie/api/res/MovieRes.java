package com.testing.themovie.api.res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieRes implements Serializable {

    @SerializedName("page")
    public int page;
    @SerializedName("results")
    public List<Result> results;
    @SerializedName("total_pages")
    public int total_pages;
    @SerializedName("total_results")
    public int total_results;

    public static class Result implements Serializable{

        @SerializedName("adult")
        public boolean adult;
        @SerializedName("backdrop_path")
        public String backdropPath;
        @SerializedName("id")
        public int id;
        @SerializedName("original_title")
        public String title;
        @SerializedName("overview")
        public String overview;
        @SerializedName("poster_path")
        public String posterPath;
        @SerializedName("release_date")
        public String releaseDate;
        @SerializedName("vote_average")
        public float voteAverage;
        @SerializedName("vote_count")
        public int voteCount;
    }
}
