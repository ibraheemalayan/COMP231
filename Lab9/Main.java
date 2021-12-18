package Lab9;
import java.lang.Math;
public class Main {

    public static void main(String[] args) {


        System.out.println( bin2Dec("010h1")  );



    }

    public static int bin2Dec(String binaryString) throws NumberFormatException{

        int res = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if ( binaryString.charAt(i) == '1' ){
                res += Math.pow(2, i);

            }else if ( binaryString.charAt(i) != '0' ){
                throw new NumberFormatException("String is not binary");
            }
        }

        return res;
    }

}
