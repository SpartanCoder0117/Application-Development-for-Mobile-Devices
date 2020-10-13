/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubo3d;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author inkis
 */
public class MiPrisma extends MIDlet implements CommandListener{
    
    private boolean midletPaused = false;
    private Display d;
    Canvas ca;
    private Command cs;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The MiPrisma constructor.
     */
    public MiPrisma() {
        d = Display.getDisplay(this); 
        ca = new Canvas(){
            int centerX, centerY, maxX, maxY, minMaxXY;
            Obj5 obj = new Obj5();
            int x=0, y=0;
            public void paint(Graphics g){             
                g.setColor(0,0,0);//Color fondo
                g.fillRect(0, 0, getWidth(), getHeight());
                maxX = getWidth()-1; maxY = getHeight()-1; minMaxXY=Math.min(maxX, maxY);
                centerX = maxX/2;
                centerY = maxY/2;
                obj.d = obj.rho*minMaxXY/obj.objSize;
                obj.eyeAndScreen();
                //Aristas horizontales inferiores
                line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 4);
                line(g, 4, 5); line(g, 5, 0); 
                //Aristas horizontales superiores
                line(g, 6, 7); line(g, 7, 8); line(g, 8, 9); line(g, 9, 10); 
                line(g, 10, 11); line(g, 11, 6); 
                //Aristas verticales
                line(g, 6, 0); line(g, 7, 1); line(g, 8, 2); line(g, 9, 3); 
                line(g, 10, 4); line(g, 11, 5);
            }
            void line(Graphics g, int i, int j){
                Point2D5 p = obj.vScr[i], q = obj.vScr[j];
                g.setColor(0,255,0);//Color cubo
                g.drawLine(centerX+(int)p.x ,centerY-(int)p.y, centerX+(int)q.x, centerY-(int)q.y);
            }
            
            public void keyPressed(int keyCode){
            switch (getGameAction(keyCode)) {
                case Canvas.DOWN: {
                    y = y + 1;
                    break;
                }
                case Canvas.LEFT: {
                    x = x - 1;
                    break;
                }
                case Canvas.UP: {
                    y = y - 1;
                    break;
                }
                case Canvas.RIGHT: {
                    x = x + 1;
                    break;
                }
                default:
                    x=x;
                    y=y;
            }
            obj.theta   = (float) getWidth()/x;
            obj.phi     = (float) getHeight()/y;
            obj.rho     = (obj.phi/obj.theta)*getHeight();
            centerX     = x;
            centerY     = y;
            repaint();
        }
        };
        cs = new Command("Salir",Command.EXIT, 3);
        ca.addCommand(cs);
        ca.setCommandListener(this); 
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
 public void commandAction(Command command, Displayable displayable) {                                               
        // write pre-action user code here
        if (command == cs) {
                destroyApp(true);
                notifyDestroyed();
        } else d.setCurrent(new Alert("", "Otro comando digitado...", null, AlertType.ERROR));
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
    public void startApp() {
        d.setCurrent(ca);
       /* if (midletPaused) {
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
        //midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
}

class Obj5{	// Posee los datos del objeto 3D
    float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D5 [] w;	// coordenadas universales
    Point2D5 [] vScr; // coordenadas de la pantalla
    Obj5(){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        w	= new Point3D5[12];
	vScr	= new Point2D5[12];
        
        //Piramide
        w[0] = new Point3D5(0, -1, -1); //Punto A
	w[1] = new Point3D5(-1, -0.5, -1);
	w[2] = new Point3D5(-1, 0.5, -1);
	w[3] = new Point3D5(0, 1, -1); //Punto B
	w[4] = new Point3D5(1, 0.5, -1);
	w[5] = new Point3D5(1, -0.5, -1);
        
	w[6] = new Point3D5(0, -1, 1); //Punto C
	w[7] = new Point3D5(-1, -0.5, 1);
        w[8] = new Point3D5(-1, 0.5, 1);
	w[9] = new Point3D5(0, 1, 1); //Punto D
        w[10] = new Point3D5(1, 0.5, 1);
	w[11] = new Point3D5(1, -0.5, 1);
        
	objSize = (float) Math.sqrt(12F); // = sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
	rho	= 5*objSize;		// para cambiar la perspectiva
    }
    void initPersp(){
        float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
	v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
	v21 = costh; v22 = -cosph*sinth; v23 = sinph*sinth;
	v32 = sinph; v33 = cosph; v43 = -rho;
    }
    void eyeAndScreen(){
        initPersp();
	for(int i=0; i<12; i++){
            Point3D5 p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D5(-d*x/z, -d*y/z);
	}
    }
}

class Point2D5{
    float x, y;
    Point2D5(float x, float y){
    	this.x = x;
        this.y = y;
    }
}

class Point3D5{
    float x, y, z;
    Point3D5(double x, double y, double z){
        this.x = (float) x;
	this.y = (float) y;
	this.z = (float) z;
    }
}