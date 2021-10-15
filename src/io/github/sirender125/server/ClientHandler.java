package io.github.sirender125.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread
{
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
        // Handle the client,
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
                //else{}
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
