package es.ies.claudiomoyano.dam2.pmdm.practica9_asensio_sanchez_alex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorAlbum extends RecyclerView.Adapter<AdaptadorAlbum.AlbumViewHolder>{
    private List<Album> listaAlbumes;

    public AdaptadorAlbum(List<Album> listaAlbumes){
        this.listaAlbumes = listaAlbumes;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        View inflate = from.inflate(R.layout.item_albumes, parent, false);
        return new AlbumViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = this.listaAlbumes.get(position);

        holder.imagen.setImageDrawable(
                holder.imagen.getContext().getDrawable(album.getIdFotoAlbum())
        );

        holder.nombreAlbum.setText(album.getNombre());
        holder.nombreBanda.setText(album.getBanda());
    }

    @Override
    public int getItemCount() {
        return this.listaAlbumes.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombreAlbum;
        public TextView nombreBanda;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenAlbum);
            nombreAlbum = itemView.findViewById(R.id.nombreAlbum);
            nombreBanda = itemView.findViewById(R.id.nombreBanda);
        }
    }
}
