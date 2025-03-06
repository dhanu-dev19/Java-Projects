package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatServer
{
    private static final int PORT = 5000;
    private static final Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());


    public static void main(String[] args)
    {
       try(ServerSocket serverSocket = new ServerSocket(PORT))
       {
           System.out.println("Chat Server is running on port "+PORT);

           while (true)
           {
               Socket clientSocket = serverSocket.accept();
               ClientHandler clientHandler = new ClientHandler(clientSocket,clients);
               clients.add(clientHandler);
               new Thread(String.valueOf(clientHandler)).start();
           }
       } catch (IOException e)
       {
           e.printStackTrace();
       }
    }
}
