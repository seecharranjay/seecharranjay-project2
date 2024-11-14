import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private PrintWriter out;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new PrintWriter(socket.getOutputStream(), true); 
    }

    public Socket getSocket() {
        return socket;
    }

    public void handshake() {
        out.println("12345");
    }

    public void disconnect() throws IOException {
        out.close();
        socket.close();
    }
}

