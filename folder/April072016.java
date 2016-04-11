public class April072016 {
	
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        if(strs.length == 0) return "";
        String str = "";
        for(int i=0;i<strs.length-1;i++) {
            for(int j=i+1;j<strs.length;j++) {
                int len = str.length();
                String str1 = strs[i];
                String str2 = strs[j];
                while(len < str1.length() && len < str2.length() && str1.substring(0,len+1).equals(str2.substring(0,len+1))) {
                    str = str1.substring(0,len+1);
                    len++;
                }
            }
        }
        return str;
    }
}