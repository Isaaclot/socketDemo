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
            System.out.println("�����������������ȴ��ͻ�������");
            int count =0;   //��¼�ͻ�������
            while (true) {
                Socket socket = serverSocket.accept();  //start listen waitting connecting
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("�ͻ���������"+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
