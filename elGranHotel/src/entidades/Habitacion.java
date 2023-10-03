
package entidades;


public class Habitacion {
    
    private int idHabitacion=-1;
    private int nroHabitacion;
    private int piso;
    private TipoHabitacion tipoHab;
    private boolean ocupada;

    public Habitacion(int idHabitacion, int nroHabitacion, int piso, TipoHabitacion tipoHab, boolean ocupada) {
        this.idHabitacion = idHabitacion;
        this.nroHabitacion = nroHabitacion;
        this.piso = piso;
        this.tipoHab = tipoHab;
        this.ocupada = ocupada;
    }

    public Habitacion(int nroHabitacion, int piso, TipoHabitacion tipoHab, boolean ocupada) {
        this.nroHabitacion = nroHabitacion;
        this.piso = piso;
        this.tipoHab = tipoHab;
        this.ocupada = ocupada;
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

    public TipoHabitacion getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(TipoHabitacion tipoHab) {
        this.tipoHab = tipoHab;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", nroHabitacion=" + nroHabitacion + ", piso=" + piso + ", tipoHab=" + tipoHab + ", ocupada=" + ocupada + '}';
    }
    
    
}
