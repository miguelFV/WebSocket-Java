/**
 * 
 */
var ws=null;
$(document).ready(function() {
	var Ws = function(url) {
		var connServer;
		if (typeof (MozWebSocket) == 'function')
			this.connServer = new MozWebSocket(url);
		else
			this.connServer = new WebSocket(url);
		this.connServer.onopen = function() {
			console.log('Abriendo conexion..');
		};
		this.connServer.onmessage = function(evt) {
			console.log("recive message from server");
			console.log(evt);
			console.log(evt.data);
		};
		this.sendMessage = function(txt) {
			console.log("send message from server:" + txt);
			this.connServer.send(txt)
		};
		this.connServer.onclose = function() {
			console.log('Cerrando conexion..');
		};
	};
	ws = new Ws("ws://127.0.0.1:8084/WebSocketServer/webSocket");
});