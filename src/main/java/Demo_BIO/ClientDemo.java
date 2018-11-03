package Demo_BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            while (true){
                socket = new Socket("127.0.0.1",5678);
                out = new PrintWriter(socket.getOutputStream(),true);
                System.out.print("我：");
                Scanner sc = new Scanner(System.in);
                String info = sc.nextLine();

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(info);

                String serverStr = in.readLine();
                System.out.println("服务端："+serverStr);
            }
        }catch (Exception e){
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
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
