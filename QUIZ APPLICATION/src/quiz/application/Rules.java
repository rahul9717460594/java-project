package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    JButton start, back;
    String name;

    Rules(String name) {
        this.name = name;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("WELCOME " + name + " TO SIMPLE MINDS");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 750, 350); // Adjusted width to fit more text
        rules.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        rules.setForeground(Color.BLACK);
        rules.setText(
                "<html>" + 
                "1. You are trained to be a programmer and not a story teller, answer point to point.<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer.<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory.<br><br>" +
                "4. Crying is allowed but please do so quietly.<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise).<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, maybe he/she is doing Jai Mata Di.<br><br>" +
                "7. Brace yourself, this paper is not for the faint-hearted.<br><br>" +
                "8. May you know more than what Jon Snow knows. Good Luck!<br><br>" +
                "</html>"
        );
        add(rules);

        start = new JButton("Start");
        start.setBounds(400, 500, 120, 30);
        start.setBackground(Color.BLUE);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setBounds(580, 500, 120, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            // Go to quiz page (to be implemented)
            setVisible(false);
            // Example: new Quiz(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login(); // Assuming you want to return to the login page
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
