package br.com.digitalnews.digitalnews.model;

import android.widget.ImageView;
import android.widget.TextView;

public class Noticias {

    private int noticias;
    private String title;
    private String subtitle;

    public Noticias(int noticias) {
        this.noticias = noticias;
    }

    public Noticias(int noticias, String title, String subtitle) {
    }

    public int getNoticias() {
        return noticias;
    }

    public void setNoticias(int noticias) {
        this.noticias = noticias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}