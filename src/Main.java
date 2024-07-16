import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


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

    static String defaultQuestions = "Who was the first president of Zambia?\n" +
            "0\n" +
            "Kenneth Kaunda\n" +
            "Harry Nkumbula\n" +
            "Simon Mwansa Kapwepwe\n" +
            "Levy Mwanawasa\n" +
            "\n" +
            "Which European explorer first visited Zambia in 1798?\n" +
            "3\n" +
            "David Livingstone\n" +
            "John Speke\n" +
            "Vasco da Gama\n" +
            "Francisco de Lacerda\n" +
            "\n" +
            "The name \"Zambia\" comes from which river?\n" +
            "1\n" +
            "Congo River\n" +
            "Zambezi River\n" +
            "Kafue River\n" +
            "Luangwa River\n" +
            "\n" +
            "Which tribe was dominant in Zambia during the pre-colonial era?\n" +
            "0\n" +
            "Bemba\n" +
            "Ngoni\n" +
            "Lozi\n" +
            "Chewa\n" +
            "\n" +
            "Who led the fight for Zambia's independence?\n" +
            "0\n" +
            "Kenneth Kaunda\n" +
            "Harry Nkumbula\n" +
            "Simon Mwansa Kapwepwe\n" +
            "Robert Makasa\n" +
            "\n" +
            "In which year did Zambia gain independence?\n" +
            "1\n" +
            "1957\n" +
            "1964\n" +
            "1970\n" +
            "1980\n" +
            "\n" +
            "Which mineral was the mainstay of Zambia's economy during colonial times?\n" +
            "0\n" +
            "Copper\n" +
            "Gold\n" +
            "Silver\n" +
            "Tin\n" +
            "\n" +
            "The British South Africa Company (BSAC) ruled Zambia as a colony from:\n" +
            "0\n" +
            "1890 to 1924\n" +
            "1900 to 1930\n" +
            "1895 to 1910\n" +
            "1888 to 1905\n" +
            "\n" +
            "The Mau Mau rebellion occurred in which year?\n" +
            "0\n" +
            "1952\n" +
            "1960\n" +
            "1955\n" +
            "1947\n" +
            "\n" +
            "Who was the leader of the ANC during the struggle for independence?\n" +
            "0\n" +
            "Kenneth Kaunda\n" +
            "Harry Nkumbula\n" +
            "Simon Mwansa Kapwepwe\n" +
            "Jason Moyo\n" +
            "\n" +
            "The Federation of Rhodesia and Nyasaland was formed in:\n" +
            "0\n" +
            "1953\n" +
            "1963\n" +
            "1950\n" +
            "1948\n" +
            "\n" +
            "The Zambian Kwacha replaced which currency in 1968?\n" +
            "3\n" +
            "British Pound\n" +
            "US Dollar\n" +
            "South African Rand\n" +
            "Rhodesian Dollar\n" +
            "\n" +
            "The Freedom Statue in Lusaka commemorates:\n" +
            "0\n" +
            "Zambia's independence\n" +
            "The end of the Cold War\n" +
            "The fight against apartheid\n" +
            "The Mau Mau rebellion\n" +
            "\n" +
            "The Barotseland Agreement of 1964 was between:\n" +
            "2\n" +
            "Zambia and Britain\n" +
            "Zambia and South Africa\n" +
            "Zambia and the Barotse Royal Establishment\n" +
            "Zambia and the UN\n" +
            "\n" +
            "Who was the first African to visit Europe from Zambia?\n" +
            "2\n" +
            "David Livingstone\n" +
            "Mwata Kazembe\n" +
            "King Lewanika\n" +
            "Mpezeni\n" +
            "\n" +
            "The Bemba people migrated to Zambia from:\n" +
            "1\n" +
            "Angola\n" +
            "Congo\n" +
            "Tanzania\n" +
            "Mozambique\n" +
            "\n" +
            "The Zambezi River forms the border between Zambia and:\n" +
            "3\n" +
            "Zimbabwe\n" +
            "Botswana\n" +
            "Namibia\n" +
            "Mozambique\n" +
            "\n" +
            "The ancient kingdom of Mapungubwe was located in:\n" +
            "2\n" +
            "Zambia\n" +
            "Zimbabwe\n" +
            "South Africa\n" +
            "Botswana\n" +
            "\n" +
            "The Zambian national anthem is called:\n" +
            "3\n" +
            "Stand and Sing of Zambia\n" +
            "God Bless Africa\n" +
            "Free Zambia\n" +
            "Lumbanyeni\n" +
            "\n" +
            "The University of Zambia was founded in:\n" +
            "2\n" +
            "1965\n" +
            "1970\n" +
            "1969\n" +
            "1966\n" +
            "\n" +
            "What was the former name for Kabwe?\n" +
            "1\n" +
            "Broken Man\n" +
            "Broken Hill\n" +
            "Broken Place\n" +
            "Sunda Station\n" +
            "\n" +
            "What was the former name for Chipata?\n" +
            "2\n" +
            "fort Rosemary\n" +
            "Fort Martin\n" +
            "Fort Jameson\n" +
            "Chipata Extension\n" +
            "\n" +
            "Who killed the Mailon brothers?\n" +
            "1\n" +
            "The Neighbors\n" +
            "Zambian Army\n" +
            "The police\n" +
            "Suicide\n" +
            "\n" +
            "What was the first name for Mushala?\n" +
            "2\n" +
            "Adam\n" +
            "Aaron\n" +
            "Adamson\n" +
            "Amos\n" +
            "\n" +
            "Who was the oldest from the late Mailon brothers?\n" +
            "2\n" +
            "Fabian\n" +
            "Stephen\n" +
            "Mika\n" +
            "Tunde\n" +
            "\n" +
            "Which part of Zambia do we find the Victoria Falls?\n" +
            "0\n" +
            "Southern\n" +
            "Eastern\n" +
            "Central\n" +
            "Lusaka\n" +
            "\n" +
            "What tribe celebrates the Likumbi Lya Mize tradition ceremony?\n" +
            "3\n" +
            "LOZI\n" +
            "Ila\n" +
            "Tonga\n" +
            "Luvale\n" +
            "\n" +
            "In which year did Zambia experience a coup d'etat?\n" +
            "0\n" +
            "1997\n" +
            "1964\n" +
            "1992\n" +
            "1973\n" +
            "\n" +
            "In which year did the famous Zanko Mpundu break the chains?\n" +
            "1\n" +
            "1964\n" +
            "1963\n" +
            "2001\n" +
            "1997\n" +
            "\n" +
            "Name the oldest university in Zambia.\n" +
            "3\n" +
            "ZCAS\n" +
            "CBU\n" +
            "UNILUS\n" +
            "UNZA\n" +
            "\n" +
            "In which year was the first president of Zambia born?\n" +
            "1\n" +
            "1900\n" +
            "1924\n" +
            "1964\n" +
            "1918\n" +
            "\n" +
            "What was the middle name for the late third republican president of Zambia?\n" +
            "2\n" +
            "Pule\n" +
            "Patson\n" +
            "Patrick\n" +
            "Prince\n" +
            "\n" +
            "Who was the first female VEEP of Zambia?\n" +
            "2\n" +
            "Inonge Wena\n" +
            "Mutale Nalumango\n" +
            "Inonge Wina\n" +
            "Ireen Mambilima\n" +
            "\n" +
            "Who was the leader of the Lumpa Church in Zambia?\n" +
            "0\n" +
            "Alice Leshina\n" +
            "Maino Soko\n" +
            "Dora Siliya\n" +
            "Esther Lungu\n" +
            "\n" +
            "Which year did Zambia lift the AFCON?\n" +
            "3\n" +
            "2013\n" +
            "1964\n" +
            "1990\n" +
            "2012\n" +
            "\n" +
            "Which Zambian artist met Americans Former President Barrack Obama at the White House?\n" +
            "3\n" +
            "Shenky\n" +
            "Dalitso\n" +
            "Chef 187\n" +
            "B flow\n" +
            "\n" +
            "What was the former name for Zambia before independence?\n" +
            "2\n" +
            "Southern Rhodesia\n" +
            "Malawi\n" +
            "Northern Rhodesia\n" +
            "East Rhodesia\n" +
            "\n" +
            "Who declared the motto \"One Zambia, One Nation\"?\n" +
            "3\n" +
            "Levy Mwanawasa\n" +
            "FTJ Chiluba\n" +
            "Edgar Lungu\n" +
            "David K Kaunda\n" +
            "\n" +
            "Who declared Zambia as a Christian Nation?\n" +
            "3\n" +
            "David  K Kaunda\n" +
            "Levy Mwanawasa\n" +
            "Edgar Lungu\n" +
            "Fredrick Jacob Titus Chiluba\n" +
            "\n" +
            "Who was Zambia's first ever white vice president?\n" +
            "1\n" +
            "Lt Barry\n" +
            "Guy Scott\n" +
            "David Livingstone\n" +
            "Mungo Park\n" +
            "\n" +
            "What was the name of the late legend who was best known for singing Kalindula?\n" +
            "2\n" +
            "P Jay\n" +
            "Amayenge\n" +
            "PK Chishala\n" +
            "Paul Ngozi\n" +
            "\n" +
            "Name the rule that allows a person to acquire citizenship of ones parents.\n" +
            "0\n" +
            "Jus sanguinis\n" +
            "Jus soli\n" +
            "Legal aspect\n" +
            "Rule of residence\n" +
            "\n" +
            "In the 1991 presidential elections, Fredrick Chiluba won the elections with absolute majority. He obtained over 50 percent of the votes cast. Which electoral system was used?\n" +
            "1\n" +
            "Mixed Member Proportionality System (MMPS)\n" +
            "Proportional Representation System(PRS)\n" +
            "Single Member Majoritarian System (SMMS)\n" +
            "Single Member Plurality System(SMPS)\n" +
            "\n" +
            "Drugs found in household products such as glue, deodorants like sprays, perfumes and fuel gases are called\n" +
            "1\n" +
            "Depressants\n" +
            "Inhalants\n" +
            "Narcotics\n" +
            "Stimulants\n" +
            "\n" +
            "What kind of corruption is associated with the electoral system?\n" +
            "3\n" +
            "Economic corruption\n" +
            "Grand corruption\n" +
            "Petty corruption\n" +
            "Political corruption\n" +
            "\n" +
            "Part Ill of the Zambian constitution consists of the.\n" +
            "1\n" +
            "Citizenship\n" +
            "Fundamental rights\n" +
            "Judicature\n" +
            "National sovereignty\n" +
            "\n" +
            "Misdemeanors are...\n" +
            "2\n" +
            "Crimes of basic intent\n" +
            "Crimes of specific intent\n" +
            "Petty crimes\n" +
            "Serious crimes\n" +
            "\n" +
            "Bobo is fifteen years old and she has been raped repeatedly by her step father since she was ten years old. This form of child abuse is known as child.\n" +
            "1\n" +
            "battering\n" +
            "defilement\n" +
            "neglect\n" +
            "prostitution\n" +
            "\n" +
            "When an alien obtains full rights and privileges of a natural citizen of his or her adopted state and there is no discrimination of any sort, the naturalization is said to be.\n" +
            "0\n" +
            "Complete\n" +
            "Neutral\n" +
            "Partial\n" +
            "Renounced\n" +
            "\n" +
            "A government which is illegitimate, incompetent, unaccountable and does not respect human rights and the rule of law is an example of.\n" +
            "1\n" +
            "Autocracy\n" +
            "Bad governance\n" +
            "Good governance\n" +
            "Monarchy\n" +
            "\n" +
            "One of the processes of a constitution making process is the process of adoption. What does the term adoption mean?\n" +
            "0\n" +
            "assume, embrace or take on the constitution.\n" +
            "amend, change or overhaul the entire constitution.\n" +
            "reject, disapprove or condemn the constitution.\n" +
            "take back the constitution to its old form.\n" +
            "\n" +
            "What do you understand by the term 'circulating capital'?\n" +
            "1\n" +
            "Money that is acquired after selling goods Money from the general public paid as tax\n" +
            "Money paid to an insurance company\n" +
            "Surplus from industries and factories\n" +
            "\n" +
            "The Supreme Court is not a trial court unless the case is a presidential election petition. Instead it hears appeals on....\n" +
            "1\n" +
            "Issues of morality other than law\n" +
            "Issues of legality other than facts\n" +
            "Questions of facts other than laws\n" +
            "Questions of law other than facts\n" +
            "\n" +
            "Chipego a pupil Civic Education at Canisius Secondary School was requested to advise on how the property of Mr Hamukoyo his grandfather would be shared to the beneficiaries after he died without leaving a will. What percentage should Chipego advise to be given to Mr Hamukoyo's wife especially that there were no dependents?\n" +
            "3\n" +
            "10%\n" +
            "20%\n" +
            "30%\n" +
            "50%\n" +
            "\n" +
            "Peace is very important to human affairs such that without it, development suffers. Which method of promoting peace refers to a way of living and accepting opposing viewpoints whereby people expressing different viewpoints are not condemned and punished?\n" +
            "3\n" +
            "Forgiveness\n" +
            "Justice\n" +
            "Respect\n" +
            "Tolerance\n" +
            "\n" +
            "At community level many people experience the adverse effects of HIV/AIDS pandemic. The major social challenge that the disease has paused on the Zambian Society is........\n" +
            "0\n" +
            "A lot of resources are spent on looking after the sick\n" +
            "A lot of girls have gone into prostitution\n" +
            "Industries and other enterprises lose money\n" +
            "The emergence of child headed homes\n" +
            "\n" +
            "The optional protocol to the Convention on the Rights of a Child prohibits the following except Child\n" +
            "3\n" +
            "Pornography\n" +
            "Prostitution\n" +
            "Trafficking\n" +
            "Welfare\n" +
            "\n" +
            "The Choobe Village headman evicted all non-Tonga speaking people in his village and gave out their land to his relatives and friends. The form of violence is referred to as..\n" +
            "3\n" +
            "Gender violence\n" +
            "Physical violence\n" +
            "Psychological violence\n" +
            "Structural violence\n" +
            "\n" +
            "When Botha died, the administrator shared the property according to the will he left. This means he died...\n" +
            "2\n" +
            "Interstate\n" +
            "Testate\n" +
            "Testator\n" +
            "Testatrix\n" +
            "\n" +
            "At family level poverty can be defined as the absence of in the family.\n" +
            "0\n" +
            "basic needs\n" +
            "clothes\n" +
            "реасе\n" +
            "water\n" +
            "\n" +
            "Which of the following is the correct procedure in the criminal justice process for the first three steps?\n" +
            "0\n" +
            "Arrest, Plea, Trial\n" +
            "Arrest, Trial, Plea\n" +
            "Trial, Plea, Arrest\n" +
            "Plea, Trial, Arrest\n" +
            "\n" +
            "A social worker form the Human Rights Commission visited Kasenga Community School Child Rights club and explained to the members that human rights cannot be taken away nor given away and that people have rights even when these are being violated. Which characteristic of human rights explains the above statement?\n" +
            "2\n" +
            "Inalienable\n" +
            "Inherent\n" +
            "Indivisible\n" +
            "Interrelated\n" +
            "\n" +
            "Pollution of the air, soil and water is an environmental problem Zambia faces today. This results in the increase of generation of waste due to industrialization and population increase in recent years. Which of the following is directly responsible for the loss of aquatic life?\n" +
            "1\n" +
            "Effluents\n" +
            "Defoliants\n" +
            "Plant regulator\n" +
            "Residual charges\n" +
            "\n" +
            "Renunciation means........\n" +
            "2\n" +
            "A person living a country which is not his/hers.\n" +
            "Born and living in a country of one's parents.\n" +
            "Declaring formally that one will no longer have anything to do with something.\n" +
            "Duty, support and loyalty one offers to the state.\n" +
            "\n" +
            "The process of lessening the suffering of the poor by meeting their immediate needs is called\n" +
            "0\n" +
            "alleviation\n" +
            "destruction\n" +
            "eradication\n" +
            "reduction\n" +
            "\n" +
            "In Zambia's national parks, there are several endangered species (animals). Which of the following is a vulnerable species?\n" +
            "1\n" +
            "Black lechwe\n" +
            "Black rhino\n" +
            "Elephant\n" +
            "Wild dog\n" +
            "\n" +
            "What is the capital city of Zambia?\n" +
            "1\n" +
            "Harare\n" +
            "Lusaka\n" +
            "Pretoria\n" +
            "Gaborone\n" +
            "\n" +
            "Which river forms part of Zambia’s southern border with Zimbabwe?\n" +
            "2\n" +
            "Congo River\n" +
            "Kafue River\n" +
            "Zambezi River\n" +
            "Luangwa River\n" +
            "\n" +
            "What is the most populated city in Zambia?\n" +
            "2\n" +
            "Kitwe\n" +
            "Ndola\n" +
            "Lusaka\n" +
            "Livingstone\n" +
            "\n" +
            "What is the provincial capital of Central Province?\n" +
            "1\n" +
            "Kabwe\n" +
            "Ndola\n" +
            "Mufulira\n" +
            "Kitwe\n" +
            "\n" +
            "What is Zambia’s main export?\n" +
            "2\n" +
            "Gold\n" +
            "Diamonds\n" +
            "Copper\n" +
            "Oil\n" +
            "\n" +
            "What is the official language of Zambia?\n" +
            "1\n" +
            "Portuguese\n" +
            "English\n" +
            "Swahili\n" +
            "French\n" +
            "\n" +
            "Which lake is shared by Zambia and Tanzania?\n" +
            "2\n" +
            "Lake Mweru\n" +
            "Lake Victoria\n" +
            "Lake Tanganyika\n" +
            "Lake Malawi\n" +
            "\n" +
            "What is the currency of Zambia?\n" +
            "2\n" +
            "Zambian dollar\n" +
            "Zambian pound\n" +
            "Zambian kwacha\n" +
            "Zambian shilling\n" +
            "\n" +
            "What is Zambia’s climate type?\n" +
            "3\n" +
            "Tundra\n" +
            "Mediterranean\n" +
            "Desert\n" +
            "Tropical\n" +
            "\n" +
            "Which river flows into the Victoria Falls?\n" +
            "3\n" +
            "Kafue River\n" +
            "Luangwa River\n" +
            "Congo River\n" +
            "Zambezi River\n" +
            "\n" +
            "What is the highest point in Zambia?\n" +
            "1\n" +
            "Kalambo Falls\n" +
            "Mafinga Central\n" +
            "Nyika Plateau\n" +
            "Chisanga Falls\n" +
            "\n" +
            "Which country borders Zambia to the west?\n" +
            "2\n" +
            "Mozambique\n" +
            "Tanzania\n" +
            "Angola\n" +
            "Malawi\n" +
            "\n" +
            "What is the largest man made lake in Zambia?\n" +
            "0\n" +
            "Lake Tanganyika\n" +
            "Lake Kariba\n" +
            "Lake Mweru\n" +
            "Lake Bangweulu\n" +
            "\n" +
            "What is the primary religion in Zambia?\n" +
            "1\n" +
            "Islam\n" +
            "Christianity\n" +
            "Buddhism\n" +
            "Hinduism\n" +
            "\n" +
            "Which city is known as the tourist capital of Zambia?\n" +
            "1\n" +
            "Livingstone\n" +
            "Lusaka\n" +
            "Kitwe\n" +
            "Ndola\n" +
            "\n" +
            "What is Zambia's main agricultural product?\n" +
            "2\n" +
            "Rice\n" +
            "Barley\n" +
            "Maize\n" +
            "Wheat\n" +
            "\n" +
            "Which waterfall is located on the border between Zambia and Zimbabwe?\n" +
            "1\n" +
            "Ngonye Falls\n" +
            "Victoria Falls\n" +
            "Lumangwe Falls\n" +
            "Kalambo Falls\n" +
            "\n" +
            "Which country borders Zambia to the east?\n" +
            "1\n" +
            "Namibia\n" +
            "Malawi\n" +
            "Botswana\n" +
            "Tanzania\n" +
            "\n" +
            "Which Zambian River is one of the two largest tributaries of the Zambezi?\n" +
            "1\n" +
            "Kafue River\n" +
            "Congo River\n" +
            "Lusemfwa River\n" +
            "Chambeshi River\n" +
            "\n" +
            "What is the name of the longest river in Zambia?\n" +
            "1\n" +
            "Zambezi River\n" +
            "Congo River\n" +
            "Kafue River\n" +
            "Luangwa River\n" +
            "\n" +
            "Which Zambian province is Lusaka located in?\n" +
            "3\n" +
            "Copperbelt Province\n" +
            "Eastern Province\n" +
            "Western Province\n" +
            "Lusaka Province\n" +
            "\n" +
            "What is the main industry in Zambia?\n" +
            "2\n" +
            "Tourism\n" +
            "Agriculture\n" +
            "Mining\n" +
            "Manufacturing\n" +
            "\n" +
            "What body of water is created by the Kariba Dam?\n" +
            "4\n" +
            "Lake Malawi\n" +
            "Lake Tanganyika\n" +
            "Lake Mweru\n" +
            "Lake Kariba\n" +
            "\n" +
            "Which Zambian Province is known for its copper mines?\n" +
            "2\n" +
            "Lusaka\n" +
            "Northern\n" +
            "Copperbelt\n" +
            "Southern\n" +
            "\n" +
            "Which province in Zambia is known for its tea plantations?\n" +
            "3\n" +
            "Western Province\n" +
            "Eastern Province\n" +
            "Southern Province\n" +
            "Luapula Province\n" +
            "\n" +
            "How many languages are in Zambia?\n" +
            "3\n" +
            "15\n" +
            "20\n" +
            "73\n" +
            "72\n" +
            "\n" +
            "Which country borders Zambia to the southeast?\n" +
            "0\n" +
            "Mozambique\n" +
            "Botswana\n" +
            "Namibia\n" +
            "Zimbabwe\n" +
            "\n" +
            "Which city is located near Victoria Falls in Zambia?\n" +
            "1\n" +
            "Lusaka\n" +
            "Livingstone\n" +
            "Ndola\n" +
            "Kitwe\n" +
            "\n" +
            "What tribe performs the Kuomboka ceremony?\n" +
            "0\n" +
            "Lozi\n" +
            "Bemba\n" +
            "Tonga\n" +
            "Ngoni\n" +
            "\n" +
            "Which is the smallest province in Zambia by area?\n" +
            "3\n" +
            "Copperbelt Province\n" +
            "Central Province\n" +
            "Western Province\n" +
            "Lusaka Province\n" +
            "\n" +
            "Which game park is well known for bird viewing in Zambia?\n" +
            "3\n" +
            "Kafue National Park\n" +
            "North Luangwa National Park\n" +
            "Lower Zambezi National Park\n" +
            "Lochinvar National Park\n" +
            "\n" +
            "Which river forms part of Zambia’s northern border with Tanzania?\n" +
            "2\n" +
            "Zambezi River\n" +
            "Luangwa River\n" +
            "Kalambo River\n" +
            "Kafue River\n" +
            "\n" +
            "What is Zambia’s main energy source?\n" +
            "3\n" +
            "Solar power\n" +
            "Nuclear power\n" +
            "Coal\n" +
            "Hydroelectric power\n" +
            "\n" +
            "Zambia is located in which continent?\n" +
            "0\n" +
            "Africa\n" +
            "Europe\n" +
            "Asia\n" +
            "South America\n" +
            "\n" +
            "Which country borders Zambia to the southwest?\n" +
            "3\n" +
            "Malawi\n" +
            "Angola\n" +
            "Tanzania\n" +
            "Namibia\n" +
            "\n" +
            "What is a traditional food staple in Zambia?\n" +
            "3\n" +
            "Pasta\n" +
            "Bread\n" +
            "Rice\n" +
            "Nshima\n" +
            "\n" +
            "What is the main type of vegetation found in most of Zambia?\n" +
            "2\n" +
            "Rainforest\n" +
            "Desert\n" +
            "Savannah\n" +
            "Tundra\n" +
            "\n" +
            "How many provinces does Zambia have?\n" +
            "3\n" +
            "12\n" +
            "13\n" +
            "7\n" +
            "10";

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
