
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,4,4,3,3,1,5,3};
        Set set=new HashSet();
        Set list=new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])){
                list.add(arr[i]);
            }else set.add(arr[i]);
        }
        System.out.println(list);
    }


}
