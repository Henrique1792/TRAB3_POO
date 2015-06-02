//Importing our assets...
import assets.screen.*;
import assets.operations.*;
import assets.users.*;
import assets.books.*;

//Importing Java packages...
import java.io.*;
import java.util.*;

//#############################################//
//       xX.Java Library System v1.0.Xx        //
//---------------------------------------------//
//Gustavo Santiago - 8937416                   //
//Henrique M Freitas - 8937225                 //
//Rita Raad - 8061452                          //
//#############################################//

public class app{
	//Avoiding classpath errors in compilation...
	Controller control;
	rent Rent;
	operations Ops;

	public static void main(String[] args){
		//Starting Sinclair, the Library System...
		Menu screen = new Menu();
		screen.startApp();
	}
}
