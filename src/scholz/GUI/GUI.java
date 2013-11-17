package scholz.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Hauptframe der GUI
 * 
 * @author Dominik
 * @version 0.1
 */
public class GUI {
    
    private static GUI i = new GUI();
    public static GUI get() { return i; };

    public GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        JFrame jf = new JFrame("Datenbankansicht");
        jf.setBounds(400, 400, 320, 320);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Connect", new ConnectPanel());
        tp.addTab("Show", new JPanel());
        tp.addTab("Insert", new JPanel());
        
        jf.add(tp);
        jf.setVisible(true);
    }

}
