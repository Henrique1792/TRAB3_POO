package assets.screen;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class Menu extends screen_utils{
	Scanner sc;
	Controller control;

	public Menu(){
		this.sc = new Scanner(System.in);
		this.control = new Controller();
	}

	public void startApp(){
		int quit = 0;
		sc = new Scanner(System.in);

		this.delim();
		System.out.println("\t\t      Olá, usuário :D");
		while (quit == 0){
			this.mainScreen();
			quit = sc.nextInt();
			if(quit < 1 || quit > 5){
				quit = 0;
			}
			else{
				switch(quit){
					case 1:
						control.signScreen_controller();
						quit = 0;
						break;
					case 2:
						control.rentScreen_controller();
						quit = 0;
						break;
					case 3:
						control.delayScreen_controller();
						quit = 0;
						break;
					case 4:
						control.listScreen_controller();
						quit = 0;
						break;
					case 5:
						quit = 1;
						break;
				}
			}
		}

		System.out.println("\n			Até Logo :D");
		this.delim();

		System.exit(0);
	}
}