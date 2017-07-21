package org.hong.javafundamental.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.*;

public class DeleteFiles extends SimpleFileVisitor<Path> {
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Files.delete(file);
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
		if (ex == null) {
			Files.delete(dir);
			return CONTINUE;
		} else {
			throw ex;
		}	
	}
}
