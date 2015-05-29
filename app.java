//Importing our assets...
import assets.screen.*;
import assets.operations.*;
import assets.users.*;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class app{
	//Avoiding classpath errors in compilation...
	Controller control;
	operations op;

	public static void main(String[] args){
		//Starting Sinclair, the Library System...
		Menu screen = new Menu();
		screen.startApp();
	}
}