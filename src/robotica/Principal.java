
package robotica;

import control.AcomodarFichas;
import control.Mover2;
import ftcomputing.roboTX.FishFaceTX;
import modelo.MatrizDenavit;
import gui.Ventana;
import modelo.Movimiento;
import static util.Movements.MOVIMIENTOS;


/**
 *
 * @author Enrique, Jorge, Grecia y Mario
 */
public class Principal {
    
    private static Ventana ventana;
    

    public static void main(String[] args) throws InterruptedException {
        
        
        FishFaceTX fx = new FishFaceTX();
        fx.openController("COM10");  
        Mover2 mov = new Mover2(fx);
        MatrizDenavit mat = new MatrizDenavit();
        AcomodarFichas fichas = new AcomodarFichas(mov, mat);
        
        mov.home();
//        
//        XboxController xbox = new XboxController();
//        
//        MovLibreArt movLib1 = new MovLibreArt(mov);     
       ventana = new Ventana(fichas);
        //Xbox x = new Xbox(movLib1,xbox,fichas);
//       
//        
//        
//   
//        
       
     //para realizar ovimiento (calibrar)   
 /*      mov.openPinza();
        mov.home();
        
        Movimiento m = new Movimiento();
        mov.mover1(MOVIMIENTOS[7][2]);
        mov.closePinza();
        m.setThetha(-mov.getPosA1());

      m.setAlfa(mov.getPosA3());
        m.setR(mov.getPosA2());
        System.out.println(m);
        mat.setMovement(m);
        mat.matrizTraslacion();
        fx.closeController();*/
        
//        fx.clearCounter(Constantes.COUNT_ART2);
//        fx.speedMotor(Constantes.ART2, Dir.Left, 500);
//        Thread.sleep(1000);
//        fx.setMotor(Constantes.ART2, Dir.Off);
//        System.out.println(fx.getCounter(Constantes.COUNT_ART2));
//        
//        fx.clearCounter(Constantes.COUNT_ART2);
//        fx.speedMotor(Constantes.ART2, Dir.Right, 500);
//        Thread.sleep(1000);
//        fx.setMotor(Constantes.ART2, Dir.Off);
//        System.out.println(fx.getCounter(Constantes.COUNT_ART2));

    }

    public static Ventana getVentana() {
        return ventana;
    }

    public static void setVentana(Ventana ventana) {
        Principal.ventana = ventana;
    }
    
    
}
