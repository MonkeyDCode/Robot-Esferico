/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import util.DimensionesBrazo;

/**
 *
 * @author Jorge
 */
public class Geometrico extends DimensionesBrazo {
    
    public static Movimiento modeloInverso(Coordenadas c)
    {

        double d, hip, thetha;
        thetha = Math.atan2(c.getY(), c.getX());
        d = hip = Math.pow(c.getX(), 2) + Math.pow(c.getY(), 2);
        d -= (Math.pow(A2, 2) + Math.pow((A3+A4), 2));
        d /= (2 * A2 * (A3+A4));
        double thetha2 = Math.acos(d);
        
        hip = Math.sqrt(hip);
        
        d = Math.pow(c.getX(), 2) + Math.pow(c.getY(), 2);
        d += Math.pow(A2, 2);
        d = -1 * (Math.pow((A3+A4), 2) - d);
        d /= (2 * A2 * hip);        
        double thetha1 = Math.acos(d);
        thetha1 = thetha - thetha1;
        
        double z = c.getZ() - 19.9;

        return new Movimiento(Math.round(Math.toDegrees(thetha1)), Math.toDegrees(thetha2), z);
    }
    
    public static Coordenadas modeloGeometrico(Movimiento m)
    {
        double x = A2 * Math.cos(Math.toRadians(m.getThetha())) + (A3 + A4) * Math.cos(Math.toRadians(m.getThetha()) + Math.toRadians(m.getAlfa()));
        double y = A2 * Math.sin(Math.toRadians(m.getThetha())) + (A3 + A4) * Math.sin(Math.toRadians(m.getThetha()) + Math.toRadians(m.getAlfa()));
        double z = 19.9 - m.getR();
        return new Coordenadas(x, y, z);
    }
}
