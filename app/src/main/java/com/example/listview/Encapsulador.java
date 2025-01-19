package com.example.listview;

public class Encapsulador {
    private int imagen;
    private String titulo;
    private String texto;
    private boolean datol;

    public Encapsulador(int idImagen, String textoTitulo, String textoContenido, boolean favorito) {
        this.imagen = idImagen;
        this.titulo = textoTitulo;
        this.texto = textoContenido;
        this.datol = favorito;
    }

    public String getTextoTitulo() {
        return titulo;
    }

    public String getTextoContenido() {
        return texto;
    }

    public int getIdImagen() {
        return imagen;
    }

    public boolean isFavorito() {
        return datol;
    }

    public void setFavorito(boolean favorito) {
        this.datol = favorito;
    }
}
