import acm.graphics.GCanvas;
import acm.graphics.GLabel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HangmanCanvas extends GCanvas {
    private static final int TEXT_HEIGHT = 17;   // you can modify this to suit your ascii art
    private static final int TEXT_X_OFFSET = 12;   // you can modify this to suit your ascii art
    private int textX;
    private int textY;
    //Resets the display so that only the hangman scaffold appears
    public void reset() {
        removeAll();
        GLabel testMessage = new GLabel("Welcome to Hangman!");
        testMessage.setFont("LucidaConsole");
        textX = TEXT_X_OFFSET;
        textY = TEXT_HEIGHT;
        add(testMessage,  textX , textY);
        GLabel nextMessage = new GLabel("");
        textY += TEXT_HEIGHT;
        add(nextMessage,  textX , textY );
    }

    public void printText(String text){
        GLabel line = new GLabel(text);
        line.setFont("LucidaConsole");
        textY += TEXT_HEIGHT;
        add(line,  textX , textY );
    }

    public void displayHangman(int guessCount) {
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("assets/Hangman/display"+guessCount+".txt"));
            String line;
            while ((line = buffer.readLine()) != null) {
                printText(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}