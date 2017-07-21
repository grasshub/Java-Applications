package org.hong.javafundamental.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathRunner {
	
	// Technical Questions
	private static final String folderName = "Technical Questions\\Whatever\\foo";
	
	public static void main(String[] args) {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
		Path path = FileSystems.getDefault().getPath(folderName);
		
		System.out.println("toString: " + path.toString());
		System.out.println("getFileName: " + path.getFileName());
		System.out.println("getName(0): " + path.getName(0));
		System.out.println("getNameCount: " + path.getNameCount());
		System.out.println("subpath(0, 2): " + path.subpath(0, 2));
		System.out.println("getParent: " + path.getParent());
		System.out.println("getRoot: " + path.getRoot());
		
		Path fullPath = path.toAbsolutePath();
		System.out.printf("%s%n", fullPath);
		
		System.out.println(path.toUri());
		

		try {
			@SuppressWarnings("unused")
			Path realPath = path.toRealPath();

		} catch (NoSuchFileException e) {
			System.err.println(path + " no such file or directory");			
		} 
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(path.resolve("bar"));
		System.out.println(path.resolve("/bar").toAbsolutePath());
		
		Path p1 = Paths.get("home");
		Path p2 = Paths.get("home/sally/bar");
		System.out.println(p1.relativize(p2));
		System.out.println(p2.relativize(p1));
		
		if (p2.equals(Paths.get("home/sally/bar"))) {
			System.out.println("Same path");
		} 
		
		if (p2.startsWith("home")) {
			System.out.println("Started with home");
		} 
		
		if (p2.endsWith("bar")) {
			System.out.println("Ended with bar");
		}
		
		for (Path p: p2) {
			System.out.println(p);
		}
		
	}

}
