import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Identification2 extends JPanel implements ActionListener {


    String[] questions = 	{
            "Is this a scam?","Is this a scam?","Is this a scam?","Is this a scam?","Is this a scam?","Is this a scam?"
    };
    String[][] options = 	{

    };
    String[] answers = 		{
            "YES",
            "YES",
            "YES",
            "YES",
            "YES",
            "YES"
    };
    char guess;
    String answer;
    int index;
    int correct_guesses =0;
    int total_questions = questions.length;
    int result;
    private int num = 1;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonYES = new JButton();
    JButton buttonNO = new JButton();

    JLabel answer_labelYES = new JLabel();
    JLabel answer_labelNO = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    JLabel pic1 = new JLabel();
    JLabel pic2 = new JLabel();
    JLabel pic3 = new JLabel();
    JLabel pic4 = new JLabel();
    JLabel pic5 = new JLabel();
    JLabel pic6 = new JLabel();

    JPanel holder = new JPanel();
    private JLabel label;

    private void setImg(String file, JLabel l) {
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File(file));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Image img = bimg.getScaledInstance(300,300,Image.SCALE_FAST);
        l.setIcon(new ImageIcon(img));
    }

    public Identification2() {
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(0,0,1000,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Garamond",Font.BOLD,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0,50,1000,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("Garamond",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonYES.setBounds(650,600,100,100);
        buttonYES.setFont(new Font("Garamond",Font.BOLD,35));
        buttonYES.setFocusable(false);
        buttonYES.addActionListener(this);
        buttonYES.setText("YES");

        buttonNO.setBounds(150,600,100,100);
        buttonNO.setFont(new Font("Garamond",Font.BOLD,35));
        buttonNO.setFocusable(false);
        buttonNO.addActionListener(this);
        buttonNO.setText("NO");



        answer_labelYES.setBounds(125,100,1000,100);
        answer_labelYES.setBackground(new Color(50,50,50));
        answer_labelYES.setForeground(new Color(25,255,0));
        answer_labelYES.setFont(new Font("Times new roman",Font.PLAIN,20));

        answer_labelNO.setBounds(125,200,1000,100);
        answer_labelNO.setBackground(new Color(50,50,50));
        answer_labelNO.setForeground(new Color(25,255,0));
        answer_labelNO.setFont(new Font("Times new roman",Font.PLAIN,20));


        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Times new roman",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        holder.setBounds(230,200,500,300);
        holder.setBackground(new Color(25,25,25));
        holder.setForeground(new Color(25,255,0));
        holder.setBorder(BorderFactory.createBevelBorder(1));

        pic1.setBounds(230,200,1000,100);
        pic1.setVisible(true);
        pic2.setBounds(230,200,500,300);
        pic2.setVisible(true);
        pic3.setBounds(230,200,500,300);
        pic3.setVisible(true);
        pic4.setBounds(230,200,500,300);
        pic4.setVisible(true);
        pic5.setBounds(230,200,500,300);
        pic5.setVisible(true);
        pic6.setBounds(230,200,500,300);

        JPanel panel = (JPanel)frame.getContentPane();

        JLabel label = new JLabel();

        int i=2;

        String file = "assets/Identification/" + i + ".jpg";

        setImg(file, label);

        panel.add(label);

        frame.setLocationRelativeTo(null);


        frame.setContentPane(panel);
        panel.revalidate();
        frame.repaint();


        frame.add(answer_labelYES);
        frame.add(answer_labelNO);
        frame.add(buttonYES);
        frame.add(buttonNO);

        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);
        frame.add(holder);


        nextQuestion();


    }
    private void nextPhoto() {
        num++;
        drawImages(num);
    }
    private void drawImages(int picNum) {
        switch (picNum) {
            case 1 -> {
                pic1.setIcon(new ImageIcon("C:\\Users\\Mashuu\\IdeaProjects\\otherquiez\\assets\\Identification\\1.jpg"));
                pic1.setBounds(230,200,200,400);
                pic1.setVisible(true);
                holder.add(pic1);
            }
            case 2 -> {
                pic2.setIcon(new ImageIcon("C:\\Users\\Mashuu\\IdeaProjects\\otherquiez\\assets\\Identification\\2.jpg"));
                pic2.setBounds(230,200,200,400);
                pic2.setVisible(true);
                holder.add(pic2);
            }
            case 3 -> {
                pic3.setIcon(new ImageIcon("C:\\Users\\Mashuu\\IdeaProjects\\otherquiez\\assets\\Identification\\3.jpg"));
                pic3.setBounds(230,200,200,400);
                pic3.setVisible(true);
                holder.add(pic3);
            }
            case 4 -> {
                pic4.setIcon(new ImageIcon("C:\\Users\\Mashuu\\IdeaProjects\\otherquiez\\assets\\Identification\\4.jpg"));
                pic4.setBounds(230,200,200,400);
                pic4.setVisible(true);
                holder.add(pic4);
            }
            case 5 -> {
                pic5.setIcon(new ImageIcon("C:\\Users\\Mashuu\\IdeaProjects\\otherquiez\\assets\\Identification\\5.jpg"));
                pic5.setBounds(230,200,200,400);
                pic5.setVisible(true);
                holder.add(pic5);

            }
            case 6 -> {
                pic6.setIcon(new ImageIcon("C:\\Users\\Mashuu\\IdeaProjects\\otherquiez\\assets\\Identification\\6.jpg"));
                pic6.setBounds(230,200,200,400);
                pic6.setVisible(true);
                holder.add(pic6);
            }
        }
    }




    public void nextQuestion() {

        if(index>=total_questions) {
            results();
        }
        else {
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelYES.setText(options[index][0]);
            answer_labelNO.setText(options[index][1]);


        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        buttonYES.setEnabled(false);
        buttonNO.setEnabled(false);


        if(e.getSource()==buttonYES) {
            answer= "YES";
            nextPhoto();
            if(answer == answers[index]) {
                correct_guesses++;
                nextPhoto();
            }
        }
        if(e.getSource()==buttonNO) {
            answer= "NO";
            nextPhoto();
            if(answer == answers[index]) {
                correct_guesses++;
                nextPhoto();
            }
        }

        displayAnswer();
    }
    public void displayAnswer() {



        buttonYES.setEnabled(false);
        buttonNO.setEnabled(false);


        if(answers[index] != "YES")
            answer_labelYES.setForeground(new Color(255,0,0));
        if(answers[index] != "NO")
            answer_labelNO.setForeground(new Color(255,0,0));


        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelYES.setForeground(new Color(25,255,0));
                answer_labelNO.setForeground(new Color(25,255,0));


                answer = "";

                buttonYES.setEnabled(true);
                buttonNO.setEnabled(true);

                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results(){

        buttonYES.setEnabled(false);
        buttonNO.setEnabled(false);


        result = (int)((correct_guesses/(double)total_questions)*100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelYES.setText("");
        answer_labelNO.setText("");


        number_right.setText("("+correct_guesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        frame.add(number_right);
        frame.add(percentage);

    }
    public static void main (String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DisplayImage();
            }
        });
    }
}
