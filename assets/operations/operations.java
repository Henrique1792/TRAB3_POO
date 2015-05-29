package assets.operations;

import java.io.*;
import java.util.*;

/*
Funções de operação
*/
public class operations{
    String nameaux;
    String titleaux;
    int newlimit;
	/*
        Recupera e imprime todos os livros cadastrados de um arquivo.
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
        /*
        Escreve registro do arquivo.
        obs= adicionar campos data atual e data de devolução
	*/
        public void reg_writer()throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("operations.csv",true));
		buffWrite.append(this.nameaux + " "+this.titleaux+"  \n");
		buffWrite.close();
	} 
        
        /*
        adicionar operação que exclui registro do arquivo
        */
        
        /*
        adicionar operação que busca atrasos e retorna a penalidade
        */
}
