/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DarioA
 */
public class LoginDAOTest {
    
    public LoginDAOTest() {
    }

    @Test
    public void testLog() {
        System.out.println("log");
        String correo = "dad@hotmail.";
        String pass = "admin123";
        LoginDAO instance = new LoginDAO();
        boolean expResult = true;
        boolean result = instance.logTest(correo, pass);
        assertEquals(expResult, result);
    }    
}
