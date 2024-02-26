package com.test.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.domain.Message;

@ServerEndpoint("/chat-server.do")
public class ChatServer {

	private static List<Session> list = new ArrayList<Session>();
	
	@OnOpen
	public void handleOpen(Session session) {
		
		list.add(session);
		
	}

	@OnMessage
	public void handleMessage(Session session, String msg) {
		
		Gson gson = new Gson();
		
		Message message = gson.fromJson(msg, Message.class);
		
		if (message.getCode().equals("2")) {
			
			list.remove(session);
			
			for (Session s : list) {
				
				try {
					
					s.getBasicRemote().sendText(msg);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		} else {
			
			for (Session s : list) {
				
				if (s != session) {
					
					try {
						
						s.getBasicRemote().sendText(msg);
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			}
			
		}
		
	}
	
	private void clearList() {
		
		Iterator<Session> iter = list.iterator();
		
		while (iter.hasNext()) {
			
			if (!(iter.next().isOpen())) {

				iter.remove();
				
			}
			
		}
		
	}
	
	@OnClose
	public void handleClose() {
		
		clearList();
		
	}

}
