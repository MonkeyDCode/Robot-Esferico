/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Mimi
 */
public class Movimiento implements java.io.Serializable {
    
    private static final long serialVersionUID  = 12457862154L;
    
   /**
    * Degrees of the first joint
    */
    private double thetha;
    
    /**
    * Degrees of the second joint
    */
    private double alfa;
    
    /**
    * Distance of the third joint
    */
    private double r;

    public Movimiento() {
    }

    public Movimiento(double thetha, double alfa, double r) {
        this.thetha = thetha;
        this.alfa = alfa;
        this.r = r;
    }

    /**
     * @return the thetha
     */
    public double getThetha() {
        return thetha;
    }

    /**
     * @param thetha the thetha to set
     */
    public void setThetha(double thetha) {
        this.thetha = thetha;
    }

    /**
     * @return the alfa
     */
    public double getAlfa() {
        return alfa;
    }

    /**
     * @param alfa the alfa to set
     */
    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    /**
     * @return the z
     */
    public double getR() {
        return r;
    }

    /**
     * @param z the z to set
     */
    public void setR(double r) {
        this.r = r;
    }
    
    @Override
    public String toString()
    {
        return "Theta: " + thetha+ "\nAlpha: " + alfa + "\nR: " + r; 
    }
    
}
