/* 
 * We are presented with a list of one million integers, which hold the 
 * ages of customers. We need to sort the list of ages.
 */

/* 
 * The solution:
 * We can create an array of size 130 (max age) and populate it with the
 * number of customers that have that age. 
 */
import java.util.*;

public class sortListofIntegers {
  public static void main(String[] args) {
    //--Declare variables
    int age = 0;
    int[] customerAges = new int[130];
    int numOfCustomers = 1000000;

    //--generate list of random ages
    for(int i = 0; i < numOfCustomers; i++) {
      age = (int)(Math.random() * 130);

      //--Organize the random ages
      customerAges[age]++;
    }//end loop

    //--Output result
    for(int i = 0; i < customerAges.length; i++) {
      System.out.println("num of customers age " + i 
	+ " = " + customerAges[i]);
    }//end for
    

    
  }//end main
}//end class
