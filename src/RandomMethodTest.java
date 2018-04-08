import java.util.Random;

public class RandomMethodTest {

    static Random r = new Random();

    static int attempts = 100000;

    static int getRandomNumberFrom1to6(){
        return r.nextInt(6)+1;
    }

    public static void main(String[] args){
        double total = 0;
        for(int i=0;i<attempts;i++){
            int res = getRandomNumberFrom1to6();
            total=total+res;
        }
        System.out.println(total/attempts);

    }

}