package server;

import common.AuthenticationInterface;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AuthenticationService
{
    public static void main(String[] args)
    {
        //Stars the RMI registry and binds the authentication service
        try
        {
            LocateRegistry.createRegistry(1099);
            AuthenticationInterface autheservice = new AuthenticationServiceImpl();
            Naming.rebind("rmi://localhost/AuthService",autheservice);
            System.out.println("Authentication service is running.........");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
