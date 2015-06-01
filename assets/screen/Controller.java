package assets.screen;

//Importing our assets...
import assets.operations.*;
import assets.users.*;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class Controller extends screen_utils{
	Scanner sc;
	operations op;

	public Controller(){
		this.op = new operations();
		this.sc = new Scanner(System.in);
	}

	//controlador da tela de cadastros
	//-------------------------------------//
	void signScreen_controller(){
		int quit = 0;

		this.signScreen();
		while (quit == 0){
			quit = sc.nextInt();
			switch(quit){
				case 1:
					op.create_user();
					this.delim();
					break;
				case 2:
					op.create_book();
					this.delim();
					break;
				case 3:
					break;
			}
		}
	}

	//controlador da tela de empréstimos & devoluções
	//-------------------------------------//
	void rentScreen_controller(){
		int quit = 0;

		this.rentScreen();
		while (quit == 0){
			quit = sc.nextInt();
			switch(quit){
				case 1:
					this.delim();
					break;
				case 2:
					this.delim();
					break;
				case 3:
					break;
			}
		}
	}

	//controlador da tela de atrasos
	//-------------------------------------//
	void delayScreen_controller(){
		int quit = 0;

		this.delayScreen();
		while (quit == 0){
			quit = sc.nextInt();
			switch(quit){
				case 1:
					this.delim();
					break;
				case 2:
					this.delim();
					break;
				case 3:
					break;
			}
		}
	}

	//controlador da tela de listar usuários & livros
	//----------------------------------------------------------//
	void listScreen_controller(){
		int quit = 0;

		this.listScreen();
		while (quit == 0){
			quit = sc.nextInt();
			switch(quit){
				case 1:
					try{
						op.recoverAllUsers("users.csv");
					} catch(IOException stream_error){
						System.out.println("\n\tNão foi possível recuperar a lista D:\n");
					}
					this.delim();
					break;
				case 2:
					try{
						op.recoverAllBooks("books.csv");
					} catch(IOException stream_error){
						System.out.println("\n\tNão foi possível recuperar a lista D:\n");
					}
					this.delim();
					break;
				case 3:
					this.delim();
					break;
				case 4:
					break;
			}
		}
	}

	//controlador da tela de pesquisas
	//-------------------------------------//
	void searchScreen_controller(){
		int quit = 0;

		this.searchScreen();
		while (quit == 0){
			quit = sc.nextInt();
			switch(quit){
				case 1:
					op.searchUser("users.csv");
					this.delim();
					break;
				case 2:
					op.searchBook("books.csv");
					this.delim();
					break;
				case 3:
					break;
			}
		}
	}

	//controlador da tela de remoções
	//-------------------------------------//
	void removeScreen_controller(){
		int quit = 0;

		this.removeScreen();
		while (quit == 0){
			quit = sc.nextInt();
			switch(quit){
				case 1:
					try{
						if(op.removeUser("users.csv") == 1) System.out.println("\n\tUsuário removido :D");
						else System.out.println("\n\tUsuário não encontrado D:");
					} catch(IOException stream_error){
						System.out.println("\n\tNão foi possível recuperar a lista D:\n");
					}
					this.delim();
					break;
				case 2:
					try{
						if(op.removeBook("books.csv") == 1) System.out.println("\n\tLivro removido :D");
						else System.out.println("\n\tLivro não encontrado D:");
					} catch(IOException stream_error){
						System.out.println("\n\tNão foi possível recuperar a lista D:\n");
					}
					this.delim();
					break;
				case 3:
					break;
			}
		}
	}

}
