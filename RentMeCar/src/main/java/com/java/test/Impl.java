package com.java.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Impl {

	public static void main(String[] args) throws IOException {
		
		File folder = new File("C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\bin");
		
		List<String> shellFiles = new ArrayList<String>();
		
		for(File file : folder.listFiles()){
			if(file.isDirectory()){
				System.out.println("This is a directory");
			}else{
				System.out.println("File name" + file.getName());
				if(file.getName().endsWith(".sh")){
					shellFiles.add(file.getName());
					FileInputStream fis = new FileInputStream(file);
					Reader read = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				}
			}
		}
		System.out.println(shellFiles);
	}
}