import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Leong on 2016/7/23.
 */
public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8889);  //create listen port
            System.out.println("服务器即将启动，等待客户端连接");
            int count =0;   //记录客户端数量
            while (true) {
                Socket socket = serverSocket.accept();  //start listen waitting connecting
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端数量："+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
