import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject; 

public class Cinema extends UnicastRemoteObject implements TableInterface{
	Vector<Vector<bool>> salaCinema;
	HashMap<Integer,String> intToString;
	
	public Cinema() throws RemoteException {
		salaCinema = new Vector<Vector<bool>>();
		for(int i = 0; i < 10; i++){
			Vector<bool> r = new Vector<bool>();
			for(int j = 0; j < 15; j++){
				r.add(true);
			}
			matrix.add(r);
    	}
		intToString = new <Integer,String>;
		intToString.put(0, "a"); intToString.put(1, "b"); intToString.put(2, "c"); intToString.put(3, "d");
		intToString.put(4, "e"); intToString.put(5, "f"); intToString.put(6, "g"); intToString.put(7, "h");
		intToString.put(8, "i"); intToString.put(9, "j");
	}
	
	public Vector<String> cadeirasLivres() throws RemoteException {
		Vector<String> cadeiras_livres = new Vector<String>();
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				if (salaCinema[i][j]) {
					String assento;
					assento = intToString.get(i) + (j+1).toString;
					cadeiras_livres.add(assento);
				}
			}
    	}
		return cadeiras_livres;
	}

	public void reservarCadeiras(Vector<String> cadeirasEscolhidas) throws RemoteException {
		for(int i = 0; i < cadeirasEscolhidas.size(); i++){
			String assento = cadeirasEscolhidas[i];
			int fileira, coluna;
			for(int key: intToString.keySet()) {
				if(intToString.get(key).equals(assento[0])) {
					fileira = key;
				}
			}
			coluna = Integer.valueOf(cadeirasEscolhidas.substring(1)) - 1;
			salaCinema[fileira][coluna] = false;
		}		
	}

}
