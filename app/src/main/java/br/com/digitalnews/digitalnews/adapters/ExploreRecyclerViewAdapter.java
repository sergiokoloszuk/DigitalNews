package br.com.digitalnews.digitalnews.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalnews.digitalnews.ArticlesActivity;
import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.explore.model.ExploreSource;

public class ExploreRecyclerViewAdapter extends RecyclerView.Adapter<ExploreRecyclerViewAdapter.ViewHolder> {

    private List<ExploreSource> exploreSources;

    public ExploreRecyclerViewAdapter(List<ExploreSource> exploreSources) {
        this.exploreSources = exploreSources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_explorer_category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ExploreSource exploreSource = exploreSources.get(position);
        holder.bind(exploreSource);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ArticlesActivity.class);
                intent.putExtra("CATEGORY" , exploreSource.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
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

            //imageView = itemView.findViewById(R.id.news_noticias);
            sourceCategory = itemView.findViewById(R.id.source_category);
        }

        //método bind
        public void bind(ExploreSource exploreSource){
            //imageView.setImageResource(R.drawable.digital_news);
            sourceCategory.setText(exploreSource.getCategory());
        }
    }

    public void update(List<ExploreSource> exploreSources) {
        this.exploreSources = exploreSources;
        notifyDataSetChanged();
    }
}
