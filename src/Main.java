import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        new QuizApp();
    }
}


class Question {
    // Assumption is that questions are separated by two line breaks.
    // Each question consists of text lines, first one being the problem statement itself,
    // the next being the index of the correct answer and the rest being the multiple choice options.

    String question;
    ArrayList<String> options;
    int correctAns, userSelection = -1;
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R"};

    static String defaultQuestions = """
            Who was the first president of Zambia?
            0
            Kenneth Kaunda
            Harry Nkumbula
            Simon Mwansa Kapwepwe
            Levy Mwanawasa

            Which European explorer first visited Zambia in 1798?
            3
            David Livingstone
            John Speke
            Vasco da Gama
            Francisco de Lacerda

            The name "Zambia" comes from which river?
            1
            Congo River
            Zambezi River
            Kafue River
            Luangwa River

            Which tribe was dominant in Zambia during the pre-colonial era?
            0
            Bemba
            Ngoni
            Lozi
            Chewa

            Who led the fight for Zambia's independence?
            0
            Kenneth Kaunda
            Harry Nkumbula
            Simon Mwansa Kapwepwe
            Robert Makasa

            In which year did Zambia gain independence?
            1
            1957
            1964
            1970
            1980

            Which mineral was the mainstay of Zambia's economy during colonial times?
            0
            Copper
            Gold
            Silver
            Tin

            The British South Africa Company (BSAC) ruled Zambia as a colony from:
            0
            1890 to 1924
            1900 to 1930
            1895 to 1910
            1888 to 1905

            The Mau Mau rebellion occurred in which year?
            0
            1952
            1960
            1955
            1947

            Who was the leader of the ANC during the struggle for independence?
            0
            Kenneth Kaunda
            Harry Nkumbula
            Simon Mwansa Kapwepwe
            Jason Moyo

            The Federation of Rhodesia and Nyasaland was formed in:
            0
            1953
            1963
            1950
            1948

            The Zambian Kwacha replaced which currency in 1968?
            3
            British Pound
            US Dollar
            South African Rand
            Rhodesian Dollar

            The Freedom Statue in Lusaka commemorates:
            0
            Zambia's independence
            The end of the Cold War
            The fight against apartheid
            The Mau Mau rebellion

            The Barotseland Agreement of 1964 was between:
            2
            Zambia and Britain
            Zambia and South Africa
            Zambia and the Barotse Royal Establishment
            Zambia and the UN

            Who was the first African to visit Europe from Zambia?
            2
            David Livingstone
            Mwata Kazembe
            King Lewanika
            Mpezeni

            The Bemba people migrated to Zambia from:
            1
            Angola
            Congo
            Tanzania
            Mozambique

            The Zambezi River forms the border between Zambia and:
            3
            Zimbabwe
            Botswana
            Namibia
            Mozambique

            The ancient kingdom of Mapungubwe was located in:
            2
            Zambia
            Zimbabwe
            South Africa
            Botswana

            The Zambian national anthem is called:
            3
            Stand and Sing of Zambia
            God Bless Africa
            Free Zambia
            Lumbanyeni

            The University of Zambia was founded in:
            2
            1965
            1970
            1969
            1966

            What was the former name for Kabwe?
            1
            Broken Man
            Broken Hill
            Broken Place
            Sunda Station

            What was the former name for Chipata?
            2
            fort Rosemary
            Fort Martin
            Fort Jameson
            Chipata Extension

            Who killed the Mailon brothers?
            1
            The Neighbors
            Zambian Army
            The police
            Suicide

            What was the first name for Mushala?
            2
            Adam
            Aaron
            Adamson
            Amos

            Who was the oldest from the late Mailon brothers?
            2
            Fabian
            Stephen
            Mika
            Tunde

            Which part of Zambia do we find the Victoria Falls?
            0
            Southern
            Eastern
            Central
            Lusaka

            What tribe celebrates the Likumbi Lya Mize tradition ceremony?
            3
            LOZI
            Ila
            Tonga
            Luvale

            In which year did Zambia experience a coup d'etat?
            0
            1997
            1964
            1992
            1973

            In which year did the famous Zanko Mpundu break the chains?
            1
            1964
            1963
            2001
            1997

            Name the oldest university in Zambia.
            3
            ZCAS
            CBU
            UNILUS
            UNZA

            In which year was the first president of Zambia born?
            1
            1900
            1924
            1964
            1918

            What was the middle name for the late third republican president of Zambia?
            2
            Pule
            Patson
            Patrick
            Prince

            Who was the first female VEEP of Zambia?
            2
            Inonge Wena
            Mutale Nalumango
            Inonge Wina
            Ireen Mambilima

            Who was the leader of the Lumpa Church in Zambia?
            0
            Alice Leshina
            Maino Soko
            Dora Siliya
            Esther Lungu

            Which year did Zambia lift the AFCON?
            3
            2013
            1964
            1990
            2012

            Which Zambian artist met Americans Former President Barrack Obama at the White House?
            3
            Shenky
            Dalitso
            Chef 187
            B flow

            What was the former name for Zambia before independence?
            2
            Southern Rhodesia
            Malawi
            Northern Rhodesia
            East Rhodesia

            Who declared the motto "One Zambia, One Nation"?
            3
            Levy Mwanawasa
            FTJ Chiluba
            Edgar Lungu
            David K Kaunda

            Who declared Zambia as a Christian Nation?
            3
            David  K Kaunda
            Levy Mwanawasa
            Edgar Lungu
            Fredrick Jacob Titus Chiluba

            Who was Zambia's first ever white vice president?
            1
            Lt Barry
            Guy Scott
            David Livingstone
            Mungo Park

            What was the name of the late legend who was best known for singing Kalindula?
            2
            P Jay
            Amayenge
            PK Chishala
            Paul Ngozi

            Name the rule that allows a person to acquire citizenship of ones parents.
            0
            Jus sanguinis
            Jus soli
            Legal aspect
            Rule of residence

            In the 1991 presidential elections, Fredrick Chiluba won the elections with absolute majority. He obtained over 50 percent of the votes cast. Which electoral system was used?
            1
            Mixed Member Proportionality System (MMPS)
            Proportional Representation System(PRS)
            Single Member Majoritarian System (SMMS)
            Single Member Plurality System(SMPS)

            Drugs found in household products such as glue, deodorants like sprays, perfumes and fuel gases are called
            1
            Depressants
            Inhalants
            Narcotics
            Stimulants

            What kind of corruption is associated with the electoral system?
            3
            Economic corruption
            Grand corruption
            Petty corruption
            Political corruption

            Part Ill of the Zambian constitution consists of the.
            1
            Citizenship
            Fundamental rights
            Judicature
            National sovereignty

            Misdemeanors are...
            2
            Crimes of basic intent
            Crimes of specific intent
            Petty crimes
            Serious crimes

            Bobo is fifteen years old and she has been raped repeatedly by her step father since she was ten years old. This form of child abuse is known as child.
            1
            battering
            defilement
            neglect
            prostitution

            When an alien obtains full rights and privileges of a natural citizen of his or her adopted state and there is no discrimination of any sort, the naturalization is said to be.
            0
            Complete
            Neutral
            Partial
            Renounced

            A government which is illegitimate, incompetent, unaccountable and does not respect human rights and the rule of law is an example of.
            1
            Autocracy
            Bad governance
            Good governance
            Monarchy

            One of the processes of a constitution making process is the process of adoption. What does the term adoption mean?
            0
            assume, embrace or take on the constitution.
            amend, change or overhaul the entire constitution.
            reject, disapprove or condemn the constitution.
            take back the constitution to its old form.

            What do you understand by the term 'circulating capital'?
            1
            Money that is acquired after selling goods Money from the general public paid as tax
            Money paid to an insurance company
            Surplus from industries and factories

            The Supreme Court is not a trial court unless the case is a presidential election petition. Instead it hears appeals on....
            1
            Issues of morality other than law
            Issues of legality other than facts
            Questions of facts other than laws
            Questions of law other than facts

            Chipego a pupil Civic Education at Canisius Secondary School was requested to advise on how the property of Mr Hamukoyo his grandfather would be shared to the beneficiaries after he died without leaving a will. What percentage should Chipego advise to be given to Mr Hamukoyo's wife especially that there were no dependents?
            3
            10%
            20%
            30%
            50%

            Peace is very important to human affairs such that without it, development suffers. Which method of promoting peace refers to a way of living and accepting opposing viewpoints whereby people expressing different viewpoints are not condemned and punished?
            3
            Forgiveness
            Justice
            Respect
            Tolerance

            At community level many people experience the adverse effects of HIV/AIDS pandemic. The major social challenge that the disease has paused on the Zambian Society is........
            0
            A lot of resources are spent on looking after the sick
            A lot of girls have gone into prostitution
            Industries and other enterprises lose money
            The emergence of child headed homes

            The optional protocol to the Convention on the Rights of a Child prohibits the following except Child
            3
            Pornography
            Prostitution
            Trafficking
            Welfare

            The Choobe Village headman evicted all non-Tonga speaking people in his village and gave out their land to his relatives and friends. The form of violence is referred to as..
            3
            Gender violence
            Physical violence
            Psychological violence
            Structural violence

            When Botha died, the administrator shared the property according to the will he left. This means he died...
            2
            Interstate
            Testate
            Testator
            Testatrix

            At family level poverty can be defined as the absence of in the family.
            0
            basic needs
            clothes
            реасе
            water

            Which of the following is the correct procedure in the criminal justice process for the first three steps?
            0
            Arrest, Plea, Trial
            Arrest, Trial, Plea
            Trial, Plea, Arrest
            Plea, Trial, Arrest

            A social worker form the Human Rights Commission visited Kasenga Community School Child Rights club and explained to the members that human rights cannot be taken away nor given away and that people have rights even when these are being violated. Which characteristic of human rights explains the above statement?
            2
            Inalienable
            Inherent
            Indivisible
            Interrelated

            Pollution of the air, soil and water is an environmental problem Zambia faces today. This results in the increase of generation of waste due to industrialization and population increase in recent years. Which of the following is directly responsible for the loss of aquatic life?
            1
            Effluents
            Defoliants
            Plant regulator
            Residual charges

            Renunciation means........
            2
            A person living a country which is not his/hers.
            Born and living in a country of one's parents.
            Declaring formally that one will no longer have anything to do with something.
            Duty, support and loyalty one offers to the state.

            The process of lessening the suffering of the poor by meeting their immediate needs is called
            0
            alleviation
            destruction
            eradication
            reduction

            In Zambia's national parks, there are several endangered species (animals). Which of the following is a vulnerable species?
            1
            Black lechwe
            Black rhino
            Elephant
            Wild dog

            What is the capital city of Zambia?
            1
            Harare
            Lusaka
            Pretoria
            Gaborone

            Which river forms part of Zambia’s southern border with Zimbabwe?
            2
            Congo River
            Kafue River
            Zambezi River
            Luangwa River

            What is the most populated city in Zambia?
            2
            Kitwe
            Ndola
            Lusaka
            Livingstone

            What is the provincial capital of Central Province?
            1
            Kabwe
            Ndola
            Mufulira
            Kitwe

            What is Zambia’s main export?
            2
            Gold
            Diamonds
            Copper
            Oil

            What is the official language of Zambia?
            1
            Portuguese
            English
            Swahili
            French

            Which lake is shared by Zambia and Tanzania?
            2
            Lake Mweru
            Lake Victoria
            Lake Tanganyika
            Lake Malawi

            What is the currency of Zambia?
            2
            Zambian dollar
            Zambian pound
            Zambian kwacha
            Zambian shilling

            What is Zambia’s climate type?
            3
            Tundra
            Mediterranean
            Desert
            Tropical

            Which river flows into the Victoria Falls?
            3
            Kafue River
            Luangwa River
            Congo River
            Zambezi River

            What is the highest point in Zambia?
            1
            Kalambo Falls
            Mafinga Central
            Nyika Plateau
            Chisanga Falls

            Which country borders Zambia to the west?
            2
            Mozambique
            Tanzania
            Angola
            Malawi

            What is the largest man made lake in Zambia?
            0
            Lake Tanganyika
            Lake Kariba
            Lake Mweru
            Lake Bangweulu

            What is the primary religion in Zambia?
            1
            Islam
            Christianity
            Buddhism
            Hinduism

            Which city is known as the tourist capital of Zambia?
            1
            Livingstone
            Lusaka
            Kitwe
            Ndola

            What is Zambia's main agricultural product?
            2
            Rice
            Barley
            Maize
            Wheat

            Which waterfall is located on the border between Zambia and Zimbabwe?
            1
            Ngonye Falls
            Victoria Falls
            Lumangwe Falls
            Kalambo Falls

            Which country borders Zambia to the east?
            1
            Namibia
            Malawi
            Botswana
            Tanzania

            Which Zambian River is one of the two largest tributaries of the Zambezi?
            1
            Kafue River
            Congo River
            Lusemfwa River
            Chambeshi River

            What is the name of the longest river in Zambia?
            1
            Zambezi River
            Congo River
            Kafue River
            Luangwa River

            Which Zambian province is Lusaka located in?
            3
            Copperbelt Province
            Eastern Province
            Western Province
            Lusaka Province

            What is the main industry in Zambia?
            2
            Tourism
            Agriculture
            Mining
            Manufacturing

            What body of water is created by the Kariba Dam?
            4
            Lake Malawi
            Lake Tanganyika
            Lake Mweru
            Lake Kariba

            Which Zambian Province is known for its copper mines?
            2
            Lusaka
            Northern
            Copperbelt
            Southern

            Which province in Zambia is known for its tea plantations?
            3
            Western Province
            Eastern Province
            Southern Province
            Luapula Province

            How many languages are in Zambia?
            3
            15
            20
            73
            72

            Which country borders Zambia to the southeast?
            0
            Mozambique
            Botswana
            Namibia
            Zimbabwe

            Which city is located near Victoria Falls in Zambia?
            1
            Lusaka
            Livingstone
            Ndola
            Kitwe

            What tribe performs the Kuomboka ceremony?
            0
            Lozi
            Bemba
            Tonga
            Ngoni

            Which is the smallest province in Zambia by area?
            3
            Copperbelt Province
            Central Province
            Western Province
            Lusaka Province

            Which game park is well known for bird viewing in Zambia?
            3
            Kafue National Park
            North Luangwa National Park
            Lower Zambezi National Park
            Lochinvar National Park

            Which river forms part of Zambia’s northern border with Tanzania?
            2
            Zambezi River
            Luangwa River
            Kalambo River
            Kafue River

            What is Zambia’s main energy source?
            3
            Solar power
            Nuclear power
            Coal
            Hydroelectric power

            Zambia is located in which continent?
            0
            Africa
            Europe
            Asia
            South America

            Which country borders Zambia to the southwest?
            3
            Malawi
            Angola
            Tanzania
            Namibia

            What is a traditional food staple in Zambia?
            3
            Pasta
            Bread
            Rice
            Nshima

            What is the main type of vegetation found in most of Zambia?
            2
            Rainforest
            Desert
            Savannah
            Tundra

            How many provinces does Zambia have?
            3
            12
            13
            7
            10""";

    Question(String question, ArrayList<String> options, int correctAns) {
        this.question = question;
        this.options = options;
        this.correctAns = correctAns;
    }

    public static ArrayList<Question> loadQuestions() {
        ArrayList<Question> data = new ArrayList<>();

        for (String currentQuestionData : Question.defaultQuestions.split("\n\n")) {
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
    WelcomePage welcomePage;
    QuizPage quizPage;
    EndPage endPage;
    CardLayout cardLayout;
    JPanel mainPanel;
    ArrayList<Question> questions;

    int nQuestions = 10;

    public QuizApp() {
        questions = Question.loadQuestions();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);

        welcomePage = new WelcomePage(this);
        quizPage = new QuizPage(this, RandomSelection.getRandomSelection(questions, nQuestions));
        endPage = new EndPage(this);

        // Add the screens with unique identifiers
        this.mainPanel.add(welcomePage, "WelcomePage");
        this.mainPanel.add(quizPage, "QuizPage");
        this.mainPanel.add(endPage, "EndPage");

        this.setSize(800, 600);
        this.setTitle("Zed Quiz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void reset() {
        for (Question question : quizPage.questions) {
            question.userSelection = -1;
        }
        quizPage.currentQuestionIndex = 0;
        quizPage.questions = RandomSelection.getRandomSelection(questions, nQuestions);
        quizPage.updateView();
    }
}


class WelcomePage extends JPanel {
    String title;
    JButton startButton;
    JButton exitButton;
    GridLayout grid;
    QuizApp parentWindow;

    public WelcomePage(QuizApp parentWindow) {
        super();
        this.parentWindow = parentWindow;
        this.title = "Quiz";
        this.startButton = new JButton("Start");
        startButton.addActionListener(e -> this.parentWindow.cardLayout.show(this.parentWindow.mainPanel, "QuizPage"));
        this.exitButton = new JButton("Exit");
        this.grid = new GridLayout(5, 1, 10, 10);

        this.setLayout(grid);  // Set the layout
        this.add(new JLabel()); // Spacer
        this.add(startButton);
        this.add(exitButton);
        this.add(new JLabel()); // Spacer
    }
}


class QuizPage extends JPanel {
    JButton prevButton, nextButton;
    JPanel mainPanel;
    JPanel questionPanel;
    JLabel questionText;
    ArrayList<Question> questions;
    int currentQuestionIndex = 0;
    QuizApp parentWindow;
    JPanel bottomBar;

    public QuizPage(QuizApp parentWindow, ArrayList<Question> questions) {
        // Initialize fields
        nextButton = new JButton();
        nextButton.addActionListener(e -> {});
        nextButton.setEnabled(false);
        prevButton = new JButton("Previous");
        questionText = new JLabel("- Question not yet loaded -");
        questionPanel = new JPanel();
//        userSelections = new ArrayList<>();

        prevButton.addActionListener(e -> toPreviousQuestion());
        bottomBar = new JPanel( new GridLayout(1, 2));
        bottomBar.add(prevButton);
        bottomBar.add(nextButton);
        this.questions = questions;
        this.parentWindow = parentWindow;

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(questionText, BorderLayout.NORTH);
        mainPanel.add(questionPanel, BorderLayout.CENTER);
        mainPanel.add(bottomBar, BorderLayout.SOUTH);

        this.add(mainPanel);


        this.updateView();
    }

    void updateView() {
        /* Control the state of the 'next' button, disabling it if either an active option hasn't been selected
        *  or there is nothing next.
        * Display the current question on the screen.
        * */

        Question currentQuestion = questions.get(currentQuestionIndex);

        questionText.setText(currentQuestionIndex + 1 + ". "+ currentQuestion.question);

        // Empty the existing multiple choice options
        mainPanel.remove(questionPanel); // Remove the center component
        mainPanel.revalidate(); // Revalidate the panel
        mainPanel.repaint(); // Repaint the panel

        questionPanel = new JPanel(new GridLayout(currentQuestion.options.size(), 1));

        mainPanel.add(questionPanel, BorderLayout.CENTER);

        // Create button group for radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();

        // Add the radio buttons
        for (int optionIndex = 0; optionIndex < currentQuestion.options.size(); optionIndex++) {
            int finalOptionIndex = optionIndex;

            JRadioButton radioButton = new JRadioButton(currentQuestion.options.get(optionIndex));

            // Add the radiobutton to the panel
            questionPanel.add(radioButton);

            // Restore user's last selection
            radioButton.setSelected(questions.get(currentQuestionIndex).userSelection == optionIndex &&
                    questions.get(currentQuestionIndex).userSelection != -1);

            radioButton.addActionListener(e -> {
                // Enable the next button
                nextButton.setEnabled(true);

                radioButton.revalidate();

                // Update the user selection
//                userSelections.set(currentQuestionIndex, finalOptionIndex);
                questions.get(currentQuestionIndex).userSelection = finalOptionIndex;

                // Add the button to the button group
                buttonGroup.add(radioButton);
            });

        }

        // Update the text and functionality of the 'next' button
        if (currentQuestionIndex == questions.size() - 1) {
            nextButton.setText("Finish");
            nextButton.removeActionListener(nextButton.getActionListeners()[0]);
            nextButton.addActionListener(e -> toEndOfQuiz());
        }
        else {
            nextButton.setText("Next");
            nextButton.removeActionListener(nextButton.getActionListeners()[0]);
            nextButton.addActionListener(e -> toNextQuestion());
        }
//        nextButton.setEnabled(userSelections.get(currentQuestionIndex) != -1);
        nextButton.setEnabled(questions.get(currentQuestionIndex).userSelection != -1);
        prevButton.setEnabled(currentQuestionIndex > 0);
    }

    void toNextQuestion() {

        // Check if there's room to go to the next question
        if (currentQuestionIndex < questions.size() - 1) {
            // increment the current index
            this.currentQuestionIndex += 1;
        }
        updateView();
    }

    void toPreviousQuestion() {
        // Check if there's room to go to the previous question
        if (currentQuestionIndex > 0) {
            // decrement the current index
            this.currentQuestionIndex -= 1;
        }
        updateView();
    }

    void toEndOfQuiz() {
        this.parentWindow.cardLayout.show(this.parentWindow.mainPanel, "EndPage");
        parentWindow.endPage.updateText();
    }
}


class EndPage extends JPanel {
    QuizApp parentWindow;
    JPanel mainPanel;
    JLabel resultsLabel;
    JButton restartButton;

    public EndPage(QuizApp parentWindow) {
        this.parentWindow = parentWindow;
        resultsLabel = new JLabel();
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(resultsLabel, BorderLayout.NORTH);
        restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> {
            parentWindow.cardLayout.show(parentWindow.mainPanel, "WelcomePage");
            parentWindow.reset();
        });
        mainPanel.add(restartButton);
        add(mainPanel);
    }

    public void updateText() {
        resultsLabel.setText("You got " + getRight() + "/" + parentWindow.quizPage.questions.size() + " correct");}

    int getRight() {
        int right = 0;
        for (Question question : parentWindow.quizPage.questions) {
            if (question.userSelection == question.correctAns)
                right += 1;
        }
        return right;
    }
}


class RandomSelection {

    public static <T> ArrayList<T> getRandomSelection(List<T> list, int n) {
        if (n > list.size()) {
            throw new IllegalArgumentException("n is larger than the list size.");
        }

        List<T> shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);

        return new ArrayList<>(shuffledList.subList(0, n));
    }
}
