/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author MarioAlberto
 */
public class MovLibreArt implements Runnable {
    
    private Thread t;
    private int dir;
    private final Mover2 mov;

    public MovLibreArt(Mover2 mov) {
        this.mov = mov;
    }
    
    

    @Override
    public void run() {
        switch(dir)
        {
            case 0:
                mov.stopArt1();
                mov.movLibLeftArt3();
                break;
//            case 1:
//                mov.movLibLeftArt3();
//                mov.movLibRightArt1();
//                break;
            case 2:
                mov.stopArt3();
                mov.movLibRightArt1();
                break;
//            case 3:
//                mov.movLibRightArt1();
//                mov.movLibRightArt3();
//                break;
            case 4:
                mov.stopArt1();
                mov.movLibRightArt3();
                break;
//            case 5:
//                mov.movLibLeftArt1();
//                mov.movLibRightArt3();
//                break;
            case 6:
                mov.stopArt3();
                mov.movLibLeftArt1();
                break;
//            case 7:
//                mov.movLibLeftArt3();
//                mov.movLibLeftArt1();
//                break;
            case 8:
                mov.movLibRightArt2();
                break;
            case 9:
                mov.movLibLeftArt2();
                break;
        }

        
    }
    
    public void moverArt1(int dir)
    {
        this.dir = dir;
        t = new Thread(this);
        t.start();
    }
    
    public void stopArt1()
    {
        mov.stopArt1();
    }
    
    public void stopArt2()
    {
        mov.stopArt2();
    }
    
    public void stopArt3()
    {
        mov.stopArt3();
    }
    
}
