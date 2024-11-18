import java.io.*;
import java.net.*;

public class Client {
    /*
    private Socket socket;
    private PrintWrited out;
    private BufferedReader in;

    
    public void disconnect() {
        out.close();
        in.close();
        socket.close();
    }
    */

    public Client(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.socket = new Socket(host, port);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
