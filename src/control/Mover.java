/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ftcomputing.roboTX.Cnt;
import ftcomputing.roboTX.Dir;
import ftcomputing.roboTX.FishFaceTX;
import ftcomputing.roboTX.Mot;
import ftcomputing.roboTX.Unv;
import modelo.Direction;
import modelo.Movimiento;
import modelo.Position;
import static util.Constantes.*;



/**
 *
 * @author MarioAlberto
 */
public class Mover {
    
    private final static double A1 = 12.355555555555555555555555555556;
    private final static double A2 = 7.7948717948717948717948717948718;
    private final static double A3 = 17.535714285714285714285714285714;
    
    private final static int SPEED1 = 600;
    private final static int SPEED2 = 500;    
    private final static int SPEED3 = 600;
    
    private final static double LIM1 = 180;
    private final static double LIM2 = 18.3;    
    private final static double LIM3 = 42;
    
    private final Direction dir1;
    private final Direction dir2;
    private final Direction dir3;
    
    private final Position pos1;
    private final Position pos2;
    private final Position pos3;
    
    private int posA1;
    private int posA2;
    private int posA3;
    
    private int signA1;
    private int signA2;
    private int signA3;
    
    private final FishFaceTX fx;

    public Mover(FishFaceTX fx) {
        this.fx = fx;
        dir1 = new Direction();
        dir2 = new Direction();
        dir3 = new Direction();
        pos1 = new Position();
        pos2 = new Position();
        pos3 = new Position();
    }
     
    
    public void mover1(Movimiento m) throws InterruptedException
    {
        signA1 = 0;
        signA2 = 0;
        signA3 = 0;
        
        posA1 = moverArt(ART1, COUNT_ART1, PARO_ART1, HOME_ART1, IS_STOP_ART1, 
                IS_HOME_ART1, SPEED1, posA1, m.getThetha(), A1, LIM1, dir1);
        signA1 = 0;
        posA2 = moverArt(ART2, COUNT_ART2, PARO_ART2, HOME_ART2, IS_STOP_ART2, 
                IS_HOME_ART2, SPEED2, posA2, m.getR(), A2, LIM2, dir2);
        signA2 = 0;
        posA3 = moverArt(ART3, COUNT_ART3, PARO_ART3, HOME_ART3, IS_STOP_ART3, 
                IS_HOME_ART3, SPEED3, posA3, m.getAlfa(), A3, LIM3, dir3);
        signA3 = 0;
    }
    
    public void mover2(Movimiento m) throws InterruptedException
    {
        signA1 = 0;
        signA2 = 0;
        signA3 = 0;
        
        posA3 = moverArt(ART3, COUNT_ART3, PARO_ART3, HOME_ART3, IS_STOP_ART3, 
                IS_HOME_ART3, SPEED3, posA3, m.getAlfa(), A3, LIM3, dir3);
        signA3 = 0;
        posA2 = moverArt(ART2, COUNT_ART2, PARO_ART2, HOME_ART2, IS_STOP_ART2, 
                IS_HOME_ART2, SPEED2, posA2, m.getR(), A2 , LIM2, dir2);
        signA2 = 0;
        posA1 = moverArt(ART1, COUNT_ART1, PARO_ART1, HOME_ART1, IS_STOP_ART1, 
                IS_HOME_ART1, SPEED1, posA1, m.getThetha(), A1, LIM3 , dir1);
        signA1 = 0;
    }
    
    private int moverArt(Mot m ,Cnt c, Unv u1, Unv u2, boolean b1, boolean b2, 
            int speed, int pos, double alpha, double scale, double lim, Direction dir) throws InterruptedException
    {
        Unv v;
        boolean f,faux = true;
        int stop = (int)Math.round(alpha*scale);
        stop -= pos;
        setSign(stop, c);
        
        fx.clearCounter(c);
        Thread.sleep(100);
        if(stop > 0)
        {
            dir.dir = Dir.Left;
            fx.speedMotor(m, Dir.Left, speed);
            v = u1;
            f = b1; 
        }
        else if(stop < 0)
        {
            dir.dir = Dir.Right;
            fx.speedMotor(m, Dir.Right, speed);  
            v = u2;
            f = b2;
        }
        else
        {
            return pos;
        }
        stop = Math.abs(stop);
        while(fx.getCounter(c) < stop && (faux=fx.getInput(v) != f))
        {         
        }
        fx.setMotor(m, Dir.Off);
        dir.dir = Dir.Off;
        if(!faux && v == u2)
        {
            return 0;
        }
        else if(!faux && v == u1)
        {
            return (int)Math.round(scale*lim);
        }
        else
        {
            return Math.abs((int)Math.round(alpha*scale));
        }     
    }
    
     
    
    private void setSign(int sign, Cnt c)
    {
        if(c == COUNT_ART1)
        {
            signA1 = (int)Math.signum(sign);
        }
        else if(c == COUNT_ART2)
        {
            signA2 = (int)Math.signum(sign);
        }
        else if(c == COUNT_ART3)
        {
            signA3 = (int)Math.signum(sign);
        }
    }
    
    public void home()
    {
        homeArt(ART3, HOME_ART3, IS_HOME_ART3, SPEED3);
        homeArt(ART2, HOME_ART2, IS_HOME_ART2, SPEED2);
        homeArt(ART1, HOME_ART1, IS_HOME_ART1, SPEED1);
        posA1 = posA2 = posA3 =0;
    }
    
    public void homeArt2()
    {
        homeArt(ART2, HOME_ART2, IS_HOME_ART2, SPEED2);
        posA2 = 0;
    }
    
    public void homeArt3()
    {
        homeArt(ART3, HOME_ART3, IS_HOME_ART3, SPEED3);
        posA3 = 0;
    }
    
    
    private void homeArt(Mot m, Unv u, boolean b, int speed)
    {
        if(fx.getInput(u) == b)
        {
            return;
        }
        fx.speedMotor(m, Dir.Right, speed);
        fx.waitForInput(u, b);
        fx.setMotor(m, Dir.Off);
    }
    
    public void finCarrera()
    {
        finCarreraArt(ART1, PARO_ART1, IS_STOP_ART1,SPEED1);
        finCarreraArt(ART2, PARO_ART2, IS_STOP_ART2,SPEED2);
        finCarreraArt(ART3, PARO_ART3, IS_STOP_ART3,SPEED3);
        
        posA1 = (int)Math.round(LIM1 * A1);
        posA2 = (int)Math.round(LIM2 * A2);
        posA3 = (int)Math.round(LIM3 * A3);
    }
    
    
    public void finCarreraArt(Mot m, Unv u, boolean b, int speed)
    {
        if(fx.getInput(u) == b)
        {
            return;
        }
        fx.speedMotor(m, Dir.Left, speed);
        fx.waitForInput(u, b);
        fx.setMotor(m, Dir.Off);
    }
    
    public void openPinza()
    {
        fx.speedMotor(PINZA, Dir.Right, 700);
        fx.waitForInput(OPEN_PINZA, IS_PINZA_OPEN);
        fx.setMotor(PINZA, Dir.Off);
    }
    
    public void closePinza() throws InterruptedException
    {
        fx.speedMotor(PINZA, Dir.Left, 700);
        Thread.sleep(2300);
        fx.setMotor(PINZA, Dir.Off);
    }

    /**
     * @return the posA1
     */
    public double getPosA1() {
        if(fx.getInput(HOME_ART1) == IS_HOME_ART1)
        {
            return 0;
        }
        else if(fx.getInput(PARO_ART1) == IS_STOP_ART1)
        {
            return LIM1;
        }
        else
        {
            return (posA1 + signA1 * fx.getCounter(COUNT_ART1)) / A1;
        }
        
    }

    /**
     * @return the posA2
     */
    public double getPosA2() {
        if(fx.getInput(HOME_ART2) == IS_HOME_ART2)
        {
            return 0;
        }
        else if(fx.getInput(PARO_ART2) == IS_STOP_ART2)
        {
            return LIM2;
        }
        else
        {
            return (posA2 + signA2 * fx.getCounter(COUNT_ART2)) / A2;
        }
    }

    /**
     * @return the posA3
     */
    public double getPosA3() {
        if(fx.getInput(HOME_ART3) == IS_HOME_ART3)
        {
            return 0;
        }
        else if(fx.getInput(PARO_ART3) == IS_STOP_ART3)
        {
            return LIM3;
        }
        else
        {
            return (posA3 + signA3 * fx.getCounter(COUNT_ART3)) / A3;
        }
    }
    
    
}
