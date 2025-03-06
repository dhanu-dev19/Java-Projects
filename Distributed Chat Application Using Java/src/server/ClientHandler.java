package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

public class ClientHandler
{
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final Set<ClientHandler> clients;

    public ClientHandler(Socket socket, Set<ClientHandler> clients)throws IOException
    {
        this.socket = socket;
        this.clients = clients;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(),true);
    }

    public void run()
    {
        try
        {
            String message;
            while((message = reader.readLine()) != null)
            {
                System.out.println("Received: "+message);
                broadcast(message);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void broadcast(String message)
    {
        for (ClientHandler client : clients)
        {
            client.writer.println(message);
        }
    }
}
