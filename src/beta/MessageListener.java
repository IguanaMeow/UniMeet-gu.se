package gu.se.project.beta;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageListener implements ActionListener {
	public static int x;

	@Override
	public void actionPerformed(ActionEvent e) {
		x = Integer.valueOf(e.getActionCommand());
		

		try {
			Message.window.dispose();
			
			SendMsg.changeMsgStatus();
			SendMsg.notifyUser();
			
			SendMsg.screen();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
