package es.ies.claudiomoyano.dam2.pmdm.practica9_asensio_sanchez_alex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetalleAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detalle_album);

        Intent intentPadre = getIntent();

        int idFoto = intentPadre.getIntExtra("foto", 0);
        String nombreAlbum = intentPadre.getStringExtra("nombre");
        String nombreBanda = intentPadre.getStringExtra("banda");
        String discografica = intentPadre.getStringExtra("discografica");
        int copias = intentPadre.getIntExtra("copias", 0);
        String fechaLanzamiento = intentPadre.getStringExtra("fechaLanzamiento");

        ImageView imagen = findViewById(R.id.fotoAlbum);
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvBanda = findViewById(R.id.tvBanda);
        TextView tvDiscografica = findViewById(R.id.tvDiscografica);
        TextView tvCopias = findViewById(R.id.tvCopias);
        TextView tvFechaLanzamiento = findViewById(R.id.tvFechalanzamiento);

        imagen.setImageResource(idFoto);
        tvNombre.setText("Nombre album: "+nombreAlbum);
        tvBanda.setText("Nombre banda: "+nombreBanda);
        tvDiscografica.setText("Discográfica: "+discografica);
        tvCopias.setText("Copias vendidas: "+copias+" millones");
        tvFechaLanzamiento.setText("Fecha de lanzamiento: "+fechaLanzamiento);

    }
}
