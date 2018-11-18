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
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesResponse;


public class RecycleNewsAdapter extends RecyclerView.Adapter<RecycleNewsAdapter.ViewHolder> {

    private List<TopHeadlinesResponse> topHeadlinesResponseList;
    private int position = 0;

    public RecycleNewsAdapter(List<TopHeadlinesResponse> topHeadlinesResponseList) {
        this.topHeadlinesResponseList = topHeadlinesResponseList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_home_news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopHeadlinesResponse response = topHeadlinesResponseList.get(position);
        holder.bind(response);
        this.position = position;
    }

    @Override
    public int getItemCount() {
        return topHeadlinesResponseList.size();
    }

    public void setResponses(List<TopHeadlinesResponse> responses){
        if (topHeadlinesResponseList.size() == 0){
            this.topHeadlinesResponseList = topHeadlinesResponseList;
        } else {
            this.topHeadlinesResponseList.addAll(topHeadlinesResponseList);
            notifyDataSetChanged();
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewNoticias;
        private TextView textViewTitle;
        private TextView textViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            //imageViewNoticias = itemView.findViewById(R.id.);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewDescription = itemView.findViewById(R.id.subtitle);
        }

        public void bind(TopHeadlinesResponse response) {
            textViewTitle.setText(response.getTopHeadlinesArticles().get(position).getTitle());
            textViewDescription.setText(response.getTopHeadlinesArticles().get(position).getDescription().toString());
        }
    }
}
