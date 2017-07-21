package org.hong.javafundamental.io;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;

public class ObjectStreams {
	
	private static final String dataFile = "Data File/InvoiceData";
	private static final BigDecimal[] prices = { 
		new BigDecimal(19.99),
		new BigDecimal(9.99),
		new BigDecimal(15.99), 
		new BigDecimal(3.99), 
		new BigDecimal(4.99) };
	private static final int[] units = { 12, 8, 13, 29, 50 };
	private static final String[] descs = {
	    "Java T-shirt",
	    "Java Mug",
	    "Duke Juggling Dolls",
	    "Java Pin",
	    "Java Key Chain"
	};
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
			
			// write the current date
			out.writeObject(Calendar.getInstance());
			
			for (int i = 0; i < prices.length; i++) {
				out.writeObject(prices[i]);
				out.writeInt(units[i]);
				out.writeObject(descs[i]);
			}
		} finally {
			if (out != null)
				out.close();
		}
		
		ObjectInputStream in = null;
		BigDecimal price;
		int unit;
		String desc;
		BigDecimal totalPrice = new BigDecimal(0);	
		Calendar date;
		
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
			
			date = (Calendar)in.readObject();
			System.out.printf("On %tA %<tB %<te %<tY%n", date);

			while (true) {
				price = (BigDecimal)in.readObject();
				unit = in.readInt();
				desc = (String)in.readObject();
				totalPrice = totalPrice.add(price.multiply(new BigDecimal(unit)));
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
