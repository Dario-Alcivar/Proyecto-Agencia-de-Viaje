/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author UsuarioPC
 */
public class HotelesDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
public boolean RegistrarHoteles(Hotel htl){
        String sql = "INSERT INTO hoteles (localidad, nombre, habitacion, precio) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, htl.getLocalidad());
            ps.setString(2, htl.getNombre());
            ps.setString(3, htl.getHabitacion());
            ps.setFloat(4, htl.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
   public List ListarHoteles(){
       List<Hotel> ListaHtl = new ArrayList();
       String sql = "SELECT * FROM hoteles";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Hotel htl = new Hotel();
               htl.setId(rs.getInt("id"));
               htl.setLocalidad(rs.getString("localidad"));
               htl.setNombre(rs.getString("nombre"));
               htl.setHabitacion(rs.getString("habitacion"));
               htl.setPrecio(rs.getFloat("precio"));
               ListaHtl.add(htl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaHtl;
   }
   
   public boolean EliminarHoteles(int id){
       String sql = "DELETE FROM hoteles WHERE id = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
   }
   
   public boolean ModificarHoteles(Hotel htl){
       String sql = "update hoteles set localidad=?, nombre=?, habitacion=?, precio=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, htl.getLocalidad());
           ps.setString(2, htl.getNombre());
           ps.setString(3, htl.getHabitacion());
           ps.setFloat(4, htl.getPrecio());
           ps.setInt(5, htl.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
   
   public List<Hotel> BuscarHoteles(String buscar){       
       List<Hotel> ListaHtl = new ArrayList();
       String sql = "SELECT * FROM hoteles WHERE localidad = '%"+buscar+"%' or habitacion '%"+buscar+"%'";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Hotel htl = new Hotel();
               htl.setId(rs.getInt("id"));
               htl.setLocalidad(rs.getString("localidad"));
               htl.setNombre(rs.getString("nombre"));
               htl.setHabitacion(rs.getString("habitacion"));
               htl.setPrecio(rs.getFloat("precio"));
               ListaHtl.add(htl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaHtl;
   }   
}
