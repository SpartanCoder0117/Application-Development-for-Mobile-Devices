package com.example.lienzo;

import android.content.*;
import android.graphics.*;
import android.view.View;
public class Lienzo extends View{
    Paint p;
    int x, y;
    public Lienzo(Context c){
        super(c);
    }
    protected void onDraw(Canvas c){
        super.onDraw(c); // Canvas pinta atributos
        p = new Paint(); // Paint asigna atributos
        x = c.getWidth(); // También: getMeasuredWidth() o getRight(), x=480
        y = c.getHeight(); // También: getMeasuredHeight() o getBottom(), y=762
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);
        p.setColor(Color.BLACK); // Texto negro
        p.setTextSize(20);
        p.setTypeface(Typeface.DEFAULT);
        c.drawText("x0=" + x/2 + ", y0=" + y/2, x/2 + 20, y/2-20, p);
        p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
        c.drawLine(x/2, 0, x/2, y, p);
        c.drawLine(0, y/2, x, y/2, p);

        p.setTextAlign(Paint.Align.RIGHT); //Paint.Align.RIGHT
        p.setTypeface(Typeface.MONOSPACE);
        c.drawText("Eje X", x-5, y/2-10, p);
        p.setTextAlign(Paint.Align.CENTER); //Paint.Align.CENTER
        p.setTypeface(Typeface.SANS_SERIF); //Typeface.DEFAULT_BOLD, Typeface.MONOSPACE, Typeface.DEFAULT, Typeface.SANS_SERIF
        c.drawText("Eje Y", x/2+30, 20, p);

        p.setColor(Color.argb(255, 200, 100, 100)); //Valor inicial de alpha 100
        c.drawOval(new RectF(90,142,270,426), p); //c.drawCircle(x/2-120, y/2+120, 100, p);
        p.setColor(Color.argb(255,0,255,0));
        c.drawRect(new Rect(450,142,630,426), p);
        p.setColor(Color.argb(255,0,0,255));
        c.drawRoundRect(new RectF(90,709,270,993),10,10, p);
        p.setColor(Color.argb(255,0,255,255));
        c.drawArc(new RectF(450,709,630,993),0,270,true, p);
    }
}