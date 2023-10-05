/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class TipoHabitacion_data {
    
    private Connection conexion=null;
    private Habitacion h = new Habitacion();
    private TipoHabitacion th = new TipoHabitacion();
    
    public TipoHabitacion_data(Conexion c) {
        this.conexion = c.buscarConexion();
    }
    
    
    public TipoHabitacion tipoRandom(){
        
        List<TipoHabitacion> listatipos = new ArrayList<>();
        
        String sql = "SELECT * FROM tipohabitacion";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                th = new TipoHabitacion();
                th.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                th.setTipo(rs.getString("tipo"));
                th.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                th.setCantidadCamas(rs.getInt("cantidadCamas"));
                th.setTipoCamas(rs.getString("tipoCamas"));
                th.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                listatipos.add(th);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        
        int random = (int) ((Math.random()*6)); 
        return listatipos.get(random);
    }
    
}
