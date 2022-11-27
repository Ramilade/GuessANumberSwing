import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    private JTextField inputField;
    private Player player;
    private Game game;
    private JLabel gameAnswer;
    private JLabel tries;

    public GameFrame(String title) {
        super(title);
        getContentPane().setLayout(new FlowLayout());



        game = new Game();
        player = new Player();
        addComponents();

        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);


    }

    private void addComponents() {
        tries = new JLabel("Antal forsøg brugt: " + player.getTries());
        getContentPane().add(tries);

        inputField = new JTextField(8);
        getContentPane().add(inputField);


        JButton submitGuess = new JButton("Gæt");
        getContentPane().add(submitGuess);
        submitGuess.addActionListener(this);


        gameAnswer = new JLabel("Gæt en gang på et tal (1-10)!");
        getContentPane().add(gameAnswer);
    }

    private void resetGame() {
        game = new Game();
        player = new Player();
        tries.setText("Antal forsøg brugt: " + player.getTries());
        gameAnswer.setText("Gæt en gang på et tal (1-10)!");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        player.addTry();
        tries.setText("Antal forsøg brugt: " + player.getTries());

        String textEntered = inputField.getText();
        int numberEntered = Integer.parseInt(textEntered);
        if (numberEntered == game.getRandomNumber()) {
            JOptionPane.showMessageDialog(null, "Du har vundet! Du brugte " + player.getTries() + " forsøg.");
            resetGame();

        } else if (numberEntered > game.getRandomNumber()) {
            gameAnswer.setText("For højt!");
        } else if (numberEntered < game.getRandomNumber()) {
            gameAnswer.setText("For lavt!");
        }


    }
}