package io.github.sirender125.networkingtutorial.client;

import io.github.sirender125.networkingtutorial.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        // Connect to the server on localhost:PORT (127.0.0.1 is localhost.)
        try (Socket socket = new Socket("127.0.0.1", Server.PORT))
        {
            System.out.println("Successfully connected to server on port " + Server.PORT);
            System.out.println("Commands known: DATE - queries the current date\nPI - queries 10 digits of pi.");

            // Get input and output streams.
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true); // Passing in true here enables automatic flushing.

            // For user input.
            Scanner scanner = new Scanner(System.in);

            // We will handle input and output on the main thread since only one client will be running.
            while (socket.isBound()) // TODO: Use a different condition?
            {
                System.out.print("Enter a command: ");
                String command = scanner.nextLine();

                // Send the command to the server.
                writer.println(command);

                // Print the server's response. (This will wait until the server does respond.)
                System.out.println(reader.readLine());
            }

            // Close the input and output streams.
            reader.close();
            writer.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        // Again with the cheesy remarks.
        System.out.println("Have a nice day!");
    }
}
