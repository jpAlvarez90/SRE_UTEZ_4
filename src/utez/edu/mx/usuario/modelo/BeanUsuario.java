package utez.edu.mx.usuario.modelo;

public class BeanUsuario {

    private String idUsuarios;
    private String Nombre;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String Email;
    private String Contra;
    private String Telefono;
    private int Status;
    private String Tipo_usuario_idTipoUsuario;
    private String Areas_idAreas;

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        Apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        Apellido_Materno = apellido_Materno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String contra) {
        Contra = contra;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getTipo_usuario_idTipoUsuario() {
        return Tipo_usuario_idTipoUsuario;
    }

    public void setTipo_usuario_idTipoUsuario(String tipo_usuario_idTipoUsuario) {
        Tipo_usuario_idTipoUsuario = tipo_usuario_idTipoUsuario;
    }

    public String getAreas_idAreas() {
        return Areas_idAreas;
    }

    public void setAreas_idAreas(String areas_idAreas) {
        Areas_idAreas = areas_idAreas;
    }

}
