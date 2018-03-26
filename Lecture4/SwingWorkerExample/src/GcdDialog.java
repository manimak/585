import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GcdDialog extends JInternalFrame {

    private static GcdDialog instance = null;

    private JTextField tf , tf2;
    private JButton btn;
    private JLabel lbl, lbl2;
    private JPanel upperPanel, lowerPanel , middlePanel;

    public static GcdDialog getInstance() {
        if(instance == null) {
            instance = new GcdDialog();
        }
        return instance;
    }

    private void gcdActionPerformed() {

        int input = 0;
        int input2 = 0;
        int output = 0;
        lbl2.setText("");
        try {
            input = Integer.parseInt(tf.getText());
            input2 = Integer.parseInt(tf2.getText());

            output = findGCD(input,input2);

            lbl2.setText(Integer.toString(output));

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Bad input! Try again.");
        }

    }

    private GcdDialog() {

        // call constructor of JInternalFrame
        // Arguments: title, resizability, closability,
        // maximizability, and iconifiability
        super("GCD", false, true, false, false);

        tf = new JTextField(10);
        tf2 = new JTextField(10);
        btn = new JButton("GCD?");
        lbl = new JLabel("Answer: ");
        lbl2 = new JLabel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        middlePanel = new JPanel();


        upperPanel.setLayout(new FlowLayout());
        upperPanel.setLayout(new FlowLayout());

        upperPanel.add(tf);
        upperPanel.add(tf2);

        middlePanel.add(btn);

        lowerPanel.add(lbl);
        lowerPanel.add(lbl2);

        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
        add(middlePanel,BorderLayout.CENTER);

        // add button listener
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gcdActionPerformed();
            }
        });

        setBounds(25, 25, 250, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    private static int findGCD(int number1, int number2) {
        //base case
        if(number2 == 0){ return number1; }
        return findGCD(number2, number1%number2);
    }
}


    





