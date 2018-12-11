
package br.com.digitalnews.digitalnews.explore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    @Expose
    @SerializedName("sources")
    private List<ExploreSource> exploreSources;

    @Expose
    private String status;

    public List<ExploreSource> getExploreSources() {
        return exploreSources;
    }

    public void setExploreSources(List<ExploreSource> exploreSources) {
        this.exploreSources = exploreSources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
