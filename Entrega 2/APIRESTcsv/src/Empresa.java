class Empresa {
    final String nombre;
    final String direccion;
    final String ciudad;
    final String pais;

    public Empresa(String nombre, String direccion, String ciudad, String pais) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }
}