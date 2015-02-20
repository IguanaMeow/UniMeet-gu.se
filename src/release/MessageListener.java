

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * MessageListener.java Purpose: contains the actionListener for show button in
 * messages
 * 
 * @author Omar
 * @version 1.0
 */
public class MessageListener implements ActionListener {
	public static int x;

	@Override
	public void actionPerformed(ActionEvent e) {
		x = Integer.valueOf(e.getActionCommand());

		try {

			SendMsg.changeMsgStatus();
			SendMsg.notifyUser();

			SendMsg.screen();

			HomePage.showMessInv.removeAll();// remove contents of panel
			HomePage.showMessInv.add(new Message());// add new contents
			HomePage.contentPane.revalidate();// refresh the panel
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
