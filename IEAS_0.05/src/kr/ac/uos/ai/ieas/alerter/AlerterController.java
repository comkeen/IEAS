package kr.ac.uos.ai.ieas.alerter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import kr.ac.uos.ai.ieas.alerterView.AlerterView;
import kr.ac.uos.ai.ieas.resource.IeasConfiguration;
import kr.ac.uos.ai.ieas.resource.IeasMessage;

public class AlerterController { 

	private IeasMessage ieasMessage;
	private AlerterTransmitter alerterTransmitter;
	private AlerterView alerterView;

	private String alerterID;

	private String message;


	public AlerterController() {

		this.alerterID = "alerter-V2";

		this.ieasMessage = new IeasMessage();
		this.alerterView = new AlerterView(this, alerterID);
		this.alerterTransmitter = new AlerterTransmitter(this, alerterID);

	}

	public void sendMessageToGateway() {

		ieasMessage.setMessage(message);

		String id = ieasMessage.getIdentifier();
		String event = ieasMessage.getEvent();
		String addresses = ieasMessage.getAddresses();

		alerterView.addAlertTableRow(id, event, addresses);
		alerterTransmitter.sendMessage(message);

		System.out.println(alerterID+" Send Message to " + "(gateway) : ");
		System.out.println();
	}

	public void acceptMessage(String message) {

		try {
			ieasMessage.setMessage(message);

			String sender = ieasMessage.getSender();
			String identifier = ieasMessage.getIdentifier();

			System.out.println("(" + alerterID + ")" + " Received Message From (" + sender + ") : ");
			System.out.println();

			if(sender.equals(IeasConfiguration.IeasName.GATEWAY_NAME)) {
				alerterView.receiveGatewayAck(identifier);
			} else {
				alerterView.receiveAlertSystemAck(identifier);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String createMessage(String addresses, String event) {

		ieasMessage.setIdentifier(alerterID);
		ieasMessage.setSender(alerterID);
		ieasMessage.setSent();
		ieasMessage.setScopeToRestricted();
		ieasMessage.setAddresses(addresses);
		ieasMessage.setMsgTypeToAlert();
		ieasMessage.setEvent(event);
		ieasMessage.build();

		return ieasMessage.getMessage();
	}

	public String buildCap(String addresses, String event) {
		this.message = createMessage(addresses, event);

		return message;
	}

	public void sendTextAreaMessageToGateway(String message) {

		ieasMessage.setMessage(message);
		
		String id = ieasMessage.getIdentifier();
		String event = ieasMessage.getEvent();
		String addresses = ieasMessage.getAddresses();
		
		alerterView.addAlertTableRow(id, event, addresses);
		alerterTransmitter.sendMessage(message);
	}

	public void saveCap(String capMessage) {
		String fileName = "D://cap/test.xml";
		
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
			fw.write(capMessage);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("write comp");
	}
}
