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
   
    Socket sock=null;        
    try{
        sock = new Socket("localhost",2021);
    }catch(Exception e){
        System.err.println("Cannot Connect");
        System.exit(1);
    }

    try{
        PrintWriter pw = new PrintWriter(sock.getOutputStream());
        pw.println("HelloWorld");
        pw.close(); //close the stream
        sock.close();//close the socket
    }catch(Exception e){
        System.err.print("IOException");
        System.exit(1);
    }
}

