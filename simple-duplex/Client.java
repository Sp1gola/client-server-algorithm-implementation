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

            while(!stringa.equals("#")) {
                stringa = s.nextLine();
                p.println(stringa);
            }
            socket.close();
            p.close();
        }catch(Exception e ) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }


    }

}
