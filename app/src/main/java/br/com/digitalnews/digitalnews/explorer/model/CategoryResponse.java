
package br.com.digitalnews.digitalnews.explorer.model;

import java.util.List;
import com.google.gson.annotations.Expose;

public class CategoryResponse {

    @Expose
    private List<Source> sources;
    @Expose
    private String status;

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
