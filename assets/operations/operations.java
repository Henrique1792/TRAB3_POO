package assets.operations;

import java.io.*;
import java.util.*;

/*read all implementada =D*/

public class operations{

	/*Recupera e imprime todos os livros cadastrados de um arquivo.
	*/
	public void recoverAll(String csv)throws IOException{
		String teste;
		BufferedReader reading = new BufferedReader(new FileReader(csv));
		
		while(reading.ready()){
			teste=reading.readLine();
			System.out.println(teste+"\n");
		}
		reading.close();
	}


}
