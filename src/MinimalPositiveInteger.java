import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimalPositiveInteger {

    static int[] a = {-1,-5,5,6,1,2,7};//test example

    static final int
            min = -1000000,
            max = 1000000,
            maxLength = 100000;

    static int getMinimalPositiveInteger(int[] array) {
        if (array.length>maxLength) {
            System.out.println("ERROR: array length more than maximum acceptable array length: "+maxLength);
            System.exit(1);
        }
        if (array.length==0) {
            System.out.println("ERROR: array cannot be empty");
            System.exit(2);
        }
        for(int i=0;i<array.length;i++) {
            if (array[i] < min || array[i] > max) {
                System.out.println("ERROR: input array contains at least 1 value beyond acceptable limits");
                System.exit(3);
            }
        }

        //counting number of positive integers in input array
        int positivesNum=0;
        for(int i=0;i<array.length;i++) {
            if (array[i] > 0) positivesNum++;
        }

        //returning 1 if there are no positive integers
        if(positivesNum==0) return 1;

        //filling arraylist with positive integers of input array
        List<Integer> listOfPositives = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i]>0){
                listOfPositives.add(array[i]);
            }
        }

        //removing duplicates
        listOfPositives = listOfPositives.stream().distinct().collect(Collectors.toList());

        //sorting arrayList O(N*log (N))
        Collections.sort(listOfPositives);

        //finding result element
        for(int i=0;i<listOfPositives.size();i++){
            if(listOfPositives.get(i)!=i+1){
                return i+1;
            }
        }return listOfPositives.size()+1;


    }

    public static void main(String[]args) {
        System.out.println(getMinimalPositiveInteger(a));
    }


}

