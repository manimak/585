import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AreaOfCircle extends JInternalFrame {
    private  static AreaOfCircle intance  = null;

    private JTextField textField;
    private JButton button;
    private JLabel label1,label2;
    private JPanel upperPanel, lowerPanel;

    public static AreaOfCircle getIntance(){
        if(intance == null){
            intance = new AreaOfCircle();

        }
        return  intance;
    }

    private AreaOfCircle(){
        //args : title
        super("Area Of Circle",false,true,false,false);
        textField = new JTextField(10);
        button = new JButton("Area");
        label1 = new JLabel("Answre");
        label2 = new JLabel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());
        lowerPanel.setLayout(new FlowLayout());
        upperPanel.add(textField);
        upperPanel.add(button);
        lowerPanel.add(label1);
        lowerPanel.add(label2);
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel,BorderLayout.SOUTH);

        addButtonListener();

        setBounds(25,25,250,120);
        setLocation(100,100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addButtonListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaOfCircle();

            }
        });
    }

    private void areaOfCircle() {
        label2.setText("");
        try{
            double radius = Double.parseDouble(textField.getText());
            double answare = Math.PI* (radius*radius);
            label2.setText(String.valueOf(answare));
        }
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(this,"Hey buddy, enter a number");

        }
    }

}
