/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RMCOMPUTERS
 */
public class Habitacion {
    private int id;
    private int numero;
    private String tipo;
    private String nombreHotel;
    private String disponibilidad;
    private double costoDiario;
    
    public Habitacion(){
        
    }
    
    public Habitacion(int id, int numero, String tipo, String nombreHotel, String disponibilidad, double costoDiario){
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.nombreHotel = nombreHotel;
        this.disponibilidad = disponibilidad;
        this.costoDiario = costoDiario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getCostoDiario() {
        return costoDiario;
    }

    public void setCostoDiario(double costoDiario) {
        this.costoDiario = costoDiario;
    }
}
