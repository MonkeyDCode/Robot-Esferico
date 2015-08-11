/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ch.aplu.xboxcontroller.XboxController;
import control.AcomodarFichas;
import control.MovLibreArt;
import controlXbox.Xbox;
//import static gui.PanelAprendizaje.banderaControl;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelo.MatrizDenavit;
import modelo.Movimiento;
import robotica.Principal;

/**
 *
 * @author MarioAlberto
 */
public class PanelAprendizaje extends javax.swing.JPanel {

    private XboxController xbox;
    private final MovLibreArt movLib1;
    private final AcomodarFichas acomodarFichas;
    private Xbox x;
    private AcomodarFichas acomodar;
    public static boolean banderaControl = false;
    private static final String[] model ={"Posición","Theta","Alfa","R","x","y","z"};
    private static final Object[] row={null,null,null,null,null,null,null};
    private DefaultTableModel tablaModel = new DefaultTableModel(model,0 );
    private MatrizDenavit matriz= new MatrizDenavit();

    
    public PanelAprendizaje(AcomodarFichas acomodarFichas) {
        initComponents();
        this.acomodarFichas = acomodarFichas;
        xbox = new XboxController();
        movLib1 = new MovLibreArt(acomodarFichas.getMover());
        this.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        buttonPause = new javax.swing.JButton();
        buttonCharge = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Panel Aprendizaje");

        buttonStart.setText("Comenzar Aprendizaje");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonPause.setText("Pausar Aprendizaje");
        buttonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPauseActionPerformed(evt);
            }
        });

        buttonCharge.setText("Recuperar Posiciones");
        buttonCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChargeActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Posicion", "Theta", "Alpha", "R", "X", "Y", "Z"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonStart)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(buttonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(buttonCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        
        banderaControl = true;
        Principal.getVentana().getPanelMatrices().empezar();
        Principal.getVentana().getPanelSimulacion().getXY().inicio();
        Principal.getVentana().getPanelSimulacion().getYZ().inicio();

        xbox = new XboxController();
        x = new Xbox(movLib1,xbox,acomodarFichas);
        
        
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPauseActionPerformed
        banderaControl = false;
        xbox.release();
    }//GEN-LAST:event_buttonPauseActionPerformed

    private void buttonChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChargeActionPerformed
        banderaControl = true;
        Principal.getVentana().getPanelMatrices().empezar();
        Principal.getVentana().getPanelSimulacion().getXY().inicio();
        Principal.getVentana().getPanelSimulacion().getYZ().inicio();

        try(FileInputStream fis = new FileInputStream("src/movimientos/archivo.obj")){
            ObjectInputStream in = new ObjectInputStream(fis);
            List<Movimiento> movimientosAlmacenados = (List<Movimiento>)in.readObject(); 
            tablaModel=new DefaultTableModel(model, 0);
            tabla.setModel(tablaModel);
            int i =0;
            
            for(Movimiento m: movimientosAlmacenados){
                tablaModel.addRow(row);
                matriz.setMovement(m);
                matriz.matrizTraslacion();
                tabla.setValueAt(i,i , 0); 
                tabla.setValueAt(String.format("%.3f",m.getThetha()),i , 1);
                tabla.setValueAt(String.format("%.3f",m.getAlfa()),i , 2);
                tabla.setValueAt(String.format("%.3f",m.getR()),i , 3);
                tabla.setValueAt(String.format("%.3f",matriz.getCoordenada().getX()),i , 4);
                tabla.setValueAt(String.format("%.3f",matriz.getCoordenada().getY()),i , 5);
                tabla.setValueAt(String.format("%.3f",matriz.getCoordenada().getZ()),i , 6);
                i++;
                //System.out.println(m);
            }
            acomodarFichas.acomodar(movimientosAlmacenados);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_buttonChargeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCharge;
    private javax.swing.JButton buttonPause;
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

