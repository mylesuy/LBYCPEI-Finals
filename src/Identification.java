import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Identification extends GraphicsProgram {
    private final int NumPics=10;
    int result;
    String[] answers={"YES","YES","YES","YES","YES"};
    public void run() {
        StartScreen();
        Questions();
        WallPic();
        buttons();
    }


    private void StartScreen() {
        GLabel welcome = new GLabel("Welcome to the Identification Game");
        GLabel pressStart = new GLabel("Press anywhere to start");
        welcome.setColor(Color.darkGray);
        welcome.setFont("Arial-27");
        pressStart.setColor(Color.darkGray);
        pressStart.setFont("Arial-24");
        add(welcome, (getWidth() / 2) - 40 - (pressStart.getWidth() / 2), (getHeight() / 2) - 40 - (pressStart.getHeight() / 2));
        add(pressStart, getWidth() / 2 - (pressStart.getWidth() / 2), getHeight() / 2 - (pressStart.getHeight() / 2));
        waitForClick();
        remove(pressStart);
        remove(welcome);


    }
    private void Questions(){
        GLabel question1 = new GLabel("Which one is a scam?");
        question1.setColor(Color.BLACK);
        question1.setFont("Garamond-20");
        add(question1,43,42);
    }
    private void WallPic(){





    }
    private void buttons(){
        GImage Front = new GImage("assets/frontrow2.jpg");
        Front.setSize(200,400);
        add(Front,270,69);
        GImage Back = new GImage("assets/d.jpg");
        Back.setSize(200,400);
        add(Back,270,69);
        GImage scam = new GImage("assets/a.png");
        scam.setSize(200,400);
        add(scam,270,69);
        GImage s = new GImage("assets/image0.png");
        s.setSize(200,400);
        add(s,270,69);
        GImage Xbox = new GImage("assets/Tite.jpg");
        Xbox.setSize(200,400);
        add(Xbox,270,69);
        GRect Yes = new GRect(150,100);
        Yes.setFillColor(Color.GREEN);
        Yes.setFilled(true);
        add(Yes,521,241);
        GRect No = new GRect(150,100);
        No.setFillColor(Color.RED);
        No.setFilled(true);
        add(No,75,241);
        GLabel agree = new GLabel("YES");
        agree.setColor(Color.BLACK);
        agree.setFont("Garamond-30");
        add(agree,555,300);
        GLabel No2 = new GLabel("NO");
        No2.setColor(Color.BLACK);
        No2.setFont("Garamond-30");
        add(No2,125,300);
        Yes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(Xbox);
                result++;

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

        No.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(Xbox);
                result--;

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
    private void program(){

    }
}

