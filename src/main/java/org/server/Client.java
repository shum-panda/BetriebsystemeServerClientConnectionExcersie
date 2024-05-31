package org.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private OutputStream outputStream;
    private static int PORT_NUMBER=7778;

    public static void main(String[] args) throws IOException {
        Client client =new Client();
        client.start("hello");
    }
    public Client() throws IOException {
        socket=new Socket("", PORT_NUMBER);// host: "", redirect to localhost
    }

    public void start(String massage) throws IOException {
        outputStream=socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
         dos.writeUTF(massage);
        System.out.println(massage+" was send successfully");
        socket.close();

    }
}
