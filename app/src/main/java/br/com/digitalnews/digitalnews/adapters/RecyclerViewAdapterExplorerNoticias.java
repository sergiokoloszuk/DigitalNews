package br.com.digitalnews.digitalnews.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.model.NoticiaExplorer;

public class RecyclerViewAdapterExplorerNoticias extends RecyclerView.Adapter<RecyclerViewAdapterExplorerNoticias.ViewHolder> {

    private List<NoticiaExplorer> noticias;

    public RecyclerViewAdapterExplorerNoticias(List<NoticiaExplorer> noticias) {
        this.noticias = noticias;
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
        NoticiaExplorer noticia = noticias.get(position);
        holder.bind(noticia);
    }

    //Retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    // criar ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.news_noticias);
        }

        //método bind
        public void bind(NoticiaExplorer noticias){
            imageView.setImageResource(noticias.getImage());
        }
    }

    public void update(List<NoticiaExplorer> noticias) {
        this.noticias=noticias;
        notifyDataSetChanged();
    }
}
