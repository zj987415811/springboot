package com.example.demo.rpc.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by zhoujin on  2019-01-06
 **/
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    protected HelloServiceImpl() throws RemoteException {
    }

    protected HelloServiceImpl(int port) throws RemoteException {
        super(port);
    }

    protected HelloServiceImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String sayHello(String someOne) throws RemoteException {
        return "Hello,"+someOne;
    }
}
