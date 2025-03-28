import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        System.out.println("indirizzo IP: ");
        String ip = s.next();

        System.out.println("port ");
        String port = s.next();

        String stringa =  "";
        try {
            Socket socket = new Socket(ip,Integer.parseInt(port));
            PrintWriter p = new PrintWriter(socket.getOutputStream(), true);

            Thread in = new Thread(new Input(socket));
            in.start();

            Thread out = new Thread(new Output(socket));
            out.start();

            in.join();
            out.join();

            p.close();
        }catch(Exception e ) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }


    }

}
