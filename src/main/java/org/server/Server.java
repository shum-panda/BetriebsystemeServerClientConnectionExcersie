package org.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private InputStream inputStream;
    private static int PORT_NUMBER=7778;

    private String whatsRead;

    public static void main(String[] args) throws IOException {
        Server server1=new Server();
        server1.start();
    }

    public String getWhatsRead(){
        return whatsRead;
    }
    public Server() throws IOException {
        server=new ServerSocket(PORT_NUMBER);
    }

    public void start() throws IOException {
        System.out.println("org.server.Server startet");
        socket=server.accept();
        inputStream=socket.getInputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        whatsRead= dis.readUTF();
        System.out.println("is waiting for massage on "+ PORT_NUMBER);
        System.out.println(whatsRead);
        socket.close();
        server.close();

    }
}
