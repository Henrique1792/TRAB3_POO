package assets.books;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class books{
	boolean isGlobal;
	boolean isRent;
	String title;
	String delim;
	Scanner reading;
	
	public books(){
		this.set_isRent(false);
	}

	public void register_book(String csv) throws IOException{
		this.delim = ",";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(csv,true));
		buffWrite.append(this.title + delim + this.isGlobal + delim + this.isRent + "\n");
		buffWrite.close();
	}

	public int[] read_book(String csv, String name) throws IOException{
		int[] ok = new int[2];
		String teste, parts[];
		BufferedReader reading = new BufferedReader(new FileReader(csv));

		ok[1]--; //contador da posição começa em -1
		while(reading.ready() && ok[0] == 0){
			teste = reading.readLine();
			parts = teste.split(",");

			if(parts[0].equals(name)){
				this.set_BookTitleString(parts[0]);
				this.set_isGlobalExt(Boolean.valueOf(parts[1]));
				this.set_isRent(Boolean.valueOf(parts[2]));
				ok[0] = 1;
			}

			ok[1]++; //incrementa contador para verificar offset
		}

		System.out.println("\n>Posição no arquivo: " + ok[1]);
		reading.close();
		return ok;
	}

	public void set_BookTitleString(String title){
		this.title = title;
	}

	public void set_BookTitle(){
		System.out.printf("\t>Digite o nome do livro: ");
		this.reading = new Scanner(System.in);
		this.title = this.reading.nextLine();
	}

	public void set_isRent(boolean check){
		this.isRent = check;
	}

	public void set_isGlobalExt(boolean isGlobal){
		this.isGlobal = isGlobal;
	}

	public void print_Book(){
		this.print_Title();
		this.print_isGlobal();
		this.print_isRent();
	}

	public void set_isGlobal(){
		String receiver;
		int ok = 0;

		while (ok == 0){
			System.out.printf("\t>É um livro de uso global? <Y/N>: ");

			this.reading = new Scanner(System.in);
			receiver = reading.nextLine();
			if(receiver.equals("Y")){
				this.isGlobal = true;
				ok = 1;
			}
			else if(receiver.equals("N")){
				this.isGlobal = false;
				ok = 1;
			}
		}

	}

	void print_Title(){
		System.out.println("\n[Título]: " + this.title);
	}

	void print_isGlobal(){
		if(this.isGlobal) System.out.println("[Tipo]: Global");
		else System.out.println("[Tipo]: Restrito");
	}

	void print_isRent(){
		if(this.isRent) System.out.println(">Alugado");
		else System.out.println(">Disponível");
	}

	boolean get_isGlobal(){
		return this.isGlobal;
	}

	boolean get_isRent(){
		return this.isRent;
	}

}
