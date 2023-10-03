
package elgranhotel;

import data.Conexion;
import data.Huesped_data;
import entidades.Huesped;


public class ElGranHotel {

    
    public static void main(String[] args) {
        
        Conexion con=new Conexion("jdbc:mariadb://localhost:3306/elgranhotel","root","");
        Huesped_data hd=new Huesped_data(con);
        Huesped h=new Huesped();
        
        
       
    }
    
}
