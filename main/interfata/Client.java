package interfata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private OutputStream writer;
    private String username;
    private Server server;

    public Client(Socket clientSocket, Server server) {
        this.socket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = socket.getOutputStream();
            username = reader.readLine();
            server.sendMessage("User "+username+" has joined the channel", username);

            String message;
            do {
                message = reader.readLine();
                server.sendMessage(message, username);
//                switch(message.split("#")[0]) {
//                    case "1": // autentificare
//                    case "2": // message
//                    case "3" : // quit
//                    case "4": // private message
//                    default: // unknown option!
//                }
            } while (!message.equals("QUIT"));
            socket.close();
            server.disconnect(this);

        } catch (IOException e) {
            System.out.println("Nu am putut deschide conexiunea pentru citire sau scriere. " + e.getMessage());
        }

    }

    public void sendMessage(String s) {
        try {
            writer.write(s.getBytes());
        } catch (IOException e) {
            System.out.println("Nu am putut trimite mesajul catre client");
        }
    }
}