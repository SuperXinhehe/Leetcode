import java.util.*;

public class ShortestDist {
  public int shortestDistance(String[] words, String word1, String word2) {
   int ind1 = 0;
   int ind2 = 0;
   for (int i = 0; i < words.length; i++ ) {
    if(words[i] == word1) ind1 = i;
    else if(words[i] == word2) ind2 = i;
   }
   if(ind1 <= ind2) return ind2-ind1;
   else return ind1 - ind2;
  }

  public static void main(String[] args) {
   ShortestDist sd = new ShortestDist();
   String[] words = new String[]{"practice","makes","perfect","coding"};
   String word1 = "coding";
   String word2 = "practice";
   System.out.println(sd.shortestDistance(words,word1,word2));
  }

}
