import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CinemaInterface extends Remote{

	public Vector<String> cadeirasLivres() throws RemoteException;
	public void reservarCadeiras(Vector<String> cadeirasEscolhidas) throws RemoteException;
	
}
