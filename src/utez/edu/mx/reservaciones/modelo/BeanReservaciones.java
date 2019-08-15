package utez.edu.mx.reservaciones.modelo;

public class BeanReservaciones {

    private String idReservaciones;
    private String FechaInicio;
    private String FechaFin;
    private String HorarioInicio;
    private String HorarioFinal;
    private String DescripciondelEvento;
    private String espacios_idEspacios;
    private String idArea;
    private String espacios_edificios_idEdificios;
    private String estadoReservaciones_idEstadoReservaciones;

    private String NombreidEspacios;
    private String NombreArea;
    private String NombreidEdificios;
    private String NombreEstadoReservaciones;

    public String getNombreEstadoReservaciones() {
        return NombreEstadoReservaciones;
    }

    public void setNombreEstadoReservaciones(String nombreEstadoReservaciones) {
        NombreEstadoReservaciones = nombreEstadoReservaciones;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getNombreidEspacios() {
        return NombreidEspacios;
    }

    public void setNombreidEspacios(String nombreidEspacios) {
        NombreidEspacios = nombreidEspacios;
    }

    public String getNombreArea() {
        return NombreArea;
    }

    public void setNombreArea(String nombreArea) {
        NombreArea = nombreArea;
    }

    public String getNombreidEdificios() {
        return NombreidEdificios;
    }

    public void setNombreidEdificios(String nombreidEdificios) {
        NombreidEdificios = nombreidEdificios;
    }



    public String getIdReservaciones() {
        return idReservaciones;
    }

    public void setIdReservaciones(String idReservaciones) {
        this.idReservaciones = idReservaciones;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public String getHorarioInicio() {
        return HorarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        HorarioInicio = horarioInicio;
    }

    public String getHorarioFinal() {
        return HorarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        HorarioFinal = horarioFinal;
    }

    public String getDescripciondelEvento() {
        return DescripciondelEvento;
    }

    public void setDescripciondelEvento(String descripciondelEvento) {
        DescripciondelEvento = descripciondelEvento;
    }

    public String getEspacios_idEspacios() {
        return espacios_idEspacios;
    }

    public void setEspacios_idEspacios(String espacios_idEspacios) {
        this.espacios_idEspacios = espacios_idEspacios;
    }

    public String getEspacios_edificios_idEdificios() {
        return espacios_edificios_idEdificios;
    }

    public void setEspacios_edificios_idEdificios(String espacios_edificios_idEdificios) {
        this.espacios_edificios_idEdificios = espacios_edificios_idEdificios;
    }

    public String getEstadoReservaciones_idEstadoReservaciones() {
        return estadoReservaciones_idEstadoReservaciones;
    }

    public void setEstadoReservaciones_idEstadoReservaciones(String estadoReservaciones_idEstadoREservaciones) {
        this.estadoReservaciones_idEstadoReservaciones = estadoReservaciones_idEstadoREservaciones;
    }

}
