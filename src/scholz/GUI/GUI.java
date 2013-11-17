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
 * @version 0.2
 */
public class GUI {
    
    private JTabbedPane tp;
    private JFrame jf;
    
    private static GUI i = new GUI();
    public static GUI get() { return i; };

    public GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        
        jf = new JFrame("Datenbankansicht");
        jf.setBounds(400, 400, 320, 320);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tp = new JTabbedPane();
        tp.addTab("Connect", new ConnectPanel());
        tp.addTab("Show", new JPanel());
        tp.addTab("Insert", new JPanel());
        
        disableTabs();
        
        jf.add(tp);
        jf.setVisible(true);
    }
    
    public void enableTabs() {
        tp.setEnabledAt(1, true);
        tp.setEnabledAt(2, true);
    }
    
    public void disableTabs() {
        tp.setEnabledAt(1, false);
        tp.setEnabledAt(2, false);
    }
    
    public void resize(int width, int height) {
        jf.setBounds(jf.getX(),jf.getY(),width,height);
    }

}
