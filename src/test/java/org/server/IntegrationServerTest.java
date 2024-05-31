package org.server;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;

public class IntegrationServerTest extends TestCase {
    public IntegrationServerTest( String testName )
    {
        super( testName );
    }

    public static TestSuite TestSuite(){return new TestSuite(IntegrationServerTest.class); }

    public void testServerClientConnection() throws IOException {
        Server server=new Server();
        Client client=new Client();
        String testString="Test String send on Port 7778";

        Runnable thread1 = () ->
        {
            // Used to set custom name to the current thread
            Thread.currentThread().setName("myThread");
            try {
                server.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        Thread run=new Thread(thread1);
        run.start();
        client.start(testString);
        assertEquals(server.getWhatsRead(),testString);
    }
}
