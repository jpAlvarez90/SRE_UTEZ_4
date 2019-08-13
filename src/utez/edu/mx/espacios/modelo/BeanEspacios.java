package utez.edu.mx.espacios.modelo;

public class BeanEspacios {

    private String idEspacios;
    private String Nombre;
    private String Extension;
    private String Telefono;
    private int Status;
    private String edificios_idEdificios;
    private String areas_idArea;

    private String NombreEdificio;
    private String NombreArea;

    public String getNombreEdificio() {
        return NombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        NombreEdificio = nombreEdificio;
    }

    public String getNombreArea() {
        return NombreArea;
    }

    public void setNombreArea(String nombreArea) {
        NombreArea = nombreArea;
    }

    public String getAreas_idArea() {
        return areas_idArea;
    }

    public void setAreas_idArea(String areas_idArea) {
        this.areas_idArea = areas_idArea;
    }

    public String getEdificios_idEdificios() {
        return edificios_idEdificios;
    }

    public void setEdificios_idEdificios(String edificios_idEdificios) {
        this.edificios_idEdificios = edificios_idEdificios;
    }

    public String getIdEspacios() {
        return idEspacios;
    }

    public void setIdEspacios(String idEspacios) {
        this.idEspacios = idEspacios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getExtension() {

        return Extension;
    }

    public void setExtension(String extension) {

        this.Extension = extension;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }

}
