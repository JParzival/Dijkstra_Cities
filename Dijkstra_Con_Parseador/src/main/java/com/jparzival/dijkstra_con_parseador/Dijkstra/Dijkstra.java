package com.jparzival.dijkstra_con_parseador.Dijkstra;

import com.jparzival.dijkstra_con_parseador.Clases.Grafo;
import com.jparzival.dijkstra_con_parseador.Clases.Nodo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import com.jparzival.dijkstra_con_parseador.Exceptions.ParsingException;
import com.jparzival.dijkstra_con_parseador.Parser.Parseador_File;
import java.io.FileNotFoundException;

/**
 *
 * @author jorge
 */
public class Dijkstra
{
    
    /*
        Esta es la clase main. Aquí haremos la lógica principal del programa, y como funciones tendremos las que forman el algoritmo de Dijkstra
    */

    public static void main(String[] args) throws ParsingException, FileNotFoundException
    {
        
        //Saco la información del documento JSON para poderla mostrar en el terminal y que se vean las distancias
        
        Parseador_File pf = new Parseador_File();
        System.out.println(pf.readFile());
        System.out.println("-------------------------------------------------");
        
        // Lo primero que hago es crear los nodos, y les doy un nombre.
        
        Nodo salamanca = new Nodo("Salamanca");
        Nodo valladolid = new Nodo("Valladolid");
        Nodo madrid = new Nodo("Madrid");
        Nodo zaragoza = new Nodo("Zaragoza"); 
        Nodo valencia = new Nodo("Valencia");
        
        //Ahora les añado los nodos que van a ser adyacendes a ellos, es decir, que van a tener conexión directa

        salamanca.anadirPegado(valladolid, 125);
        salamanca.anadirPegado(madrid, 214);
        valladolid.anadirPegado(zaragoza, 487);
        valladolid.anadirPegado(madrid, 214);
        madrid.anadirPegado(zaragoza, 312);
        madrid.anadirPegado(valencia, 358);
        zaragoza.anadirPegado(valencia, 312);
        
        //Inicializo el grafo...

        Grafo g = new Grafo();
        
        //... y le añado los nodos.

        g.andirNuevoNodo(salamanca);
        g.andirNuevoNodo(valladolid);
        g.andirNuevoNodo(madrid);
        g.andirNuevoNodo(zaragoza);
        g.andirNuevoNodo(valencia);
        
        // Hago el algoritmo de Dijkstra, diciendo cual es el grafo y cuál es el nodo de partida.

        //g = dijkstra(g, salamanca);
        dijkstra(salamanca);
        //Saco resultados...
        
        List<Nodo> elmascorto = valencia.getCaminoCorto();
        for(Nodo nodo : elmascorto)
        {
            System.out.println(nodo.getNombreCiudad());
        }
        System.out.println("Valencia");
        System.out.println("La distancia final recorrida ha sido: " + valencia.getDistancia());
        
    }
    
    //Estas funciones deberán de ser estáticas ya que las estoy implementando dentro de la clase Main (estática)
    
    public static void dijkstra(Nodo primero)
    {
        primero.setDistancia(0);        //Lo primero que hago es poner la distancia a cero del primero, ya que estoy en él

        Set<Nodo> pasados = new HashSet<>();        //haremos dos sets, uno de nodos ya pasados y uno de nodos no pasados
        Set<Nodo> nopasados = new HashSet<>();

        nopasados.add(primero);                     //por el primero no hemos pasado, por lo que lo añadimos y comenzaremos a iterar por él (en nuestro caso, Salamanca)

        while (!nopasados.isEmpty())                //Mientras que no esté vacío...
        {
            Nodo actual = distanciaMasCorta(nopasados); //calculamos la distancia más corta de los que no hayamos pasado
            nopasados.remove(actual);                   //ahora determinamos que hemos pasado, por lo que lo borramos del set
            for (Entry <Nodo, Integer> pegado : actual.getNodosAdjuntos().entrySet())   //Hemos obtenido los adjuntos, por lo que iteramos con ellos (cada entrada de la tabla)
            {
                Nodo siguiente = pegado.getKey();           //cogemis tanto la key como el value del mapa, obteniendo cual es el siguiente y el peso del camino (que lo utilizaremos luego para sumarlo con la distancia)
                Integer pesoCamino = pegado.getValue();
                
                if (!pasados.contains(siguiente))           //Para no repetir nodo...
                {
                    Integer distanciaDesdeOrigen;
                    distanciaDesdeOrigen = actual.getDistancia();   //cogemos la distancia entre los dos nodos, el que estoy y el siguiente
                    int totalACalcular = distanciaDesdeOrigen + pesoCamino; //Hacemos la suma comentada anteriormente...
                    
                    if(totalACalcular < siguiente.getDistancia())       //Si la distancia es menor... 
                    {
                        siguiente.setDistancia(totalACalcular);         //Ponemos que su distancia es esa
                        LinkedList<Nodo> caminoMasCorto = new LinkedList<>(actual.getCaminoCorto());    //Añadimos el camino más corto...
                        caminoMasCorto.add(actual);
                        siguiente.setCaminoCorto(caminoMasCorto);
                    }
                    
                    nopasados.add(siguiente);   //Vamos al siguiente para añadirlo a los no pasados, y poder pasar por él
                }
            }
            
            pasados.add(actual);        //añadimos en el que hemos estado en los ya pasados, para no volver a él
        }

    }
     
    private static Nodo distanciaMasCorta(Set<Nodo> noPasados) 
    {
        Nodo nodoMinimaDistancia = null;
        int minima = Integer.MAX_VALUE;     //por una de las reglas principales de Dijkstra
        int distanciaDelNodo = Integer.MAX_VALUE;
        
        for (Nodo nodo: noPasados)
        {
            distanciaDelNodo = nodo.getDistancia();
            if (distanciaDelNodo < minima)          //Si la distancia del nodo de los no pasados es menor que la mínima hasta ahora...
            {
                minima = distanciaDelNodo;
                nodoMinimaDistancia = nodo;         //Convertimos este nodo en el nodo de mínima distancia
            }
        }
        
        return nodoMinimaDistancia;                 //lo devolvemos a la función principal
    }
    
}
