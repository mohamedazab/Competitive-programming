package solopractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVA230Borrowers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		ArrayList<book> books=new ArrayList<book>();
		while(!(input.equals("END"))){
			input=br.readLine();
			if(input.equals("END"))break;
			String rm[]=input.split("by");
			
			books.add(new book(rm[0].substring(0,rm[0].length()-1),rm[1].substring(1,rm[1].length()-1)));
			
		}
		
		input="";
		ArrayList<book> bor=new ArrayList<book>();
		ArrayList<book> taken=new ArrayList<book>();
		while(!(input.equals("END"))){
			input=br.readLine();
			
			if(input.equals("END"))break;
			String rm[]=input.split(" ");
			if (input.equals("SHELVE"))
			{
				
				
				for (int i = 0; i < bor.size(); i++) {
				books.add(bor.get(i));
			}
				Collections.sort(books);
			Collections.sort(bor);
				for (int i = 0; i < bor.size(); i++) {
					int index=books.indexOf(bor.get(i));
					if(index!=0)
					{  System.out.println("Put "+bor.get(i).name+" after "+books.get(index-1).name);
					}
					else
						System.out.println("Put "+bor.get(i).name+" first");
				}
				System.out.println("END");
				
				bor.clear();
			}
			if(rm[0].equals("BORROW")){
				int i=0;
				for ( i = 0; i <books.size(); i++) {
					
				if((books.get(i).name).equals(input.substring(7)))
					{break;}
			}  
				taken.add(books.get(i));
				books.remove(i);
			
				
			}
			
			if(rm[0].equals("RETURN"))
			{int i=0;
				for ( i = 0; i <taken.size(); i++) {
				if((taken.get(i).name).equals(input.substring(7)))
					{break;}
			}  
				
				bor.add(taken.get(i));
			}
		}
	
	
		
	}
	
	
	
}
class book implements Comparable{
	String name,author;
	public book(String name,String author) {
		this.name=name;this.author=author;
	}
	@Override
	public int compareTo(Object o) {
		book r=(book) o;
		if(this.author.compareTo(r.author)==0)
			return(this.name.compareTo(r.name));
		else
		return this.author.compareTo(r.author);
	}
}
