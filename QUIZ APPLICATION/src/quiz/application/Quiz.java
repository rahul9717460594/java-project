package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userAnswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup optionsGroup;
    JButton next, submit;

    int count = 0;
    int score = 0;

    Quiz() {
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 300);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 350, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 350, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(150, 400, 700, 30);
        opt1.setBackground(Color.WHITE);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(150, 450, 700, 30);
        opt2.setBackground(Color.WHITE);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(150, 500, 700, 30);
        opt3.setBackground(Color.WHITE);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(150, 550, 700, 30);
        opt4.setBackground(Color.WHITE);
        add(opt4);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(opt1);
        optionsGroup.add(opt2);
        optionsGroup.add(opt3);
        optionsGroup.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 450, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 16));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 500, 200, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        // Questions and answers
        questions[0][0] = "Which is used to find and fix bugs in Java programs?";
        questions[0][1] = "JVM"; questions[0][2] = "JDB"; questions[0][3] = "JDK"; questions[0][4] = "JRE";
        answers[0][1] = "JDB";

        questions[1][0] = "Which keyword is used for inheritance in Java?";
        questions[1][1] = "implement"; questions[1][2] = "extends"; questions[1][3] = "inherits"; questions[1][4] = "super";
        answers[1][1] = "extends";

        questions[2][0] = "Which method is the entry point of a Java program?";
        questions[2][1] = "start()"; questions[2][2] = "run()"; questions[2][3] = "main()"; questions[2][4] = "init()";
        answers[2][1] = "main()";

        questions[3][0] = "Which of the following is not an OOP concept?";
        questions[3][1] = "Polymorphism"; questions[3][2] = "Inheritance"; questions[3][3] = "Compilation"; questions[3][4] = "Encapsulation";
        answers[3][1] = "Compilation";

        questions[4][0] = "Which class is the parent of all Java classes?";
        questions[4][1] = "Object"; questions[4][2] = "String"; questions[4][3] = "Main"; questions[4][4] = "Class";
        answers[4][1] = "Object";

        questions[5][0] = "Which data type is used to store text?";
        questions[5][1] = "myString"; questions[5][2] = "string"; questions[5][3] = "String"; questions[5][4] = "Txt";
        answers[5][1] = "String";

        questions[6][0] = "How do you create a variable with the value 5?";
        questions[6][1] = "num x = 5"; questions[6][2] = "x = 5"; questions[6][3] = "int x = 5"; questions[6][4] = "double x = 5";
        answers[6][1] = "int x = 5";

        questions[7][0] = "Which operator compares two values?";
        questions[7][1] = "="; questions[7][2] = "=="; questions[7][3] = "!="; questions[7][4] = "<>";
        answers[7][1] = "==";

        questions[8][0] = "Which loop runs at least once?";
        questions[8][1] = "for"; questions[8][2] = "while"; questions[8][3] = "do-while"; questions[8][4] = "none";
        answers[8][1] = "do-while";

        questions[9][0] = "Which exception occurs when dividing by zero?";
        questions[9][1] = "NullPointerException"; questions[9][2] = "NumberFormatException"; questions[9][3] = "ArithmeticException"; questions[9][4] = "IOException";
        answers[9][1] = "ArithmeticException";

        showQuestion(count);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            recordAnswer();
            count++;
            if (count == 9) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            showQuestion(count);
        } else if (ae.getSource() == submit) {
            recordAnswer();
            for (int i = 0; i < userAnswers.length; i++) {
                if (userAnswers[i][0] != null && userAnswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
setVisible(false);
new Score("User", score); // You can pass a username variable here instead of "User"
        }
    }
    void recordAnswer() {
        if (opt1.isSelected()) userAnswers[count][0] = opt1.getText();
        else if (opt2.isSelected()) userAnswers[count][0] = opt2.getText();
        else if (opt3.isSelected()) userAnswers[count][0] = opt3.getText();
        else if (opt4.isSelected()) userAnswers[count][0] = opt4.getText();
        else userAnswers[count][0] = "";
    }

    void showQuestion(int count) {
        qno.setText((count + 1) + ".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);
        optionsGroup.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
