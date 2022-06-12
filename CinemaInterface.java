import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface CinemaInterface extends Remote{

	public Vector<String> cadeirasLivres() throws RemoteException;
	public void reservarCadeiras(String[] cadeirasEscolhidas) throws RemoteException;
	
}
