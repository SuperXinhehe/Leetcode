import java.util.*;

public class ExcelSheetColumn {
  public int ExcelSheet(String s) {
    int len = s.length();
    char[] ca = s.toCharArray();
    if(len == 1) {
      return ((int) ca[0] - 64);
    }
    int out = 0;
    for(int i=0;i<len;i++) {
      out = out + (int) Math.pow(26,(len-i-1))*((int) ca[i] - 64);
    }
    return out;
  }

  public static void main(String[] args) {
   System.out.println((int) 'B' - 64);
   ExcelSheetColumn esc = new ExcelSheetColumn();
   System.out.println(esc.ExcelSheet("BB"));
  }


}
