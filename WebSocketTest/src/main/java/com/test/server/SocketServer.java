package com.test.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test-server.do")
public class SocketServer {

	@OnOpen
	public void handleOpen() {
		
		System.out.println("클라이언트와 연결되었습니다.");
		
	}
	
	@OnMessage
	public String handleMessage(String msg) {
		
		System.out.println("수신한 메시지: " + msg);
		
		return "응답";
		
	}
	
	@OnError
	public void handleError(Throwable e) {
		
		System.out.println("발생한 에러: " + e.getMessage());
		
	}

	@OnClose
	public void handleClose() {
		
		System.out.println("클라이언트와의 연결이 종료되었습니다.");
		
	}
	
}
