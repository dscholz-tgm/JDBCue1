package scholz.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scholz.GUI.InsertPanel;

/**
 * Listener für den Insert Button
 * 
 * @author Dominik
 * @version 0.1
 */
public class InsertListener implements ActionListener {
    
    private InsertPanel ip;

    public InsertListener(InsertPanel ip) {
        this.ip = ip;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
}
