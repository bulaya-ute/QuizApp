import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        new QuizApp();
    }
}


class QuestionData {
    static String questionsData =
            """
                    Who was the first president of Zambia?
                    0
                    Kenneth Kaunda
                    Harry Nkumbula
                    Simon Mwansa Kapwepwe
                    Levy Mwanawasa

                    Which European explorer first visited Zambia in 1798?
                    2
                    David Livingstone
                    John Speke
                    Vasco da Gama
                    Francisco de Lacerda

                    The name "Zambia" comes from which river?
                    3
                    Congo River
                    Zambezi River
                    Kafue River
                    Luangwa River""";
}


class Question {
    String question;
    ArrayList<String> options;
    int correctAns;
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R"};

    Question(String question, ArrayList<String> options, int correctAns) {
        this.question = question;
        this.options = options;
        this.correctAns = correctAns;
    }

    public static ArrayList<Question> loadQuestions(String text) {
        // Assumption is that questions are separated by two blank lines
        // EAch question consists of 5 lines, first one being the question itself
        // and the rest being the options.
        ArrayList<Question> data = new ArrayList<Question>();

        for (String currentQuestionData : text.split("\n\n")) {
            String[] lines = currentQuestionData.split("\n");
            ArrayList<String> options = new ArrayList<>(Arrays.asList(lines).subList(2, lines.length));
            Question currentQuestion = new Question(lines[0], options, Integer.parseInt(lines[1]));
            data.add(currentQuestion);
        }

        return data;

    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append(this.question).append("\n");
        for (int i = 0; i < this.options.size(); i++) {
            data.append(this.letters[i]).append(") ").append(this.options.get(i)).append("\n");
        }
        return data.toString();
    }
}


class QuizApp extends JFrame {
    JPanel welcomePage, quizPage, settingsScreen;
    CardLayout  cardLayout;
    JPanel mainPanel;

    public QuizApp() {
        this.welcomePage = new WelcomePage(this);
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);

        this.add(mainPanel);

        // Add the screens
        this.mainPanel.add(welcomePage);
//        this.mainPanel.add(quizPage);
//        this.mainPanel.add(settingsScreen);

        this.setSize(800, 600);
        this.setTitle("Zed Quiz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}


class WelcomePage extends JPanel {
    String title;
    JButton startButton;
    JButton helpButton;
    JButton exitButton;
    GridLayout grid;
    JFrame parentWindow;

    public WelcomePage(JFrame parentWindow) {
        super();
        this.parentWindow = parentWindow;
        this.title = "Quiz";
        this.startButton = new JButton("Start");
        this.helpButton = new JButton("Help");
        this.exitButton = new JButton("Exit");
        this.grid = new GridLayout(5, 1, 10, 10);

        this.setLayout(grid);  // Set the layout
        this.add(new JLabel()); // Spacer
        this.add(startButton);
        this.add(helpButton);
        this.add(exitButton);
        this.add(new JLabel()); // Spacer
    }
}


class QuizPage extends JPanel {
    public QuizPage() {

    }
}


class SettingsPage extends JPanel {
    public SettingsPage() {

    }
}
