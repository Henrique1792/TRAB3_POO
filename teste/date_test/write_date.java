import java.io.*;
import java.util.*;
import java.time.*;



public class write_date{
	LocalDate today;
	
	public void write()throws IOException{
		int dia,mes,ano;
		BufferedWriter bw = new BufferedWriter(new FileWriter("batata.csv",true));
		this.today=LocalDate.now();
		dia=this.today.getDayOfMonth();
		mes=this.today.getMonthValue();
		ano=this.today.getYear();
		bw.append(dia+"  "+mes+"  "+ano);
		bw.close();

	}
}
