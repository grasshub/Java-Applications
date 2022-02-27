package org.hong.javafundamental.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.EnumSet;
import java.util.List;

import static java.nio.file.StandardCopyOption.*;

public class FileRunner {
	
	private static final String DESTINATION_NAME = "Java SE Development/Data File/OutFile.txt";
	private static final String SOURCE_NAME = "Java SE Development/Data File/USNumbers.txt";
	private static final String FILE_NAME = "Java SE Development/Data File/NewFile";
	private static final String TMP_FILE_NAME = "Java SE Development/Data File";
	private static final String DIRECTORY_NAME = "Java SE Development/Data File/foo";
	private static final String LINK_NAME = "Java SE Development/Data File/link";
	private static final String START_DIR_NAME = ".";
	private static final String DELETE_DIR_NAME = "Java SE Development/Temp";
	
	public static void main(String[] args) throws IOException {
		
		Path destinationPath = Paths.get(DESTINATION_NAME);
		Path sourcePath = Paths.get(SOURCE_NAME);
		Path filePath = Paths.get(FILE_NAME);
		Path tmpFilePath = Paths.get(TMP_FILE_NAME);
		Path directoryPath = Paths.get(DIRECTORY_NAME);
		Path link = Paths.get(LINK_NAME);
		Path startPath = Paths.get(START_DIR_NAME);
		Path deletePath = Paths.get(DELETE_DIR_NAME);
		
		System.out.println("File exists: " + Files.exists(destinationPath));
		System.out.println("File not exists: " + Files.notExists(destinationPath));
		System.out.println("Is regular file: " + Files.isRegularFile(destinationPath));
		System.out.println("Is directory: " + Files.isDirectory(destinationPath));
		System.out.println("Is readable: " +Files.isReadable(destinationPath));
		System.out.println("Is writable: " + Files.isWritable(destinationPath));
		System.out.println("Is executable: " + Files.isExecutable(destinationPath));
		System.out.println("Directory size: " + Files.size(destinationPath));
		System.out.println("File size: " + Files.size(sourcePath));
		System.out.println("Last modified time: " + Files.getLastModifiedTime(sourcePath));
		System.out.println("File owner: " + Files.getOwner(sourcePath));
		
		// bulk operation to get all basic file attributes 
		BasicFileAttributes basicAttr = Files.readAttributes(sourcePath, BasicFileAttributes.class);
		// set the last modified time to current time
		long currentTime = System.currentTimeMillis();
		FileTime ft = FileTime.fromMillis(currentTime);
		Files.setLastModifiedTime(sourcePath, ft);
				
		System.out.println("File key: " + basicAttr.fileKey());
		System.out.println("File creation time: " + basicAttr.creationTime());
		System.out.println("Is other: " + basicAttr.isOther());
		System.out.println("File last access time: " + basicAttr.lastAccessTime());
		
		// dos file attributes
		DosFileAttributes dosAttr = Files.readAttributes(sourcePath, DosFileAttributes.class);
		//Files.setAttribute(sourcePath, "dos:hidden", false);
		
		System.out.println("Is archive file : " + dosAttr.isArchive());
		System.out.println("Is hidden file: " + dosAttr.isHidden());
		System.out.println("Is read only file: " + dosAttr.isReadOnly());
		System.out.println("Is system file: " + dosAttr.isSystem());
		
		// file store attributes
		FileStore fileStore = Files.getFileStore(sourcePath);
		System.out.println(fileStore.getTotalSpace());
		System.out.println(fileStore.getUnallocatedSpace());
		System.out.println(fileStore.getUsableSpace());

		Files.copy(sourcePath, destinationPath, REPLACE_EXISTING);
		
		BufferedInputStream bufferedStream = new BufferedInputStream(new FileInputStream(SOURCE_NAME));
		Files.copy(bufferedStream, destinationPath, REPLACE_EXISTING);
		if(bufferedStream != null)
			bufferedStream.close();

		Files.move(sourcePath, Paths.get("Java SE Development/Properties File/USNumbers.txt"), REPLACE_EXISTING);
		Files.move(Paths.get("Java SE Development/Properties File/USNumbers.txt"), sourcePath, REPLACE_EXISTING);
		
		Charset cs = StandardCharsets.US_ASCII;
		List<String> contentList = Files.readAllLines(sourcePath, cs);
		for (String content : contentList)
			System.out.println(content);
		
		System.out.println();

		Files.write(destinationPath, contentList, cs);
		
		try (BufferedReader reader = Files.newBufferedReader(sourcePath, cs);
			 BufferedWriter writer = Files.newBufferedWriter(destinationPath, cs)) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
		} 
		
		try (SeekableByteChannel sourceSbc =
					 Files.newByteChannel(sourcePath, StandardOpenOption.READ, StandardOpenOption.WRITE);
			 SeekableByteChannel destinationSbc =
					 Files.newByteChannel(destinationPath, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
			ByteBuffer buffer = ByteBuffer.allocate(10);
			
			while (sourceSbc.read(buffer) > 0) {
				buffer.rewind();
				//System.out.print(cs.decode(buffer));
				destinationSbc.write(buffer);
				buffer.flip();
			}
			System.out.println();
		}
		
		Files.createFile(filePath);
		//Files.setAttribute(filePath, "dos:readonly", true);
		Files.deleteIfExists(filePath);
				
		Path tmpFile = Files.createTempFile(tmpFilePath, null, ".tmp");
		tmpFile.toFile().deleteOnExit();
		
		for ( Path path: FileSystems.getDefault().getRootDirectories()) 
			System.out.println(path);
		
		for (FileStore store: FileSystems.getDefault().getFileStores())
			System.out.println(store);
		
		System.out.println("The path separator is: " + FileSystems.getDefault().getSeparator());
		
		Files.createDirectory(directoryPath);
		Files.deleteIfExists(directoryPath);
		
		Path tmpPath = Files.createTempDirectory(tmpFilePath, null);
		Files.deleteIfExists(tmpPath);
		
		// declares a filter based on directory type
		DirectoryStream.Filter<Path> filter = Files::isDirectory;
		
		//Path softLnk = Files.createSymbolicLink(softLinkPath, tmpFilePath);
		//boolean isSymbolicLink = Files.isSymbolicLink(softLnk);
		
		// create a hard link
		Files.createLink(link, sourcePath);
		Files.deleteIfExists(link);
		
		// Print the file tree
		System.out.println();
		PrintFiles pf = new PrintFiles();
		EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
		Files.walkFileTree(startPath, opts, Integer.MAX_VALUE, pf);
		
		DeleteFiles df = new DeleteFiles();
		Files.walkFileTree(deletePath, df);
		
	}

}
