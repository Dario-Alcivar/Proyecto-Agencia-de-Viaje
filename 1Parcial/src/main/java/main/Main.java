package main;

import interfaz.*;
import dominio.*;

public class Main{
     
     public static void main (String[] args){
          
        VentanaGestion venta = new VentanaGestion(new Sistema(new Trabajador()));
        venta.setVisible(true);    
    }     
}