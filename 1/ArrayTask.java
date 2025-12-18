import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;



public class Main{
  public static void main(String[]args){
     int[] arr = {3,8,15,17,8,8};
     int value = 32;
     getMatch(arr, value);
     checkDub(arr);
  }
  
    public static void getMatch(int[] a, int v){
    Map<Integer,Integer> hm = new HashMap<>();
    
    for(int i = 0; i < a.length; i++){
      int isIt = v - a[i];
      if(hm.containsKey(isIt)){
         System.out.println("result = ["+hm.get(isIt)+","+i+"]");  
      }
      hm.put(a[i],i);
    }
  }

  
  public static void checkDub(int[] a){     
    Set<Integer> withOutDup = Arrays.stream(a).boxed().collect(Collectors.toSet());
    boolean result = a.length != withOutDup.size();
    System.out.println(result ? "Result: true":"Result: false"+"\nДубликатов нет");
    for(int val : withOutDup){
        int dupCount = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i]==val){
              dupCount++;  
            } 
        }
        if(dupCount > 1){
            System.out.println("Число: " + val + " повторяется " + dupCount + " раз");
        }
    }
  }
}