import java.io.*;
public class CodeED {
  
  public static void main(String args[]) {
    String str = "this is a string";
    try{
    byte encode[] = str.getBytes("UTF-8");
    System.out.println(encode);
    }
    catch(UnsupportedEncodingException e) {
      System.out.println("Unsupported Character Set");
    }
  }




}
