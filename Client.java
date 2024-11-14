import java.util.*;
import java.io.*;
import java.net.*;


public class Client {

    private Socket socket;

    public Client (String localAddress, int port) throws IOException {
        socket = new Socket(localAddress, port);
    }

    public Socket getSocket() {
        return socket; 
    }

    public void handShake() {
        System.out.println("12345");
    }

    public void disconnect() {
        socket.close();
    }
}
