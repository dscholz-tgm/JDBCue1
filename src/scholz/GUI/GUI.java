package scholz.GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * @author Dominik
 * @version 0.1
 */
public class GUI {
    
    private static GUI i = new GUI();
    public static GUI get() { return i; };

    public GUI() {
        JFrame jf = new JFrame("Datenbankansicht");
        jf.setBounds(100, 100, 800, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLayout(new BorderLayout());

        jf.setVisible(true);
    }

}
