import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

/*
    Window Size: 376,470
*/

public class Side extends GCanvas {

    private int centerCanvasX() {
        return 376/2;
    }
    private int centerCanvasY() {
        return 470/2;
    }
    private void setCenterLocations(GObject obj, int OffsetX, int OffsetY) {
        obj.setLocation((centerCanvasX()-obj.getWidth()/2)+OffsetX, (centerCanvasY()-obj.getHeight()/2)+OffsetY);
    }
    private void setCenterX(GObject obj, int Y) {
        obj.setLocation(centerCanvasX()-obj.getWidth()/2, Y);
    }
    private void setCenterY(GObject obj, int X) {
        obj.setLocation(X, centerCanvasY()-obj.getHeight()/2);
    }
    private void centerAtObj(GObject obj1, GObject obj2, int offsetX, int offsetY) {
        obj2.setLocation(obj1.getX() + (obj1.getWidth()/2 - obj2.getWidth()/2) + offsetX, obj1.getY() + (obj1.getHeight()/2 - obj2.getHeight()/2) + offsetY);
    }

    public void art(){
        removeAll();
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

    public void lessons() {
        removeAll();

        setBackground(Color.CYAN);

        String font1 = "Arial-35-bold";
        String font2 = "Arial-25";

        GLabel lesson = new GLabel("Welcome to Lessons!");
        lesson.setFont(font1);
        setCenterLocations(lesson,0,-10);
        add(lesson);

        GLabel selLesson = new GLabel("Please select a lesson");
        selLesson.setFont(font2);
        setCenterLocations(selLesson,0,20);
        add(selLesson);

        GLabel arrow = new GLabel("<--------------");
        arrow.setFont(font2);
        setCenterLocations(arrow, 0, 50);
        add(arrow);

    }

    public void module1() {
        removeAll();
        setBackground(Color.CYAN);

        String font1 = "Arial-25-bold";
        String font2 = "Arial-20";

        GLabel Module1 = new GLabel("Module 1: Online Etiquette");
        Module1.setFont(font1);
        setCenterX(Module1,20);
        add(Module1);

        GLabel whatIsOE = new GLabel("What is Online Etiquette?");
        whatIsOE.setFont(font2);
        add(whatIsOE,0,40);
    }

    public void module2() {
        removeAll();
        setBackground(Color.CYAN);
    }

    public void module3() {
        removeAll();
        setBackground(Color.CYAN);
    }
}
