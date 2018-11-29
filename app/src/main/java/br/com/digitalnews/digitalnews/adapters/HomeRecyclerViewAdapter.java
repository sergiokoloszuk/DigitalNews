package br.com.digitalnews.digitalnews.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;


public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {
    private List<TopHeadlinesArticle> articleList;

    public HomeRecyclerViewAdapter(List<TopHeadlinesArticle> articleList) {
        this.articleList = articleList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_home_news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopHeadlinesArticle article = articleList.get(position);
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public void setArticles(List<TopHeadlinesArticle> articleList) {
        if (articleList.size() == 0) {
            this.articleList = articleList;
        } else {
            this.articleList.addAll(articleList);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewNews;
        private TextView textViewTitle;
        private TextView textViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewNews = itemView.findViewById(R.id.home_news_image);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewDescription = itemView.findViewById(R.id.content_preview);
        }

        public void bind(TopHeadlinesArticle article) {
            Picasso.get().load(article.getUrlToImage()).into(imageViewNews);
            textViewTitle.setText(article.getTitle());
            textViewDescription.setText(article.getDescription());
        }
    }

    public void update(List<TopHeadlinesArticle> articleList) {
        this.articleList = articleList;
        notifyDataSetChanged();
    }
}
