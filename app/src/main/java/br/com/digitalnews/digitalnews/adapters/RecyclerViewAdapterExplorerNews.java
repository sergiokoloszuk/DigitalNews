package br.com.digitalnews.digitalnews.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.explorer.model.ExploreSource;

public class RecyclerViewAdapterExplorerNews extends RecyclerView.Adapter<RecyclerViewAdapterExplorerNews.ViewHolder> {

    private List<ExploreSource> exploreSources;

    public RecyclerViewAdapterExplorerNews(List<ExploreSource> exploreSources) {
        this.exploreSources = exploreSources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_explorer_category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExploreSource exploreSource = exploreSources.get(position);
        holder.bind(exploreSource);
    }

    @Override
    public int getItemCount() {
        return exploreSources.size();
    }

    // criar ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView sourceCategory;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.news_noticias);
            sourceCategory = itemView.findViewById(R.id.source_category);
        }

        //método bind
        public void bind(ExploreSource exploreSource){
            imageView.setImageResource(R.drawable.news_3);
            sourceCategory.setText(exploreSource.getCategory());
        }
    }

    public void update(List<ExploreSource> exploreSources) {
        this.exploreSources = exploreSources;
        notifyDataSetChanged();
    }
}
