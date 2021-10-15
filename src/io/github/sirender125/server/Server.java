package io.github.sirender125.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static final int PORT = 5959;

    public static void main(String[] args)
    {
        // Run the server.
        try (ServerSocket serverSocket = new ServerSocket(PORT))
        {
            System.out.println("Server listening on port " + PORT + "...");

            // Run client handling loop.
            while (true)
            {
                // Accept a client.
                Socket socket = serverSocket.accept();
                System.out.println("A client connected.");

                // Get input and output streams.
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Handle the client. (The reader and writer will be closed by the handler.)
                new ClientHandler(socket, reader, writer).start();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        // Say something nice? Sorta pointless. Ha, ha!
        System.out.println("Thank you for using this server!!");
    }
}
