package br.com.digitalnews.digitalnews.data.local.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
import java.lang.reflect.Type;
import java.util.List;

import br.com.digitalnews.digitalnews.explorer.model.ExploreSource;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesSource;

public class Converters {
    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }

    /// Type converter para uma lista de String
    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public ExploreSource fromExploreSource(String value) {
        Type listType = (Type) new TypeToken<ExploreSource>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromExloreSource(ExploreSource source) {
        Gson gson = new Gson();
        return gson.toJson(source);
    }

    @TypeConverter
    public TopHeadlinesSource fromTopHeadlinesSource(String value){
        Type listType = (Type) new TypeToken<TopHeadlinesSource>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }


    @TypeConverter
    public String fromTopHeadlinesSource(TopHeadlinesSource source) {
        Gson gson = new Gson();
        return gson.toJson(source);
    }

    @TypeConverter
    public Object fromObject(String value) {
        Type listType = (Type) new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromObject(Object list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
