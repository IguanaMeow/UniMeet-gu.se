

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * NotifyListener.java Purpose: has the actionlistener for show button to
 * display invitation.
 * 
 * @author Omar
 * @version 1.0
 */
public class NotifyListener implements ActionListener {
	public static int x = 0;

	public void actionPerformed(ActionEvent e) {

		x = Integer.valueOf(e.getActionCommand());// gets the value assigned to
													// the button
		receiveInvite a = new receiveInvite();
		try {
			a.riscreen();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
