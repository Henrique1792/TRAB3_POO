package assets.screen;

//Importing our assets...
import assets.operations.*;

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
					this.delim();
					break;
				case 3:
					break;
			}
		}
	}

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

	void listScreen_controller(){
		int quit = 0;

		this.listScreen();
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
					this.delim();
					break;
				case 4:
					break;
			}
		}
	}

}