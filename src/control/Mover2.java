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
public class Mover2 {
    
    private final static double A1 = 12.5;
    private final static double A2 = 7.7948717948717948717948717948718;
    private final static double A3 = 17.535714285714285714285714285714;
    
    private final static int SPEED1 = 600;
    private final static int SPEED2 = 500;    
    private final static int SPEED3 = 600;
    
    private final static double LIM1 = 180; //2196
    private final static double LIM2 = 18.3;    
    private final static double LIM3 = 42;
    
    private final Direction dir1;
    private final Direction dir2;
    private final Direction dir3;
    
    private final Position pos1;
    private final Position pos2;
    private final Position pos3;
    
    private volatile boolean  flagart1;
    private volatile boolean  flagart2;
    private volatile boolean  flagart3;
    
    private volatile boolean  stop;
    
    
    
    private final FishFaceTX fx;

    public Mover2(FishFaceTX fx) {
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
        
        moverArt(ART1, COUNT_ART1, PARO_ART1, HOME_ART1, IS_STOP_ART1, 
                IS_HOME_ART1, SPEED1, pos1, m.getThetha(), A1, LIM1, dir1);
        if(stop) return;
        
        moverArt(ART2, COUNT_ART2, PARO_ART2, HOME_ART2, IS_STOP_ART2, 
                IS_HOME_ART2, SPEED2, pos2, m.getR(), A2, LIM2, dir2);
        if(stop) return;
        moverArt(ART3, COUNT_ART3, PARO_ART3, HOME_ART3, IS_STOP_ART3, 
                IS_HOME_ART3, SPEED3, pos3, m.getAlfa(), A3, LIM3, dir3);
       
    }
    
    public void mover2(Movimiento m) throws InterruptedException
    {
        
        moverArt(ART3, COUNT_ART3, PARO_ART3, HOME_ART3, IS_STOP_ART3, 
                IS_HOME_ART3, SPEED3, pos3, m.getAlfa(), A3, LIM3, dir3);
        
        moverArt(ART2, COUNT_ART2, PARO_ART2, HOME_ART2, IS_STOP_ART2, 
                IS_HOME_ART2, SPEED2, pos2, m.getR(), A2 , LIM2, dir2);
        
        moverArt(ART1, COUNT_ART1, PARO_ART1, HOME_ART1, IS_STOP_ART1, 
                IS_HOME_ART1, SPEED1, pos1, m.getThetha(), A1, LIM1 , dir1);
    }
    
    
    
    private synchronized void moverArt(Mot m ,Cnt c, Unv u1, Unv u2, boolean b1, boolean b2, 
            int speed, Position pos, double alpha, double scale, double lim, Direction dir) throws InterruptedException
    {
        if(stop) return;
        int stop = (int)Math.round(alpha*scale);
        int stopaux = stop - pos.pos;
        
        fx.clearCounter(c);
        Thread.sleep(100);
        
        if(stopaux > 0)
        {
            dir.dir = Dir.Left;
            moveLeft(m, c, u1, b1, speed, pos, stop, scale * lim);
            dir.dir = Dir.Off;
        }
        else if(stopaux < 0)
        {
            dir.dir = Dir.Right;
            moveRigth(m, c, u2, b2, speed, pos, stop);
            dir.dir = Dir.Off;
        } 
    }
     
     private synchronized void moveLeft(Mot m ,Cnt c, Unv u1, boolean b1,int speed, Position pos, 
             int stop, double lim)
     {
         if(fx.getInput(u1) == b1)
         {
             return;
         }
         pos.flag = false;
         fx.speedMotor(m, Dir.Left, speed);
         while ((pos.posaux = pos.pos + fx.getCounter(c)) < stop && fx.getInput(u1) != b1 && !this.stop) 
         {  
         }
         fx.setMotor(m, Dir.Off);
         pos.flag = true;
         if(fx.getInput(u1) == b1)
         {
             pos.pos = (int)(Math.round(lim));
             pos.posaux = pos.pos;
             System.out.println("Fin:" + pos.pos);
         }
         else
         {
            pos.pos = pos.posaux;    
         }
     }
     
     private synchronized void moveRigth(Mot m ,Cnt c, Unv u1, boolean b1,int speed, Position pos, 
             int stop)
     {
         if(fx.getInput(u1) == b1)
         {
             return;
         }
         pos.flag = false;
         fx.speedMotor(m, Dir.Right, speed);
         while ((pos.posaux = pos.pos - fx.getCounter(c)) > stop && fx.getInput(u1) != b1 && !this.stop) 
         {  
         }
         fx.setMotor(m, Dir.Off);
         pos.flag = true;
         if(fx.getInput(u1) == b1)
         {
             pos.pos = 0;
             pos.posaux = pos.pos;
         }
         else
         {
            pos.pos = pos.posaux;    
         }
     }
     
     public void home()
    {
        if(stop)return;
        homeArt3();
        if(stop)return;
        homeArt2();
        if(stop)return;
        homeArt1();
    }
     
    public synchronized void homeArt1()
    {
        dir1.dir = Dir.Right;
        homeArt(ART1, COUNT_ART1, HOME_ART1, pos1, IS_HOME_ART1, SPEED1);
        dir1.dir = Dir.Off;
        pos1.pos = 0;
    }
    
    public synchronized void homeArt2()
    {
        dir2.dir = Dir.Right;
        homeArt(ART2, COUNT_ART2, HOME_ART2, pos2, IS_HOME_ART2, SPEED2);
        dir2.dir = Dir.Off;
        pos2.pos = 0;
    }
    
    public synchronized void homeArt3()
    {
        dir3.dir = Dir.Right;
        homeArt(ART3, COUNT_ART3, HOME_ART3, pos3, IS_HOME_ART3, SPEED3);
        dir3.dir = Dir.Off;
        pos3.pos = 0;
    }
    
    
    private synchronized void homeArt(Mot m, Cnt c, Unv u, Position pos, boolean b, int speed)
    {
        if(fx.getInput(u) == b)
        {
            return;
        }
        pos.flag = false;
        fx.speedMotor(m, Dir.Right, speed);
        while (fx.getInput(u) != b && !stop) 
        {  
            pos.posaux = pos.pos - fx.getCounter(c);
        }
        fx.setMotor(m, Dir.Off);
        pos.flag = true;
    }
    
    public void finCarrera()
    {
        if(stop)return;
        finCarreraArt1();
        if(stop)return;
        finCarreraArt2();
        if(stop)return;
        finCarreraArt3();
        
    }
    
    public synchronized void finCarreraArt1()
    {
        dir1.dir = Dir.Left;
        finCarreraArt(ART1, COUNT_ART1, PARO_ART1, pos1, IS_STOP_ART1, SPEED1);
        dir1.dir = Dir.Off;
        pos1.pos = (int)Math.round(LIM1 * A1);
    }
    
    public synchronized void finCarreraArt2()
    {
        dir2.dir = Dir.Left;
        finCarreraArt(ART2, COUNT_ART2, HOME_ART2, pos2, IS_HOME_ART2, SPEED2);
        dir2.dir = Dir.Off;
        pos2.pos = (int)Math.round(LIM2 * A2);
    }
    
    public synchronized void finCarreraArt3()
    {
        dir3.dir = Dir.Left;
        finCarreraArt(ART3, COUNT_ART3, HOME_ART3, pos3, IS_HOME_ART3, SPEED3);
        dir3.dir = Dir.Off;
        pos3.pos = (int)Math.round(LIM3 * A3);
    }
        
    
    public synchronized void finCarreraArt(Mot m, Cnt c, Unv u, Position pos, boolean b, int speed)
    {
        if(fx.getInput(u) == b)
        {
            return;
        }
        pos.flag = false;
        fx.speedMotor(m, Dir.Left, speed);
        while (fx.getInput(u) != b && !stop) 
        {  
            pos.posaux = pos.pos + fx.getCounter(c);
        }
        fx.setMotor(m, Dir.Off);
        pos.flag = true;
    }
    
    public void openPinza()
    {
        fx.speedMotor(PINZA, Dir.Right, 700);
        while(fx.getInput(OPEN_PINZA)!= IS_PINZA_OPEN && !stop)
        {
            
        }
        fx.setMotor(PINZA, Dir.Off);
    }
    
    public void closePinza() throws InterruptedException
    {
        fx.speedMotor(PINZA, Dir.Left, 700);
        Thread.sleep(2300);
        fx.setMotor(PINZA, Dir.Off);
    }
    
    //Theta
    public double getPosA1()
    {
        if(!pos1.flag)
        {
            return pos1.posaux / A1;
        }
        else
        {
            return pos1.pos / A1;
        }
    }
    
    //R
    public double getPosA2()
    {
        if(!pos2.flag)
        {
            return pos2.posaux / A2;
        }
        else
        {
            return pos2.pos / A2;
        }
    }
    
    //Alpha
    public double getPosA3()
    {
        if(!pos3.flag)
        {
            return pos3.posaux / A3;
        }
        else
        {
            return pos3.pos / A3;
        }
    }
    
    public void pause()
    {
        fx.setMotor(ART1, Dir.Off);
        fx.setMotor(ART2, Dir.Off);
        fx.setMotor(ART3, Dir.Off);
    }
    
    public void continuar()
    {
        stop = false;
        fx.speedMotor(ART1, dir1.dir, SPEED1);
        fx.speedMotor(ART2, dir2.dir, SPEED2);
        fx.speedMotor(ART3, dir3.dir, SPEED3);
    }
    
    public void stopArt1()
    {
        flagart1 = false;
    }
    
    public synchronized void movLibLeftArt1()
    {
        fx.clearCounter(COUNT_ART1);
        flagart1 = true;
        if(fx.getInput(HOME_ART1) == IS_HOME_ART1)
        {
            return;
        }
        pos1.flag = false;
        fx.speedMotor(ART1, Dir.Right, SPEED1);
        while(flagart1 && fx.getInput(HOME_ART1) != IS_HOME_ART1)
        {
            pos1.posaux = pos1.pos - fx.getCounter(COUNT_ART1);
        }
        fx.setMotor(ART1, Dir.Off);
        pos1.flag = true;
        if(fx.getInput(HOME_ART1) == IS_HOME_ART1)
         {
             pos1.pos = 0;
             pos1.posaux = pos1.pos;
         }
         else
         {
            pos1.pos = pos1.posaux;    
         }
        System.out.println(pos1.pos);
        
    }
    
    public synchronized void movLibRightArt1()
    {
        fx.clearCounter(COUNT_ART1);
        flagart1 = true;
        if(fx.getInput(PARO_ART1) == IS_STOP_ART1)
        {
            return;
        }
        pos1.flag = false;
        fx.speedMotor(ART1, Dir.Left, SPEED1);
        while(flagart1 && fx.getInput(PARO_ART1) != IS_STOP_ART1)
        {
            pos1.posaux = pos1.pos + fx.getCounter(COUNT_ART1);
        }
        fx.setMotor(ART1, Dir.Off);
        pos1.flag = true;
        if(fx.getInput(PARO_ART1) == IS_STOP_ART1)
         {
             pos1.pos = 2250;
             pos1.posaux = pos1.pos;
         }
         else
         {
            pos1.pos = pos1.posaux;    
         }
        System.out.println(pos1.pos);
        
    }
    
    public void stopArt2()
    {
        flagart2 = false;
    }
    
    public synchronized void movLibLeftArt2()
    {
        fx.clearCounter(COUNT_ART2);
        flagart2 = true;
        if(fx.getInput(HOME_ART2) == IS_HOME_ART2)
        {
            return;
        }
        pos2.flag = false;
        fx.speedMotor(ART2, Dir.Right, SPEED2);
        while(flagart2 && fx.getInput(HOME_ART2) != IS_HOME_ART2)
        {
            pos2.posaux = pos2.pos - fx.getCounter(COUNT_ART2);
            //System.out.println(fx.getCounter(COUNT_ART2));
            //System.out.println(pos2.posaux);
        }
        fx.setMotor(ART2, Dir.Off);
        pos2.flag = true;
        if(fx.getInput(HOME_ART2) == IS_HOME_ART2)
         {
             pos2.pos = 0;
             pos2.posaux = pos2.pos;
         }
         else
         {
            pos2.pos = pos2.posaux;    
         }
        
    }
    
    public synchronized void movLibRightArt2()
    {
        fx.clearCounter(COUNT_ART2);
        flagart2 = true;
        if(fx.getInput(PARO_ART2) == IS_STOP_ART2)
        {
            return;
        }
        pos2.flag = false;
        fx.speedMotor(ART2, Dir.Left, SPEED2);
        while(flagart2 && fx.getInput(PARO_ART2) != IS_STOP_ART2)
        {
            pos2.posaux = pos2.pos + fx.getCounter(COUNT_ART2);
        }
        fx.setMotor(ART2, Dir.Off);
        pos2.flag = true;
        if(fx.getInput(PARO_ART2) == IS_STOP_ART2)
         {
             pos2.pos = (int)(Math.round(LIM2 * A2));
             pos2.posaux = pos2.pos;
         }
         else
         {
            pos2.pos = pos2.posaux;    
         }
        
    }
    
    public void stopArt3()
    {
        flagart3 = false;
    }
    
    public synchronized void movLibLeftArt3()
    {
        fx.clearCounter(COUNT_ART3);
        flagart3 = true;
        if(fx.getInput(HOME_ART3) == IS_HOME_ART3)
        {
            return;
        }
        pos3.flag = false;
        fx.speedMotor(ART3, Dir.Right, SPEED3);
        while(flagart3 && fx.getInput(HOME_ART3) != IS_HOME_ART3)
        {
            pos3.posaux = pos3.pos - fx.getCounter(COUNT_ART3);
        }
        fx.setMotor(ART3, Dir.Off);
        pos3.flag = true;
        if(fx.getInput(HOME_ART3) == IS_HOME_ART3)
         {
             pos3.pos = 0;
             pos3.posaux = pos3.pos;
         }
         else
         {
            pos3.pos = pos3.posaux;    
         }
        
    }
    
    public synchronized void movLibRightArt3()
    {
        fx.clearCounter(COUNT_ART3);
        flagart3 = true;
        if(fx.getInput(PARO_ART3) == IS_STOP_ART3)
        {
            return;
        }
        pos3.flag = false;
        fx.speedMotor(ART3, Dir.Left, SPEED3);
        while(flagart3 && fx.getInput(PARO_ART3) != IS_STOP_ART3)
        {
            pos3.posaux = pos3.pos + fx.getCounter(COUNT_ART3);
        }
        fx.setMotor(ART3, Dir.Off);
        pos3.flag = true;
        if(fx.getInput(PARO_ART3) == IS_STOP_ART3)
         {
             pos3.pos = (int)(Math.round(LIM3 * A3));
             pos3.posaux = pos3.pos;
         }
         else
         {
            pos3.pos = pos3.posaux;    
         }
        
    }
    
    public void stop()
    {
        pause();
        fx.setMotor(PINZA, Dir.Off);
        stopArt1();
        stopArt2();
        stopArt3();
        stop = true;
        dir1.dir = Dir.Off;
        dir2.dir = Dir.Off;
        dir3.dir = Dir.Off;
    }
    
}
