package org.hong.javafundamental.util;

public final class OsUtils
{
   private static final String OS = null;
   
   public static String getOsName()
   {
      if(OS == null) 
    	  OS = System.getProperty("os.name");
      return OS;
   }
   
   public static boolean isWindows()
   {
      return getOsName().startsWith("Windows");
   }
   
   public static boolean isMac()
   {
	   return getOsName().startsWith("Mac");
   }

   //public static boolean isUnix()
}