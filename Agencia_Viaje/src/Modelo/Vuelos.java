/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author DarioA
 */
public class Vuelos {
    private int id;
    private String destino;
    private String partida;
    private String retorno;

    
    public Vuelos() {
        
    }
    
    public Vuelos(int id, String destino, String partida, String retorno) {
        this.id = id;
        this.destino = destino;
        this.partida = partida;
        this.retorno = retorno;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
        
    
}
