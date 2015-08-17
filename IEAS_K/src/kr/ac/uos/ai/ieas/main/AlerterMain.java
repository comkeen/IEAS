package kr.ac.uos.ai.ieas.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import kr.ac.uos.ai.ieas.alerter.AlerterController;

public class AlerterMain{

	private JFrame frame;
	private JButton alerterButton;
	private JButton gatewayButton;
	private JButton alertsystemButton;

	private ActionListener actionListener;




	public AlerterMain() {

		new AlerterController();
	}

	public static void main(String[] args) {
		new AlerterMain();
	}

	private void createGUI(){
		this.frame = new JFrame();
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		alerterButton = new JButton("alerter");
		gatewayButton = new JButton("gateway");
		alertsystemButton = new JButton("alertsystem");

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String event = e.getActionCommand();
				switch (event) {
				case "alerter":
					
					break;
				case "gateway":

					break;
				case "alertsystem":

					break;
				default:
					break;
				}
			}
		};
	}
}
