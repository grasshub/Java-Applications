package org.hong.javafundamental.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.*;

public class PrintFiles extends SimpleFileVisitor<Path> {
	
	// Print information about each type of file and its size
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
		
		if (attributes.isRegularFile()) 
			System.out.println("Regular file: " + file);
		else if (attributes.isSymbolicLink())
			System.out.println("Symbolic link: " + file);
		else if (attributes.isOther())
			System.out.println("Other : " + file);

		System.out.println("Size : " + attributes.size());
		
		return CONTINUE;
	}
	
	// Print each directory visited
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
		System.out.println("Directory name: " + dir);
		System.out.println("Directory size: " + Files.getAttribute(dir, "size"));
		if (ex != null)
			System.err.println(ex.getMessage());
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException ex) {
		System.err.println(ex.getMessage());
		return CONTINUE;
	}

}
