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
 * @author cardi
 */
public class PaquetesDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarPaquete(Paquetes pq){
        String sql = "INSERT INTO paquetes (destino, salida, duracion, tipo) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pq.getDestino());
            ps.setString(2,pq.getSalida() );
            ps.setInt(3, pq.getDuracion());
            ps.setString(4, pq.getTipo());
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
    
    public List ListarPaquetes(){
       List<Paquetes> ListaPq = new ArrayList();
       String sql = "SELECT * FROM paquetes";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()) {               
               Paquetes pq = new Paquetes();
               pq.setDestino(rs.getString("destino"));
               pq.setSalida(rs.getString("salida"));
               pq.setDuracion(rs.getInt("duracion"));
               pq.setTipo(rs.getString("tipo"));
               ListaPq.add(pq);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaPq;
   }
   
   public boolean EliminarPaquetes(int id){
       String sql = "DELETE FROM paquetes WHERE id = ?";
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
   
   public boolean ModificarPaquetes(Paquetes pq){
       String sql = "UPDATE paquetes SET destino=?, salida=?, duracion=?, tipo=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, pq.getDestino());
           ps.setString(2, pq.getSalida());
           ps.setInt(3, pq.getDuracion());
           ps.setString(4, pq.getTipo());
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
  
   
   public List<Paquetes> buscarPaquetes(String buscar){
       List<Paquetes> ListaPq2 = new ArrayList();
       String sql = "select * from paquetes where destino like '%" +buscar+ "%' or salida like '%" +buscar+ "%'";       
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Paquetes pq = new Paquetes();
               pq.setDestino(rs.getString("destino"));
               pq.setSalida(rs.getString("salida"));
               pq.setDuracion(rs.getInt("duracion"));
               pq.setTipo(rs.getString("tipo"));
               ListaPq2.add(pq);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaPq2;
   }
}
