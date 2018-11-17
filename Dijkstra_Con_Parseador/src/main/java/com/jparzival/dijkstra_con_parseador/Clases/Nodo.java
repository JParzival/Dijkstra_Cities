package com.jparzival.dijkstra_con_parseador.Clases;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jorge
 */
public class Nodo 
{
    
    private String nombreCiudad;                            //Nombre de la ciudad
    private List<Nodo> caminoCorto = new LinkedList<>();    //Para ir guardando el camino más corto
    private Integer distancia = Integer.MAX_VALUE;          //En integer para evitar problemas
    Map<Nodo, Integer> nodosAdjuntos = new HashMap<>();     //Los nodos que están siguiendo a este
    
    //Hago el constructor...
    public Nodo(String nombreCiudad) 
    {
        this.nombreCiudad = nombreCiudad;
    }
   
    //Hago esta función para poder añadir los nodos que estén directamente conectados en la inicialización
    public void anadirPegado(Nodo destination, int distance)
    {
        nodosAdjuntos.put(destination, distance);
    }
   
    //Ahora ponemos los get y set

    public String getNombreCiudad()
    {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) 
    {
        this.nombreCiudad = nombreCiudad;
    }

    public List<Nodo> getCaminoCorto() 
    {
        return caminoCorto;
    }

    public void setCaminoCorto(List<Nodo> caminoCorto) 
    {
        this.caminoCorto = caminoCorto;
    }

    public Integer getDistancia() 
    {
        return distancia;
    }

    public void setDistancia(Integer distancia)
    {
        this.distancia = distancia;
    }

    public Map<Nodo, Integer> getNodosAdjuntos() 
    {
        return nodosAdjuntos;
    }

    public void setNodosAdjuntos(Map<Nodo, Integer> nodosAdjuntos) 
    {
        this.nodosAdjuntos = nodosAdjuntos;
    }
    
}
