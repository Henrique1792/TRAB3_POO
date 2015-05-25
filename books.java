import java.io.*;
import java.util.*;



public class books{
	boolean isGlobal;
	boolean isRent;
	String title;
	Scanner reading;

	void set_bookname(){
		this.reading=new Scanner(System.in);
		title=reading.nextLine();
	}

	
	void set_isGlobal(){
		this.reading=new Scanner(System.in);
		isGlobal=reading.nextBoolean();
	}

	boolean get_rent(){
		return this.isRent;
	}
	
	void set_Rent(boolean check){
		check=this.isRent;
	}
}
