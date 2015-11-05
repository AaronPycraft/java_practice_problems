/* AUthor: Aaron Pycraft
 * Date: 11/02/2015
 * File: clockHands.java
 * Synopsis: THis program will be used to determine how many times a clocks
 * 	hands cross in a given amount of time. 
 */
/*
 * There is a hand cross if 
 * hand A crosses hand B:	if (A > B && A-1 < B) 
 *
 */
import java.util.*;
public class clockHands {
  public static void main(String[] args) {
    //--Variables, location of the clock's hands
    int hourHand   = 0;	//--Range from 0 to 59
    int minuteHand = 0; //--Range from 0 to 59
    int secondHand = 0; //--Rnage from 0 to 59
    int[] clock = new int[60];
    int[] time = {0,0,0};
    final int MAX_HOURS = 24;
    //--Variables to increase readability of accessing time[]
    final int hr,min,sec;
    hr = 0;
    min = 1;
    sec = 2;
    
    //--Create loop to increment each hand
    //ASSUMPTIONS: 
    // - only one hand moves at a time (in min increments of one second)

    for(;;) {
      //--Print out the time
      System.out.printf("Time = \t%d:%d:%d\n",time[hr],time[min],time[sec]);

      //--Increment second hand
      secondHand++;
      time[sec]++;

      if (secondHand > 59) {
        //--Increment minute hand, if necessary
        secondHand = 0;
	time[sec] = 0;
        minuteHand++;
	time[min]++;

	if(minuteHand > 59) {
	  //--increment hours if necessary
	  minuteHand = 0;
	  time[min] = 0;
  	  hourHand++;	  
	  time[hr]++;
	  //--Stop counting if we've reached our max hours
	  if(time[hr] > MAX_HOURS - 1) break;
	}//end if
      }//end if
    }//end for
  }//end main
}//end class
