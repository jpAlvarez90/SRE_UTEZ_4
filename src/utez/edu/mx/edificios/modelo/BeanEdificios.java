package utez.edu.mx.edificios.modelo;

public class BeanEdificios {

    private String idEdificios;
    private String Nombre;
    private String Extension;
    private String Direccion;
    private int Status;

    public String getIdEdificios() {
        return idEdificios;
    }

    public void setIdEdificios(String idEdificios) {
        this.idEdificios = idEdificios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String extension) {
        Extension = extension;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

}
