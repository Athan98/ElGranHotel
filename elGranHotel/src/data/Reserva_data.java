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
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

public class Reserva_data {

    private Connection con = null;
    
 

    public Reserva_data(Conexion c) {
        this.con = c.buscarConexion();
    }

    public void hacerReserva(Huesped h, Habitacion hab, LocalDate ingreso, LocalDate egreso, int personas) {
        ReservaHuesped reserva = new ReservaHuesped();
        String sql = "INSERT INTO reserva (idHuesped, idHabitacion, fechaIngreso, fechaSalida, monto, estado) VALUES (?,?,?,?,?,?)";

        long dias = egreso.toEpochDay() - ingreso.toEpochDay();
        double precioXnoche = dias * hab.getIdTipoHabitacion().getPrecioPorNoche();

        if (!hab.isOcupada()) {
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, h.getIdHuesped());
                ps.setInt(2, hab.getIdHabitacion());
                ps.setDate(3, Date.valueOf(ingreso));
                ps.setDate(4, Date.valueOf(egreso));
                ps.setDouble(5, precioXnoche);
                ps.setBoolean(6, true);

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    reserva.setIdReserva(rs.getInt(1));                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error al obtener el ID");
                }
                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de sentencia.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La Habitacion está ocupada.");
        }

    }

    public List buscarReservaPorHuesped(String dni) {
        List<ReservaHuesped> reservas = new ArrayList();

        String sql = "SELECT * FROM reserva r JOIN huesped h ON(r.idHuesped=h.idHuesped) JOIN habitacion hab ON (r.idHabitacion=hab.idHabitacion) JOIN tipohabitacion tp ON(hab.idTipoHabitacion = tp.idTipoHabitacion) WHERE h.dni=? ORDER BY r.idReserva";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReservaHuesped r = new ReservaHuesped();
                Huesped huesped = new Huesped();
                Habitacion hab = new Habitacion();
                TipoHabitacion tipo = new TipoHabitacion();

                r.setIdReserva(rs.getInt("idReserva"));
                                                        
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setDireccion(rs.getString("direccion"));
                huesped.setDni("dni");
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                r.setIdHuesped(huesped);

                hab.setIdHabitacion(rs.getInt("idHabitacion"));
                hab.setNroHabitacion(rs.getInt("nroHabitacion"));
                hab.setPiso(rs.getInt("piso"));
                hab.setOcupada(rs.getBoolean("ocupada"));
                tipo.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipo.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                tipo.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipo.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                tipo.setTipo(rs.getString("Tipo"));
                tipo.setTipoCamas(rs.getString("tipoCamas"));
                hab.setIdTipoHabitacion(tipo);
                r.setIdHabitacion(hab);

                r.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                r.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                r.setMonto(rs.getDouble("monto"));
                r.setEstado(rs.getBoolean("estado"));

                reservas.add(r);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de sentencia SQL");
        }

        return reservas;
    }
    
    public void cancelarReserva (int idReserva){
        String sql = "DELETE FROM reserva  WHERE idReserva=?";
        
        try {   
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idReserva);
            ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null,"Reserva cancelada.");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia SQL");
        }
        
        
    }
    
    public void finReserva(){        
        String sql ="UPDATE reserva r SET estado=0 WHERE r.fechasalida <= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,Date.valueOf(LocalDate.now()));
            ps.executeQuery();
            ResultSet rs = ps.getGeneratedKeys();           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia.");
        }
    }
    
    public List buscarReservasXfecha(LocalDate ingreso, LocalDate egreso){
        ReservaHuesped r;
        Huesped huesped;
        Habitacion hab;
        TipoHabitacion tipo;
        List<ReservaHuesped> reservas = new ArrayList();
        try {
            String sql = "SELECT * FROM reserva r JOIN huesped h ON(r.idHuesped=h.idHuesped) JOIN habitacion hab ON (r.idHabitacion=hab.idHabitacion) JOIN tipohabitacion tp ON(hab.idTipoHabitacion = tp.idTipoHabitacion) WHERE (? BETWEEN r.fechaIngreso AND r.fechaSalida) OR  ( ? BETWEEN r.fechaIngreso AND r.fechaSalida) OR (r.fechaIngreso BETWEEN ? AND ?) OR (r.fechaSalida BETWEEN ? AND ?) ORDER BY hab.piso";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(ingreso));
            ps.setDate(2, Date.valueOf(egreso));
            ps.setDate(3, Date.valueOf(ingreso));
            ps.setDate(4, Date.valueOf(egreso));
            ps.setDate(5, Date.valueOf(ingreso));
            ps.setDate(6, Date.valueOf(egreso));
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                r = new ReservaHuesped();
                huesped = new Huesped();
                hab = new Habitacion();
                tipo = new TipoHabitacion();

                r.setIdReserva(rs.getInt("idReserva"));
                                                        
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setDireccion(rs.getString("direccion"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                r.setIdHuesped(huesped);

                hab.setIdHabitacion(rs.getInt("idHabitacion"));
                hab.setNroHabitacion(rs.getInt("nroHabitacion"));
                hab.setPiso(rs.getInt("piso"));
                hab.setOcupada(rs.getBoolean("ocupada"));
                tipo.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipo.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                tipo.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipo.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                tipo.setTipo(rs.getString("Tipo"));
                tipo.setTipoCamas(rs.getString("tipoCamas"));
                hab.setIdTipoHabitacion(tipo);
                r.setIdHabitacion(hab);

                r.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                r.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                r.setMonto(rs.getDouble("monto"));
                r.setEstado(rs.getBoolean("estado"));

                reservas.add(r);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error sentencia SQL");
           
        }
        return reservas;
    }
    
    public List listarReservas () {
       
        List<ReservaHuesped> reservas = new ArrayList();
        try {
            
            
            String sql = "SELECT * FROM reserva r JOIN huesped h ON(r.idHuesped=h.idHuesped) JOIN habitacion hab ON (r.idHabitacion=hab.idHabitacion) JOIN tipohabitacion tp ON(hab.idTipoHabitacion = tp.idTipoHabitacion) WHERE r.estado=true";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ReservaHuesped r = new ReservaHuesped();
                Huesped huesped = new Huesped();
                Habitacion hab = new Habitacion();
                TipoHabitacion tipo = new TipoHabitacion();

                r.setIdReserva(rs.getInt("idReserva"));
                                                        
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setDireccion(rs.getString("direccion"));
                huesped.setDni(rs.getString("dni"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                r.setIdHuesped(huesped);

                hab.setIdHabitacion(rs.getInt("idHabitacion"));
                hab.setNroHabitacion(rs.getInt("nroHabitacion"));
                hab.setPiso(rs.getInt("piso"));
                hab.setOcupada(rs.getBoolean("ocupada"));
                tipo.setCantidadCamas(rs.getInt("cantidadCamas"));
                tipo.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                tipo.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipo.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                tipo.setTipo(rs.getString("Tipo"));
                tipo.setTipoCamas(rs.getString("tipoCamas"));
                hab.setIdTipoHabitacion(tipo);
                r.setIdHabitacion(hab);

                r.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
                r.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                r.setMonto(rs.getDouble("monto"));
                r.setEstado(rs.getBoolean("estado"));

                reservas.add(r);
            }
            
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error sentencia SQL");
        }
         
         return reservas;
    }
}
