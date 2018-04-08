public class MinimalPositiveInteger {

    static int[] a = {-2,-3,0,1,2,-6,4};//test example

    static final int
            min = -1000000,
            max = 1000000,
            maxLength = 100000;

    static int getMinimalPositiveInteger(int[] array) throws AssertionError{
        if (array.length>maxLength) {
            System.out.println("ERROR: array length more than maximum acceptable array length: "+maxLength);
            System.exit(1);
        }
        if (array.length==0) {
            System.out.println("ERROR: array cannot be empty");
            System.exit(2);
        }
        int res = 1;
        for(Integer i:array) {
            if (i<min||i>max) {
                System.out.println("ERROR: input array contains at least 1 value beyond acceptable limits");
                System.exit(3);
            }
            if(i==res) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[]args) {
        System.out.println("Minimum value of the array is: "+getMinimalPositiveInteger(a));
    }


}

