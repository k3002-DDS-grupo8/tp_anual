public enum TipoMedio {
    FERROCARRIL,
    SUBTERRANEO
}

public enum TipoOrganizacion {
    SUPERMERCADO,
    CENTRO COMUNAL,
    BANCO
}

public enum Rol {
    MIEMBRO,
    ADMINISTRADOR
}

class Linea extends EntidadPrestadora {
    final TipoMedio tipo;
    final Establecimiento estacionOrigen;
    final Establecimiento estacionDestino;
}

class Organizacion extends EntidadPrestadora {
    final TipoOrganizacion tipo;
}

class Localizacion {
    final Lugar provincia;
    final Lugar departamento;
    final Lugar municipio;
}

class Lugar {
    final int id;
    final String nombre;
}

class Servicio {
    final String nombre;
    public boolean prestadoHabitualmente() {}
}

class GrupoServicios {
    final String nombre;
    final Servicio[] servicio;
}

class MediosElevacion extends Servicio {
    final String inicio;
    final String fin;
}

class Establecimiento {
    final String nombre;
    final String ubicacionGeografica;
    final GrupoServicios[] grupoServicios;
    final Servicio[] servicios; // Y esto por qué? Si tengo grupoServicios
}

class EntidadPrestadora {
    final String nombre;
    final Establecimiento[] listaEstablecimientos;
    final Localizacion[] localizacion; // ¿No sería "localizaciones"?
}

class Usuario {
    final String nombre;
    final String email;
    final Servicio[] serviciosDeInteres;
    final Localizacion localizacion;
}

class EEO extends Usuario {
    final Responsable responsable;
}

class Responsable {
    final String nombre;
    final String email;
}

class UsuarioPersona extends Usuario {
    final String apellido;
}

class MiembroComunidad {
    final Usuario usuario;
    Rol rol;
}

class Comunidad {
    final String nombre;
    MiembroComunidad[] miembros;
    GrupoServicios[] serviciosDeInteres;
}