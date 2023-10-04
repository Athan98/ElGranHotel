
package elgranhotel;

import data.*;
import entidades.*;


public class ElGranHotel {

    
    public static void main(String[] args) {
        
        Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel","root","");
        Huesped_data hd = new Huesped_data(con);
        Habitacion_data habd = new Habitacion_data(con);
        Huesped h = new Huesped();
        Habitacion hab = new Habitacion();
        
        
       
    }
    
}
