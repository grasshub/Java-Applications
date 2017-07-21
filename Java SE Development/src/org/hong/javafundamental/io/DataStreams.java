package org.hong.javafundamental.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class DataStreams {
	
	private static final String dataFile = "Data File/InvoiceData";
	private static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	private static final int[] units = { 12, 8, 13, 29, 50 };
	private static final String[] descs = {
	    "Java T-shirt",
	    "Java Mug",
	    "Duke Juggling Dolls",
	    "Java Pin",
	    "Java Key Chain"
	};
	
	public static void main(String[] args) throws IOException {
		
		DataOutputStream out = null;
		
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
			
			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		} finally {
			if (out != null)
				out.close();
		}
		
		DataInputStream in = null;
		double price;
		int unit;
		String desc;
		double totalPrice = 0;		
		
		try {
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

			while (true) {
				price = in.readDouble();
				unit = in.readInt();
				desc = in.readUTF();
				totalPrice += price * unit;
				System.out.printf("Ordered %d of %s with price $%.2f%n", unit, desc, price);
			}
		} catch (EOFException e) {
			// use EOFException to indicate all invoice data has been read
			System.out.printf("The total price of invoice is: $%.2f%n", totalPrice);
		} finally {
			if (in != null)
				in.close();
		}

		
	}

}
