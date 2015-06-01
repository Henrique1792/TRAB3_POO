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
    boolean returned; // se o emprestimo foi devolvido, returned =1
    
    
	//Funções de cadastrar//
	//####################################################################//
	//--------------------//
	//Cadastrar um usuário//
	//--------------------//
	public void create_user(){
		Scanner sc = new Scanner(System.in);
		String input;
		boolean ok = false;
		user Usr = new user();
		System.out.println(">Tipos de usuário: [C]omunidade, [A]luno ou [P]rofessor");

		while(!ok){
			System.out.printf("\n\t>Informe o tipo de usuário: ");
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
					Usr.register_user("users.csv");
					System.out.println("\n\tUsuário cadastrado :D\n");
			
				} catch(IOException stream_error){
					System.out.println("\n\tCadastro não foi possível D:\n");
				}
		 
			}
		}
	}

	//------------------//
	//Cadastrar um livro//
	//------------------//
	public void create_book(){
		books Book = new books();

		Book.set_BookTitle();
		Book.set_isGlobal();
		Book.print_Book();

		try{
			Book.register_book("books.csv");
			System.out.println("\n\tLivro cadastrado :D\n");
		} catch(IOException stream_error){
			System.out.println("\n\tCadastro não foi possível D:\n");
		}
	}
	//####################################################################//

	//Funções de pesquisar//
	//####################################################################//
	//-----------------//
	//Pesquisar usuário//
	//-----------------//
	public user search_User(String csv, String input){

		
		user Usr = new user();

		try{
			if(Usr.read_user(csv, input)[0] == 1) return Usr;
			else System.out.println("\n\tUsuário não encontrado D:\n");
                             return null;
		} catch(IOException input_mistake){
			System.out.println("\n\tUsuário não encontrado D:\n");
                        return null;
		}

	}

	//---------------//
	//Pesquisar livro//
	//---------------//
        
        public void searchUser(String csv){

		String input;
		Scanner sc = new Scanner(System.in);
		user Usr = new user();

		System.out.printf("\n\t>Digite o nome do usuário: ");
		input = sc.nextLine();

		try{
			if(Usr.read_user(csv, input)[0] == 1) Usr.print_User();
			else System.out.println("\n\tUsuário não encontrado D:\n");
		} catch(IOException input_mistake){
			System.out.println("\n\tUsuário não encontrado D:\n");
		}

	}
        
	public int searchBook(String csv){

		String input;
		Scanner sc = new Scanner(System.in);
		books Book = new books();

		System.out.printf("\n\t>Digite o nome do livro: ");
		input = sc.nextLine();

		try{
			if(Book.read_book(csv, input)[0] == 1) return Book.read_book(csv, input)[0];
			else System.out.println("\n\tLivro não encontrado D:\n");
                             return 0;
		} catch(IOException input_mistake){
			System.out.println("\n\tLivro não encontrado D:\n");
                        return 0;
		}

	}
        
        public books searchBook(String csv, String book){

		
		books Book = new books();


		try{
			if(Book.read_book(csv, book)[0] == 1) return Book;
			else System.out.println("\n\tLivro não encontrado D:\n");
                             return null;
		} catch(IOException input_mistake){
			System.out.println("\n\tLivro não encontrado D:\n");
                        return null;
		}

	}
	//####################################################################//

	//Funções de listar
	//####################################################################//
	//------------------------//
	//Listar todos os usuários//
	//------------------------//
	public void recoverAllUsers(String csv) throws IOException{
		String teste, parts[];
		BufferedReader reading = new BufferedReader(new FileReader(csv));
		user Usr = new user();
		
		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			Usr.set_UserNameString(parts[0]);
			Usr.set_UserType(Integer.parseInt(parts[1]));
			Usr.set_UserNbooks(Integer.parseInt(parts[2]));
			Usr.set_UserLimit(Integer.parseInt(parts[3]));

			Usr.print_User();

		}

		reading.close();
	}

	//----------------------//
	//Listar todos os livros//
	//----------------------//
	public void recoverAllBooks(String csv) throws IOException{
		String teste, parts[];
		books Book = new books();
		BufferedReader reading = new BufferedReader(new FileReader(csv));
		
		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			Book.set_BookTitleString(parts[0]);
			Book.set_isGlobalExt(Boolean.valueOf(parts[1]));
			Book.set_isRent(Boolean.valueOf(parts[2]));

			Book.print_Book();
		}

		reading.close();
	}

	//----------------------------------------------------------//
	//Listar todos os empréstimos
	//----------------------------------------------------------//
	public void recoverAllRents(String csv) throws IOException{
		String teste, parts[];
		BufferedReader reading = new BufferedReader(new FileReader(csv));
		
		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");
		}

		reading.close();
	}
	//####################################################################//

	//Funções de remover//
	//####################################################################//
	public void removeUser(){

	}

	public void removeBook(){

	}

	public void garbageCollector() throws IOException{
		String teste, parts[];
		user Usr = new user();
		books Book = new books();

		File tmpusers = new File("tmpusers.csv");
		File tmpbooks = new File("tmpbooks.csv");
		File users = new File("users.csv");
		File books = new File("books.csv");

		//atualizando o arquivo de usuários...
		BufferedReader reading = new BufferedReader(new FileReader("users.csv"));

		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			if(teste.charAt(0) != '*'){
				Usr.set_UserNameString(parts[0]);
				Usr.set_UserType(Integer.parseInt(parts[1]));
				Usr.set_UserNbooks(Integer.parseInt(parts[2]));
				Usr.set_UserLimit(Integer.parseInt(parts[3]));
				try{
					Usr.register_user("tmpusers.csv");
				} catch(IOException stream_error){
					System.out.println("\n\tErro ao passar o GarbageCollector D:\n");			 
				}
			}
		}

		reading.close();
		users.delete();

		File newUsers = new File("users.csv");
		tmpusers.renameTo(newUsers);

		//atualizando o arquivo de livros...
		reading = new BufferedReader(new FileReader("books.csv"));

		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			if(teste.charAt(0) != '*'){
				Book.set_BookTitleString(parts[0]);
				Book.set_isGlobalExt(Boolean.valueOf(parts[1]));
				Book.set_isRent(Boolean.valueOf(parts[2]));
				try{
					Book.register_book("tmpbooks.csv");
				} catch(IOException stream_error){
					System.out.println("\n\tErro ao passar o GarbageCollector D:\n");			 
				}
			}
		}

		reading.close();
		books.delete();

		File newBooks = new File("books.csv");
		tmpbooks.renameTo(newBooks);

	}
	//####################################################################//
        
        /* usar streams para procurar atrasos a partir do campo data*/
       // boolean isSuspended; // se 0 user pode pegar livro
        

        public user get_user (String nome, String csv){
            user Usr = new user();
            Usr = search_User(csv, nome);
            return Usr;
        }
        
        public books get_book (String nome, String csv){
            books Book = new books();
            Book = searchBook(csv, nome);
            return Book;
        }
                
}