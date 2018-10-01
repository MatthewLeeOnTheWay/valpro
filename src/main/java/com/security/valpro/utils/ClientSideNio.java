package com.security.valpro.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ClientSideNio {
    ByteBuffer writeBuffer=ByteBuffer.allocate(1024);
    ByteBuffer readBuffer=ByteBuffer.allocate(1024);

    public void start() throws IOException{
        SocketChannel sc=SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("locahost",8080));

        Selector selector=Selector.open();
//        注册连接服务器的socket的动作
        sc.register(selector, SelectionKey.OP_CONNECT);

        Scanner scanner=new Scanner(System.in);
        while(true){
            //选择一组键，其相应的通道已为 I/O 操作准备就绪。
            //此方法执行处于阻塞模式的选择操作
            selector.select();
            Set<SelectionKey> keys=selector.selectedKeys();
            System.out.println("keys="+keys.size());
            Iterator<SelectionKey> keyIterator=keys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key=keyIterator.next();
                keyIterator.remove();

                if(key.isConnectable()){
                    sc.finishConnect();
                    sc.register(selector,SelectionKey.OP_WRITE);
                    System.out.println("serevr connected……");
                    break;
                }else if (key.isWritable()){
                    System.out.println("please input message:");
                    String message=scanner.nextLine();

                    writeBuffer.clear();
                    writeBuffer.put(message.getBytes());

                    writeBuffer.flip();
                    sc.write(writeBuffer);

//
                    sc.register(selector, SelectionKey.OP_READ);
                    sc.register(selector,SelectionKey.OP_WRITE);
                    sc.register(selector,SelectionKey.OP_READ);
                }else if (key.isReadable()){
                    System.out.println("receive message:");
                    SocketChannel client=(SocketChannel)key.channel();

                    readBuffer.clear();
                    int num= client.read(readBuffer);
                    System.out.println(new String(readBuffer.array(),0,num));
//                    准备下一次的读取
                    sc.register(selector,SelectionKey.OP_WRITE);
                }
            }
        }
    }

    public  static void main(String[] args) throws IOException {
        new ClientSideNio().start();
    }
}
