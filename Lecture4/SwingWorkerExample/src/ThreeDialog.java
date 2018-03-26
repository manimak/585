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

class ThreeDialog extends JInternalFrame {

    private static ThreeDialog instance = null;

    private JTextField tf;
    private JButton btn;
    private JLabel lbl, lbl2;
    private JPanel upperPanel, lowerPanel , middlePanel;

    public static ThreeDialog getInstance() {
        if(instance == null) {
            instance = new ThreeDialog();
        }
        return instance;
    }

    private void evenActionPerformed() {

        int input = 0;
        lbl2.setText("");
        try {
            input = Integer.parseInt(tf.getText());
            if(input % 3 == 0) {
                lbl2.setText("Yes!");
            }
            else {
                lbl2.setText("Nope!");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Bad input! Try again.");
        }

    }

    private ThreeDialog() {

        // call constructor of JInternalFrame
        // Arguments: title, resizability, closability,
        // maximizability, and iconifiability
        super("Multiplied3", false, true, false, false);

        tf = new JTextField(10);
        btn = new JButton("Is it multiple by three?");
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
                evenActionPerformed();
            }
        });

        setBounds(25, 25, 250, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

}


