import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        System.out.println("port: ");
        String port = s.nextLine();

        try {
            ServerSocket socket = new ServerSocket(Integer.parseInt(port));
            Socket socket2 = socket.accept();
            System.out.println("Connesso!");

            Thread in = new Thread(new Input(socket2));
            in.start();

            Thread out = new Thread(new Output(socket2));
            out.start();

            in.join();
            out.join();

        }catch(Exception e ) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }
    }

}
