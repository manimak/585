import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class ChartComponent extends JComponent{
    private ArrayList<Double> values;
    private double maxValue;
    public ChartComponent(double maxValue){
        values = new ArrayList<Double>();
        this.maxValue = maxValue;

    }

    public  void append(double value){
        values.add(value);
        repaint();
    }

    public void paintComponent(Graphics g){
       /* g.fillRect(0,10,200,10);
        g.fillRect(0,30,300,10);
        g.fillRect(0,50,100,10);

        g.drawLine(350,35,305 , 35);
        g.drawLine(305,35,310 , 30);
        g.drawLine(305,35,310 , 40);

        g.setColor(Color.yellow);
        g.fillOval(350,25,35,20);
        g.setColor(Color.BLACK);
        g.drawString("Best",355,40);*/

       final int GAP = 5;
       final int BAR_HEIGHT = 10;
       int y = GAP;
       int bandWidth = 0 ;
       for(double value : values){
           bandWidth = (int)(getWidth()* value / maxValue);
           g.fillOval(0,y,bandWidth,BAR_HEIGHT);
           y = y + BAR_HEIGHT + GAP;
       }
    }
}
