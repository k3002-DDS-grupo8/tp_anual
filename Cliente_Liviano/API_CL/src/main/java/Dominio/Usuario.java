package Dominio;

import kotlin.text.UStringsKt;

import java.util.ArrayList;

public class Usuario {
    private long id;
    private float puntosConfianza;
    //private GradoConfianza gradoConfianza;
    private boolean activo;
    private String nombre;
    private String email;
    private String contrasenia;
    private ArrayList<Comunidad> comunidades;

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Comunidad> getComunidades() {
        return comunidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComunidades(ArrayList<Comunidad> comunidades) {
        this.comunidades = comunidades;
    }


    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setPuntosConfianza(float puntosConfianza) {
        this.puntosConfianza += puntosConfianza;
    }

   /*public void setGradoConfianza(GradoConfianza gradoConfianza) {
        this.gradoConfianza = gradoConfianza;
    }*/

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long getId() {
        return id;
    }

    public float getPuntosConfianza() {
        return puntosConfianza;
    }

   /*public GradoConfianza getGradoConfianza() {
        return gradoConfianza;
    }*/

    public boolean isActivo() {
        return activo;
    }

    public Usuario() {
        this.id = 0;
        this.puntosConfianza = 5;
       //this.gradoConfianza = GradoConfianza.CONFIABLE_NIVEL_2;
        this.activo = false;
        this.comunidades = null;
        this.nombre = "mati";
        this.email = "matikalo@yahoo.com";
        this.contrasenia = "abruTeAmo";
    }

    public Usuario(long id, float puntosConfianza, /*GradoConfianza gradoConfianza,*/ boolean activo, String nombre, String email, String contrasenia) {
        this.id = id;
        this.puntosConfianza = puntosConfianza;
       // this.gradoConfianza = gradoConfianza;
        this.activo = activo;
        this.comunidades = null;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }
}
