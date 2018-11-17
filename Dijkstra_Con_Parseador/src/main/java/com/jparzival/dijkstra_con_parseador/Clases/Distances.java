package com.jparzival.dijkstra_con_parseador.Clases;

/**
 *
 * @author jorge
 */

//Clase hecha para que, si algún día quiero completar el parseo, se pueda hacer.

public class Distances
{
    
    private int distance;
    private int origin;
    private int fin;

    public Distances()
    {
    }

    public Distances(int distance, int origin, int fin) 
    {
        this.distance = distance;
        this.origin = origin;
        this.fin = fin;
    }

    public int getDistance() 
    {
        return distance;
    }

    public void setDistance(int distance) 
    {
        this.distance = distance;
    }

    public int getOrigin() 
    {
        return origin;
    }

    public void setOrigin(int origin)
    {
        this.origin = origin;
    }

    public int getFin()
    {
        return fin;
    }

    public void setFin(int fin) 
    {
        this.fin = fin;
    }

    @Override
    public String toString()
    {
        return "Distances{" + "distance=" + distance + ", origin=" + origin + ", fin=" + fin + '}';
    }
    
    
}
