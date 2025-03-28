import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        System.out.println("port: ");
        String port = s.nextLine();

        String stringa =  "";

        try {
            ServerSocket socket = new ServerSocket(Integer.parseInt(port));
            Socket socket2 = socket.accept();
            System.out.println("Connesso!");
            Scanner in = new Scanner(socket2.getInputStream());

            while(!stringa.equals("#") && in.hasNextLine()) {
                stringa = in.nextLine();
                System.out.println(stringa);
            }
            socket.close();
            in.close();
        }catch(Exception e ) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }
    }

}
