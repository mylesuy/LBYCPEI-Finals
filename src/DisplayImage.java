import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DisplayImage {

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

    public DisplayImage() {
        JFrame frame = new JFrame("Identification");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel)frame.getContentPane();

        JLabel label = new JLabel();

        int i=2;

        String file = "assets/Identification/" + i + ".jpg";

        setImg(file, label);

        panel.add(label);

        frame.setLocationRelativeTo(null);
        frame.setSize(500,400);
        frame.setVisible(true);
        frame.setResizable(false);

        frame.setContentPane(panel);
        panel.revalidate();
        frame.repaint();
    }

    public static void main (String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DisplayImage();
            }
        });
    }
}