
package entidades;


public class Habitacion {
    
    private int idHabitacion = -1;
    private TipoHabitacion idTipoHabitacion;
    private int nroHabitacion;
    private int piso;
    private boolean estado;

    public Habitacion(int idHabitacion, TipoHabitacion idTipoHabitacion, int nroHabitacion, int piso, boolean estado) {
        this.idHabitacion = idHabitacion;
        this.idTipoHabitacion = idTipoHabitacion;
        this.nroHabitacion = nroHabitacion;
        this.piso = piso;
        this.estado = estado;
    }

    public Habitacion(TipoHabitacion idTipoHabitacion, int nroHabitacion, int piso, boolean estado) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nroHabitacion = nroHabitacion;
        this.piso = piso;
        this.estado = estado;
    }    

    public Habitacion() {
        this.idHabitacion=-1;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public TipoHabitacion getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(TipoHabitacion idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{ id:" + idHabitacion + ", nro:" + nroHabitacion + ", piso:" + piso + ", TipoHabitacion:" + idTipoHabitacion.getTipo() + ", estado=" + estado + '}';
    }
    
    
}
