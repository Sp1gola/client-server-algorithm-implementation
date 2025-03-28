import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Output implements Runnable {
    private Socket socket;
    private String stringa;
    public Output(Socket socket){
        this.socket=socket;
        this.stringa="";
    }

    public void run() {
        try {
            Scanner s= new Scanner(System.in);
            PrintWriter p = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connesso!");

            while (!stringa.equals("#")) {
                stringa = s.nextLine();
                p.println(stringa);
            }
            socket.close();
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
}

