package org.hong.javafundamental.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

import static java.nio.file.StandardCopyOption.*;
import static java.nio.file.FileVisitResult.*;

/* Copy the files/directories in the similar manner as cp utility at Unix
 * 
 */

public class Copy {
	
	private static final String Y = "y";
	private static final String YES = "yes";
	private static final String DASH = "-";
	private static final int MINIMUM = 2;
	// this reader is connected to System.in, so it can only close once at the end of this program
	// if you close it at the method level, then next read from System.in will fail with Stream closed exception
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	// ok to overwrite a file (cp -i)
	private static boolean okToOverwrite(Path file) {
		String confirmation;
		System.out.printf("Overwrite %s (yes/no)?%n", file);
		try {
			confirmation = reader.readLine();
			return confirmation.equalsIgnoreCase(Y) || confirmation.equalsIgnoreCase(YES);
		} catch (IOException ex) {
			System.out.println("Unable to get user confimation" + file);
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	// preserve the file attribute (cp -p)
	private static void copyFile(Path source, Path target, boolean prompt, boolean preserve) {
		CopyOption[] options = (preserve)? new CopyOption[] {COPY_ATTRIBUTES, REPLACE_EXISTING} : new CopyOption[] {REPLACE_EXISTING};
		
		if (!prompt || Files.notExists(target) || okToOverwrite(target)) {
			try {
				Files.copy(source, target, options);
			} catch (IOException ex) {
				System.err.printf("Unable to copy %s%n", source);
				System.err.println(ex.getMessage());
			}
		}
		
	}
	
	// Copy a file tree recursively (cp -r)
	private static class TreeCopier extends SimpleFileVisitor<Path> {
		
		private final Path source;
		private final Path target;
		private final boolean prompt;
		private final boolean preserve;
		
		TreeCopier(Path source, Path target, boolean prompt, boolean preserve) {
			this.source = source;
			this.target = target;
			this.prompt = prompt;
			this.preserve = preserve;
		}
		
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
			
			// before visiting entries of directory, need copy the directory to target location
			StandardCopyOption[] options = (preserve)? new StandardCopyOption[] {COPY_ATTRIBUTES} : new StandardCopyOption[0];
			
			Path newDir = target.resolve(source.relativize(dir));
			
			try {
				Files.copy(dir, newDir, options);
			} catch (FileAlreadyExistsException ex) {
				// ignor
			} catch (IOException ex) {
				System.err.printf("Unable to create: %s%n", newDir);
				System.err.println(ex.getMessage());
				return SKIP_SUBTREE;
			}
			
			return CONTINUE;
		}
		
		@Override 
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			copyFile(file, target.resolve(source.relativize(file)), prompt, preserve);
			return CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException ex) {
			if (ex instanceof FileSystemLoopException) {
				System.err.println("Cycle link detected: " + file);
			} else {
				System.err.printf("Unable to copy %s%n", file);
				System.err.println(ex.getMessage());
			}
			return CONTINUE;
		}
		
	}
	
	// output the correct usage of this program
	private static void usage() {
		System.err.println("java Copy [-ip] source... target");
		System.err.println("java Copy -r [-ip] source-directory... target");
		System.exit(-1);
	}
	
	public static void main(String[] args) throws IOException {
		
		boolean recursive = false;
		boolean prompt = false;
		boolean preserve = false;
		
		// process options
		int argi = 0;
		while (argi < args.length) {
			String arg = args[argi];
			
			// all options start with - (ie -r)
			if (!arg.startsWith(DASH))
				break;
			
			if (arg.length() < MINIMUM)
				usage();
			
			for (int i = 1; i < arg.length(); i++) {
				char c = arg.charAt(i);
				
				switch (c) {
					case 'r' : recursive = true;
					break;
					
					case 'i' : prompt = true;
					break;
					
					case 'p' : preserve = true;
					break;
					
					default : usage();
				}
			}
			argi++;
		}
		
		// remaining arguments are the source file/directory and target location
		int remaining = args.length - argi;
		
		if (remaining < MINIMUM)
			usage();
		
		Path[] sources = new Path[remaining -1];
		int index = 0;
		while (remaining > 1) {
			sources[index++] = Paths.get(args[argi++]);
			remaining--;
		}
		
		Path target = Paths.get(args[argi]);
		boolean isDir = Files.isDirectory(target);
		
		// copy each source file/directory to target location
		for (int i = 0; i < sources.length; i++) {
			Path destination = (isDir)? target.resolve(sources[i].getFileName()) : target;
			
			if (recursive) {
				// follow links when copying files
				EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
				TreeCopier tc = new TreeCopier(sources[i], destination, prompt, preserve);
				Files.walkFileTree(sources[i], opts, Integer.MAX_VALUE, tc);
			} else {
				// non recursive so source must not be a directory
				if (Files.isDirectory(sources[i])) {
					System.err.printf("%s is a directory%n", sources[i]);
					continue;
				}
				copyFile(sources[i], destination, prompt, preserve);
			}
		}	
		
		if (reader != null) 
			reader.close();
		
	}

}
