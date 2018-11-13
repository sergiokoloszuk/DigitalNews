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
import br.com.digitalnews.digitalnews.explorer.model.Source;

public class RecyclerViewAdapterExplorerNoticias extends RecyclerView.Adapter<RecyclerViewAdapterExplorerNoticias.ViewHolder> {

    private List<Source> sources;

    public RecyclerViewAdapterExplorerNoticias(List<Source> sources) {
        this.sources = sources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    //método que passa a "pessoa" para o método bind()
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Source source = sources.get(position);
        holder.bind(source);
    }

    //Retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return sources.size();
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
        public void bind(Source source){
            //imageView.setImageResource(source.ge());
            sourceCategory.setText(source.getCategory());
        }
    }

    public void update(List<Source> sources) {
        this.sources = sources;
        notifyDataSetChanged();
    }
}
