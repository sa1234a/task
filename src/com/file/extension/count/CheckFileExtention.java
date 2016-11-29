package com.file.extension.count;
import java.io.*;
import java.util.*;


public class CheckFileExtention {

	public static void main(String[] args) {

	
                System.out.println("Search path"+args[0]);
		fetchFileExtentions(args[0]);

	}
		
	private static void fetchFileExtentions(String directoryPath){
		File path = new File(directoryPath);
		File[] fileList = path.listFiles();
		int count = 0;
		Map<String,Integer> extensionList = new HashMap<String,Integer>();
		for(int i =0;i < fileList.length;i++){
			if (fileList[i].isFile()) {
				String[] fileName = fileList[i].getName().split("[.]");
				if(fileName[fileName.length-1].equalsIgnoreCase("xlsx")){
					System.out.println(" .xlsx "+fileList[i].getName());
				}
		        if(extensionList.get("."+fileName[fileName.length-1]) != null){
		        	count = Integer.parseInt(extensionList.get("."+fileName[fileName.length-1]).toString());
		        	extensionList.put("."+fileName[fileName.length-1], ++count);
		        	count = 0;
		        } else {
		        	extensionList.put("."+fileName[fileName.length-1], ++count);
		        	count = 0;
		        }
		       
		       
		      } 
			
		}
		 for(Map.Entry<String, Integer> entry : extensionList.entrySet()){
	        	System.out.println(entry.getKey()+"  ,  "+entry.getValue());
	        }
		return;
	}

}
