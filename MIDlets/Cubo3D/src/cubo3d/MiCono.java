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
public class MiCono extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    private Display d;
    Canvas ca;
    private Command cs;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The MiCono constructor.
     */
    public MiCono() {
         d = Display.getDisplay(this); 
        ca = new Canvas(){
            int centerX, centerY, maxX, maxY, minMaxXY;
            Obj3 obj = new Obj3();
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
                line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 8);
                line(g, 8, 9); line(g, 9, 10); line(g, 10, 11); line(g, 11, 12); 
                line(g, 12, 13); line(g, 13, 14); line(g, 14, 15); line(g, 15, 16); 
                line(g, 16, 17); line(g, 17, 18); line(g, 18, 19); line(g, 19, 20); 
                line(g, 20, 21); line(g, 21, 22); line(g, 22, 23); 
                line(g, 23, 24); line(g, 24, 25); line(g, 25, 26);
                line(g, 26, 27); line(g, 27, 28); line(g, 28, 29); line(g, 29, 30);
                line(g, 30, 31); line(g, 31, 32); line(g, 32, 33); line(g, 33, 34); 
                line(g, 34, 35); line(g, 35, 36); line(g, 36, 37); line(g, 37, 38); 
                line(g, 38, 39); line(g, 39, 40); line(g, 40, 41); line(g, 41, 42); 
                line(g, 42, 43); line(g, 43, 0); 
                //Aristas verticales
                line(g, 0, 44); line(g, 1, 44); line(g, 2, 44); line(g, 3, 44);
                line(g, 4, 44); line(g, 5, 44); line(g, 6, 44); line(g, 7, 44);
                line(g, 8, 44); line(g, 9, 44); line(g, 10, 44); line(g, 11, 44); 
                line(g, 12, 44); line(g, 13, 44); line(g, 14, 44); line(g, 15, 44); 
                line(g, 16, 44); line(g, 17, 44); line(g, 18, 44); line(g, 19, 44); 
                line(g, 20, 44); line(g, 21, 44); line(g, 22, 44); 
                line(g, 23, 44); line(g, 24, 44); line(g, 25, 44);
                line(g, 26, 44); line(g, 27, 44); line(g, 28, 44); line(g, 29, 44);
                line(g, 30, 44); line(g, 31, 44); line(g, 32, 44); line(g, 33, 44); 
                line(g, 34, 44); line(g, 35, 44); line(g, 36, 44); line(g, 37, 44); 
                line(g, 38, 44); line(g, 39, 44); line(g, 40, 44); line(g, 41, 44); 
                line(g, 42, 44); line(g, 43, 44);
                //line(g, 0, 14); line(g, 14, 15); line(g, 15, 16); line(g, 16, 1);
                //line(g, 0, 1); line(g, 2, 3); //line(g, 3, 0);// aristas horizontales inferiores
               // line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores
               // line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
                    
                //line(g, 2, 13); line(g, 13, 11); line(g, 11, 12); line(g, 12, 1);
                //g.drawArc(1,-1, 20, 20, 0, 180);
            }
            void line(Graphics g, int i, int j){
                Point2D3 p = obj.vScr[i], q = obj.vScr[j];
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

class Obj3{	// Posee los datos del objeto 3D
    float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D3 [] w;	// coordenadas universales
    Point2D3 [] vScr; // coordenadas de la pantalla
    Obj3(){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        w	= new Point3D3[45];
	vScr	= new Point2D3[45];
        
        //Cubo
        //w[0]	= new Point3D3(1, 0, -1); //Punto A
	/*w[1]	= new Point3D3(0, -1, -1); Punto B
	w[2]	= new Point3D3(-1, 0, -1); C
	w[3]	= new Point3D3(0, 1, -1); D*/ 
        w[0]	= new Point3D3(1, 0, -1); //Punto A
        
        w[1]	= new Point3D3(0.98, -0.2, -1);
        w[2]	= new Point3D3(0.9, -0.42, -1);
	w[3]	= new Point3D3(0.8, -0.6, -1);
	w[4]	= new Point3D3(0.7, -0.7, -1);        
	w[5]	= new Point3D3(0.6, -0.8, -1);
	w[6]	= new Point3D3(0.5, -0.87, -1);
	w[7]	= new Point3D3(0.4, -0.91, -1);
	w[8]	= new Point3D3(0.3, -0.95, -1);       
        w[9]	= new Point3D3(0.2, -0.97, -1);
        w[10]	= new Point3D3(0.1, -1, -1); 
        
	w[11]	= new Point3D3(0, -1, -1); //Punto B
        
	w[12]	= new Point3D3(-0.1, -1, -1);
	w[13]	= new Point3D3(-0.2, -0.97, -1);        
	w[14]	= new Point3D3(-0.3, -0.95, -1);        
	w[15]	= new Point3D3(-0.4, -0.91, -1);
	w[16]	= new Point3D3(-0.5, -0.87, -1);
	w[17]	= new Point3D3(-0.6, -0.8, -1);       
        w[18]	= new Point3D3(-0.7, -0.7, -1);
	w[19]	= new Point3D3(-0.8, -0.6, -1);
	w[20]	= new Point3D3(-0.9, -0.42, -1);        
        w[21]	= new Point3D3(-0.98, -0.2, -1); 
        
	w[22]	= new Point3D3(-1, 0, -1); //Punto C
        
        w[23]	= new Point3D3(-0.98, 0.2, -1);
	w[24]	= new Point3D3(-0.9, 0.42, -1);        
	w[25]	= new Point3D3(-0.8, 0.6, -1);
	w[26]	= new Point3D3(-0.7, 0.7, -1);
	w[27]	= new Point3D3(-0.6, 0.8, -1);
	w[28]	= new Point3D3(-0.5, 0.87, -1);        
        w[29]	= new Point3D3(-0.4, 0.91, -1);
        w[30]	= new Point3D3(-0.3, 0.95, -1);
	w[31]	= new Point3D3(-0.2, 0.97, -1);        
        w[32]	= new Point3D3(-0.1, 1, -1);
        
	w[33]	= new Point3D3(0, 1, -1); //Punto D   
        
	w[34]	= new Point3D3(0.1, 1, -1);
	w[35]	= new Point3D3(0.2, 0.97, -1);
	w[36]	= new Point3D3(0.3, 0.95, -1);
	w[37]	= new Point3D3(0.4, 0.91, -1);        
        w[38]	= new Point3D3(0.5, 0.87, -1);
        w[39]	= new Point3D3(0.6, 0.8, -1);
	w[40]	= new Point3D3(0.7, 0.7, -1);
        w[41]	= new Point3D3(0.8, 0.6, -1);
	w[42]	= new Point3D3(0.9, 0.42, -1);        
	w[43]	= new Point3D3(0.98, 0.2, -1);
        
	w[44]	= new Point3D3(0, 0, 1);
        
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
	for(int i=0; i<45; i++){
            Point3D3 p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D3(-d*x/z, -d*y/z);
	}
    }
}

class Point2D3{
    float x, y;
    Point2D3(float x, float y){
    	this.x = x;
        this.y = y;
    }
}

class Point3D3{
    float x, y, z;
    Point3D3(double x, double y, double z){
        this.x = (float) x;
	this.y = (float) y;
	this.z = (float) z;
    }
}