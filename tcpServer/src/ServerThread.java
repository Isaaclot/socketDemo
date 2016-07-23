import java.io.*;
import java.net.Socket;

/**
 * Created by Leong on 2016/7/23.
 */
public class ServerThread  extends Thread{

    //create Socket
    Socket socket= null;
    public ServerThread(Socket socket){
        this.socket =socket;
    }
    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;

        try {
            is= socket.getInputStream();  //获取字节输入流
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);    //转换为字符流
            String info = null;
            while ((info=br.readLine())!=null){  //读取字符流信息
                System.out.println("我是服务器：客户端说"+info);
            }
            socket.shutdownInput(); //关闭输入流
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎访问");
            pw.flush();     //更新缓存信息
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                pw.close();
                os.close();
                br.close();
                is.close();
                isr.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
