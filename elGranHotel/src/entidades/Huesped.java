
package entidades;


public class Huesped {
    
    private int idHuesped=-1;
    private int dni;
    private String apellido;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private boolean estado;

    public Huesped(int idHuesped, int dni, String apellido, String nombre, String telefono, String correo, String direccion, boolean estado) {
        this.idHuesped = idHuesped;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Huesped(int dni, String apellido, String nombre, String telefono, String correo, String direccion, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Huesped() {
        this.idHuesped=-1;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Huesped{" + "idHuesped=" + idHuesped + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", estado=" + estado + '}';
    }
    
    
}
