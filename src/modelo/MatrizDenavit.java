/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import Jama.*;
import util.DimensionesBrazo;
import java.util.Arrays;

/**
 *
 * @author Jorge
 */
public class MatrizDenavit extends DimensionesBrazo {
    
    private Movimiento movement;
    private Coordenadas coordenada;
    
    private Matrix t1;
    private Matrix t2;
    private Matrix t3;
    private Matrix T;
    
    

 
    public MatrizDenavit (){
        coordenada = new Coordenadas();
    }         
    
    public MatrizDenavit(Movimiento movement)
    {
        this.movement = movement;
    }
    
    public void mostrarMatrix(Matrix m)
    {
        for (double [] i : m.getArray())
        {
            System.out.println(Arrays.toString(i));
        }
        
    }
    
    private synchronized void mostrarCoordenada(Matrix m)
    {
        coordenada.setX(m.get(0, 3));
        coordenada.setY(m.get(1, 3));
        coordenada.setZ(m.get(2, 3));
//        System.out.print("(");
//        for (double [] i : m.getArray()) {
//            System.out.print(""+i[3]+",");
//        }
//        System.out.println("/b)");
    }

   
    public synchronized void matrizTraslacion()
    {
        t1 = crearMatriz(THETHA1 + movement.getThetha(),L1,A1,ALPHA1);
        /*System.out.println("1° Matriz");
        mostrarMatrix(a1);*/
        Matrix a2 = crearMatriz(THETHA2, L2 + movement.getR(), A2,ALPHA2);
        /*System.out.println("2° Matriz");
        mostrarMatrix(a2);*/
        Matrix a3 = crearMatriz(THETHA3 + movement.getAlfa(), L3, A3,ALPHA3);
        /*System.out.println("3° Matriz");
        mostrarMatrix(a3);*/
        Matrix a4 = crearMatriz(THETHA4 + C * movement.getAlfa(), L4, A4,ALPHA4);
        /*System.out.println("4° Matriz");
        mostrarMatrix(a4);*/
        
        t2 = t1.times(a2);
        /*System.out.println("Matriz de traslación 1");
        mostrarMatrix(T);*/
        t3 = t2.times(a3);
        /*System.out.println("Matriz de traslación 2");
        mostrarMatrix(T);*/
        T = t3.times(a4);
        if(movement.getR() > 4)
        {
            T.set(2, 3, T.get(2, 3) - 2);
            
        }
        if(movement.getAlfa() > 10)
        {
            T.set(2, 3, T.get(2, 3) - 1);
        }
        /*System.out.println("Matriz de traslación 3");
        mostrarMatrix(T);*/
        mostrarCoordenada(T);
    }
    /**
     * This method creates a the Matrix A(i) of the Denavit-Hatenberg algorithm
     * from the parameters received, using alpha(i) = 0;
     * @param thetha the thetha(i) of the Denavit-Hatenberg algorithm
     * @param d  The d(i) of the Denavit-Hatenberg algorithm
     * @param a The a(i) of the Denavit-Hatenberg algorithm
     * @return The Matrix of the Denavit-Hatenberg
     */
    private Matrix crearMatriz(double thetha, double d, double a , double alpha)
    {
        double [][] b;
        if(alpha == 90)
        {
            
            b = new double[][]  {{Math.cos(Math.toRadians(thetha)),0.0,Math.sin(Math.toRadians(thetha)),a*Math.cos(Math.toRadians(thetha))},
                        {Math.sin(Math.toRadians(thetha)),0.0,-1.0 * Math.cos(Math.toRadians(thetha)),a*Math.sin(Math.toRadians(thetha))},
                        {0,1,0,d},{0,0,0,1}};
        }
        else
        {
            b = new double[][]  {{Math.cos(Math.toRadians(thetha)),-1.0*Math.sin(Math.toRadians(thetha)),0.0,a*Math.cos(Math.toRadians(thetha))},
                        {Math.sin(Math.toRadians(thetha)),Math.cos(Math.toRadians(thetha)),0,a*Math.sin(Math.toRadians(thetha))},
                        {0,0,1,d},{0,0,0,1}};
        }
        return new Matrix(b);
    }

    public double[][] getT1() {
        return t1.getArray();
    }

    public double[][] getT2() {
        return t2.getArray();
    }

    public double[][] getT3() {
        return t3.getArray();
    }

    public double[][] getT() {
        return T.getArray();
    }

    public Coordenadas getCoordenada() {
        return coordenada;
    }
    
    
    
    

    /**
     * @return the movement
     */
    public Movimiento getMovement() {
        return movement;
    }

    /**
     * @param movement the movement to set
     */
    public void setMovement(Movimiento movement) {
        this.movement = movement;
    }
     
    
    
}
