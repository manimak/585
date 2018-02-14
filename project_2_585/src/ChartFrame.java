import javafx.scene.chart.Chart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChartFrame extends JFrame{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    private static final double INTEREST_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private static final double CHART_WIDTH = 300;
    private static final double CHART_HIGHT = 300;

    private JLabel label;
    private JTextField text;
    private JButton button;
    private ChartComponent chart;
    private double balance;


    public ChartFrame(){
        balance = INITIAL_BALANCE;
        chart = new ChartComponent(3 * INITIAL_BALANCE);
        chart.setPreferredSize(new Dimension((CHART_WIDTH,CHART_HIGHT)));
        chart.append(INITIAL_BALANCE);
        createTextField();
        creatButten();
        createPanel();

    }

    private void createPanel() {
    }

    private void creatButten(){
        button = new JButton("Add interest");
        ActionListener listener = new AddInte
    }
    private void createTextArea() {
        text = new JTextArea(ROWS,COLS);
        text.setText("Balance: " +balance + "\n");
        text.setEditable(false);
    }
    private void createTextField() {
        final int FIELD_LENGTH = 10;
        textField = new JTextField(FIELD_LENGTH);
        textField.addKeyListener(keyListener);
        textField.setText(String.valueOf(INTEREST_RATE));
    }

}
