import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class User {
	public static void main(String[] args) throws IOException{
	    InputStreamReader reader = new InputStreamReader(System.in);
	    BufferedReader in = new BufferedReader(reader);    //objeto buffereader
	    
		ToDoItem n = new ToDoItem();   //object
		n.readFile();
		n.WhatToDo();
	
		BufferedWriter bw = null;
		FileWriter fw = null;
		String note = null;
		
		try {
			while (!(note=in.readLine()).equals("end")) {
				n.addToDoNote(note); 
				}
			in.close();
			
			fw = new FileWriter("/Users/macbookair/Documents/workspace/ToDOlListBuffered/File/ToDo.txt", true); //to overwrite a new text
			bw = new BufferedWriter(fw);
			ArrayList<String> newContent = n.getAllToDoNotes();
			bw.write(newContent.toString());
			
		}catch (IOException io) {
			System.out.println(io.getStackTrace());
		} finally {
			if(bw != null) {
				bw.close();
			}
			if(fw != null) {
				fw.close();
			}
		}
		
		System.out.println(n.getAllToDoNotes());
	}

}