import javax.swing.*;
import java.awt.*;

public class PizzaGUIRunner
{
    public static void main(String[] args)
    {
        double dHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double dWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        int height = ((int) (dHeight * .90));
        int width = ((int) (dWidth * .75));

        PizzaGUIFrame frame = new PizzaGUIFrame();
        frame.setSize(width, height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}