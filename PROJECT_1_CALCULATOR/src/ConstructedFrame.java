import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class ConstructedFrame extends JFrame {

    //panels
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JTextField textField;
    private JLabel label;
    private Font labelFont;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonDot;
    private JButton buttonCE;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMulti;
    private JButton buttonEqual;
    private JButton buttonMOD;
    private JButton buttonDivide;
    private JButton buttonDel;
    private JButton buttonNegation;



    public ConstructedFrame(){
        createLable();
        createPanel();
        createButton();
        createFrame();




    }

    private void createButton() {
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonDot = new JButton(".");
        buttonCE = new JButton("CE");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMulti = new JButton("×");
        buttonEqual = new JButton("=");
        buttonMOD = new JButton("MOD");
        buttonDivide = new JButton("÷");
        buttonDel = new JButton("DEL");
        buttonNegation = new JButton("±");
    }

    private void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,4));
    }

    private void createLable() {
        label = new JLabel("20");
        labelFont = new Font("Serif",Font.BOLD,30);
        label.setFont(labelFont);

    }

    private void createFrame() {

        buttonPanel.add(buttonCE);
        buttonPanel.add(buttonMOD);
        buttonPanel.add(buttonDel);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonMulti);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonPlus);
        buttonPanel.add(buttonNegation);
        buttonPanel.add(button0);
        buttonPanel.add(buttonDot);
        buttonPanel.add(buttonEqual);

        mainPanel.add(label);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        add(mainPanel);

        pack();
        setTitle("Calculator");
    }

}
