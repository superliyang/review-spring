package com.comb.spring.thrift.demo.application;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.comb.spring.thrift.demo.HelloWorldService;
import com.comb.spring.thrift.demo.impl.HelloWorldServiceImpl;

public class ServerApplication {
	
	public static void main(String[] args) {
		try {
			TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());
			TServerSocket serverTransport = new TServerSocket(9000);
			TServer.Args tArgs = new TServer.Args(serverTransport);
			tArgs.processor(tProcessor);
			tArgs.protocolFactory(new TBinaryProtocol.Factory());
			
			TServer tServer = new TSimpleServer(tArgs);
			tServer.serve();
			
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

}
