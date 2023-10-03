
package data;

import entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Huesped_data {
    
    private Connection conexion = null;
    private Huesped h=new Huesped();

    public Huesped_data(Conexion con) {
        this.conexion = con.buscarConexion();
    }
    
    public void agregarHuesped(Huesped huesped) {

        String sql = "INSERT INTO huesped(dni,apellido,nombre,telefono,correo,direccion,estado) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, huesped.getDni());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getNombre());
            ps.setInt(4, huesped.getTelefono());
            ps.setString(5, huesped.getCorreo());
            ps.setString(6, huesped.getDireccion());
            ps.setBoolean(7, huesped.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                huesped.setIdHuesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El huesped fue cargado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }
    
    public List listarHuespedesPorApellido(String apellido) {
        List<Huesped> huespedes = new ArrayList<>();
        String sql = "SELECT * FROM huesped WHERE apellido LIKE ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, apellido + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                h.setIdHuesped(rs.getInt("idHuesped"));
                h.setDni(rs.getInt("dni"));
                h.setApellido(rs.getString("apellido"));
                h.setNombre(rs.getString("nombre"));
                h.setTelefono(rs.getInt("telefono"));
                h.setCorreo(rs.getString("correo"));
                h.setCorreo(rs.getString("direccion"));
                h.setEstado(rs.getBoolean("estado"));
                huespedes.add(h);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        return huespedes;
    }

    public List listarHuespedes() {
        List<Huesped> huespedes = new ArrayList<>();
        String sql = "SELECT * FROM huesped";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h.setIdHuesped(rs.getInt("idHuesped"));
                h.setDni(rs.getInt("dni"));
                h.setApellido(rs.getString("apellido"));
                h.setNombre(rs.getString("nombre"));
                h.setTelefono(rs.getInt("telefono"));
                h.setCorreo(rs.getString("correo"));
                h.setCorreo(rs.getString("direccion"));
                h.setEstado(rs.getBoolean("estado"));
                huespedes.add(h);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return huespedes;
    }

    public Huesped buscarHuespedPorDni(int dni) {
        String sql = "SELECT * FROM huesped WHERE dni=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h.setIdHuesped(rs.getInt("idHuesped"));
                h.setDni(rs.getInt("dni"));
                h.setApellido(rs.getString("apellido"));
                h.setNombre(rs.getString("nombre"));
                h.setTelefono(rs.getInt("telefono"));
                h.setCorreo(rs.getString("correo"));
                h.setCorreo(rs.getString("direccion"));
                h.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        return h;
    }

    public void modificarHuesped(int dni, String apellido, String nombre, LocalDate fechaNac, boolean estado) {
        String sql = "UPDATE huesped SET apellido=?,nombre=?,fechaNac=?,estado=? WHERE dni=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, apellido);
            ps.setString(2, nombre);
            ps.setDate(3, Date.valueOf(fechaNac));
            ps.setBoolean(4, estado);
            ps.setInt(5, dni);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos del huesped han sido actualizados");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

    }
    
    public void eliminarHuesped(int dni){
    
        String sql="DELETE FROM huesped WHERE dni=?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
        
    }
}