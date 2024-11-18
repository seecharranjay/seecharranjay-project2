import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private PrintWrited out;
    private BufferedReader in;


    public void disconnect() {
        out.close();
        in.close();
        socket.close();
    }
}
