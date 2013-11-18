package scholz.GUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import scholz.Listener.TabListener;

/**
 * Hauptframe der GUI
 * 
 * @author Dominik
 * @version 0.7
 */
public class GUI {
    
    private JTabbedPane tp;
    private JFrame jf;
    private ConnectPanel connectPanel;
    private ShowPanel showPanel;
    private InsertPanel insertPanel;
    
    private static GUI i = new GUI();
    public static GUI get() { return i; };

    private GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        
        jf = new JFrame("Datenbankansicht");
        jf.setBounds(400, 400, TabSize.CONNECT.getWidth(),TabSize.CONNECT.getHeight());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        connectPanel = new ConnectPanel();
        showPanel = new ShowPanel();
        insertPanel = new InsertPanel();
        
        tp = new JTabbedPane();
        tp.addTab("Connect", connectPanel);
        tp.addTab("Show", showPanel);
        tp.addTab("Insert", insertPanel);
        tp.addChangeListener(new TabListener());
        
        disableTabs();
        
        jf.add(tp);
        jf.setVisible(true);
    }

    public ConnectPanel getConnectPanel() {
        return connectPanel;
    }

    public ShowPanel getShowPanel() {
        return showPanel;
    }

    public InsertPanel getInsertPanel() {
        return insertPanel;
    }
    
    /**
     * Aktiviert die tabs Show,Insert
     */
    public void enableTabs() {
        tp.setEnabledAt(1, true);
        tp.setEnabledAt(2, true);
    }
    
    /**
     * Deaktiviert die Tabs Show,Insert
     */
    public void disableTabs() {
        tp.setEnabledAt(1, false);
        tp.setEnabledAt(2, false);
    }
    
    /**
     * Verändert die Größe des Fensters
     * @param width die neue Breite
     * @param height die neue Höhe
     */
    public void resize(int width, int height) {
        jf.setBounds(jf.getX(),jf.getY(),width,height);
    }

}
