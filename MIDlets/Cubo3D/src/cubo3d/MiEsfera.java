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
public class MiEsfera extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    private Display d;
    Canvas ca;
    private Command cs;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The MiEsfera constructor.
     */
    public MiEsfera() {
        d = Display.getDisplay(this); 
        ca = new Canvas(){
            int centerX, centerY, maxX, maxY, minMaxXY;
            Obj6 obj = new Obj6();
            int x=0, y=0;
            public void paint(Graphics g){             
                g.setColor(0,0,0);//Color fondo
                g.fillRect(0, 0, getWidth(), getHeight());
                maxX = getWidth()-1; maxY = getHeight()-1; minMaxXY=Math.min(maxX, maxY);
                centerX = maxX/2;
                centerY = maxY/2;
                obj.d = obj.rho*minMaxXY/obj.objSize;
                obj.eyeAndScreen();
                //Circulo con Y = 0
                line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 4); 
                line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 8); 
                line(g, 8, 9); line(g, 9, 10); line(g, 10, 11); line(g, 11, 12); 
                line(g, 12, 13); line(g, 13, 14); line(g, 14, 15); line(g, 15, 16);
                line(g, 16, 17); line(g, 17, 18); line(g, 18, 19); line(g, 19, 20);
                line(g, 20, 21); line(g, 21, 22); 
                line(g, 22, 23); line(g, 23, 24); line(g, 24, 25); line(g, 25, 26); 
                line(g, 26, 27); line(g, 27, 28); line(g, 28, 29); line(g, 29, 30); 
                line(g, 30, 31); line(g, 31, 32); line(g, 32, 33); line(g, 33, 34); 
                line(g, 34, 35); line(g, 35, 36); line(g, 36, 37); line(g, 37, 38);
                line(g, 38, 39); line(g, 39, 40); line(g, 40, 41); line(g, 41, 42); 
                line(g, 42, 43); line(g, 43, 0); 
                //Circulo con X = 0
                line(g, 44, 45); line(g, 45, 46); line(g, 46, 47); line(g, 47, 48); 
                line(g, 48, 49); line(g, 49, 50); line(g, 50, 51); line(g, 51, 52); 
                line(g, 52, 53); line(g, 53, 54); line(g, 54, 55); line(g, 55, 56); 
                line(g, 56, 57); line(g, 57, 58); line(g, 58, 59); line(g, 59, 60);
                line(g, 60, 61); line(g, 61, 62); line(g, 62, 63); line(g, 63, 64);
                line(g, 64, 65); line(g, 65, 66); 
                line(g, 66, 67); line(g, 67, 68); line(g, 68, 69); line(g, 69, 70);
                line(g, 70, 71); line(g, 71, 72); line(g, 72, 73); line(g, 73, 74); 
                line(g, 74, 75); line(g, 75, 76); line(g, 76, 77); line(g, 77, 78); 
                line(g, 78, 79); line(g, 79, 80); line(g, 80, 81); line(g, 81, 82); 
                line(g, 82, 83); line(g, 83, 84); line(g, 84, 85); line(g, 85, 86); 
                line(g, 86, 87); line(g, 87, 44); 
                //Nuevas
                /*line(g, 88, 89); line(g, 89, 90); line(g, 90, 91); line(g, 91, 92); 
                line(g, 92, 93); line(g, 93, 94); line(g, 94, 95); line(g, 95, 96); 
                line(g, 96, 97); line(g, 97, 98); line(g, 98, 109); 
                line(g, 99, 100); 
                line(g, 100, 101); line(g, 101, 102); line(g, 102, 103); 
                line(g, 103, 104); line(g, 104, 105); line(g, 105, 106); line(g, 106, 107); 
                line(g, 107, 108); line(g, 108, 109); //line(g, 109, 11); 
                line(g, 110, 111); 
                line(g, 111, 112); line(g, 112, 113); line(g, 113, 114); 
                line(g, 114, 115); line(g, 115, 116); line(g, 116, 117); line(g, 117, 118); 
                line(g, 118, 119); line(g, 119, 99);
                line(g, 120, 33); line(g, 111, 33);
                line(g, 120, 121); line(g, 121, 122); line(g, 122, 123); 
                line(g, 123, 124); line(g, 124, 125); line(g, 125, 126); line(g, 126, 127); 
                line(g, 127, 128); line(g, 128, 129); line(g, 129, 88); 
                line(g, 130, 131); 
                line(g, 131, 132); line(g, 132, 133); line(g, 133, 134); 
                line(g, 134, 135); line(g, 135, 136); line(g, 136, 137); line(g, 137, 138); 
                line(g, 138, 139); line(g, 139, 140);
                
                line(g, 141, 142); line(g, 142, 143); line(g, 143, 144); 
                line(g, 144, 145); line(g, 145, 146); line(g, 146, 147); line(g, 147, 148); 
                line(g, 148, 149); line(g, 149, 150); line(g, 150, 151);
                
                line(g, 152, 153); line(g, 153, 154); line(g, 154, 155); 
                line(g, 155, 156); line(g, 156, 157); line(g, 157, 158); line(g, 158, 159); 
                line(g, 159, 160); line(g, 160, 161); //line(g, 150, 151);
                
                line(g, 162, 163); line(g, 163, 164); line(g, 164, 165); 
                line(g, 165, 166); line(g, 166, 167); line(g, 167, 168); line(g, 168, 169); 
                line(g, 169, 170); line(g, 170, 171); //line(g, 150, 151);
                line(g, 140, 11); line(g, 151, 11); line(g, 161, 131); line(g, 171, 141);
                line(g, 142, 33); line(g, 131, 33);*/
            }
            void line(Graphics g, int i, int j){
                Point2D6 p = obj.vScr[i], q = obj.vScr[j];
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

class Obj6{	// Posee los datos del objeto 3D
    float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D6 [] w;	// coordenadas universales
    Point2D6 [] vScr; // coordenadas de la pantalla
    Obj6(){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        w	= new Point3D6[88];//176
	vScr	= new Point2D6[88];
        
        //Circulo eje Y = 0
        w[0]	= new Point3D6(1, 0, 0); //Punto A         
       
        w[1]	= new Point3D6(0.98, 0, 0.2);
        w[2]	= new Point3D6(0.9, 0, 0.42);
	w[3]	= new Point3D6(0.8, 0, 0.6);
	w[4]	= new Point3D6(0.7, 0, 0.7);        
	w[5]	= new Point3D6(0.6, 0, 0.8);
	w[6]	= new Point3D6(0.5, 0, 0.87);
	w[7]	= new Point3D6(0.4, 0, 0.91);
	w[8]	= new Point3D6(0.3, 0, 0.95);       
        w[9]	= new Point3D6(0.2, 0, 0.97);
        w[10]	= new Point3D6(0.1, 0, 1); 
        
	w[11]	= new Point3D6(0, 0, 1); //Punto B
        
        w[12]	= new Point3D6(-0.1, 0, 1);
	w[13]	= new Point3D6(-0.2, 0, 0.97);        
	w[14]	= new Point3D6(-0.3, 0, 0.95);        
	w[15]	= new Point3D6(-0.4, 0, 0.91);
	w[16]	= new Point3D6(-0.5, 0, 0.87);
	w[17]	= new Point3D6(-0.6, 0, 0.8);       
        w[18]	= new Point3D6(-0.7, 0, 0.7);
	w[19]	= new Point3D6(-0.8, 0, 0.6);
	w[20]	= new Point3D6(-0.9, 0, 0.42);        
        w[21]	= new Point3D6(-0.98, 0, 0.2);
        
        w[22]	= new Point3D6(-1, 0, 0); //Punto C         
       
        w[23]	= new Point3D6(-0.98, 0, -0.2);
        w[24]	= new Point3D6(-0.9, 0, -0.42);
	w[25]	= new Point3D6(-0.8, 0, -0.6);
	w[26]	= new Point3D6(-0.7, 0, -0.7);        
	w[27]	= new Point3D6(-0.6, 0, -0.8);
	w[28]	= new Point3D6(-0.5, 0, -0.87);
	w[29]	= new Point3D6(-0.4, 0, -0.91);
	w[30]	= new Point3D6(-0.3, 0, -0.95);       
        w[31]	= new Point3D6(-0.2, 0, -0.97);
        w[32]	= new Point3D6(-0.1, 0, -1); 
        
	w[33]	= new Point3D6(0, 0, -1); //Punto D
        
        w[34]	= new Point3D6(0.1, 0, -1);
	w[35]	= new Point3D6(0.2, 0, -0.97);        
	w[36]	= new Point3D6(0.3, 0, -0.95);        
	w[37]	= new Point3D6(0.4, 0, -0.91);
	w[38]	= new Point3D6(0.5, 0, -0.87);
	w[39]	= new Point3D6(0.6, 0, -0.8);       
        w[40]	= new Point3D6(0.7, 0, -0.7);
	w[41]	= new Point3D6(0.8, 0, -0.6);
	w[42]	= new Point3D6(0.9, 0, -0.42);        
        w[43]	= new Point3D6(0.98, 0, -0.2);
        
        //Circulo eje X = 0
        w[44]	= new Point3D6(0, -1, 0); //Punto E         
       
        w[45]	= new Point3D6(0, -0.98, 0.2);
        w[46]	= new Point3D6(0, -0.9, 0.42);
	w[47]	= new Point3D6(0, -0.8, 0.6);
	w[48]	= new Point3D6(0, -0.7, 0.7);        
	w[49]	= new Point3D6(0, -0.6, 0.8);
	w[50]	= new Point3D6(0, -0.5, 0.87);
	w[51]	= new Point3D6(0, -0.4, 0.91);
	w[52]	= new Point3D6(0, -0.3, 0.95);       
        w[53]	= new Point3D6(0, -0.2, 0.97);
        w[54]	= new Point3D6(0, -0.1, 1); 
        
	w[55]	= new Point3D6(0, 0, 1); //Punto B
        
        w[56]	= new Point3D6(0, 0.1, 1);
	w[57]	= new Point3D6(0, 0.2, 0.97);        
	w[58]	= new Point3D6(0, 0.3, 0.95);        
	w[59]	= new Point3D6(0, 0.4, 0.91);
	w[60]	= new Point3D6(0, 0.5, 0.87);
	w[61]	= new Point3D6(0, 0.6, 0.8);       
        w[62]	= new Point3D6(0, 0.7, 0.7);
	w[63]	= new Point3D6(0, 0.8, 0.6);
	w[64]	= new Point3D6(0, 0.9, 0.42);        
        w[65]	= new Point3D6(0, 0.98, 0.2);
        
        w[66]	= new Point3D6(0, 1, 0); //Punto G         
       
        w[67]	= new Point3D6(0, 0.98, -0.2);
        w[68]	= new Point3D6(0, 0.9, -0.42);
	w[69]	= new Point3D6(0, 0.8, -0.6);
	w[70]	= new Point3D6(0, 0.7, -0.7);        
	w[71]	= new Point3D6(0, 0.6, -0.8);
	w[72]	= new Point3D6(0, 0.5, -0.87);
	w[73]	= new Point3D6(0, 0.4, -0.91);
	w[74]	= new Point3D6(0, 0.3, -0.95);       
        w[75]	= new Point3D6(0, 0.2, -0.97);
        w[76]	= new Point3D6(0, 0.1, -1); 
       
	w[77]	= new Point3D6(0, 0, -1); //Punto D
        
        w[78]	= new Point3D6(0, -0.1, -1);
	w[79]	= new Point3D6(0, -0.2, -0.97);        
	w[80]	= new Point3D6(0, -0.3, -0.95);        
	w[81]	= new Point3D6(0, -0.4, -0.91);
	w[82]	= new Point3D6(0, -0.5, -0.87);
	w[83]	= new Point3D6(0, -0.6, -0.8);       
        w[84]	= new Point3D6(0, -0.7, -0.7);
	w[85]	= new Point3D6(0, -0.8, -0.6);
	w[86]	= new Point3D6(0, -0.9, -0.42);        
        w[87]	= new Point3D6(0, -0.98, -0.2);
        
        //Nuevas caras
        /*w[88]	= new Point3D6(1, -1, 0); //Punto F
        
        w[89]	= new Point3D6(0.98, -0.98, 0.2);
        w[90]	= new Point3D6(0.9, -0.9, 0.42);
	w[91]	= new Point3D6(0.8, -0.8, 0.6);
	w[92]	= new Point3D6(0.7, -0.7, 0.7);        
	w[93]	= new Point3D6(0.6, -0.6, 0.8);
	w[94]	= new Point3D6(0.5, -0.5, 0.87);
	w[95]	= new Point3D6(0.4, -0.4, 0.91);
	w[96]	= new Point3D6(0.3, -0.3, 0.95);       
        w[97]	= new Point3D6(0.2, -0.2, 0.97);
        w[98]	= new Point3D6(0.1, -0.1, 1); 
        
        w[99]	= new Point3D6(-1, 1, 0); //Punto I
        
        w[100]	= new Point3D6(-0.98, 0.98, 0.2);
        w[101]	= new Point3D6(-0.9, 0.9, 0.42);
	w[102]	= new Point3D6(-0.8, 0.8, 0.6);
	w[103]	= new Point3D6(-0.7, 0.7, 0.7);        
	w[104]	= new Point3D6(-0.6, 0.6, 0.8);
	w[105]	= new Point3D6(-0.5, 0.5, 0.87);
	w[106]	= new Point3D6(-0.4, 0.4, 0.91);
	w[107]	= new Point3D6(-0.3, 0.3, 0.95);       
        w[108]	= new Point3D6(-0.2, 0.2, 0.97);
        w[109]	= new Point3D6(-0.1, 0.1, 1); 
        
        w[110]	= new Point3D6(-0.1, 0.1, -1);
	w[111]	= new Point3D6(-0.2, 0.2, -0.97);        
	w[112]	= new Point3D6(-0.3, 0.3, -0.95);        
	w[113]	= new Point3D6(-0.4, 0.4, -0.91);
	w[114]	= new Point3D6(-0.5, 0.5, -0.87);
	w[115]	= new Point3D6(-0.6, 0.6, -0.8);       
        w[116]	= new Point3D6(-0.7, 0.7, -0.7);
	w[117]	= new Point3D6(-0.8, 0.8, -0.6);
	w[118]	= new Point3D6(-0.9, 0.9, -0.42);        
        w[119]	= new Point3D6(-0.98, 0.98, -0.2);
        
        w[120]	= new Point3D6(0.1, -0.1, -1);
	w[121]	= new Point3D6(0.2, -0.2, -0.97);        
	w[122]	= new Point3D6(0.3, -0.3, -0.95);        
	w[123]	= new Point3D6(0.4, -0.4, -0.91);
	w[124]	= new Point3D6(0.5, -0.5, -0.87);
	w[125]	= new Point3D6(0.6, -0.6, -0.8);       
        w[126]	= new Point3D6(0.7, -0.7, -0.7);
	w[127]	= new Point3D6(0.8, -0.8, -0.6);
	w[128]	= new Point3D6(0.9, -0.9, -0.42);        
        w[129]	= new Point3D6(0.98, -0.98, -0.2);
        
        w[130]	= new Point3D6(1, 1, 0); //Punto J
        
        w[131]	= new Point3D6(0.98, 0.98, 0.2);
        w[132]	= new Point3D6(0.9, 0.9, 0.42);
	w[133]	= new Point3D6(0.8, 0.8, 0.6);
	w[134]	= new Point3D6(0.7, 0.7, 0.7);        
	w[135]	= new Point3D6(0.6, 0.6, 0.8);
	w[136]	= new Point3D6(0.5, 0.5, 0.87);
	w[137]	= new Point3D6(0.4, 0.4, 0.91);
	w[138]	= new Point3D6(0.3, 0.3, 0.95);       
        w[139]	= new Point3D6(0.2, 0.2, 0.97);
        w[140]	= new Point3D6(0.1, 0.1, 1); 
        
        w[141]	= new Point3D6(-1, -1, 0); //Punto H
        
        w[142]	= new Point3D6(-0.98, -0.98, 0.2);
        w[143]	= new Point3D6(-0.9, -0.9, 0.42);
	w[144]	= new Point3D6(-0.8, -0.8, 0.6);
	w[145]	= new Point3D6(-0.7, -0.7, 0.7);        
	w[146]	= new Point3D6(-0.6, -0.6, 0.8);
	w[147]	= new Point3D6(-0.5, -0.5, 0.87);
	w[148]	= new Point3D6(-0.4, -0.4, 0.91);
	w[149]	= new Point3D6(-0.3, -0.3, 0.95);       
        w[150]	= new Point3D6(-0.2, -0.2, 0.97);
        w[151]	= new Point3D6(-0.1, -0.1, 1);
        
        w[152]	= new Point3D6(0.1, 0.1, -1);
	w[153]	= new Point3D6(0.2, 0.2, -0.97);        
	w[154]	= new Point3D6(0.3, 0.3, -0.95);        
	w[155]	= new Point3D6(0.4, 0.4, -0.91);
	w[156]	= new Point3D6(0.5, 0.5, -0.87);
	w[157]	= new Point3D6(0.6, 0.6, -0.8);       
        w[158]	= new Point3D6(0.7, 0.7, -0.7);
	w[159]	= new Point3D6(0.8, 0.8, -0.6);
	w[160]	= new Point3D6(0.9, 0.9, -0.42);        
        w[161]	= new Point3D6(0.98, 0.98, -0.2);
        
        w[162]	= new Point3D6(-0.1, -0.1, -1);
	w[163]	= new Point3D6(-0.2, -0.2, -0.97);        
	w[164]	= new Point3D6(-0.3, -0.3, -0.95);        
	w[165]	= new Point3D6(-0.4, -0.4, -0.91);
	w[166]	= new Point3D6(-0.5, -0.5, -0.87);
	w[167]	= new Point3D6(-0.6, -0.6, -0.8);       
        w[168]	= new Point3D6(-0.7, -0.7, -0.7);
	w[169]	= new Point3D6(-0.8, -0.8, -0.6);
	w[170]	= new Point3D6(-0.9, -0.9, -0.42);        
        w[171]	= new Point3D6(-0.98, -0.98, -0.2);*/
        /*w[88]	= new Point3D6(-1, -1, 0); //Punto H
        w[88]	= new Point3D6(-1, 1, 0); //Punto I
        w[88]	= new Point3D6(1, 1, 0); //Punto J*/
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
	for(int i=0; i<88; i++){
            Point3D6 p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D6(-d*x/z, -d*y/z);
	}
    }
}

class Point2D6{
    float x, y;
    Point2D6(float x, float y){
    	this.x = x;
        this.y = y;
    }
}

class Point3D6{
    float x, y, z;
    Point3D6(double x, double y, double z){
        this.x = (float) x;
	this.y = (float) y;
	this.z = (float) z;
    }
}