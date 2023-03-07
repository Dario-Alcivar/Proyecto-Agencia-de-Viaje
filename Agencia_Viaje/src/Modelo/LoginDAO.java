
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LoginDAO {
    Connection con;    
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //consulta en la base de datos
    public login log(String correo, String pass){
        login l = new login();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs= ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
    public boolean logTest(String correo, String pass){
        login l = new login();
        boolean result = true;
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs= ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return result;
    }
    
    
    public boolean Registrar(login reg){
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List ListarUsuarios(){
       List<login> Lista = new ArrayList();
       String sql = "SELECT * FROM usuarios";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               login lg = new login();
               lg.setId(rs.getInt("id"));
               lg.setNombre(rs.getString("nombre"));
               lg.setCorreo(rs.getString("correo"));
               Lista.add(lg);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Lista;
   }
}
