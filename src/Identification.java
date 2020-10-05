import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Identification extends GraphicsProgram {
    int NumPics = 0;

    int correct_guesses = 0;

    private int num = 1;
    int index;

    int result;
    String[] answer = {"YES", "YES", "YES", "YES", "YES"};

    public void run() {
        setTitle("Scam Identifier");
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

    private void Questions() {
        GLabel question1 = new GLabel("Is this a scam?");
        question1.setColor(Color.BLACK);
        question1.setFont("Garamond-20");
        add(question1, 43, 42);
    }

    private void WallPic() {


    }

    private void nextPhoto() {
        num++;
        drawImages(num);
    }

    private void drawImages(int picNum) {
        switch (picNum) {
            case 1 -> {
                GImage pic1 = new GImage("assets/Identification/1.jpg");
                pic1.setSize(200, 400);
                add(pic1, 270, 69);
            }
            case 2 -> {
                GImage pic2 = new GImage("assets/Identification/2.jpg");
                pic2.setSize(200, 400);
                add(pic2, 270, 69);
            }
            case 3 -> {
                GImage pic3 = new GImage("assets/Identification/3.jpg");
                pic3.setSize(200, 400);
                add(pic3, 270, 69);
            }
            case 4 -> {
                GImage pic4 = new GImage("assets/Identification/4.jpg");
                pic4.setSize(200, 400);
                add(pic4, 270, 69);
            }
            case 5 -> {
                GImage pic5 = new GImage("assets/Identification/5.jpg");
                pic5.setSize(200, 400);
                add(pic5, 270, 69);
            }
            case 6 -> {
                GImage pic6 = new GImage("assets/Identification/6.jpg");
                pic6.setSize(200, 400);
                add(pic6, 270, 69);
            }
        }
    }

    private void buttons() {
        drawImages(1);
        GRect Yes = new GRect(150, 100);
        Yes.setFillColor(Color.GREEN);
        Yes.setFilled(true);
        add(Yes, 521, 241);
        GRect No = new GRect(150, 100);
        No.setFillColor(Color.RED);
        No.setFilled(true);
        add(No, 75, 241);
        GLabel agree = new GLabel("YES");
        agree.setColor(Color.BLACK);
        agree.setFont("Garamond-30");
        add(agree, 555, 300);
        GLabel No2 = new GLabel("NO");
        No2.setColor(Color.BLACK);
        No2.setFont("Garamond-30");
        add(No2, 125, 300);
        Yes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //remove(pic1);
                nextPhoto();

                if (e.getSource() == Yes) {
                    correct_guesses++;
                    NumPics++;
                    score();


                }
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
                //remove(pic1);
                nextPhoto();
                NumPics++;
                score();


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

    public void score() {
        result = correct_guesses;
        if (NumPics == 6) {
            GLabel point = new GLabel(result + "/6");
            point.setFont("Garamond-30");
            add(point, 615, 67);

        }


    }
}