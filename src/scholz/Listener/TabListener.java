package scholz.Listener;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import scholz.GUI.GUI;
import scholz.GUI.TabSize;

/**
 * Listener der Tabs
 * 
 * @author Dominik
 * @version 0.1
 */
public class TabListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent ce) {
        TabSize ts = TabSize.values()[((JTabbedPane) ce.getSource()).getSelectedIndex()];
        GUI.get().resize(ts.getWidth(), ts.getHeight());
    }

}
