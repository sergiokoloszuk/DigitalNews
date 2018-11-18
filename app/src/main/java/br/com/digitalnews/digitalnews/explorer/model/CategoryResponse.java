
package br.com.digitalnews.digitalnews.explorer.model;

import java.util.List;
import com.google.gson.annotations.Expose;

public class CategoryResponse {

    @Expose
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
