package assets.screen;

//Importing Java packages...
import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class screen_utils{

	void getTime(){
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	System.out.println("\t\t     Relógio: " + sdf.format(cal.getTime()) );
	}

	void screenHeader(){
		System.out.println("\n		>>Java Library System v0.3<<");
		this.getTime();
	}

	void delim(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
	}

	void signScreen(){
		this.screenHeader();
		System.out.println("\n	[1] Cadastrar um Usuário");
		System.out.println("	[2] Cadastrar um Livro");
		System.out.println("	[3] Voltar ao Menu");
	}

	void rentScreen(){
		this.screenHeader();
		System.out.println("\n	[1] Registrar um Empréstimo");
		System.out.println("	[2] Registrar uma Devolução");
		System.out.println("	[3] Voltar ao Menu");
	}

	void delayScreen(){
		this.screenHeader();
		System.out.println("\n	[1] Verificar Atrasos");
		System.out.println("	[2] Calcular Suspensão");
		System.out.println("	[3] Voltar ao Menu");
	}

	void listScreen(){
		this.screenHeader();
		System.out.println("\n	[1] Listar Todos os Usuários");
		System.out.println("	[2] Listar Todos os Livros");
		System.out.println("	[3] Listar Todos os Empréstimos");
		System.out.println("	[4] Voltar ao Menu");
	}

	void mainScreen(){
		this.screenHeader();
		System.out.println("\n	[1] Cadastrar Usuário ou Livro");
		System.out.println("	[2] Registrar Empréstimos e Devoluções");
		System.out.println("	[3] Atrasos e Suspensões");
		System.out.println("	[4] Listar Cadastros e Empréstimos");
		System.out.println("	[5] Sair do Programa");
	}

}