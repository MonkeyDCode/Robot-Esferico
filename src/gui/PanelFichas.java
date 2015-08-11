
package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Enrique, Jorge, Grecia y Mario
 */
public class PanelFichas extends JPanel implements ActionListener{
    
    public JMenuItem submenuSeleccionado;
    
    //Los botones serviran para representar una coordenada en el plano cartesiano de dos dimensiones
    public JButton botones[][];
    
    public PanelFichas(){
        //-------------Le damos medidas al panel----------------------------------------------------
        this.setPreferredSize(new Dimension(850,700));
        
        //-------------Creamos elArray de botones para las coordenadas del plano cartesiano----------
        botones = new JButton[10][14];
        
        //-------------Creacion del GridLayout para ponerlos en el grid los botones--------
        GridLayout grid = new GridLayout(10,14);
        this.setLayout(grid);
        
        //-------------Aqui se colocan los botones en el grid -------------------------------
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 14 ; y++){
                botones[x][y] = new JButton(new ImageIcon("src/imagenes/Nada.png")/*"x:" + x + " y:" + y*/); 
                botones[x][y].addActionListener(this);
                Ventana.posicionFichas[x][y] = "Nada";
                this.add(botones[x][y]);
                System.out.println("x: " + x + "y: " + y + " " +"Nada");
            }
        }
        
        this.setVisible(true);
    }

    //-------Listener al dar click en alguno de los botones------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        
        //----- Este if es cuando se va a quitar una ficha
        if(submenuSeleccionado.getText().equals("Quitar Ficha")){
            if(!button.getIcon().toString().contains("Nada")){
                String color = null;
                if(button.getIcon().toString().contains("Negro"))
                    color = "Negro";
                if(button.getIcon().toString().contains("Blanco"))
                    color = "Blanco";
                if(button.getIcon().toString().contains("Rojo"))
                    color = "Rojo";
                if(button.getIcon().toString().contains("Azul"))
                    color = "Azul";
                if(button.getIcon().toString().contains("Verde"))
                    color = "Verde";
                
                Ventana.numeroFichas.put(color, Ventana.numeroFichas.get(color) + 1);
                Ventana.inicializaMenu();
                button.setIcon(new ImageIcon("src/imagenes/Nada.png"));
                
                // for para asignar el color de la ficha en posicionFichas
                for(int x = 0; x < 10; x++){
                    for(int y = 0; y < 14 ; y++){
                        if(botones[x][y].equals(button)){
                            Ventana.posicionFichas[x][y] = "Nada";
                            System.out.println("x: " + x + "y: " + y + " " +"Nada");
                        }
                    }
                }
            }
        }
        //----- Este else es cuando va a colocar una ficha
        else{
            if(Ventana.numeroFichas.get(Ventana.colorFicha) > 0){
                if(button.getIcon().toString().contains("Nada")){
                    button.setIcon(new ImageIcon("src/imagenes/" + Ventana.colorFicha + ".png"));

                    Ventana.numeroFichas.put(Ventana.colorFicha, Ventana.numeroFichas.get(Ventana.colorFicha) - 1);
                    String texto = String.format("%s (Quedan %d)", Ventana.colorFicha, Ventana.numeroFichas.get(Ventana.colorFicha) ) ;
                    submenuSeleccionado.setText(texto);
                    
                    // for para asignar el color de la ficha en posicionFichas
                    for(int x = 0; x < 10; x++){
                        for(int y = 0; y < 14 ; y++){
                            if(botones[x][y].equals(button)){
                                Ventana.posicionFichas[x][y] = Ventana.colorFicha;
                                System.out.println("x: " + x + "y: " + y + " " +Ventana.colorFicha);
                            }
                        }
                    }
                }
            }
            else {
                /* Poner Option Pane que se acabaron las fichas de ese color */
                JOptionPane.showMessageDialog(null, "Se acabaron las fichas de color " + Ventana.colorFicha + ", elige otro color en el menu de Fichas.");
            }
        }
        
    }
    
    public void inicializaTablero(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 14 ; y++){
                botones[x][y].setIcon(new ImageIcon("src/imagenes/Nada.png")/*"x:" + x + " y:" + y*/); 
                Ventana.posicionFichas[x][y] = "Nada";
                System.out.println("x: " + x + "y: " + y + " " +"Nada");
            }
        }
    }

}
