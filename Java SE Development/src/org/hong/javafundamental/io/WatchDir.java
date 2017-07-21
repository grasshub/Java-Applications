package org.hong.javafundamental.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchDir {
	
	private final WatchService watcher;
	private final Map<WatchKey, Path> keys;
	private final boolean recursive;
	private boolean trace = false;
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final String DASH_R = "-r";
	
	private void register(Path dir) throws IOException {
		WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		
		if(trace) {
			Path prev = keys.get(key);
			
			if (prev == null) {
				System.out.printf("register: %s%n", dir);
			} else {
				if (!dir.equals(prev))
					System.out.printf("update: %s -> %s%n", prev, dir);
			}
		}
		
		keys.put(key, dir);
	}
	
	// Register the given directory, and all its sub-directories with WatchService
	private void registerAll(Path start) throws IOException {
		Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				register(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}
	
	public WatchDir(Path dir, boolean recursive) throws IOException {
		this.watcher = FileSystems.getDefault().newWatchService();
		this.keys = new HashMap<WatchKey, Path>();
		this.recursive = recursive;
		this.trace = true;
		
		if (recursive) {
			System.out.printf("Scanning %s... %n", dir);
			registerAll(dir);
			System.out.println("Done");
		} else {
			register(dir);
		}
	}
	
	// Process all the events for keys queued to the watcher
	private void processEvents() throws IOException {
		
		for (;;) {
			
			WatchKey key;
			
			try {
				key = watcher.take();
			} catch (InterruptedException ex) {
				return;
			}
			
			Path dir = keys.get(key);
			if (dir == null) {
				System.err.printf("WatchKey %s not registered for entry: %s%n", key, dir);
				continue;
			}
			
			for (WatchEvent<?> event: key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				
				// skip the OVERFLOW event
				if (kind == OVERFLOW) 
					continue;
				
				// Context for directory entry event is the file name of entry
				Path name = (Path)event.context();
				Path childPath = dir.resolve(name);
				
				// print out the directory entry event
				System.out.printf("%s: %s%n", event.kind().name(), childPath);
				
				// if directory is created, and watching recursively, then register it and its sub-directories
				if (recursive && (kind == ENTRY_CREATE)) {
					if (Files.isDirectory(childPath, LinkOption.NOFOLLOW_LINKS)) {
						try {
							registerAll(childPath);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			boolean valid = key.reset();
			// directory associated with this key is inaccessible, so remove it from Map
			if (!valid)
				keys.remove(key);
			
			// if all directories are inaccessible, breaks for this method
			if (keys.isEmpty()) {
				break;
			}
		}		
	}
	
	private static void usage() {
		System.err.println("usage: java WatchDir [-r] dir");
		System.exit(-1);
	}
	
	public static void main(String[] args) throws IOException {
		// Parse arguments
		if (args.length == ZERO || args.length > TWO)
			usage();
		
		boolean recursive = false;
		int i = ZERO;
		if (args[ZERO].equals(DASH_R)) {
			if (args.length < TWO)
				usage();
			recursive = true;
			i++;
		}
		
		// Register directory and process its events
		Path dir = Paths.get(args[i]);
		new WatchDir(dir, recursive).processEvents();
	}

}
