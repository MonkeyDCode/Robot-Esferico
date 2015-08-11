
package gui;

import control.AcomodarFichas;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import modelo.Accion;

/**
 *
 * @author Enrique, Jorge, Grecia y Mario
 */
public class Ventana extends JFrame implements ActionListener{
    
    //-------- Aqui se almacenan en que coordenada se encuentran las fichas
    public static String[][] posicionFichas;
    
    // ------- Variable para identificar el color que va a colocar-------
    public static String colorFicha = "Negro";
    
    //-------- Mapa que contiene cuantas fichas faltan de cada color-------
    public static Map<String,Integer> numeroFichas;
    
    //-------- Panel que contiene el tablero de las coordenadas para colocar las fichas-------
    private PanelFichas      panelFichas;
    //-------- Panel que contiene las Matrices-------
    private PanelMatrices    panelMatrices;
    //-------- Panel que contiene la Simulacion-------
    private PanelSimulacion  panelSimulacion;
    //-------- Panel que contiene el Aprendizaje con el control y play y pause-------
    private PanelAprendizaje panelAprendizaje;
    
    private final ArrayList<Accion> accion;
    
    private static JMenu menu;
    
    private final AcomodarFichas acomodarFichas;
    
    private int count;
    
    public Ventana(AcomodarFichas acomodarFichas){
        
        accion = new ArrayList();
        this.acomodarFichas = acomodarFichas;
        //Inicializamos las coordenadas de las fichas
        posicionFichas = new String[10][14];
        
        //Inicializamos el mapa de numero de fichas
        numeroFichas = new HashMap<String,Integer>();
        inicializaNumeroFichas();
        
        inicializaComponentes();
        
        this.setTitle("Robot Esferico");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    public void inicializaNumeroFichas(){
        numeroFichas.put("Negro", 5);
        numeroFichas.put("Blanco", 5);
        numeroFichas.put("Rojo", 5);
        numeroFichas.put("Verde", 5);
        numeroFichas.put("Azul", 5);
    }
    
    public static void inicializaMenu(){
        menu.getItem(0).setText(String.format("Negro (Quedan %d)", numeroFichas.get("Negro")));
        menu.getItem(1).setText(String.format("Blanco (Quedan %d)", numeroFichas.get("Blanco")));
        menu.getItem(2).setText(String.format("Rojo (Quedan %d)", numeroFichas.get("Rojo")));
        menu.getItem(3).setText(String.format("Verde (Quedan %d)", numeroFichas.get("Verde")));
        menu.getItem(4).setText(String.format("Azul (Quedan %d)", numeroFichas.get("Azul")));
    }
    
    public void inicializaComponentes(){
        //----------- Creacion de los paneles--------------------
        panelFichas      = new PanelFichas();
        panelMatrices    = new PanelMatrices(acomodarFichas);
        panelSimulacion  = new PanelSimulacion(acomodarFichas);
        panelAprendizaje = new PanelAprendizaje(acomodarFichas);
        
        //------------Creacion de barra de menu-----------------------
        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        
        //------------Creacion del menu y submenu---------------------
        menu = new JMenu("Home");
        
        JMenuItem subMenu = new JMenuItem("Nuevo Tablero");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Coloca Fichas");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Ver Fichas");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Ver Matrices");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Ver Simulacion");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Ver Modo de Aprendizaje");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Pausa");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Continuar");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Paro");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        
	barraMenu.add(menu);
        
        menu = new JMenu("Ficha");
	
        /*  Home, play, pause, coordendas actuales del robot, animacion (3d o dos vistas en 2d) */
        subMenu = new JMenuItem(String.format("Negro (Quedan %d)", numeroFichas.get("Negro")));
        subMenu.setActionCommand("Negro");
        subMenu.addActionListener(this);
        panelFichas.submenuSeleccionado = subMenu;
        menu.add(subMenu);
        subMenu = new JMenuItem(String.format("Blanco (Quedan %d)", numeroFichas.get("Blanco")));
        subMenu.setActionCommand("Blanco");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem(String.format("Rojo (Quedan %d)", numeroFichas.get("Rojo")));
        subMenu.setActionCommand("Rojo");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem(String.format("Verde (Quedan %d)", numeroFichas.get("Verde")));
        subMenu.setActionCommand("Verde");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem(String.format("Azul (Quedan %d)", numeroFichas.get("Azul")));
        subMenu.setActionCommand("Azul");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        subMenu = new JMenuItem("Quitar Ficha");
        subMenu.addActionListener(this);
        menu.add(subMenu);
        
	barraMenu.add(menu);
        
        //------Agregamos el Panel de Fichas--------
        this.setLayout(new BorderLayout());
	this.add(panelFichas,BorderLayout.CENTER); 
    }

    //------Listener al seleccionar una de las opciones del submenu-----
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        
        switch(opcion)
        {
            case "Nuevo Tablero":
                inicializaNumeroFichas();
                inicializaMenu();
                panelFichas.inicializaTablero();
                break;
            
            case "Coloca Fichas":
                accion.clear();
                for(int x=0;x<10;x++)
                {
                    for(int y=0;y<14;y++)
                    {
                        if(!posicionFichas[x][y].equals("Nada"))
                        {
                            System.out.println("posicion "+x+", "+y+" Color : "+posicionFichas[x][y]);
                            accion.add(new Accion(posicionFichas[x][y], x, y));
                        }
                    }
                }
                acomodarFichas.acomodar(accion);
                panelMatrices.empezar();
                panelSimulacion.getXY().inicio();
                panelSimulacion.getYZ().inicio();
                break;
            
            
            case "Ver Fichas":
                panelFichas.setVisible(true);
                panelMatrices.setVisible(false);
                panelSimulacion.setVisible(false);
                panelAprendizaje.setVisible(false);
                this.add(panelFichas,BorderLayout.CENTER); 
                break;
            
            case  "Ver Matrices":
                panelFichas.setVisible(false);
                panelMatrices.setVisible(true);
                panelSimulacion.setVisible(false);
                panelAprendizaje.setVisible(false);
                this.add(panelMatrices,BorderLayout.CENTER); 
                break;
            
            case "Ver Simulacion":
                panelFichas.setVisible(false);
                panelMatrices.setVisible(false);
                panelSimulacion.setVisible(true);
                panelAprendizaje.setVisible(false);
                this.add(panelSimulacion,BorderLayout.CENTER); 
                break;
            
            case "Ver Modo de Aprendizaje":
                panelFichas.setVisible(false);
                panelMatrices.setVisible(false);
                panelSimulacion.setVisible(false);
                panelAprendizaje.setVisible(true);
                this.add(panelAprendizaje,BorderLayout.CENTER); 
                break;
            
            case "Rojo": 
                colorFicha = "Rojo";
                panelFichas.submenuSeleccionado = (JMenuItem)e.getSource();
                break;
            
            case "Verde":
                colorFicha = "Verde";
                panelFichas.submenuSeleccionado = (JMenuItem)e.getSource();
                break;
            
            case "Azul":
                colorFicha = "Azul";
                panelFichas.submenuSeleccionado = (JMenuItem)e.getSource();
                break;
            
            case "Negro":
                colorFicha = "Negro";
                panelFichas.submenuSeleccionado = (JMenuItem)e.getSource();
                break;
            
            case "Blanco":
                colorFicha = "Blanco";
                panelFichas.submenuSeleccionado = (JMenuItem)e.getSource();
                break;
            
            case "Quitar Ficha":
                panelFichas.submenuSeleccionado = (JMenuItem)e.getSource();
                break;
            case "Pausa":
                acomodarFichas.getMover().pause();
                break;
            case "Continuar":
                count = 0;
                acomodarFichas.getMover().continuar();
                break;
            case "Paro":
                count++;
                if(count%2==0)
                {
                    acomodarFichas.getMover().continuar();
                    acomodarFichas.getMover().home();
                }
                else
                {
                    acomodarFichas.getMover().stop();
                }
                break;
            
        }
    }

    public PanelMatrices getPanelMatrices() {
        return panelMatrices;
    }

    public void setPanelMatrices(PanelMatrices panelMatrices) {
        this.panelMatrices = panelMatrices;
    }

    public PanelSimulacion getPanelSimulacion() {
        return panelSimulacion;
    }

    public void setPanelSimulacion(PanelSimulacion panelSimulacion) {
        this.panelSimulacion = panelSimulacion;
    }
    
    
    
}
