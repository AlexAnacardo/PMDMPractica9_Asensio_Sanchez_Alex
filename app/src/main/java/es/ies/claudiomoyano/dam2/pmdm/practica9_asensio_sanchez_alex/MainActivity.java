package es.ies.claudiomoyano.dam2.pmdm.practica9_asensio_sanchez_alex;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

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

public class MainActivity extends AppCompatActivity {

    private final List<Album> listaAlbumes = new ArrayList<>();

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

        listaAlbumes.add(new Album(R.drawable.ic_launcher_background, "papasote", "a", 2, "a", LocalDate.parse("2000-01-01")));
        listaAlbumes.add(new Album(R.drawable.ic_launcher_background, "papasote", "a", 2, "a", LocalDate.parse("2000-01-01")));

        RecyclerView rvAlbumes = findViewById(R.id.rvAlbumes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvAlbumes.setLayoutManager(linearLayoutManager);
        AdaptadorAlbum adaptadorAlbum = new AdaptadorAlbum(listaAlbumes);
        rvAlbumes.setAdapter(adaptadorAlbum);


        final GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener()){
            @Override
            public boolean onSingleTapUp(@NonNull MotionEvent e){

            }
        };

        rvAlbumes.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });



    }
}