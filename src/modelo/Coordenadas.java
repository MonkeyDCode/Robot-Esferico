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
public class Coordenadas  {
    
    private static final long serialVersionUID  = 12457862151L;
    
    /**
     * The x of the cartesian plane
     */
    private double x;
    
    /**
     * The y of the cartesian plane
     */
    private double y;
    
    /**
     * The z of the cartesian plane
     */
    private double z;
    
    public Coordenadas(){
        
    }

    /**
     * 
     * @param x the x to set
     * @param y the y to set
     * @param z the z to set
     */
    public Coordenadas(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(double z) {
        this.z = z;
    }
    
    @Override
    public String toString()
    {
        return "X: " + x + "\nY: " + y + "\nZ: " + z;
    }
    
    
}