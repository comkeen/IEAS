package kr.ac.uos.ai.ieas.main;

import kr.ac.uos.ai.ieas.gatewayController.GatewayController;

public class GatewayMain{

	public GatewayMain() {

		GatewayController.getInstance();
	}

	public static void main(String[] args) {
		new GatewayMain();
	}
}
