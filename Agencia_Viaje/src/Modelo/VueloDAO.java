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
 * @author DarioA
 */
public class VueloDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarVuelos(Vuelos vl){
        String sql = "insert into vuelos (id, destino, partida, retorno) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vl.getId());
            ps.setString(2, vl.getDestino());
            ps.setString(3, vl.getPartida());
            ps.setString(4, vl.getRetorno());
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
    
   public List ListarVuelos(){
       List<Vuelos> ListaVl = new ArrayList();
       String sql = "select * from vuelos";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {          
               Vuelos vl = new Vuelos();
               vl.setId(rs.getInt("id"));
               vl.setDestino(rs.getString("destino"));
               vl.setPartida(rs.getString("partida"));
               vl.setRetorno(rs.getString("retorno"));
               ListaVl.add(vl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaVl;
   }
   
   public boolean EliminarVuelos(int id){
       String sql = "delete from vuelos where id = ?";
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
   
   public boolean ModificarVuelos(Vuelos vl){
       String sql = "update vuelos set id=?, destino=?, partida=?, retorno=? where id=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setInt(1, vl.getId());
           ps.setString(2, vl.getDestino());
           ps.setString(3, vl.getPartida());
           ps.setString(4, vl.getRetorno());
           ps.setInt(5, vl.getId());
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
     
   public List<Vuelos> buscarVuelos(String buscar){
       List<Vuelos> ListaVl = new ArrayList();
       String sql = "select * from vuelos where partida like '%" +buscar+ "%' or destino like '%" +buscar+ "%'";       
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Vuelos vl = new Vuelos();
               vl.setId(rs.getInt("id"));
               vl.setDestino(rs.getString("destino"));
               vl.setPartida(rs.getString("partida"));
               vl.setRetorno(rs.getString("retorno"));
               ListaVl.add(vl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaVl;
   }
}
