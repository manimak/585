import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,200);
        frame.setTitle("A bar chart...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent comp = new ChartComponent();
        frame.add(comp);
        frame.setVisible(true);
    }
}
