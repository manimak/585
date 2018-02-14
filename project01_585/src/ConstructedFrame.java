
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class ConstructedFrame extends JFrame {
    private JButton button;
    private JLabel label;
    private JPanel panel;
    private JTextField textField;
    private KeyListener keyListener;
    private JTextArea textArea;

    private double balance;

    private static final int ROWS = 10;
    private static final int COLS = 30;

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    private static final double INTEREST_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    public ConstructedFrame(){
        balance = INITIAL_BALANCE;
        createTextArea();
        createKeyListener();
        createTextField();
        createFrame();
        addListener();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }

    private void createTextArea() {
        textArea = new JTextArea(ROWS,COLS);
        textArea.setText("Balance: " +balance + "\n");
        textArea.setEditable(false);
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

    private void handleKeyPressed(int keyCode){
        switch (keyCode){
            case 10:
                updateTextFiled();
                break;
            case 27:
                break;
        }
    }

    private void createTextField() {
        final int FIELD_LENGTH = 10;
        textField = new JTextField(FIELD_LENGTH);
        textField.addKeyListener(keyListener);
        textField.setText(String.valueOf(INTEREST_RATE));
    }

    private void updateTextFiled(){
        double rate = 0;
        try {
            rate = Double.parseDouble(textField.getText());
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"Bad rate! try again.");
        }
        double interest = balance * rate /100;
        balance += interest;
        String balanceSTR = "Balance: " + balance + "\n";
        label.setText("Balance: "+ balance);
        textArea.append(balanceSTR);
    }

    public class ClickListener implements ActionListener{
        public  void  actionPerformed(ActionEvent ae){
            updateTextFiled();
        }
    }

    private void createFrame(){
        button = new JButton("Calculate!");
        label = new JLabel(String.valueOf(balance));
        panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        JScrollPane myScrollPane = new JScrollPane(textArea);
        panel.add(myScrollPane);
        add(panel);
    }

    private void addListener(){
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
    }
}
