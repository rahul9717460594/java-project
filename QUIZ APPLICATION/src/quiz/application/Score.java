package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(0, 0, 1440, 850); // Fullscreen frame
        setLayout(null);

        // Background image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/score.jpg")); // Place score.jpg in /icon/
        Image bgImg = bgIcon.getImage().getScaledInstance(1440, 850, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(bgImg);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 1200, 850);
        add(background);

        // Neon-style heading
        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds");
        heading.setBounds(200, 100, 1000, 60);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(Color.CYAN);
        background.add(heading);

        // Score
        JLabel scoreLabel = new JLabel("Your score is " + score);
        scoreLabel.setBounds(600, 250, 400, 60);
        scoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        scoreLabel.setForeground(Color.YELLOW);
        background.add(scoreLabel);

        // Play Again Button
        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(650, 400, 150, 40);
        playAgain.setBackground(Color.BLACK);
        playAgain.setForeground(Color.CYAN);
        playAgain.setFont(new Font("Tahoma", Font.BOLD, 16));
        playAgain.addActionListener(this);
        background.add(playAgain);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Quiz(); // Restart quiz
    }
}
