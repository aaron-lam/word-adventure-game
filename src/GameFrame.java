import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameFrame extends JFrame {
    private static Container gameContainer;
    private static JPanel titleNamePanel, startButtonPanel, backGroundStoryButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, backGroundStoryPanel;
    private static JLabel titleNameLabel, playerPanelLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    private static Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private static Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    private static JButton startButton, backGroundStoryButton, choiceButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4;
    private static JTextArea mainTextArea, backGroundTextArea;
    private static int playerHP, monsterHP, silverRing;
    private static String weapon, position;

    private static IntroScreenHandler introScreenHandler = new IntroScreenHandler();
    private static TitleScreenHandler titleScreenHandler = new TitleScreenHandler();
    private static ChoiceHandler choiceHandler = new ChoiceHandler();

    public GameFrame(){
        setSize(800, 600);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        gameContainer = getContentPane();
        createTitleNamePanel();
        createTitleNameLabel();
        createStartButtonPanel();
        createStartButton();

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        gameContainer.add(titleNamePanel);
        gameContainer.add(startButtonPanel);
    }

    private static void createTitleNamePanel() {
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
    }

    private static JLabel createTitleNameLabel() {
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        return titleNameLabel;
    }

    private static void createStartButtonPanel() {
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
    }

    private static void createStartButton() {
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.RED);
        startButton.setFont(normalFont);
        startButton.addActionListener(titleScreenHandler);
    }

    private static void createGameScreen() {
        backGroundStoryPanel.setVisible(false);
        backGroundStoryButtonPanel.setVisible(false);

        createMainTextPanel();

        createButtonPanel();

        createPlayerPanel();

        playerSetup();
    }

    private static void createMainTextPanel(){
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        gameContainer.add(mainTextPanel);

        createMainTextArea();
    }

    private static void createMainTextArea(){
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);
    }

    private static void createButtonPanel(){
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        gameContainer.add(choiceButtonPanel);

        choiceButton1 = newChoiceButton("Choice 1", "c1");
        choiceButton2 = newChoiceButton("Choice 2", "c2");
        choiceButton3 = newChoiceButton("Choice 3", "c3");
        choiceButton4 = newChoiceButton("Choice 4", "c4");

        choiceButtonPanel.add(choiceButton1);
        choiceButtonPanel.add(choiceButton2);
        choiceButtonPanel.add(choiceButton3);
        choiceButtonPanel.add(choiceButton4);
    }

    private static JButton newChoiceButton(String buttonName, String actionCommandName) {
        choiceButton = new JButton(buttonName);
        choiceButton.setForeground(Color.BLACK);
        choiceButton.setFont(normalFont);
        choiceButton.setFocusPainted(false);
        choiceButton.addActionListener(choiceHandler);
        choiceButton.setActionCommand(actionCommandName);
        return choiceButton;
    }

    private static void createPlayerPanel() {
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1, 4));
        gameContainer.add(playerPanel);

        hpLabel = newPlayerPanelLabels("HP: ");
        hpLabelNumber = newPlayerPanelLabels("");
        weaponLabel = newPlayerPanelLabels("Weapon: ");
        weaponLabelName = newPlayerPanelLabels("");

        playerPanel.add(hpLabel);
        playerPanel.add(hpLabelNumber);
        playerPanel.add(weaponLabel);
        playerPanel.add(weaponLabelName);
    }

    private static JLabel newPlayerPanelLabels(String labelName){
        playerPanelLabel = new JLabel(labelName);
        playerPanelLabel.setText(labelName);
        playerPanelLabel.setFont(normalFont);
        playerPanelLabel.setForeground(Color.white);
        return playerPanelLabel;
    }

    private static void playerSetup() {
        playerHP = 15;
        monsterHP = 20;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);
        townGate();
    }

    private static void createIntroScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        createBackGroundStoryPanel();
        createBackGroundStoryArea();

        createBackGroundStoryButtonPanel();
        createBackGroundStoryButton();

        backGroundStoryPanel.add(backGroundTextArea);
        backGroundStoryButtonPanel.add(backGroundStoryButton);

        gameContainer.add(backGroundStoryPanel);
        gameContainer.add(backGroundStoryButtonPanel);
    }

    private static void createBackGroundStoryPanel(){
        backGroundStoryPanel = new JPanel();
        backGroundStoryPanel.setBounds(20, 100, 600, 250);
        backGroundStoryPanel.setBackground(Color.BLACK);
    }

    private static void createBackGroundStoryArea(){
        backGroundTextArea = new JTextArea("You are an exiled prince,looking to reclaim your \npower to thre throne. You decided to go on an \nadvanture to gain more gifts to defeat all the\nenemies in your way.  ");
        backGroundTextArea.setBounds(200, 100, 600, 600);
        backGroundTextArea.setBackground(Color.black);
        backGroundTextArea.setForeground(Color.green);
        backGroundTextArea.setFont(normalFont);
        backGroundTextArea.setLineWrap(true);
    }

    private static void createBackGroundStoryButtonPanel() {
        backGroundStoryButtonPanel = new JPanel();
        backGroundStoryButtonPanel.setBounds(290, 400, 200, 100);
        backGroundStoryButtonPanel.setBackground(Color.black);
    }

    private static void createBackGroundStoryButton() {
        backGroundStoryButton = new JButton("START");
        backGroundStoryButton.setBackground(Color.black);
        backGroundStoryButton.setForeground(Color.RED);
        backGroundStoryButton.setFont(normalFont);
        backGroundStoryButton.addActionListener(introScreenHandler);
    }

    private static void townGate() {
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
        choiceButton1.setText("Talk to the guard");
        choiceButton2.setText("Attack the guard");
        choiceButton3.setText("Leave");
        choiceButton4.setText("");
    }

    private static void talkGuard() {
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP);
        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
        choiceButton1.setText("Go north");
        choiceButton2.setText("Go east");
        choiceButton3.setText("Go south");
        choiceButton4.setText("Go west");
    }

    private static void north() {
        position = "north";
        mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
        playerHP = playerHP + 2;
        hpLabelNumber.setText("" + playerHP);
        choiceButton1.setText("Go south");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void east() {
        position = "east";
        mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choiceButton1.setText("Go west");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void west() {
        position = "west";
        mainTextArea.setText("You encounter a goblin!");
        choiceButton1.setText("Fight");
        choiceButton2.setText("Run");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void fight() {
        position = "fight";
        mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
        choiceButton1.setText("Attack");
        choiceButton2.setText("Run");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void playerAttack() {
        position = "playerAttack";

        int playerDamage = 0;

        if (weapon.equals("Knife")) {
            playerDamage = new java.util.Random().nextInt(3);
        } else if (weapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(12);
        }

        mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");

        monsterHP = monsterHP - playerDamage;

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void monsterAttack() {
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");

        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText("" + playerHP);

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void win() {
        position = "win";

        mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");

        silverRing = 1;

        choiceButton1.setText("Go east");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    private static void lose() {
        position = "lose";
        mainTextArea.setText("You are dead!\n\n");
        disableChoices();
    }

    private static void ending() {
        position = "ending";
        mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n");
        disableChoices();
    }

    private static void disableChoices(){
        choiceButton1.setText("");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        choiceButton1.setVisible(false);
        choiceButton2.setVisible(false);
        choiceButton3.setVisible(false);
        choiceButton4.setVisible(false);
    }

    public static class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createIntroScreen();
        }
    }

    public static class IntroScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

    public static class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            if (silverRing == 1)
                                ending();
                            else
                                talkGuard();
                            break;
                        case "c2":
                            attackGuard();
                            if(playerHP < 1)
                                lose();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                    }
                    break;
                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            west();
                            break;
                    }
                    break;
                case "north":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "west":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "playerAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (monsterHP < 1) {
                                win();
                            } else {
                                monsterAttack();
                            }
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                lose();
                            } else {
                                fight();
                            }
                            break;
                    }
                    break;
                case "win":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                    }
                    break;
            }
        }
    }
}
