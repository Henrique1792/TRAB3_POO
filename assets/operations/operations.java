package assets.operations;

//Importing our assets...
import assets.users.*;
import assets.books.*;
import assets.operations.*;

//Importing Java packages...
import java.io.*;
import java.util.*;


public class operations{

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

			if(ok){
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

	//-----------------------//
	//Cadastrar um empréstimo//
	//-----------------------//
	public void create_rent(){
		String input;
		Scanner sc = new Scanner(System.in);

		rent Rent = new rent();
		user Usr = new user();
		books Book = new books();

		//procurando o user...
		System.out.printf("\n\t>Digite o nome do usuário: ");
		input = sc.nextLine();

		try{
			if(Usr.read_user("users.csv", input)[0] == 0){
				System.out.println("\n\tUsuário não encontrado D:");
				return;
			}
		} catch(IOException input_mistake){
			System.out.println("\n\tUsuário não encontrado D:\n");
		}

		//procurando o livro...
		System.out.printf("\n\t>Digite o nome do livro: ");
		input = sc.nextLine();

		try{
			if(Book.read_book("books.csv", input)[0] == 0){
				System.out.println("\n\tLivro não encontrado D:");
				return;
			}
		} catch(IOException input_mistake){
			System.out.println("\n\tLivro não encontrado D:\n");
		}

		//gravando no arquivo (ou não)...
		try{
			Rent.rent_elements(Usr,Book);
			this.updateUser(Usr);
			this.updateBook(Book);
		} catch (IOException stream_error){
			System.out.println("\n\tNão foi possível abrir a lista D:\n");
		}
	}
	//####################################################################//

	//Funções de pesquisar//
	//####################################################################//
	//-----------------//
	//Pesquisar usuário//
	//-----------------//
	public String searchUser(String csv){
		String input;
		Scanner sc = new Scanner(System.in);
		user Usr = new user();

		System.out.printf("\n\t>Digite o nome do usuário: ");
		input = sc.nextLine();

		try{
			if(Usr.read_user(csv, input)[0] == 1){
				Usr.print_User();
				return input;
			}
			else{
				System.out.println("\n\tUsuário não encontrado D:\n");
				return null;
			}
		} catch(IOException input_mistake){
			System.out.println("\n\tUsuário não encontrado D:\n");
		}

		return null;
	}

	//---------------//
	//Pesquisar livro//
	//---------------//
	public String searchBook(String csv){

		String input;
		Scanner sc = new Scanner(System.in);
		books Book = new books();

		System.out.printf("\n\t>Digite o nome do livro: ");
		input = sc.nextLine();

		try{
			if(Book.read_book(csv, input)[0] == 1){
				Book.print_Book();
				return input;
			}
			else{
				System.out.println("\n\tLivro não encontrado D:\n");
				return null;
			}
		} catch(IOException input_mistake){
			System.out.println("\n\tLivro não encontrado D:\n");
		}

		return null;

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

			if(parts[0].charAt(0) != '*'){
				Usr.set_UserNameString(parts[0]);
				Usr.set_UserType(Integer.parseInt(parts[1]));
				Usr.set_UserNbooks(Integer.parseInt(parts[2]));
				Usr.set_UserLimit(Integer.parseInt(parts[3]));
				Usr.set_UserRents(Integer.parseInt(parts[4]));
				Usr.set_UserSuspend(Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));

				Usr.print_User();
			}
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

			if(parts[0].charAt(0) != '*'){
				Book.set_BookTitleString(parts[0]);
				Book.set_isGlobalExt(Boolean.valueOf(parts[1]));
				Book.set_isRent(Boolean.valueOf(parts[2]));

				Book.print_Book();
			}
		}

		reading.close();
	}

	//---------------------------//
	//Listar todos os empréstimos//
	//---------------------------//
	public void recoverAllRents(String csv) throws IOException{
		String teste, parts[];
		BufferedReader reading = new BufferedReader(new FileReader(csv));

		rent Rent = new rent();
		books Book = new books();
						
		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");
			Rent.nameaux = parts[0];
			Rent.titleaux = parts[1];
			Rent.day = Integer.parseInt(parts[2]);
			Rent.mon = Integer.parseInt(parts[3]);
			Rent.year = Integer.parseInt(parts[4]);

			Rent.print_rent();

			Book.read_book("books.csv",Rent.get_TitleAux());
			Book.print_wasReturned();
		}

		reading.close();
	}
	//####################################################################//

	//Funções de remover//
	//####################################################################//
	public int removeUser(String csv) throws IOException{
		int ok = 0;
		String input, teste, parts[];
		user Usr = new user();
		Scanner sc = new Scanner(System.in);

		File tmpusers = new File("tmpusers.csv");
		File users = new File("users.csv");
		BufferedReader reading = new BufferedReader(new FileReader("users.csv"));

		System.out.printf("\n\t>Digite o nome do usuário: ");
		input = sc.nextLine();

		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			if(parts[0].equals(input)){
				char[] removed = parts[0].toCharArray();
				removed[0] = '*';
				parts[0] = String.valueOf(removed);
				ok = 1;
			}

			Usr.set_UserNameString(parts[0]);
			Usr.set_UserType(Integer.parseInt(parts[1]));
			Usr.set_UserNbooks(Integer.parseInt(parts[2]));
			Usr.set_UserLimit(Integer.parseInt(parts[3]));
			Usr.set_UserRents(Integer.parseInt(parts[4]));
			Usr.set_UserSuspend(Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));

			try{
				Usr.register_user("tmpusers.csv");
			} catch(IOException stream_error){
				System.out.println("\n\tErro ao remover a entrada D:\n");			 
			}
		}

		reading.close();
		users.delete();

		File newUsers = new File("users.csv");
		tmpusers.renameTo(newUsers);
		return ok;
	}

	public int removeBook(String csv) throws IOException{
		int ok = 0;
		String input, teste, parts[];
		books Book = new books();
		Scanner sc = new Scanner(System.in);

		File tmpbooks = new File("tmpbooks.csv");
		File books = new File("books.csv");
		BufferedReader reading = new BufferedReader(new FileReader("books.csv"));

		System.out.printf("\n\t>Digite o nome do livro: ");
		input = sc.nextLine();

		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			if(parts[0].equals(input)){
				char[] removed = parts[0].toCharArray();
				removed[0] = '*';
				parts[0] = String.valueOf(removed);
				ok = 1;
			}

			Book.set_BookTitleString(parts[0]);
			Book.set_isGlobalExt(Boolean.valueOf(parts[1]));
			Book.set_isRent(Boolean.valueOf(parts[2]));

			try{
				Book.register_book("tmpbooks.csv");
			} catch(IOException stream_error){
				System.out.println("\n\tErro ao remover a entrada D:\n");			 
			}
		}

		reading.close();
		books.delete();

		File newBooks = new File("books.csv");
		tmpbooks.renameTo(newBooks);
		return ok;
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
				Usr.set_UserRents(Integer.parseInt(parts[4]));
				Usr.set_UserSuspend(Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));

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

	//Funções internas de atualizar no arquivo//
	//####################################################################//
	//--------------------//
	//Atualizar um usuário//
	//--------------------//
	public void updateUser(user User) throws IOException{
		String input, teste, parts[];
		user Usr = new user();
		Scanner sc = new Scanner(System.in);

		File tmpusers = new File("tmpusers.csv");
		File users = new File("users.csv");
		BufferedReader reading = new BufferedReader(new FileReader("users.csv"));

		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			Usr.set_UserNameString(parts[0]);
			Usr.set_UserType(Integer.parseInt(parts[1]));
			Usr.set_UserNbooks(Integer.parseInt(parts[2]));
			Usr.set_UserLimit(Integer.parseInt(parts[3]));
			Usr.set_UserRents(Integer.parseInt(parts[4]));
			Usr.set_UserSuspend(Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));

			if(parts[0].equals(User.get_UserName())){
				Usr.set_UserRents(User.get_UserRents());
				Usr.set_UserSuspend(User.sDay,User.sMon,User.sYear);
			}

			try{
				Usr.register_user("tmpusers.csv");
			} catch(IOException stream_error){
				System.out.println("\n\tErro ao atualizar o usuário D:\n");			 
			}
		}

		reading.close();
		users.delete();

		File newUsers = new File("users.csv");
		tmpusers.renameTo(newUsers);
	}

	//------------------//
	//Atualizar um livro//
	//------------------//
	public void updateBook(books Book) throws IOException{
		String input, teste, parts[];
		books Bk = new books();
		Scanner sc = new Scanner(System.in);

		File tmpbooks = new File("tmpbooks.csv");
		File books = new File("books.csv");
		BufferedReader reading = new BufferedReader(new FileReader("books.csv"));

		while(reading.ready()){
			teste = reading.readLine();
			parts = teste.split(",");

			Bk.set_BookTitleString(parts[0]);
			Bk.set_isGlobalExt(Boolean.valueOf(parts[1]));
			Bk.set_isRent(Boolean.valueOf(parts[2]));

			if(parts[0].equals(Book.get_BookTitle())){
				Bk.set_isRent(Book.get_isRent());
			}

			try{
				Bk.register_book("tmpbooks.csv");
			} catch(IOException stream_error){
				System.out.println("\n\tErro ao atualizar o livro D:\n");			 
			}
		}

		reading.close();
		books.delete();

		File newBooks = new File("books.csv");
		tmpbooks.renameTo(newBooks);
	}
	//####################################################################//

}
