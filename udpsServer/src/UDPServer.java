import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Leong on 2016/7/24.
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8088);//创建DatagramSocket，指定端口
        byte[] data = new byte[1024];  //创建数据报，用于接收客户端发送的数据
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
        socket.receive(datagramPacket); //此方法在接收到数据报之前一直阻塞
        String info = new String(data,0,datagramPacket.getLength());  //读取数据
        System.out.println("我是服务器，客户端说："+info);
    }
}
