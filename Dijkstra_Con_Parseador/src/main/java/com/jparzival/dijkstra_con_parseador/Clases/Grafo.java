/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jparzival.dijkstra_con_parseador.Clases;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jorge
 */

//Esta clase Grafo es innecesaria, pero la tengo creada en caso de que algún día se quiera ampliar el código y meterle al grafo algunas funcionalidades...
//o hacer una interfaz gráfica del mismo con las librerías pertinentes.

public class Grafo 
{
    //El grafo estará compuesto de un conjunto de nodos, por lo que hago un mapa para guardarlos
    private Set<Nodo> nodos = new HashSet<>();
     
    //Por supuesto, tenemos que tener una función de añadir un nuevo nodo, que la usaremos para la inicialización.
    public void andirNuevoNodo(Nodo nodo)
    {
        nodos.add(nodo);
    }
 
    // Ponemos get y set 

    public Set<Nodo> getNodos()
    {
        return nodos;
    }

    public void setNodos(Set<Nodo> nodos) 
    {
        this.nodos = nodos;
    }
    
}
