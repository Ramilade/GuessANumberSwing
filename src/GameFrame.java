import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    JTextField inputField;
    Game game;

    public GameFrame(String title) {
        super(title);
        getContentPane().setLayout(new FlowLayout());

        addComponents();

        game = new Game();


        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);


    }

    private void addComponents() {
        JLabel tries = new JLabel("Antal forsøg: ");
        getContentPane().add(tries);

        inputField = new JTextField(8);
        getContentPane().add(inputField);


        JButton submitGuess = new JButton("Gæt");
        getContentPane().add(submitGuess);
        submitGuess.addActionListener(this);


        JLabel gameAnswer = new JLabel("For højt");
        getContentPane().add(gameAnswer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textEntered = inputField.getText();
        int numberEntered = Integer.parseInt(textEntered);

        if (numberEntered == game.getRandomNumber()) {
            System.out.println("Du gættede rigtigt!");
        } else if (numberEntered > game.getRandomNumber()) {
            System.out.println("For højt!");
        } else if (numberEntered < game.getRandomNumber()) {
            System.out.println("For lavt!");
        }


    }
}