import java.io.*;
import java.net.Socket;

/**
 * Created by Leong on 2016/7/23.
 */
class client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",8889);  //create client socket with ip port
            OutputStream os = socket.getOutputStream(); //获取字节输出流，向服务器发送信息
            PrintWriter pw = new PrintWriter(os);   //将输出流转换为打印流
            pw.write("用户名：admin 密码：123");
            pw.flush();
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String receivefromServer = null;
            while ((receivefromServer=br.readLine())!=null){
                System.out.println("我是客户端，服务器说："+receivefromServer);
            }
            is.close();
            br.close();

            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
