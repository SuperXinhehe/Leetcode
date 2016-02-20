package Algorithm;

//use recursion and for loop...
public class addDigits {
    public static Integer addD(Integer num) {
        String str = num.toString();
        Integer ans = 0;
        for(String i:str.split("")) {
            ans = ans + Integer.parseInt(i);   
        }
        if(ans > 10) {
            return addD(ans);
        }
        else return ans;
    }
    public static void main(String args[]){
        Integer num = 38;
        System.out.println(addD(38));
    }  
}