/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DarioA
 */
public class ClienteDaoTest {
    
    public ClienteDaoTest() {
    }
    

    /**
     * Test of RegistrarCliente method, of class ClienteDao.
     */
    @Test
    public void testRegistrarCliente() {
        System.out.println("RegistrarCliente");
        Cliente cl = null;
        ClienteDao instance = new ClienteDao();
        boolean expResult = false;
        boolean result = instance.RegistrarCliente(cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarCliente method, of class ClienteDao.
     */
    @Test
    public void testListarCliente() {
        System.out.println("ListarCliente");
        ClienteDao instance = new ClienteDao();
        List expResult = null;
        List result = instance.ListarCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarCliente method, of class ClienteDao.
     */
    @Test
    public void testEliminarCliente() {
        System.out.println("EliminarCliente");
        int id = 0;
        ClienteDao instance = new ClienteDao();
        boolean expResult = false;
        boolean result = instance.EliminarCliente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarCliente method, of class ClienteDao.
     */
    @Test
    public void testModificarCliente() {
        System.out.println("ModificarCliente");
        Cliente cl = null;
        ClienteDao instance = new ClienteDao();
        boolean expResult = false;
        boolean result = instance.ModificarCliente(cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCliente method, of class ClienteDao.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        String buscar = "";
        ClienteDao instance = new ClienteDao();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.buscarCliente(buscar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }     
    
}
