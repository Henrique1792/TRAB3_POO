package assets.operations;

//Importing our assets...
import assets.users.*;

//Importing Java packages...
import java.io.*;
import java.util.*;

/*read all implementada =D*/

public class operations{

	/* Cadastra um usuário, pedindo seu tipo e seu nome */
	public void create_user(){
		Scanner sc = new Scanner(System.in);
		String input;
		user user;
		int ok = 0;

		System.out.println(">Tipos de usuário: [C]omunidade, [A]luno ou [P]rofessor");
		while(ok == 0){
			System.out.println("	>Informe o tipo de usuário: ");
			input = sc.next();
			switch(input){
				case "A":
					user = new student();
					ok = 1;
					break;
				case "C":
					user = new common();
					ok = 1;
					break;
				case "P":
					user = new teacher();
					ok = 1;
					break;
			}
		}

		//user.register_user();
		System.out.println("		OK!");
	}

	/*Recupera e imprime todos os livros cadastrados de um arquivo.
	*/
	public void recoverAll(String csv)throws IOException{
		String teste;
		BufferedReader reading = new BufferedReader(new FileReader(csv));
		
		while(reading.ready()){
			teste = reading.readLine();
			System.out.println(teste + "\n");
		}
		reading.close();
	}


}
