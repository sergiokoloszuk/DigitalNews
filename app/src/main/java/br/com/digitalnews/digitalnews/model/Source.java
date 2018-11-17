
package br.com.digitalnews.digitalnews.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Source {

    @Expose
    private Object id;
    @Expose
    private String name;

    public Object getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private Object id;
        private String name;

        public Source.Builder withId(Object id) {
            this.id = id;
            return this;
        }

        public Source.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Source build() {
            Source source = new Source();
            source.id = id;
            source.name = name;
            return source;
        }

    }

}
