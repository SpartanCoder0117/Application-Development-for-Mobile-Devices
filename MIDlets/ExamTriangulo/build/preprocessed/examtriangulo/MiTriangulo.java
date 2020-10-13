/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examtriangulo;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author inkis
 */
public class MiTriangulo extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    Command salir;
    Command siguiente;
    Command regresar;
    Display d;
    Form f;
    Form f2;
    Lienzo l;
    TextField textField;
    TextField textField1;
    TextField textField2;
    TextField textField3;
    TextField textField4;
    TextField textField5;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The MiTriangulo constructor.
     */
    public MiTriangulo() {
        //Items
        textField = new TextField("Ax", null, 32, TextField.ANY); 
        textField1 = new TextField("Ay", null, 32, TextField.ANY);
        textField2 = new TextField("Bx", null, 32, TextField.ANY);
        textField3 = new TextField("By", null, 32, TextField.ANY);
        textField4 = new TextField("Cx", null, 32, TextField.ANY);
        textField5 = new TextField("Cy", null, 32, TextField.ANY);
        //Display
        d = Display.getDisplay(this);
        //Comandos
        salir = new Command("Salir", Command.EXIT, 2);
        siguiente = new Command("Siguiente", Command.OK, 0);
        regresar = new Command("Regresar", Command.BACK, 0);
        //Form
        f = new Form("Triangulo");
        f.addCommand(salir);
        f.addCommand(siguiente);
        f.setCommandListener(this);  
        //Agrega Items al form
        f.append(textField);
        f.append(textField1);
        f.append(textField2);
        f.append(textField3);
        f.append(textField4);
        f.append(textField5);
        //Lienzo
        l = new Lienzo();
        l.addCommand(salir);
        l.addCommand(regresar);
        l.setCommandListener(this);        
        
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    public void commandAction(Command co, Displayable di){
        if(co == salir){
            destroyApp(false);
            notifyDestroyed();
        }else if(co == siguiente){
            d.setCurrent(l);
        }else if(co == regresar){
            d.setCurrent(f);
        }
            
    }
    
    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() throws MIDletStateChangeException {
        d.setCurrent(f);
        /*if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;*/
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
    class Lienzo extends Canvas {
        public void paint(Graphics g) {
            int x1, y1, x2, y2, x3, y3;
            int Ax, Ay, Bx, By, Cx, Cy;
            int area1, area2, area3, areat;
            double A;
            double B = 0.5;
            x1 = Integer.parseInt(textField.getString());
            y1 = Integer.parseInt(textField1.getString());
            x2 = Integer.parseInt(textField2.getString());
            y2 = Integer.parseInt(textField3.getString());
            x3 = Integer.parseInt(textField4.getString());
            y3 = Integer.parseInt(textField5.getString());
             
            area1 = x1 * ((y2 * 1) - (y3 * 1));
            area2 = y1 * ((x2 * 1) - (x3 * 1));
            area3 = 1 * ((x2 * y3) - (x3 * y2));
            areat = area1 - area2 + area3;
            A = B * areat;
            
            
            //Fondo Negro
            System.out.println("Ancho " + getWidth());
            System.out.println("Alto " + getHeight());
            g.setColor(0,0,0);
            g.fillRect(0, 0, getWidth(), getHeight());
            //Ejes
            g.setColor(0,0,255);
            g.drawRect(0, 0, 240, 240);
            g.drawLine(120, 0, 120, 240);      
            g.drawLine(0, 120, 240, 120);
            //Texto Area
            g.setColor(255,255,255);
            g.drawString("El area es: " + A, 0, 260, Graphics.BOTTOM | Graphics.LEFT);
            //Texto puntos
            g.setColor(0,255,0);
            g.drawString("Ax: " + x1, 110, 260, Graphics.BOTTOM | Graphics.LEFT);
            g.drawString("Ay: " + y1, 160, 260, Graphics.BOTTOM | Graphics.LEFT);
            g.setColor(255,255,0);
            g.drawString("Bx: " + x2, 110, 275, Graphics.BOTTOM | Graphics.LEFT);
            g.drawString("By: " + y2, 160, 275, Graphics.BOTTOM | Graphics.LEFT);
            g.setColor(255,0,0);
            g.drawString("Cx: " + x3, 110, 290, Graphics.BOTTOM | Graphics.LEFT);
            g.drawString("Cy: " + y3, 160, 290, Graphics.BOTTOM | Graphics.LEFT);
            //Puntos
            Ax = x1*10 + 120;
            Ay = y1*-10 + 120;
            Bx = x2*10 + 120;
            By = y2*-10 + 120;
            Cx = x3*10 + 120;
            Cy = y3*-10 + 120;
            g.setColor(0,255,0);
            g.drawLine(Ax, Ay, Bx, By);
            g.setColor(255,255,0);
            g.drawLine(Bx, By, Cx, Cy);
            g.setColor(255,0,0);
            g.drawLine(Cx, Cy, Ax, Ay);            
        }
    }
    
}
