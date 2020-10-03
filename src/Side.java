import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    private static final int TEXT_HEIGHT=20;
    private int textX=0;
    private int textY=0;

    private void printText(String text){
        GLabel line = new GLabel(text);
        line.setFont("Arial-16");
        textY += TEXT_HEIGHT;
        add(line,  textX , textY );
    }

    private void displayTxt(String module, int page) {
        removeAll();
        textY=0;
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("assets/"+ module +"/" + page + ".txt"));
            String line;
            while ((line = buffer.readLine()) != null) {
                printText(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void page(String module, int page, int total) {
        displayTxt(module,page);

        GPolygon next = new GPolygon();
        next.addVertex(-30,0);
        next.addVertex(30,0);
        next.addVertex(0,40);
        next.rotate(90);
        next.setColor(Color.WHITE);
        next.setFillColor(Color.GREEN);
        next.setFilled(true);
        next.setLocation(330,435);

        GPolygon previous = new GPolygon();
        previous.addVertex(-30,0);
        previous.addVertex(30,0);
        previous.addVertex(0,40);
        previous.rotate(-90);
        previous.setColor(Color.WHITE);
        previous.setFillColor(Color.GREEN);
        previous.setFilled(true);
        previous.setLocation(290,435);

        int pre = page-1;
        int nxt = page+1;
        /*
        String nxpg = "Lesson"+nxt;
        String prepg = "Lesson"+pre;
        */

        if (pre<1 && nxt>total) {
            previous.setFillColor(Color.GRAY);
            add(previous);
            next.setFillColor(Color.GRAY);
            add(next);

        } else if (pre<1) {
            previous.setFillColor(Color.GRAY);
            add(previous);
            add(next);
            next.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    page(module,nxt,total);
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
        } else if (nxt>total) {
            add(previous);
            previous.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    page(module,pre,total);
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
            next.setFillColor(Color.GRAY);
            add(next);
        } else {
            add(previous);
            add(next);
            previous.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    page(module,pre,total);
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
            next.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    page(module,nxt,total);
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
    }

    public void module1() {
        int total_pages=3;
        removeAll();
        setBackground(Color.CYAN);

        //displayLesson("Module1","Lesson1");
        page("Module1",1, total_pages);
    }

    public void module2() {
        int total_pages=2;
        removeAll();
        setBackground(Color.CYAN);
        page("Module2",1, total_pages);
    }

    public void module3() {
        int total_pages=3;
        removeAll();
        setBackground(Color.CYAN);
        page("Module3",1, total_pages);
    }

    public void game() {
        removeAll();
        setBackground(Color.RED);

        String font1 = "Arial-35-bold";
        String font2 = "Arial-25";

        GLabel game = new GLabel("Welcome to Games!");
        game.setFont(font1);
        setCenterLocations(game,0,-10);
        add(game);

        GLabel selGame = new GLabel("Please select a game");
        selGame.setFont(font2);
        setCenterLocations(selGame,0,20);
        add(selGame);

        GLabel arrow = new GLabel("<--------------");
        arrow.setFont(font2);
        setCenterLocations(arrow, 0, 50);
        add(arrow);
    }

    public void aboutApp() {
        removeAll();
        setBackground(Color.YELLOW);

        String font1 = "Arial-30-bold";
        String font2 = "Arial-20";

        GLabel about = new GLabel("Welcome to About App!");
        about.setFont(font1);
        setCenterLocations(about,0,-10);
        add(about);

        GLabel selNfo = new GLabel("Please select the info you want to view");
        selNfo.setFont(font2);
        setCenterLocations(selNfo,0,20);
        add(selNfo);

        GLabel arrow = new GLabel("<--------------");
        arrow.setFont(font2);
        setCenterLocations(arrow, 0, 50);
        add(arrow);
    }

    public void references() {
        removeAll();
        setBackground(Color.YELLOW);
        page("Reference",1,2);
    }

    public void appInfo() {
        removeAll();
        setBackground(Color.YELLOW);
        page("App Info", 1,1);
    }

    public void credits() {
        removeAll();
        setBackground(Color.YELLOW);
        page("Credits",1,1);
    }
}
