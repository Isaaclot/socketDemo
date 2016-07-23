import java.io.IOException;
import java.net.*;

/**
 * Created by Leong on 2016/7/24.
 */
public class client {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");  //定义服务器的地址，端口，数据
        int port = 8088;
        byte[] data = "用户名：roy 密码：admin".getBytes();
        DatagramPacket packer = new DatagramPacket(data,data.length,address,port);  //创建数据报：包含发送的信息
        DatagramSocket socket = new DatagramSocket();   //创建DatagramSocket通信对象，并发送数据报
        socket.send(packer);


    }
}
