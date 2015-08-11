package gui;
import control.AcomodarFichas;
import java.awt.Color;
import java.awt.Graphics;

public class lienzo extends javax.swing.JPanel implements Runnable{
    int x=70;
    int y=370;
  private final AcomodarFichas acomodarFichas;
          
    Thread hilo;
    public lienzo(AcomodarFichas acomodarFichas) {
        initComponents();
        this.acomodarFichas = acomodarFichas;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.fillOval(x-8, y-8, 16, 16);
        g.setColor(Color.BLACK);
        g.drawLine(200, 370, x, y);
        pintaCuadricula(g);
        
    }

    public void inicio(){
        hilo = new Thread(this);
        hilo.start();
    }

    public void pausa(){
        hilo.suspend();
    }

    public void continuar(){
        hilo.resume();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        try {
            
            while(acomodarFichas.finish || PanelAprendizaje.banderaControl)
            {
                
                //acomodarFichas.getMatriz().getCoordenada();
                x=(int)(200+(Double.valueOf(acomodarFichas.getMatriz().getCoordenada().getX())*4.3));
                y=(int)(370-(Double.valueOf(acomodarFichas.getMatriz().getCoordenada().getY())*4.3));
                //System.out.println(x+" , "+y);
                repaint();
            }
        } catch (Exception e) {
            //System.out.println("sucedio un error"+e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void pintaCuadricula(Graphics g) {
        g.setColor(Color.BLUE);
        //para dibujar los ejes
        g.drawLine(200, 0, 200, 400);
        g.drawLine(0, 370, 400, 370);   
    }

}
