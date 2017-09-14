package mx.serverSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint(value = "/webSocket")
public class WSEndPoint extends HttpServlet {
	private final Logger log = Logger.getLogger(getClass().getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 5839283778172464000L;

	@OnOpen
	public void onOpen(Session session, EndpointConfig ePointConf) {
		try {
			log.info("Nueva conexion de " + session.getId());
			System.out.println("Nueva conexion de " + session.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@OnMessage
	public void onTextMessage(Session session, String msg) throws IOException {
		try {
			Set<Session> sesiones = session.getOpenSessions();
			if (sesiones.size() > 1) {
				for (Session ses : sesiones) {
					if (session.getId() != ses.getId()) {
						ses.getBasicRemote().sendText(msg);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnMessage
	public void onBinaryMessage(Session session, ByteBuffer msg) {
		log.info("Un mensaja onBinaryMessage");
	}

	@OnMessage
	public void onPongMessage(Session session, PongMessage pMsg) {
		log.info("Un mensaje onPongMessage: " + pMsg.getApplicationData());
	}

	@OnClose
	public void onClose(Session session) {
		log.info("Cerrando conexion de: " + session.getId());
		System.out.println("Cerrando conexion de " + session.getId());
	}

}
