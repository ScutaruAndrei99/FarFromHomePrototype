package interfata;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port = 9999;
    private List<Client> clients = new ArrayList<>();

    public void execute() {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serverul a pornit pe portul " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Client user = new Client(clientSocket, this);
                System.out.println("New connection...");
                clients.add(user);
                user.start();
            }
        } catch (IOException e) {
            System.out.println("Nu am putut deschide serverul pe portul " + port);
            System.exit(1);
        }
    }

    public void sendMessage(String message, String username) {
        System.out.println("Sending message to " + clients.size() + " connected users");
        for (Client client : clients) {
            client.sendMessage("[" + username + "] " + message + "\n");
        }
    }

    public static void main(String[] args) {
        new Server().execute();
    }

    public void disconnect(Client userThread) {
        clients.remove(userThread);
    }
}
