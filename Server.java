import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.*;


public class Server {

    private final int port;
    private ServerSocket serverSocket;
    private final List<LocalDateTime> connectionTimes = Collections.synchronizedList(new ArrayList<>());

    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    public void serve(int clientCount) {
        try {
            for (int i = 0; i < clientCount; i++) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

           
            String passcode = in.readLine();
            if (!"12345".equals(passcode)) {
                out.println("couldn't handshake"); 
                return; 
            }
            connectionTimes.add(LocalDateTime.now());

            
            String input = in.readLine();
            try {
                long number = Long.parseLong(input);
                if (number > Integer.MAX_VALUE) {
                    out.println("There was an exception on the server");
                    return;
                }
                List<Integer> factors = calculateFactors((int) number);
                out.printf("The number %d has %d factors%n", number, factors.size());
            } catch (NumberFormatException e) {
                out.println("There was an exception on the server");
            }

        } catch (IOException e) {
            System.err.println("Error communicating with client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }

    public void disconnect() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public ArrayList<LocalDateTime> getConnectedTimes() {
        return new ArrayList<>(connectionTimes);
    }

    private List<Integer> calculateFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors.add(i);
        }
        return factors;
    }
}


