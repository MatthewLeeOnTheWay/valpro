package com.security.valpro.utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class NioCollector {

    public static void fileChanel(){
        RandomAccessFile aFile=null;
        try{
            aFile=new RandomAccessFile("/static/readme.md","rw");
            FileChannel fileChannel=aFile.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            int byteRead=fileChannel.read(buffer);
            while(byteRead!=-1){
                buffer.flip();
                while(buffer.hasRemaining())
                {
                    System.out.print((char)buffer.get());
                }
                buffer.compact();
                byteRead = fileChannel.read(buffer);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void client(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try
        {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("10.10.195.115",8080));
            if(socketChannel.finishConnect())
            {
                int i=0;
                while(true)
                {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm "+i+++"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


}
