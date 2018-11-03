package Demo_BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo {

    public static void main(String[] args) {

        BufferedReader in = null;
        PrintWriter out = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5678);
            System.out.println("服务端已启动。");
            while (true){
                Socket socket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);

                String result = "";
                if((result=in.readLine()) == null) break;
//                String readLine = in.readLine();
                System.out.println("客户端:"+result);

                System.out.print("我：");
                Scanner sc = new Scanner(System.in);
                String info = sc.nextLine();
                out.println(info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if(out!=null){
                out.close();
                out = null;
            }
        }
    }
}
