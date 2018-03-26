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

class FebDialog extends JInternalFrame {

    private static FebDialog instance = null;

    private JTextField tf;
    private JButton btn;
    private JLabel lbl, lbl2;
    private JPanel upperPanel, lowerPanel , middlePanel;

    public static FebDialog getInstance() {
        if(instance == null) {
            instance = new FebDialog();
        }
        return instance;
    }

    private void febActionPerformed() {

        int input = 0;
        int output = 0;
        lbl2.setText("");
        try {
            input = Integer.parseInt(tf.getText());
            output = fibonacci(input);
            lbl2.setText(Integer.toString(output));

        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Bad input! Try again.");
        }

    }

    private FebDialog() {

        // call constructor of JInternalFrame
        // Arguments: title, resizability, closability,
        // maximizability, and iconifiability
        super("fibonacci", false, true, false, false);

        tf = new JTextField(10);
        btn = new JButton("fibonacci");
        lbl = new JLabel("Answer: ");
        lbl2 = new JLabel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        middlePanel = new JPanel();


        upperPanel.setLayout(new FlowLayout());
        upperPanel.setLayout(new FlowLayout());

        upperPanel.add(tf);
        middlePanel.add(btn);

        lowerPanel.add(lbl);
        lowerPanel.add(lbl2);

        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
        add(middlePanel,BorderLayout.CENTER);

        // add button listener
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                febActionPerformed();
            }
        });

        setBounds(35, 35, 270, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    private int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

}


