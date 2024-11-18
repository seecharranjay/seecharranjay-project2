import java.io.*;
import java.net.*;

public class Client {
    
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;


    public Client(String host, int port) throws IOException {
        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected to server: " + host + ":" + port);
        } catch (IOException e) {
            throw new IOException("Cannot connect to server: " + e.getMessage(), e);
        }
    }

    public boolean handshake() throws IOException {
        out.println("12345");
        out.flush();
        return true; 
    }

    public String request(String data) throws IOException {
        out.println(data);
        out.flush();
        return in.readLine(); 
    }

    public void disconnect() throws IOException {
        try {
            out.close();
            in.close();
            socket.close();
            System.out.println("Disconnected from server");
        } catch (IOException e) {
            throw new IOException("Error closing client: " + e.getMessage(), e);
        }
    }

    public Socket getSocket() {
        return socket;
    }


}

