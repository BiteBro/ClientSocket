package edu.clientSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Алексей
 */
public class SocketClient {
    private String host;
    private int port;    
    private String clientName;

    public SocketClient(String host, int port, String clientName) {
        this.host = host;
        this.port = port;
        this.clientName = clientName;
    }

    public SocketClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public void startConnection(){
        while (true) {             
        try (Socket s = new Socket(host, port);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream())){
            System.out.println();

            dos.writeUTF(clientName);
            dos.flush();

            String serverMessage = dis.readUTF();
            System.out.println("Server ansver : " + serverMessage);
            
        } catch(Exception ex){
            if (ex instanceof SocketException) {
                System.out.println("--> Reconnection: " + host +" port " + port);
                System.out.println();                
                continue;
            } else Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }            
        }
    }

    public String getClientName() {
        return clientName;
    }
   
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
   
}
