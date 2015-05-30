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
		user Usr;
		int ok = 0;

		System.out.println(">Tipos de usuário: [C]omunidade, [A]luno ou [P]rofessor");
		System.out.println("\n> Informe o tipo de usuário");
		while(ok == 0){
			input = sc.next();
			switch(input){
				case "A":
					Usr = new student();
					Usr.print_User();
					ok = 1;
					break;
				case "C":
					Usr = new common();
					Usr.print_User();
					ok= 1;
					break;
				case "P":
					Usr = new teacher();
					Usr.print_User();
					ok = 1;
					break;
			}
			 if (ok==1){
				try{
					Usr.register_usr();
					System.out.println("Usuário cadastrado.\n");
			
				} catch(IOException input_mistake){
					System.out.println("cadastro não foi possível");
				}
		 
			 }
		}

		
	
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
