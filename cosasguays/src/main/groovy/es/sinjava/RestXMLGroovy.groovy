package es.sinjava

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer

class RestXMLGroovy {

	static main(args) {

		InetSocketAddress address = new InetSocketAddress(8000)
		HttpServer httpServer = HttpServer.create(address, 0)

		HttpHandler handler = new HttpHandler() {

					public void handle(HttpExchange exchange) throws IOException {

						Date today = new Date()
						String guayDay = today.format("dd/MMM/yy a hh:mm:ss")

						byte[] response = """<?xml version=\"1.0\"?>\n
												<resource id=\"llamada a test\" />\n<date>${guayDay}</date> \n""".getBytes();
						exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,response.length)
						exchange.getResponseBody().write(response)
						exchange.close()
					}
				};

		httpServer.createContext("/test", handler)

		// start the server
		httpServer.start();

		// Navigator http://localhost:8000/test
	}
}
