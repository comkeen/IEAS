package kr.ac.uos.ai.ieas.alerter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.ac.uos.ai.ieas.alerterView.AlerterView;

public class AleterActionListener implements ActionListener{
	
	private AlerterView view;
	
	
	public AleterActionListener(AlerterView view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();
		
		if (actionCommand.equals("GenerateCap")){
			view.generateCap();
		} else if(actionCommand.equals("Send")) {
			view.sendMessage();			
		} else if(actionCommand.equals("TextAreaSend")) {
			view.sendTextAreaMessage();			
		} else if(actionCommand.equals("SaveCap")) {
			view.saveCap();			
		}
	}
	
	

}
