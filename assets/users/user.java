package assets.users;

import java.io.*;
import java.util.*;
/*
classe user 
*/
public class user{

    String name;
    String delim;
    int limit, type, nbooks;
    Scanner sc;
        boolean isSuspended; // se 0 user pode pegar livro

    public void register_user(String csv) throws IOException{
        this.delim = ",";
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(csv,true));
        buffWrite.append(this.name + delim + this.type + delim + this.nbooks + delim + this.limit + "\n");
        buffWrite.close();
    }

    public int[] read_user(String csv, String name) throws IOException{
        int[] ok = new int[2];
        String teste, parts[];
        BufferedReader reading = new BufferedReader(new FileReader(csv));

        ok[1]--; //contador da posição começa em -1
        while(reading.ready() && ok[0] == 0){
            teste = reading.readLine();
            parts = teste.split(",");

            if(parts[0].equals(name)){
                this.set_UserNameString(parts[0]);
                this.set_UserType(Integer.parseInt(parts[1]));
                this.set_UserNbooks(Integer.parseInt(parts[2]));
                this.set_UserLimit(Integer.parseInt(parts[3]));
                ok[0] = 1;
            }

            ok[1]++; //incrementa contador para verificar offset
        }

        System.out.println("\t>Posição no arquivo: " + ok[1]);
        reading.close();
        return ok;
    }

    public void set_UserNameString(String name){
        this.name = name;
    }

    public void set_UserType(int type){
        this.type = type;
    }

    public void set_UserNbooks(int nb){
        this.nbooks = nb;
    }

    public void set_UserLimit(int limit){
        this.limit = limit; 
    }

    public int get_UserNbooks(){
        return this.nbooks;
    }

    public int get_UserLimit(){
        return this.limit;  
    }

    public void print_User(){
        this.print_Name();
        this.print_Type();
        System.out.println(">Número de livros alugados: " + get_UserNbooks());
        System.out.println(">Tempo-Limite para devolução: " + get_UserLimit());
    }

    void print_Name(){
        System.out.println("\n[Nome]: " + this.name);
    }

    void print_Type(){
        switch(this.type){
            case 0:
                System.out.println("[Tipo]: Comunidade");
                break;
            case 1:
                System.out.println("[Tipo]: Aluno");
                break;
            case 2:
                System.out.println("[Tipo]: Professor");
                break;
        }
    }

    void set_UserName(){
        System.out.printf("\t>Digite o nome de usuário: ");
        sc = new Scanner(System.in);
        this.name = sc.nextLine();
    }

        String get_UserName(){
            return this.name;
        }
        
        boolean get_isSuspended (){
            return this.isSuspended;
        }
}
