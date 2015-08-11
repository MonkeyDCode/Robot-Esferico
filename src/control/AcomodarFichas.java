/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.PanelAprendizaje;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Accion;
import modelo.MatrizDenavit;
import modelo.Movimiento;
import util.Movements;

/**
 *
 * @author MarioAlberto
 */
public class AcomodarFichas implements Runnable {
    
    private ArrayList<Accion> accion;
    private List<Movimiento> movimientos;
    private Thread t;
    private final Mover2 mover;
    public boolean finish;
    private final MatrizDenavit matriz;
    
    private boolean recuperarMovimiento = false;

    public AcomodarFichas(Mover2 mover, MatrizDenavit matriz) {
        this.mover = mover;
        this.matriz = matriz;
    }
    
    public void colocaFichas(){
        for (Accion accion1 : accion) {
                try {
                    mover.openPinza();
                    mover.homeArt3();
                    switch(accion1.ficha)
                    {
                        case "Negro":
                            mover.mover1(Movements.BLACK);
                            break;
                        case "Blanco":
                            mover.mover1(Movements.WHITE);
                            break;
                        case "Verde":
                            mover.mover1(Movements.GREEN);
                            break;
                        case "Azul":
                            mover.mover1(Movements.BLUE);
                            break;
                        case "Rojo":
                            mover.mover1(Movements.RED);
                            break;
                        default:
                            // Aqui entra cuando recupera movimientos
                    }
                    mover.closePinza();
                    mover.homeArt3();
                    mover.mover1(Movements.MOVIMIENTOS[accion1.y][accion1.x]);
                    mover.openPinza();
                } catch (InterruptedException ex) {
                    Logger.getLogger(AcomodarFichas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public void colocaMovimientoAlmacenado(){
        for (Movimiento accion1 : movimientos) {
            try {
                accion1.setThetha(-accion1.getThetha());
                mover.mover1(accion1);
            } catch (InterruptedException ex) {
                Logger.getLogger(AcomodarFichas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() 
    {
        mover.home();
        
        if(recuperarMovimiento){
            colocaMovimientoAlmacenado();
        }
        else{
            colocaFichas();
        }
        
        recuperarMovimiento = false;
        finish = false;
        PanelAprendizaje.banderaControl=false;
        
        mover.home();
    }
    
    public void acomodar(ArrayList<Accion> a)
    {
        finish = true;
        accion = a;
        t = new Thread(this);
        t.start();
    }
    
    public void acomodar(List<Movimiento> m)
    {
        finish = true;
        recuperarMovimiento = true;
        movimientos = m;
        t = new Thread(this);
        t.start();
    }

    public Mover2 getMover() {
        return mover;
    }

    /**
     * @return the matriz
     */
    public MatrizDenavit getMatriz() {
        return matriz;
    }
    
    
    
}
