package es.ies.claudiomoyano.dam2.pmdm.practica9_asensio_sanchez_alex;

import java.time.LocalDate;
import java.util.Date;

public class Album {
    private int idFotoAlbum;
    private String nombre;
    private String banda;
    private int copiasVendidas;
    private String discografica;
    private LocalDate fechaLanzamiento;

    public Album(int idFotoAlbum, String nombre, String banda, int copiasVendidas, String discografica, LocalDate fechaLanzamiento) {
        this.idFotoAlbum = idFotoAlbum;
        this.nombre = nombre;
        this.banda = banda;
        this.copiasVendidas = copiasVendidas;
        this.discografica = discografica;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getIdFotoAlbum() {
        return idFotoAlbum;
    }

    public void setIdFotoAlbum(int idFotoAlbum) {
        this.idFotoAlbum = idFotoAlbum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getCopiasVendidas() {
        return copiasVendidas;
    }

    public void setCopiasVendidas(int copiasVendidas) {
        this.copiasVendidas = copiasVendidas;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
