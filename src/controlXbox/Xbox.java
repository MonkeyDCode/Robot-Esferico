/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlXbox;

import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerListener;
import control.AcomodarFichas;
import control.MovLibreArt;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Accion;
import modelo.MatrizDenavit;
import modelo.Movimiento;



/**
 *
 * @author MarioAlberto
 */
public class Xbox implements XboxControllerListener {
    
    private XboxController xbox;
    private MovLibreArt movLib1;
    private boolean flag1;
    private boolean flag2;
    
    private final ArrayList<Accion> accion;
    private final AcomodarFichas acomodarFichas;
    
    private final MatrizDenavit matriz;
    private final Movimiento mov;
    
    private List<Movimiento> movimientosAlmacenados = new ArrayList<>();
    
    public Xbox(MovLibreArt movLib1, XboxController xbox, AcomodarFichas acomodarFichas) {
        this.xbox = xbox;
        this.xbox.addXboxControllerListener(this);
        this.movLib1 = movLib1;
        
        accion = new ArrayList();
        this.acomodarFichas = acomodarFichas;
        
        matriz = acomodarFichas.getMatriz();
        mov = new Movimiento();
    }
    

    @Override
    public void buttonA(boolean bln) {
        mov.setThetha(- acomodarFichas.getMover().getPosA1());
        mov.setR(acomodarFichas.getMover().getPosA2());
        mov.setAlfa(acomodarFichas.getMover().getPosA3());
        System.out.println(mov);
        matriz.setMovement(mov);
        matriz.matrizTraslacion();
        double [][] t1 = matriz.getT1();
        double [][] t2 = matriz.getT2();
        double [][] t3 = matriz.getT3();
        double [][] t4 = matriz.getT();
        String s1;
        String s2;
        String s3;
        String s4;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                s1 = String.valueOf(t1[y][x]);
                s2 = String.valueOf(t2[y][x]);
                s3 = String.valueOf(t3[y][x]);
                s4 = String.valueOf(t4[y][x]);
//                System.out.println("("+x+","+y+") = "+s1);
//                System.out.println("("+x+","+y+") = "+s2);
//                System.out.println("("+x+","+y+") = "+s3);
//                System.out.println("("+x+","+y+") = "+s4);
                    
            }
        }
        
        boolean bandera = false;
        
        for(Movimiento m: movimientosAlmacenados)
            if(m.getThetha() == mov.getThetha() && m.getAlfa() == mov.getAlfa() && m.getR() == mov.getR()){
                bandera = true;
                break;
            }    
        
        if(!bandera){
            movimientosAlmacenados.add(new Movimiento(mov.getThetha(),mov.getAlfa(),mov.getR()));
        
            try(FileOutputStream fos = new FileOutputStream("src/movimientos/archivo.obj")){
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(movimientosAlmacenados);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        
        
    }

    @Override
    public void buttonB(boolean bln) {
        acomodarFichas.getMover().finCarrera();
    }

    @Override
    public void buttonX(boolean bln) {
        acomodarFichas.getMover().home();
    }

    @Override
    public void buttonY(boolean bln) {
    }

    @Override
    public void back(boolean bln) {
    }

    @Override
    public void start(boolean bln) {
    }

    @Override
    public void leftShoulder(boolean bln) {
        if(bln && !flag2)
        {
            flag1 = true;
            movLib1.moverArt1(8);
        }
        else
        {
            flag1 = false;
            movLib1.stopArt2();
        }
    }

    @Override
    public void rightShoulder(boolean bln) {
        if(bln && !flag1)
        {
            flag2 = true;
            movLib1.moverArt1(9);
        }
        else
        {
            flag2 = false;
            movLib1.stopArt2();
        }
    }

    @Override
    public void leftThumb(boolean bln) {

    }

    @Override
    public void rightThumb(boolean bln) {

    }

    @Override
    public void dpad(int i, boolean bln) {
        if(bln)
        {
            movLib1.moverArt1(i);
            
        }
        else
        {
            switch(i)
            {
                case 0:
                    movLib1.stopArt3();
                    break;
                case 1:
                    movLib1.stopArt3();
                case 2:
                    movLib1.stopArt1();
                    break;
                case 3:
                    movLib1.stopArt1();
                case 4:
                    movLib1.stopArt3();
                    break;
                case 5:
                    movLib1.stopArt3();
                case 6:
                    movLib1.stopArt1();
                    break;
                case 7:
                    movLib1.stopArt3();
                    movLib1.stopArt1();
                    break;
            }
            movLib1.stopArt1();
            
        }
    }

    @Override
    public void leftTrigger(double d) {
    }

    @Override
    public void rightTrigger(double d) {
    }

    @Override
    public void leftThumbMagnitude(double d) {

    }

    @Override
    public void leftThumbDirection(double d) {

    }

    @Override
    public void rightThumbMagnitude(double d) {

    }

    @Override
    public void rightThumbDirection(double d) {

    }

    @Override
    public void isConnected(boolean bln) {

    }
       
}
