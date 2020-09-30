import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
    Size: 376,470
*/

public class MainMenu extends GCanvas {
    private int centerCanvasX() {
        return 376/2;
    }
    private int centerCanvasY() {
        return 470/2;
    }

    public void setCenterLocations(GObject obj) {
        obj.setLocation(centerCanvasX()-obj.getWidth()/2, centerCanvasY()-obj.getHeight()/2);
    }

    public void setCenterLocations(GObject obj, int X, int Y) {
        obj.setLocation((centerCanvasX()-obj.getWidth()/2)+X, (centerCanvasY()-obj.getHeight()/2)+Y);
    }

    public void setCenterX(GObject obj, int Y) {
        obj.setLocation(centerCanvasX()-obj.getWidth()/2, Y);
    }

    public void setCenterY(GObject obj, int X) {
        obj.setLocation(X, centerCanvasY()-obj.getHeight()/2);
    }

    public void centerAtObj(GObject obj1, GObject obj2, int offsetX, int offsetY) {
        obj2.setLocation(obj1.getX() + (obj1.getWidth()/2 - obj2.getWidth()/2) + offsetX, obj1.getY() + (obj1.getHeight()/2 - obj2.getHeight()/2) + offsetY);
    }

    public void run() {
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

        lessons_b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked on Lessons.");
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
                MultipleChoice.main(new String[0]);
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
    }

}
