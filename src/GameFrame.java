import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

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

        JTextField inputField = new JTextField(8);
        getContentPane().add(inputField);


        JButton submitGuess = new JButton("Gæt");
        getContentPane().add(submitGuess);
        submitGuess.addActionListener(this);


        JLabel gameAnswer = new JLabel("For højt");
        getContentPane().add(gameAnswer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Klikket");

    }
}