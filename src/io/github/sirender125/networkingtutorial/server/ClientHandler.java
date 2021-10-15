package io.github.sirender125.networkingtutorial.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread
{
    public static final String PI_STRING = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679"; // source: http://www.math.com/tables/constants/pi.htm

    Socket socket;
    BufferedReader reader;
    PrintWriter writer;

    public ClientHandler(Socket socket, BufferedReader reader, PrintWriter writer)
    {
        this.socket = socket;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run()
    {
        // Handle the client.
        try
        {
            // Read all input from the client.
            String line;
            while ((line = reader.readLine()) != null)
            {
                // This server sends the date when asked,
                // but you can do anything here.

                if ("DATE".equals(line))
                {
                    // Send the current date and time as a string.
                    writer.println(new Date());
                }
                else if ("PI".equals(line))
                {
                    // Send 100 digits of pi.
                    writer.println(PI_STRING);
                }
                else
                {
                    // Deny the request.
                    writer.println("ERROR");
                }
            }

            // Close the input and output streams.
            reader.close();
            writer.close();

            // Disconnect from the client.
            socket.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
