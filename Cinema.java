import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Vector; 

public class Cinema extends UnicastRemoteObject implements CinemaInterface{
	Vector<Vector<Boolean>> salaCinema;
	HashMap<Integer,String> intToString;
	
	public Cinema() throws RemoteException {
		salaCinema = new Vector<Vector<Boolean>>();
		for(int i = 0; i < 10; i++){
			Vector<Boolean> r = new Vector<Boolean>();
			for(int j = 0; j < 15; j++){
				r.add(true);
			}
			salaCinema.add(r);
    	}
		intToString = new HashMap<Integer,String>();
		intToString.put(0, "a"); intToString.put(1, "b"); intToString.put(2, "c"); intToString.put(3, "d");
		intToString.put(4, "e"); intToString.put(5, "f"); intToString.put(6, "g"); intToString.put(7, "h");
		intToString.put(8, "i"); intToString.put(9, "j");
	}
	
	public Vector<String> cadeirasLivres() throws RemoteException {
		Vector<String> cadeiras_livres = new Vector<String>();
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				if (salaCinema.get(i).get(j)) {
					String assento;
					assento = intToString.get(i) + String.valueOf(j+1);
					cadeiras_livres.add(assento);
				}
			}
    	}
		return cadeiras_livres;
	}

	public void reservarCadeiras(String[] cadeirasEscolhidas) throws RemoteException {
		for(int i = 0; i < cadeirasEscolhidas.length; i++){
			String assento = cadeirasEscolhidas[i];
			int fileira = 0; 
			int coluna;
			for(int key: intToString.keySet()) {
				if(intToString.get(key).equals(assento.substring(0,1))) {
					fileira = key;
				}
			}
			coluna = Integer.valueOf(cadeirasEscolhidas[i].substring(1)) - 1;
			salaCinema.get(fileira).set(coluna, false);
		}		
	}

}
