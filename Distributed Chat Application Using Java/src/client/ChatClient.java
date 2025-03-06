package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient
{
    public static void main(String[] args) throws IOException {
     try(Socket socket = new Socket("localhost", 5000);
         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

         BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)))
     {
         System.out.println("Connected to Chat Server. Type your messages:");

         new Thread( () ->
         {
             try
             {
                 String serverMessage;
                 while ((serverMessage = reader.readLine()) != null)
                 {
                     System.out.println("Server: "+serverMessage);
                 }
             }catch(IOException e)
             {
                 e.printStackTrace();
             }
         }).start();

         String message;
         while((message = userInput.readLine()) != null)
         {
             writer.println(message);
         }
     } catch (IOException e)
     {
         e.printStackTrace();
     }

     }
}

