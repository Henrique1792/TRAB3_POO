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
		boolean ok = false;
		user Usr = new user();
		System.out.println(">Tipos de usuário: [C]omunidade, [A]luno ou [P]rofessor");
		System.out.println("\n> Informe o tipo de usuário");

		while(!ok){
			input = sc.next();
			switch(input){
				case "A":
					Usr = new student();
					Usr.print_User();
					ok = true;
					break;
				case "C":
					Usr = new common();
					Usr.print_User();
					ok = true;
					break;
				case "P":
					Usr = new teacher();
					Usr.print_User();
					ok = true;
					break;
			}
			 if (ok){
				try{
					Usr.register_user();
					System.out.println("Usuário cadastrado.\n");
			
				} catch(IOException input_mistake){
					System.out.println("cadastro não foi possível");
					}
		 
			 }
		}
	}

	/*Recupera e imprime todos os livros cadastrados de um arquivo.
	*/


}
