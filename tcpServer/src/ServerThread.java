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
            is= socket.getInputStream();  //��ȡ�ֽ�������
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);    //ת��Ϊ�ַ���
            String info = null;
            while ((info=br.readLine())!=null){  //��ȡ�ַ�����Ϣ
                System.out.println("���Ƿ��������ͻ���˵"+info);
            }
            socket.shutdownInput(); //�ر�������
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("��ӭ����");
            pw.flush();     //���»�����Ϣ
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
