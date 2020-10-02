import acm.program.*;
import acm.graphics.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class Main extends GraphicsProgram {
    private Side canvas;

    public void init() {
        canvas = new Side();
        add(canvas);
        canvas.art();
    }

    private int centerCanvasX() {
        return 376/2;
    }
    private int centerCanvasY() {
        return 470/2;
    }
    private void setCenterLocations(GObject obj) {
        obj.setLocation(centerCanvasX()-obj.getWidth()/2, centerCanvasY()-obj.getHeight()/2);
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

    private void drawMainMenu() {
        removeAll();
        setBackground(Color.GRAY);

        String font1 = "Arial-50-bold";
        String font2 = "Arial-20";

        GLabel mainmenu = new GLabel("Main Menu");
        mainmenu.setFont(font1);
        setCenterX(mainmenu,40);
        add(mainmenu);

        GRect lessons_b = new GRect(120,50);
        lessons_b.setFillColor(Color.LIGHT_GRAY);
        lessons_b.setFilled(true);
        setCenterLocations(lessons_b,0,-50);
        add(lessons_b);

        GLabel lessons_l = new GLabel("Lessons");
        lessons_l.setFont(font2);
        centerAtObj(lessons_b,lessons_l, 0, 18);
        add(lessons_l);

        GRect game_b = new GRect(120,50);
        game_b.setFillColor(Color.LIGHT_GRAY);
        game_b.setFilled(true);
        setCenterLocations(game_b,0,5);
        add(game_b);

        GLabel game_l = new GLabel("Play Games");
        game_l.setFont(font2);
        centerAtObj(game_b,game_l,0,18);
        add(game_l);

        GRect about_b = new GRect(120,50);
        about_b.setFillColor(Color.LIGHT_GRAY);
        about_b.setFilled(true);
        setCenterLocations(about_b,0,60);
        add(about_b);

        GLabel about_l = new GLabel("About App");
        about_l.setFont(font2);
        centerAtObj(about_b,about_l,0,18);
        add(about_l);

        GRect exit_b = new GRect(120,50);
        exit_b.setFillColor(Color.LIGHT_GRAY);
        exit_b.setFilled(true);
        setCenterLocations(exit_b,0,115);
        add(exit_b);

        GLabel exit_l = new GLabel("Exit App");
        exit_l.setFont(font2);
        centerAtObj(exit_b,exit_l,0,18);
        add(exit_l);

        lessons_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("Mouse Clicked on Lessons.");  //for testing/debugging
                drawLessons();
                canvas.lessons();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        game_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Quiz quiz = new Quiz();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        about_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("About App Clicked!");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        exit_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void drawLessons() {
        removeAll();
        setBackground(Color.GRAY);

        String font1 = "Arial-50-bold";
        String font2 = "Arial-20";

        GLabel lessons = new GLabel("Lessons");
        lessons.setFont(font1);
        setCenterX(lessons,40);
        add(lessons);

        GRect Module1_b = new GRect(120,50);
        Module1_b.setFillColor(Color.LIGHT_GRAY);
        Module1_b.setFilled(true);
        setCenterLocations(Module1_b,0,-50);
        add(Module1_b);

        GLabel Module1_l = new GLabel("Module 1");
        Module1_l.setFont(font2);
        centerAtObj(Module1_b,Module1_l, 0, 18);
        add(Module1_l);

        GRect Module2_b = new GRect(120,50);
        Module2_b.setFillColor(Color.LIGHT_GRAY);
        Module2_b.setFilled(true);
        setCenterLocations(Module2_b,0,5);
        add(Module2_b);

        GLabel Module2_l = new GLabel("Module 2");
        Module2_l.setFont(font2);
        centerAtObj(Module2_b,Module2_l,0,18);
        add(Module2_l);

        GRect Module3_b = new GRect(120,50);
        Module3_b.setFillColor(Color.LIGHT_GRAY);
        Module3_b.setFilled(true);
        setCenterLocations(Module3_b,0,60);
        add(Module3_b);

        GLabel Module3_l = new GLabel("Module 3");
        Module3_l.setFont(font2);
        centerAtObj(Module3_b,Module3_l,0,18);
        add(Module3_l);

        GRect exit_b = new GRect(120,50);
        exit_b.setFillColor(Color.LIGHT_GRAY);
        exit_b.setFilled(true);
        setCenterLocations(exit_b,0,115);
        add(exit_b);

        GLabel exit_l = new GLabel("Exit Lessons");
        exit_l.setFont(font2);
        centerAtObj(exit_b,exit_l,0,18);
        add(exit_l);

        Module1_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.module1();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Module2_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.module2();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Module3_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.module3();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        exit_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawMainMenu();
                canvas.art();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void run() {
        drawMainMenu();
    }

    public static void main(String[] args) {
        new Main().start(args);
    }
}
