
package entidades;


public class TipoHabitacion {
    
    private int idTipoHabitacion=-1;
    private int cantidadCamas;
    private int cantidadPersonas;
    private String tipoCamas;
    private double precioPorNoche;

    public TipoHabitacion(int idTipoHabitacion, int cantidadCamas, int cantidadPersonas, String tipoCamas, double precioPorNoche) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.cantidadCamas = cantidadCamas;
        this.cantidadPersonas = cantidadPersonas;
        this.tipoCamas = tipoCamas;
        this.precioPorNoche = precioPorNoche;
    }

    public TipoHabitacion(int cantidadCamas, int cantidadPersonas, String tipoCamas, double precioPorNoche) {
        this.cantidadCamas = cantidadCamas;
        this.cantidadPersonas = cantidadPersonas;
        this.tipoCamas = tipoCamas;
        this.precioPorNoche = precioPorNoche;
    }

    public TipoHabitacion() {
        this.idTipoHabitacion=-1;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "idTipoHabitacion=" + idTipoHabitacion + ", cantidadCamas=" + cantidadCamas + ", cantidadPersonas=" + cantidadPersonas + ", tipoCamas=" + tipoCamas + ", precioPorNoche=" + precioPorNoche + '}';
    }
    
    
}
