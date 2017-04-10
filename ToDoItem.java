import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoItem {
	static int id = 0;
	int serialNumber;
	  
	static ArrayList<String> notes;   //primeira metade do arraylist
	
	public ToDoItem() {
		notes = new ArrayList<>();  //segunda metade do arraylist  no construtor
	}
	
	public void WhatToDo(){
		System.out.println("Insert your more item in the 'to do list' and type 'end' to quit:");
	}
	public void addToDoNote(String note) {
		//String n = new String(note);   poderia usar ou o de baixo
		//notes.add(n);
		serialNumber = ++id;
		notes.add(new String(id+"-"+note));
	}

	

	public  String getFirstToDoNote() {
		if(!notes.isEmpty()) {
			return notes.get(0);   // 0 é a primeira index da arraylist
		} 
		return "No Notes Yet";
	}

	
	public String getLastToDoNote() {
		int lastIndex = notes.size() - 1;
		if(!notes.isEmpty()) {
			return notes.get(lastIndex);
		}
		return "No notes yet";
	}
	
	public ArrayList<String> getAllToDoNotes() {
		return notes;
	}
	
	public void readFile(){
		System.out.println("Your currently 'what to do list':");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader("/Users/macbookair/Documents/workspace/ToDOlListBuffered/File/ToDo.txt");
			br = new BufferedReader(fr);
			String content = null;
			while((content = br.readLine()) != null) {
			System.out.println(content);
			}
			
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}


}
