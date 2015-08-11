package gui;
import control.AcomodarFichas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author Enrique, Jorge, Grecia y Mario
 */
public class PanelSimulacion extends JPanel{
    
    private lienzo simulacionEjeXY;
    private lienzo1 simulacionEjeYZ;
    
    public PanelSimulacion(AcomodarFichas acomodarFichas){
        //-------------Le damos medidas al panel----------------------------------------------------
        this.setPreferredSize(new Dimension(850,700)); 
        
        GridLayout grid = new GridLayout(1,2);
        this.setLayout(grid);
        
        simulacionEjeXY = new lienzo(acomodarFichas);
        simulacionEjeYZ = new lienzo1(acomodarFichas);
        //simulacionEjeXY.dibujaEjesXY();
        //simulacionEjeYZ = new JavaDraw2DPanel();
        
        this.add(simulacionEjeXY);
        this.add(simulacionEjeYZ);
        
        this.setVisible(true);
       
    }
    public lienzo getXY()
    {
        return simulacionEjeXY;
    }
    public lienzo1 getYZ()
    {
        return simulacionEjeYZ;
    }

    public lienzo getSimulacionEjeXY() {
        return simulacionEjeXY;
    }

    public void setSimulacionEjeXY(lienzo simulacionEjeXY) {
        this.simulacionEjeXY = simulacionEjeXY;
    }

    public lienzo1 getSimulacionEjeYZ() {
        return simulacionEjeYZ;
    }

    public void setSimulacionEjeYZ(lienzo1 simulacionEjeYZ) {
        this.simulacionEjeYZ = simulacionEjeYZ;
    }
    
    
}