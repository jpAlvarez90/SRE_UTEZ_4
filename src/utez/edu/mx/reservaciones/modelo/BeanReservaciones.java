package utez.edu.mx.reservaciones.modelo;

public class BeanReservaciones {

    private String idReservaciones;
    private String FechaInicio;
    private String FechaFin;
    private String HorarioInicio;
    private String HorarioFinal;
    private String DescripciondelEvento;
    private String espacios_idEspacios;
    private String espacios_edificios_idEdificios;
    private String estadoReservaciones_idEstadoReservaciones;

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
