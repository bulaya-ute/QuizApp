import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
    }
}


class Question {
    String question, optionA, optionB, optionC, optionD, correctAns;

    Question(String question, String optionA, String optionB, String optionC, String optionD,
             String correctAns) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAns = correctAns;
    }

    public static loadQuestions(String text) {
        // Assumption is that questions are separated by two blank lines
        // EAch question consists of 5 lines, first one being the question itself
        // and the rest being the options.
    }
}


class Window {
    // This approach doesn't extend the JFrame class. Instead, it creates and instance
    // of the JFrame class and calls its methods.
    // It is more preferable in my opinion, no stress with accessing superclass entities.
    JFrame jFrame = new JFrame();
    JButton jButton = new JButton("Click Me!");
    JPanel jPanel = new JPanel(new BorderLayout());  // Specify the layout of this panel
    JLabel label = new JLabel("New label");


    public Window() {
        jFrame.setSize(800, 600);
        jFrame.setTitle("My first GUI application");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        jPanel.add(jButton, BorderLayout.EAST);
        jPanel.add(this.label, "North");

        jFrame.setVisible(true);
    }
}
