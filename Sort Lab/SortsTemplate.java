
import java.util.*;

public class SortsTemplate{
  private long steps;
  
  //Description of Constructor
  public SortsTemplate(){
    steps = 0;
  }
  
  /**
   * @param  list  reference to an array of integers to be sorted
   */
  public int bubbleSort(ArrayList <Integer> list){
    int temp;
    int steps = 0;
    for(int i=0; i<list.size()-1; ++i)
    {
      for(int j=i+1; j<list.size(); ++j)
      {
        if(list.get(i) > list.get(j)){
          temp = list.get(i);
          list.set(i, list.get(j));
          list.set(j, temp);
        }
        steps++;
      }
    }
    System.out.println();
    System.out.println("Bubble Sort");
    System.out.println();
    return steps;
  }
  
  /**
   * @param  list  reference to an array of integers to be sorted
   * At the end of execution, return the number of steps (comparisons) performed
   */
  public int selectionSort(ArrayList <Integer> list){
    //replace these lines with your code
    int steps = 0;
    for(int j = 0; j < list.size(); j++)
    {
      int minIndex = j;
      for(int k = j + 1; k < list.size(); k++)
      {
        if(list.get(k) < list.get(minIndex))
          minIndex = k;
        steps++;
      }
      int temp = list.get(j);
      list.set(j, list.get(minIndex));
      list.set(minIndex, temp);
    }
    System.out.println();
    System.out.println("SELECTION SORT");
    System.out.println();
    return steps;
  }
  
  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   * At the end of execution, return the number of steps (comparisons) performed
   */
  public int insertionSort(ArrayList <Integer> list){
    //replace these lines with your code
    int steps = 0;
    for(int j = 1; j < list.size(); j++)
    {
    int temp = list.get(j);
    int possibleIndex = j;
    while(possibleIndex > 0 && temp < list.get(possibleIndex - 1))
    {
      list.set(possibleIndex, list.get(possibleIndex - 1));
      possibleIndex--;
      steps++;
    }
    list.set(possibleIndex, temp);
    }
    System.out.println();
    System.out.println("INSERTION SORT");
    System.out.println();
    return steps;
  }
  
  
  /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
  public int mergeSort(ArrayList <Integer> list) {
    int length = list.size()-1;
    return doMergeSort(list, 0, length, 0);
  }
  private int doMergeSort(ArrayList <Integer> list, int lowerIndex, int higherIndex, int steps) {
    
    if (lowerIndex < higherIndex) {
      int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
      // Below step sorts the left side of the array
      steps = doMergeSort(list, lowerIndex, middle, steps);
      // Below step sorts the right side of the array
      steps = doMergeSort(list, middle + 1, higherIndex, steps);
      // Now merge both sides
      steps = mergeParts(list, lowerIndex, middle, higherIndex, steps);
    }
    
    return steps;
  }
  private int mergeParts(ArrayList <Integer> list, int lowerIndex, int middle, int higherIndex, int steps) {
    ArrayList<Integer> tempArrList = new ArrayList<Integer>();
    for (int i = 0; i <= list.size()-1; i++) {
      tempArrList.add(list.get(i));
    }
    int i = lowerIndex;
    int j = middle + 1;
    int k = lowerIndex;
    while (i <= middle && j <= higherIndex) {
      if (tempArrList.get(i) <= tempArrList.get(j)) {
        list.set(k, tempArrList.get(i));
        i++;
      } else {
        list.set(k, tempArrList.get(j));
        j++;
      }
      k++;
    }
    while (i <= middle) {
      steps++;
      list.set(k, tempArrList.get(i));
      k++;
      i++;
    }
    return steps;
  }
    
    
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
    return steps;
  }
    
    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
      steps = stepCount;
    }
    
    /**
     *  Interchanges two elements in an ArrayList
     *
     * @param  list  reference to an array of integers
     * @param  a     index of integer to be swapped
     * @param  b     index of integer to be swapped
     */
    public void swap(ArrayList <Integer> list, int a, int b){
      //replace these lines with your code
      int temp = list.get(a);
      list.set(a, list.get(b));
      list.set(b, temp);
      System.out.println();
      System.out.println("Swap");
      System.out.println();
    }
}
