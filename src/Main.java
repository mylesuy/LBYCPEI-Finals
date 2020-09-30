import acm.program.*;
import acm.graphics.*;

import java.awt.font.GlyphJustificationInfo;
import java.io.*;
import java.awt.*;

public class Main extends GraphicsProgram {
    private MainMenu canvas;

    public void init() {
        canvas = new MainMenu();
        add(canvas);
        canvas.run();
    }
    public void run(){
        GImage a = new GImage("assets/MainMenu/Internet-Online Conference.png");
        a.scale(0.2);

        GImage b = new GImage("assets/MainMenu/Internet-Online Shopping.png");
        b.scale(0.059);

        GImage c = new GImage("assets/MainMenu/Hacker.jpg");
        c.scale(0.2);

        GImage d = new GImage("assets/MainMenu/Mobile Devices.png");
        d.scale(0.08);

        add(a,0,0);
        add(b,0,0);
        add(c,0,250);
        add(d, 220,-5);

        String font1 = "TimesNewRoman-20-bold";

        /*GLabel welcomeFL = new GLabel("Welcome to Online Etiquette & Safety Class");
        welcomeFL.setFont(font1);
        welcomeFL.setColor(Color.RED);
        add(welcomeFL, 0, 245);*/

        GLabel welcome0 = new GLabel("Welcome to");
        welcome0.setFont(font1);
        welcome0.setColor(Color.RED);
        add(welcome0, 0, 230);

        GLabel welcome1 = new GLabel("Online Etiquette");
        welcome1.setFont(font1);
        welcome1.setColor(Color.RED);
        add(welcome1, 105, 245);

        GLabel welcome2 = new GLabel("&");
        welcome2.setFont(font1);
        welcome2.setColor(Color.GREEN);
        add(welcome2, 250,265);

        GLabel welcome3 = new GLabel("Safety");
        welcome3.setFont(font1);
        welcome3.setColor(Color.GREEN);
        add(welcome3,272,286);

        GLabel welcome4 = new GLabel("Class");
        welcome4.setFont(font1);
        welcome4.setColor(Color.GREEN);
        add(welcome4,332,310);
    }

    public static void main(String[] args) {
        new Main().start(args);
    }
}
