package es.ies.claudiomoyano.dam2.pmdm.practica9_asensio_sanchez_alex;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAlbumesInterface {

    private final List<Album> listaAlbumes = new ArrayList<>();
    AdaptadorAlbum adaptadorAlbum = new AdaptadorAlbum(listaAlbumes, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.albumes_layout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rvAlbumes), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaAlbumes.add(new Album(R.drawable.number_of_the_beast, "The number of the beast", "Iron Maiden", 14, "EMI / Harvest", LocalDate.parse("1982-03-29")));
        listaAlbumes.add(new Album(R.drawable.powerslave, "Powerslave", "Iron Maiden", 2, "EMI / Capitol", LocalDate.parse("1984-09-03")));
        listaAlbumes.add(new Album(R.drawable.seventh_son_of_a_seventh_son, "Seventh son of a seventh son", "Iron Maiden", 1, "EMI / Epic", LocalDate.parse("1988-04-11")));
        listaAlbumes.add(new Album(R.drawable.somewhere_in_time, "Somewhere in time", "Iron Maiden", 3, "EMI / Capitol", LocalDate.parse("1986-09-29")));
        listaAlbumes.add(new Album(R.drawable.no_prayer_for_the_dying, "No prayer for the dying", "Iron Maiden", 1, "EMI / Epic", LocalDate.parse("1990-10-01")));
        listaAlbumes.add(new Album(R.drawable.killers, "Killers", "Iron Maiden", 1, "EMI / Capitol", LocalDate.parse("1981-02-02")));
        listaAlbumes.add(new Album(R.drawable.brave_new_world, "Brave new world", "Iron Maiden", 0, "EMI / Sony", LocalDate.parse("2000-05-29")));

        listaAlbumes.add(new Album(R.drawable.painkiller, "Painkiller", "Judas Priest", 0, "Columbia", LocalDate.parse("1990-09-17")));
        listaAlbumes.add(new Album(R.drawable.angel_of_retribution, "Angel of retribution", "Judas Priest", 0, "Columbia / Sony", LocalDate.parse("2005-03-01")));
        listaAlbumes.add(new Album(R.drawable.screaming_for_vengeance, "Screaming for vengeance", "Judas Priest", 0, "Columbia", LocalDate.parse("1982-07-17")));

        listaAlbumes.add(new Album(R.drawable.paranoid, "Paranoid", "Black Sabbath", 4, "Vertigo / Warner Bros.", LocalDate.parse("1970-09-18")));

        listaAlbumes.add(new Album(R.drawable.blizzard_of_ozz, "Blizzard of Ozz", "Ozzy Osbourne", 5, "Jet / Epic", LocalDate.parse("1980-09-20")));
        listaAlbumes.add(new Album(R.drawable.black_rain, "Black rain", "Ozzy Osbourne", 0, "Epic / Sony", LocalDate.parse("2007-05-22")));
        listaAlbumes.add(new Album(R.drawable.bark_at_the_moon, "Bark at the moon", "Ozzy Osbourne", 3, "Jet / Epic", LocalDate.parse("1983-11-15")));

        listaAlbumes.add(new Album(R.drawable.rust_in_peace, "Rust in peace", "Megadeth", 1, "Capitol", LocalDate.parse("1990-09-24")));
        listaAlbumes.add(new Album(R.drawable.peace_sells, "Peace sells... but who's buying?", "Megadeth", 1, "Capitol", LocalDate.parse("1986-09-19")));
        listaAlbumes.add(new Album(R.drawable.countdown_to_extinction, "Countdown to extinction", "Megadeth", 2, "Capitol", LocalDate.parse("1992-07-14")));

        listaAlbumes.add(new Album(R.drawable.angel_of_salvation, "Angel of salvation", "Galneryus", 0, "VAP / Warner Music Japan", LocalDate.parse("2012-10-10")));

        listaAlbumes.add(new Album(R.drawable.metallica, "Metallica (The Black Album)", "Metallica", 17, "Elektra", LocalDate.parse("1991-08-12")));
        listaAlbumes.add(new Album(R.drawable.master_of_puppets, "Master of puppets", "Metallica", 8, "Elektra", LocalDate.parse("1986-03-03")));




        RecyclerView rvAlbumes = findViewById(R.id.rvAlbumes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvAlbumes.setLayoutManager(linearLayoutManager);

        rvAlbumes.setAdapter(adaptadorAlbum);


    }

    @Override
    public void onItemClick(int position) {
        Intent intentDetalles = new Intent(this, DetalleAlbumActivity.class);
        Album album = listaAlbumes.get(position);

        intentDetalles.putExtra("foto", album.getIdFotoAlbum());
        intentDetalles.putExtra("nombre", album.getNombre());
        intentDetalles.putExtra("banda", album.getBanda());
        intentDetalles.putExtra("copias", album.getCopiasVendidas());
        intentDetalles.putExtra("discografica", album.getDiscografica());
        intentDetalles.putExtra("fechaLanzamiento", album.getFechaLanzamiento());

        startActivity(intentDetalles);
    }

    @Override
    public void onItemLongClick(int posicion) {
        final String nombreAlbum = listaAlbumes.get(posicion).getNombre();
        listaAlbumes.remove(posicion);
        adaptadorAlbum.notifyItemRemoved(posicion);

        Toast.makeText(getApplicationContext(), nombreAlbum+" ha sido borrado", Toast.LENGTH_LONG).show();

    }
}