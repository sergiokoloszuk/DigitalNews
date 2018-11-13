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
import br.com.digitalnews.digitalnews.model.Noticias;


public class RecycleNoticiasAdapter extends RecyclerView.Adapter<RecycleNoticiasAdapter.ViewHolder> {

    private List<Noticias> noticiasList;

    public RecycleNoticiasAdapter(List<Noticias> noticiasList) {
        this.noticiasList = noticiasList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_noticia_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Noticias noticias = noticiasList.get(position);
        holder.bind(noticias);
    }


    @Override
    public int getItemCount() {
        return noticiasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewNoticias;
        private TextView textViewTitle;
        private TextView textViewSubtitle;

        public ViewHolder(View itemView) {
            super(itemView);

            //imageViewNoticias = itemView.findViewById(R.id.noticias);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewSubtitle = itemView.findViewById(R.id.subtitle);
        }

        public void bind(Noticias noticias) {
           textViewTitle.setText(noticias.getTitle());
           textViewSubtitle.setText(noticias.getSubtitle());

        }
    }
}
