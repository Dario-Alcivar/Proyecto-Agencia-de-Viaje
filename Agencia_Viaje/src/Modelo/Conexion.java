/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author DarioA
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    Connection con;

    public Connection getConnection() {
        /*//Conexion en ORACLE
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String myBD = "jdbc:oracle:thin:@localhost:1521:XE";
            con = DriverManager.getConnection(myBD, "System", "Admin2022");            
            System.out.println("Conectado");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null*/
        
        //Conexion en MySQL
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String myDB = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
            con = DriverManager.getConnection(myDB, "root", "");
            return con;
        }catch (SQLException e){
            System.out.println("Error"+e);            
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la Base de Datos, contacte con soporte");
        }    
        return null;
    }
    
}
