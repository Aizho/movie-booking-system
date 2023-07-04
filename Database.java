
import java.io.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Database{

	private String fileName = "userData.txt";
	private Long noIC;
	private String name;
	private int age;
	private char gender;

	public Database(){
		noIC = 0L;
		name = "unknown";
		age = 0;
		gender = '0';
	}

	public Database(Long noIC, String name, int age, char gender){
		this.noIC = noIC;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void setAttributes(Long noIC, String name, int age, char gender){
		this.noIC = noIC;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public long getIC(){ return noIC;}
	public String getName(){ return name;}
	public int getAge(){ return age;}
	public char getGender(){ return gender;}
	
	public void userWrite(){


		try{

			File outFile = new File(fileName);
			FileWriter fw = new FileWriter(outFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
		
			//Write some data into the text files
			pw.println(noIC + ":" + name + ":" + age + ":" + gender);
			
		
			//output done, so close the stream
			pw.close();
			bw.close();
			fw.close();

		}catch (Exception ex){System.out.println(ex.getMessage());}
	}	

	public Long userRead(){

		try{

			File inFile = new File(fileName);
			FileReader fr = new FileReader(inFile);
			BufferedReader br = new BufferedReader(fr);
				
			String input = br.readLine();
			while(input != null){
				StringTokenizer st = new StringTokenizer(input, ":");
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				String s3 = st.nextToken();
				String s4 = st.nextToken();

				noIC = Long.parseLong(s1);
				name = s2;
				age = Integer.parseInt(s3);
				gender = s4.charAt(0);

				input = br.readLine();
			}
		
			//output done, so close the stream
			fr.close();
			br.close();

		}catch (Exception ex){System.out.println(ex.getMessage());}
		return noIC;
	}	
}