import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

import java.util.Scanner;
import java.util.Vector;

public class Client {

	Scanner in; 
	CinemaInterface cinema; 
	
	public Client() {
		in = new Scanner(System.in);
	    	if(System.getSecurityManager() == null) {
	    		System.setSecurityManager(new SecurityManager());
	    	}	    	 
	    	try {  
	            cinema =(CinemaInterface)Naming.lookup( "rmi://127.0.0.1/Tabela1");  
	    	}
	        catch(RemoteException e ) {  
	            System.out.println();  
	            System.out.println( "RemoteException: " + e.toString() );  
	        }  
	        catch(NotBoundException e ) {  
	            System.out.println();  
	            System.out.println( "NotBoundException: " + e.toString() );  
	        }  
	        catch(Exception e ) {  
	            System.out.println();  
	            System.out.println( "Exception: " + e.toString() );  
	        }
	}
	
	public void execute() {
		String comando;
		String cadeiras;
		
		try {
			System.out.println("Entre com um dos comandos a seguir:\n \t\tcadeiras livres\n\t\tget <key>\n\t\tsair");
			while(true) {
				comando = in.next();
				if(comando.equalsIgnoreCase("cadeiras livres")) {
					cinema.cadeirasLivres();
					System.out.println("Adicionou item");
				} else if(comando.equalsIgnoreCase("reservar cadeiras")) {
					cadeiras = in.nextLine();
					String[] parts = cadeiras.split(" ");
					cinema.reservarCadeiras(parts);
				} else {
					System.out.println("Saindo do programa");
					break;
				}
			}
		in.close();
		}catch(Exception e) {		
			System.out.println( "Exception: " + e.toString()); 
		}
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		c.execute();

	}

}
