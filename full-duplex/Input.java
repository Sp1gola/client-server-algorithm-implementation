import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Input implements Runnable {
    private Socket socket;
    private String stringa;
    public Input(Socket socket){
        this.socket=socket;
        this.stringa = "";
    }

    public void run() {
        try {
            Scanner in = new Scanner(socket.getInputStream());

            while (!stringa.equals("#") && in.hasNextLine()) {
                stringa = in.nextLine();
                System.out.println(stringa);
            }
            socket.close();
            in.close();
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
}
