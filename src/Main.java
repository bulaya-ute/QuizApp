import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    int correctAns, response;
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
    JPanel welcomePage, quizPage, helpPage, endPage;
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
    JButton prevButton, nextButton;
    JPanel mainPanel;
    JPanel questionPanel;
    JLabel questionText;
    ArrayList<JLabel> options;
    ArrayList<Question> questions;
    int currentIndex = 0;
    QuizApp parentWindow;

    public QuizPage(QuizApp parentWindow, ArrayList<Question> questions) {
        this.questions = questions;
        this.parentWindow = parentWindow;
        prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toPreviousQuestion();
            }
        });

        this.updateView();
    }

    boolean isOnLastQuestion() {
        return currentIndex >= questions.size() - 1;
    }

    void updateView() {
        if (this.isOnLastQuestion()) {
            nextButton.setText("Finish");
            nextButton.removeActionListener(nextButton.getActionListeners()[0]);
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    toEndOfQuiz();
                }
            });
        } else {
            nextButton.setText("Next");
            nextButton.removeActionListener(nextButton.getActionListeners()[0]);
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    toNextQuestion();
                }
            });
        }
    }

    void toNextQuestion() {
        System.out.println("Next question");

        // Disable the next button. It will be re-enabled by clicking one of the multiple-choice
        // options
        nextButton.setEnabled(false);

        // Check if there's room to go to the next question
        if (currentIndex < questions.size() - 2) {
            // increment the current index
            this.currentIndex += 1;
        }
    }
    void toPreviousQuestion() {
        System.out.println("Previous question");
        // Check if there's room to go to the previous question
        if (currentIndex > 0) {
            // decrement the current index
            this.currentIndex -= 1;
        }
    }
    void toEndOfQuiz() {
        System.out.println("End quiz");
        this.parentWindow.cardLayout.show(this.parentWindow.endPage, "End of quiz");

    }
}


class HelpPage extends JPanel {
    QuizApp parentWindow;
    public HelpPage(QuizApp parentWindow) {
        this.parentWindow = parentWindow;
    }
}
