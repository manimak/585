/*
Mani Makaremi
2/13/2018
class comp585
project Calculator
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;



public class ConstructedFrame extends JFrame {

    //panels
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JTextField textField;
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
    private KeyListener keyListener;
    private double firstNumber;
    private double secondNumber;
    private String tempNumber; // to find the first number and the second number
    private String symbol;
    private Functions functions;
    private double answare;

    //menu
    private JMenuBar menuBar;
    private JMenu app;
    private JMenu help;
    private JMenuItem exit;
    private JMenuItem about;

    public ConstructedFrame(){
        firstNumber = 0.0;
        secondNumber = 0.0;
        symbol = "";
        tempNumber = "";
        answare = 0;
        buildMenu();
        addMenuListeners();
        createKeyListener();
        createTextField();
        createPanel();
        createButton();
        createFrame();
        addButtonListener();

    }

    private void buildMenu() {
        menuBar = new JMenuBar();
        app = new JMenu("App");
        help = new JMenu("Help");
        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");
        app.add(exit);
        help.add(about);
        menuBar.add(app);
        menuBar.add(help);
    }

    private void addMenuListeners() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitActionPerform();
            }
        });
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutActionPerform();
            }
        });

    }

    private void aboutActionPerform() {
        JOptionPane.showMessageDialog(this,"Thx for using my app!");

    }

    private void exitActionPerform() {
        dispose();
    }


    private void createTextField() {
        final int FILED_LENGTH = 20;
        textField = new JTextField(FILED_LENGTH);
        textField.addKeyListener(keyListener);
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

        mainPanel.add(textField);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        add(mainPanel);

        setJMenuBar(menuBar);

        pack();
        setTitle("Calculator");
    }


    private void addButtonListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1Listener();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2Listener();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3Listener();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4Listener();
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5Listener();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button6Listener();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button7Listener();
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button8Listener();
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button9Listener();
            }
        });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button0Listener();
            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPlusListener();
            }
        });
        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEqualListener();
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonMinusListener();
            }
        });
        buttonMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonMultiListener();
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonDivideListener();
            }
        });
        buttonMOD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonMODListener();
            }
        });
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonDotListener();
            }
        });
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonDelListener();
            }
        });
        buttonCE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCEListener();
            }
        });
    }
    private void createKeyListener() {
        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("You pressed: " + e.getKeyCode());
                handleKeyPressed(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    private void handleKeyPressed(int keyCode) {
        switch (keyCode){
            case 96:
                button0Listener();
                break;
            case 97:
                button1Listener();
                break;
            case 98:
                button2Listener();
                break;
            case 99:
                button3Listener();
                break;
            case 100:
                button4Listener();
                break;
            case 101:
                button5Listener();
                break;
            case 102:
                button6Listener();
                break;
            case 103:
                button7Listener();
                break;
            case 104:
                button8Listener();
                break;
            case 105:
                button9Listener();
                break;
            case 189:
                buttonMinusListener();
                break;
            case 27:
                buttonEqualListener();
                break;
        }
    }

    private void buttonCEListener() {
        textField.setText("");
        tempNumber = "";
    }

    private void buttonDelListener() {
        String tempStr =  textField.getText();
        tempStr = tempStr.substring(0, tempStr.length() - 1);
        tempNumber = tempNumber.substring(0,tempNumber.length()-1);
        textField.setText(tempStr);
    }

    private void buttonDotListener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + ".");
        tempNumber = tempNumber + ".";
    }

    private void buttonMODListener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "MOD");
        firstNumber = Double.parseDouble(tempNumber);
        tempNumber = "";
        symbol = "M";
    }

    private void buttonDivideListener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "÷");
        firstNumber = Double.parseDouble(tempNumber);
        tempNumber = "";
        symbol = "÷";
    }

    private void buttonMultiListener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "×");
        firstNumber = Double.parseDouble(tempNumber);
        tempNumber = "";
        symbol = "×";
    }

    private void buttonMinusListener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "-");
        firstNumber = Double.parseDouble(tempNumber);
        tempNumber = "";
        symbol = "-";
    }

    private void buttonEqualListener() {
        String tempStr = textField.getText();
        textField.setText(tempStr + "=");
        if (tempNumber != "") {
            secondNumber = Double.parseDouble(tempNumber);
        }
        tempNumber = "";
        switch (symbol) {
            case "+":
                functions = new Functions(firstNumber, secondNumber);
                answare = functions.add();
                textField.setText(textField.getText() + Double.toString(answare));
                symbol = "";
                break;
            case "-":
                functions = new Functions(firstNumber, secondNumber);
                answare = functions.difference();
                textField.setText(textField.getText() + Double.toString(answare));
                symbol = "";
                break;
            case "×":
                functions = new Functions(firstNumber, secondNumber);
                answare = functions.multiplication();
                textField.setText(textField.getText() + Double.toString(answare));
                symbol = "";
                break;
            case "÷":
                functions = new Functions(firstNumber, secondNumber);
                answare = functions.division();
                textField.setText(textField.getText() + Double.toString(answare));
                symbol = "";
                break;
            case "M":
                functions = new Functions(firstNumber, secondNumber);
                answare = functions.mod();
                textField.setText(textField.getText() + Double.toString(answare));
                symbol = "";
                break;
            default:
                textField.setText("");
        }


    }

    private void buttonPlusListener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "+");
        firstNumber = Double.parseDouble(tempNumber);
        tempNumber = "";
        symbol = "+";
    }

    private void button6Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "6");
        tempNumber = tempNumber + "6";
    }

    private void button7Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "7");
        tempNumber = tempNumber + "7";
    }

    private void button8Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "8");
        tempNumber = tempNumber + "8";
    }

    private void button9Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "9");
        tempNumber = tempNumber + "9";
    }

    private void button0Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "0");
        tempNumber = tempNumber + "0";
    }

    private void button5Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "5");
        tempNumber = tempNumber + "5";
    }

    private void button4Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "4");
        tempNumber = tempNumber + "4";
    }

    private void button3Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "3");
        tempNumber = tempNumber + "3";
    }

    private void button2Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "2");
        tempNumber = tempNumber + "2";
    }

    private void button1Listener() {
        String tempStr =  textField.getText();
        textField.setText(tempStr + "1");
        tempNumber = tempNumber + "1";
    }

}
