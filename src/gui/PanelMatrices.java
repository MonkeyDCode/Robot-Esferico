
package gui;

import control.AcomodarFichas;
import control.Mover2;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modelo.MatrizDenavit;
import modelo.Movimiento;

/**
 *
 * @author Enrique, Jorge, Grecia y Mario
 */
public class PanelMatrices extends JPanel implements Runnable{
    
    private JTable tabla1;
    private JTable tabla2;
    private JTable tabla3;
    private JTable tabla4;
    private JTable tablacoor;
    
    private final MatrizDenavit matriz;
    private final Movimiento mov;
    private final AcomodarFichas acomodarFichas;
    
    
    
    private Thread t;
    
    public PanelMatrices(AcomodarFichas acomodarFichas){
        
        this.acomodarFichas = acomodarFichas;
        matriz = acomodarFichas.getMatriz();
        mov = new Movimiento();
        
        //-------------Le damos medidas al panel----------------------------------------------------
        this.setPreferredSize(new Dimension(850,700));     
        
        GridLayout grid = new GridLayout(3,2);
        this.setLayout(grid);
        
        
        String[] encabezado = new String[]{".",".",".","."};
        String[][] datos    = new String[][]{{"e","f","g","h"}
                                            ,{"i","j","k","l"}
                                            ,{"m","n","o","p"}
                                            ,{"q","r","s","t"}};
        
        tabla1 = new JTable(datos,encabezado);
        JScrollPane panel = new JScrollPane(tabla1);
        
        this.add(panel);
        tabla2 = new JTable(datos,encabezado);
        panel = new JScrollPane(tabla2);
        this.add(panel);
        tabla3 = new JTable(datos,encabezado);
        panel = new JScrollPane(tabla3);
        this.add(panel);
        tabla4 = new JTable(datos,encabezado);
        panel = new JScrollPane(tabla4);
        this.add(panel);
        
        String[] coordenadas= new String[]{"X","Y","Z"};
        String[][] puntos = new String[][]{{null,null,null}};
        tablacoor=new JTable(puntos,coordenadas);
        panel = new JScrollPane(tablacoor);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        
        while(acomodarFichas.finish || PanelAprendizaje.banderaControl)
        {
            mov.setThetha(- acomodarFichas.getMover().getPosA1());
            mov.setR(acomodarFichas.getMover().getPosA2());
            mov.setAlfa(acomodarFichas.getMover().getPosA3());
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
                    s1 = String.format("%.3f",t1[y][x]);
                    s2 = String.format("%.3f",t2[y][x]);
                    s3 = String.format("%.3f",t3[y][x]);
                    s4 = String.format("%.3f",t4[y][x]);
                    tabla1.getModel().setValueAt(s1, y, x);
                    tabla2.getModel().setValueAt(s2, y, x);
                    tabla3.getModel().setValueAt(s3, y, x);
                    tabla4.getModel().setValueAt(s4, y, x);;
                    
                }
            }

            tablacoor.setValueAt(String.format("%.3f",matriz.getCoordenada().getX()),0 , 0);
            tablacoor.setValueAt(String.format("%.3f",matriz.getCoordenada().getY()),0 , 1);
            tablacoor.setValueAt(String.format("%.3f",matriz.getCoordenada().getZ()),0 , 2);
            
        }
        JOptionPane.showMessageDialog(this, "Terminó");
        
    }
    
    public void empezar()
    {
        t = new Thread(this);
        t.start();
    }
    
}
