import java.net.*;
import java.io.*;

public class Client
{
  public static void main(String s[])
  {
    Socket socket;
  	PrintStream out;
	InputStreamReader input=new InputStreamReader(System.in);
	BufferedReader tastiera= new BufferedReader(input);
	String frase=new String("");
	String IP_dest, Port_dest;
	
	BufferedReader datin; 
	
	try{
		System.out.print("IP destinatario: ");
		IP_dest=tastiera.readLine();
		System.out.print("Port destinatario: ");
		Port_dest=tastiera.readLine();
		socket = new Socket(IP_dest,Integer.parseInt(Port_dest)); 
	 	out=new PrintStream(socket.getOutputStream());
	 	
	 	datin=new BufferedReader (new InputStreamReader(socket.getInputStream()));
	 	
		while(frase.compareTo("#")!=0)
		{	
		    frase=tastiera.readLine();
		    out.println(frase);
		    
		    frase=datin.readLine();
		    System.out.println(frase);
	    } 
          	socket.close();
    }catch(IOException e){ System.out.println(" "+e); }
  }
}
	