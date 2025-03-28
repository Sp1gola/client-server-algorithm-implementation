import java.net.*;
import java.io.*;

public class server 
{
	public static void main(String s[]) 
	{
		ServerSocket canale_ser;
		Socket socket;
		PrintStream out;
		String frase=new String("");
		String Port_di_ascolto;
		BufferedReader tastiera= new BufferedReader(new InputStreamReader(System.in));
		BufferedReader datin; 
		try {
			System.out.print("Port di ascolto: ");
			Port_di_ascolto=tastiera.readLine();
			canale_ser=new ServerSocket(Integer.parseInt(Port_di_ascolto));
			System.out.println("In attesa di connessioni...");
			socket=canale_ser.accept();
			System.out.println("Connesso!");
			datin=new BufferedReader (new InputStreamReader(socket.getInputStream()));
			
			out=new PrintStream(socket.getOutputStream());
			
			while(frase.compareTo("#")!=0)
			{
			    frase=datin.readLine();
			    System.out.println(frase);
			    
			    frase=tastiera.readLine();
			    out.println(frase);
			}
			socket.close();
		} catch (IOException e) {System.out.println(""+e);}
	}
}