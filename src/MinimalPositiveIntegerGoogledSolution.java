import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Это решение я нагуглил, сам до такого не додумался
 */

    public class MinimalPositiveIntegerGoogledSolution {

        static int[] a = {2,3,100500, 6,5,0,6,1,-1};//test example

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

            //creating a bool array having the same size as the arrayList of positive ints from input array
            int size = listOfPositives.size();
            boolean[] arrayOfBools = new boolean[size];
            
            //filling it with false value
            Arrays.fill(arrayOfBools, false);
            
            //if positive int from the array less than size, set value of the same index to true
            for(int i=0;i<size;i++){
                if(listOfPositives.get(i)<size){
                    arrayOfBools[listOfPositives.get(i)]=true;
                }
            }
            
            //searching for the first false
            for(int i=1;i<size;i++){
                if (!arrayOfBools[i]){
                    return i;
                }
            }
            
            //if all values equal true, the answer is the size of the list
            return size;
        }

        public static void main(String[]args) {
            System.out.println(getMinimalPositiveInteger(a));
        }


    }
