package com.example.demo.rpc.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by zhoujin on  2019-01-06
 **/
public class ServerMain {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        HelloService helloService = new HelloServiceImpl();
        LocateRegistry.createRegistry(8801);
        Naming.bind("rmi://localhost:8801/helloService",helloService);
        System.out.println("ServerMain provide RPC service now.");
    }
}
