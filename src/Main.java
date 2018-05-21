import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static int PORT = 2017;

    public static void main(String[] args) {
        MWebSocketService socketServer = null;
        try {
            socketServer = new MWebSocketService(PORT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        socketServer.start();

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = socketServer.getPort();
            System.out.println(String.format("服务已启动: %s:%d", ip, port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
//        Timer timer = new Timer();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println();// new Date()为获取当前系统时间
//                socketServer.sendToAll("系统消息啊:" + df.format(new Date()));
//            }
//        }, 0, 1000 * 10);
    }
}
