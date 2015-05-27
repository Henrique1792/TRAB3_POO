package assets.books;

import java.io.*;
import java.util.*;

/*Books:important info!
 Estamos usando um boolean para settar se um livro
 já foi alugado ou não.
 tudo bem que os testes podem ser true ou false, mas apenas
 atentar aos campos, que estão na seguinte ordem no montador.
 
	booktitle
	isGlobal (liberado pra GALERA ou se é Texto)
	isRent (se está presente ou não);

Para que não ocorram problemas, é preciso seguir essa ordem na leitura.
Até onde sei NÃO HÁ ESCRITA POR BYTES NO ARQUIVO, e vamos ter de usar as streams
nas buscas, até onde sei é o jeito mais fácil de ir percorrendo o arquivo.
no mais eu acho que é isso, vou mandar esse arquivo na branch 0.0.01

se alguém não souber o pq dos números, eu explico:

primeiro num: versão final (1) ou versão em construção/testes(0);
segundo num: versão em debugging(1 e demais números) e construção (0)
terceiro num: versão da edição.

acho que é isso xD

Cordialmente Henrique Freitas


 */


public class books{
	boolean isGlobal;
	boolean isRent;
	String title;
	Scanner reading;
	
	public books(){
		this.set_bookname();
		this.set_isGlobal();
		this.set_Rent(false);
	}

	public void reg_book(String csv)throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(csv,true));
		buffWrite.append(this.title+" "+this.isGlobal+" "+this.isRent+"\n");
		buffWrite.close();
	}
	public void read_book(String csv)throws IOException{
		String teste;
		BufferedReader buffRead = new BufferedReader(new FileReader(csv));
		teste=buffRead.readLine();
		System.out.println(teste);
		buffRead.close();
	}
	

	void set_bookname(){
		this.reading=new Scanner(System.in);
		this.title=this.reading.nextLine();
	}

	
	void set_isGlobal(){
		String receiver;
		System.out.println("It's a general book? <YES/NO>");
		this.reading=new Scanner(System.in);
		receiver=reading.nextLine();
		if(receiver.equals("YES"))
			this.isGlobal=true;
		else
			this.isGlobal=false;

	}

	boolean get_isRent(){
		return this.isRent;
	}
	
	void set_Rent(boolean check){
		check=this.isRent;
	}
}
