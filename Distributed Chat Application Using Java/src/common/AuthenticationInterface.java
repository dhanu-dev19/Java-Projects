package common;

import java.rmi.Remote;
import java.rmi.RemoteException;


//This interface defines the remote method for user authentication
public interface AuthenticationInterface extends Remote
{
    boolean login(String username, String password) throws RemoteException;
}
