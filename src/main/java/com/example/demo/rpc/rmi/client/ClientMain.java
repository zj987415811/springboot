package com.example.demo.rpc.rmi.client;

import com.example.demo.rpc.rmi.server.HelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by zhoujin on  2019-01-06
 **/
public class ClientMain
{
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //构造服务对象
        HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8801/helloService");
        System.out.println("RMI服务返回结果:\"" + helloService.sayHello("rocky"));
    }
}
