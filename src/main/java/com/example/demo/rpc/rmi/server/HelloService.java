package com.example.demo.rpc.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zhoujin on  2019-01-06
 **/
public interface HelloService extends Remote {
    String sayHello(String someOne) throws RemoteException;
}
