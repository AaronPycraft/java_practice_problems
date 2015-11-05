import java.util.*;

public class MergeSort {
  //--Variables to sort
  int[] array;
  int[] tempArray;
  int length;

  public static void main(String[] args) {
    //--Generate sequence of random numbers
    MergeSort ms = new MergeSort();
    
    //--Create array to sort
    int[] inputArray = {14,96,20,6,3,46,83};
    
    //--print the unsorted array
    for(int i:inputArray) System.out.print(i + " ");
    System.out.println();

    //--Sort the array
    ms.sort(inputArray);
    
    //--Output sorted array
    for(int i = 0; i < inputArray.length - 1; i++) {
      System.out.print(inputArray[i] + " ");
    }//end for 
    System.out.println();

  }//end main

/*
Merge sort algorithm
split each element into partitions of size 1
recursively merge adjancent partitions
  for i = leftPartStartIndex to rightPartLastIndex inclusive
    if leftPartHeadValue <= rightPartHeadValue
      copy leftPartHeadValue
    else: copy rightPartHeadValue
copy elements back to original array

To implement the merge sort recursively, we need to set the indices
for the leftmost and rightmost elements. Then sort the elements 
between the indices (recursive)

if we have only two elements to sort, then copy them in order to a 
second array. Then, preserving order, copy them back to the original
array.
*/
  
//--Method to implement sort
  public void sort(int[] inputArray) {
    //--Create index variables
    int left_index, right_index;
    this.array = inputArray;
    this.length = array.length; 
    this.tempArray = new int[length];
    
    //--Begin sorting the entire array
    doMergeSort(0,length-1);

  }//end method

  //--Recursive method to break down the list in to smaller chunks
  private void doMergeSort(int lowIndex, int highIndex) {
    //--split the list in half
    if(lowIndex < highIndex) {
      int middle = (lowIndex + highIndex)/2;

      //--sort the left half
      doMergeSort(lowIndex, middle); 
    
      //--sort the right half
      doMergeSort(middle + 1, highIndex); 

      //--merge the parts
      mergeParts(lowIndex, middle, highIndex);
    }//end if

  }//end method

  //--Method to merge parts of a list, uses a temp array to sort main
  //  array
  private void mergeParts(int lowIndex, int middle, int highIndex) {
    //--Copy the array into the temporary array
    for(int i = lowIndex; i <= highIndex; i++) {
      tempArray[i] = array[i];
    }//end for

    //--Create loop iterator items
    int i = lowIndex;
    int j = middle;
    int k = lowIndex;
    //--For all of the elements between the given index locations...
    //--Copy the smaller item of tempArray to the leftmost position
    //  in the actual array
    while(i <= middle+1 && j >= highIndex) {
      //--If the left element is larger than the right, 
      if(tempArray[i] < tempArray[j]) {
        //--copy the left to the actual array left
	array[k] = tempArray[i]; 
	i++;
      }//end if
      //--Otherwise, copy the right (larger) item into the left in the
      //  actual array
      else {
        array[k] = tempArray[j];
	j++;
      }//end else
    }//end while
    while(i <= middle) {
      array[k] = tempArray[i];
      k++;
      i++;
    }//end while

  }//end method


}//end class
