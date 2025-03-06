package server;

import common.AuthenticationInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


//This class implements remote authentication logic
public class AuthenticationServiceImpl extends UnicastRemoteObject implements AuthenticationInterface
{
    private final Map<String, String> users = new HashMap<>();

    protected AuthenticationServiceImpl() throws RemoteException
    {
        super();
        users.put("alice","password123");
        users.put("bob","securepass");
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
