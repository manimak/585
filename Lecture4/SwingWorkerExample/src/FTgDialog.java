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

class FTgDialog extends JInternalFrame {

    private static FTgDialog instance = null;

    private JTextField tf;
    private JButton btn;
    private JLabel lbl, lbl2;
    private JPanel upperPanel, lowerPanel;

    public static FTgDialog getInstance() {
        if(instance == null) {
            instance = new FTgDialog();
        }
        return instance;
    }

    private void ftgActionPerformed() {

        int input = 0;
        double output = 0;
        lbl2.setText("");
        try {
            input = Integer.parseInt(tf.getText());
            output = input * 0.031080950172;
            lbl2.setText(Double.toString(output));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Bad input! Try again.");
        }

    }

    private FTgDialog() {

        // call constructor of JInternalFrame
        // Arguments: title, resizability, closability,
        // maximizability, and iconifiability
        super("Foot to gn", false, true, false, false);

        tf = new JTextField(10);
        btn = new JButton("Convert:");
        lbl = new JLabel("Answer: ");
        lbl2 = new JLabel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout());
        upperPanel.setLayout(new FlowLayout());

        upperPanel.add(tf);
        upperPanel.add(btn);

        lowerPanel.add(lbl);
        lowerPanel.add(lbl2);

        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);

        // add button listener
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ftgActionPerformed();
            }
        });

        setBounds(25, 25, 250, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

}



