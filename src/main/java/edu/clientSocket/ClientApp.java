package edu.clientSocket;

import java.io.IOException;


public class ClientApp {
    private static String nameClient;
public static void main(String [] args) throws IOException, InterruptedException {
    nameClient = NameClientSetter.getCommandArgsName(args);
    SocketClient socketClient = new SocketClient("localhost", 6666, nameClient);
    socketClient.startConnection();
}

}    

