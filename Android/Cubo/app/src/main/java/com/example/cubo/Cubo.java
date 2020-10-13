package com.example.cubo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

import static android.content.Context.SENSOR_SERVICE;


public class Cubo extends View implements View.OnTouchListener{
    Paint p;
    Path r;
    int centerX=0, centerY=0, maxX=0, maxY=0, minMaxXY=0;
    int x,y;
    Obj obj = new Obj();

    public Cubo(Context c){
        super(c);
        x=100;
        y=100;
        centerX = maxX/2;
        centerY = maxY/2;
    }


    void line(Canvas g, int i, int j){
        Point2D pa = obj.vScr[i], q = obj.vScr[j];
        //p.setColor(Color.RED);
        p.setColor(Color.GREEN);
        g.drawLine(iX(pa.x), iY(pa.y), iX(q.x), iY(q.y), p);
    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        p = new Paint();
        //p.setColor(Color.WHITE);
        p.setColor(Color.BLACK);
        c.drawPaint(p);
        setOnTouchListener(this);
        Rect rectangulo = new Rect(0,0, getWidth(), getHeight());
        //p.setColor(Color.argb(50, 50, 50, 50));
        p.setColor(Color.argb(100, 0, 0, 0));
        c.drawRect(rectangulo, p);
        maxX=getWidth()-1; maxY=getHeight()-1; minMaxXY=Math.min(maxX,maxY);
        centerX = maxX/2;
        centerY = maxY/2;
        obj.d = obj.rho*minMaxXY/obj.objSize;
        obj.eyeAndScreen();
        line(c, 0, 1); line(c, 1, 2); line(c, 2, 3); line(c, 3, 0); // aristas horizontales inferiores
        line(c, 4, 5); line(c, 5, 6); line(c, 6, 7); line(c, 7, 4); // aristas horizontales superiores
        line(c, 0, 4); line(c, 1, 5); line(c, 2, 6); line(c, 3, 7); // aristas verticales
    }

    int iX(float x){
        return centerX + (int)x;
    }
    int iY(float y){
        return centerY - (int)y;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int eventaction = event.getAction();
        if(eventaction == MotionEvent.ACTION_MOVE){
            x = (int) event.getX();
            y = (int) event.getY();
        }
        obj.theta   = (float) getWidth() / x;
        obj.phi     = (float) getHeight() / y;
        obj.rho     = (obj.phi/obj.theta) * getHeight();
        centerX     = x;
        centerY     = y;
        v.invalidate();
        return true;
    }
}



/*
public class Cubo extends View implements SensorEventListener,Runnable {
    Paint p;
    Path r;
    int centerX=0, centerY=0, maxX=0, maxY=0, minMaxXY=0;
    float x,y;
    Obj obj = new Obj();
    SensorManager sm;
    List<Sensor> sensors;

    public Cubo(Context c){
        super(c);
        x=100;
        y=100;
        centerX = maxX/2;
        centerY = maxY/2;
        sm=(SensorManager) c.getSystemService(SENSOR_SERVICE);
        sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
    }


    void line(Canvas g, int i, int j){
        Point2D pa = obj.vScr[i], q = obj.vScr[j];
        p.setColor(Color.RED);
        g.drawLine(iX(pa.x), iY(pa.y), iX(q.x), iY(q.y), p);
    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        p = new Paint();
        p.setColor(Color.WHITE);
        //setOnTouchListener(this);
        sm.registerListener((SensorEventListener) this,sensors.get(0),SensorManager.SENSOR_DELAY_NORMAL);
        c.drawPaint(p);
        Rect rectangulo = new Rect(0,0, getWidth(), getHeight());
        p.setColor(Color.argb(50, 50, 50, 50));
        c.drawRect(rectangulo, p);
        maxX=getWidth()-1; maxY=getHeight()-1; minMaxXY=Math.min(maxX,maxY);
        centerX = maxX/2;
        centerY = maxY/2;
        obj.d = obj.rho*minMaxXY/obj.objSize;
        obj.eyeAndScreen();
        line(c, 0, 1); line(c, 1, 2); line(c, 2, 3); line(c, 3, 0); // aristas horizontales inferiores
        line(c, 4, 5); line(c, 5, 6); line(c, 6, 7); line(c, 7, 4); // aristas horizontales superiores
        line(c, 0, 4); line(c, 1, 5); line(c, 2, 6); line(c, 3, 7); // aristas verticales
    }

    int iX(float x){
        return centerX + (int)x;
    }
    int iY(float y){
        return centerY - (int)y;
    }
    /*
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int eventaction = event.getAction();
            if(eventaction == MotionEvent.ACTION_MOVE){
                x = (int) event.getX();
                y = (int) event.getY();
            }
            obj.theta   = (float) getWidth() / x;
            obj.phi     = (float) getHeight() / y;
            obj.rho     = (obj.phi/obj.theta) * getHeight();
            centerX     = x;
            centerY     = y;
            v.invalidate();
            return true;
        }
    */
   /* @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        obj.theta = (float) getWidth() / x;
        obj.phi = (float) getHeight() / y;
        obj.rho = (obj.phi / obj.theta) * getHeight();
        centerX = (int) x;
        centerY = (int) y;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void run() {

    }
}*/
