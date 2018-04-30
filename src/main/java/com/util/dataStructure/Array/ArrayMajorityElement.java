package com.util.dataStructure.Array;

/* find a MAjority element in un sorted array
 * Manority element - element occurs more than n/2 time in array
 * n is siz eof array. we use Boyer moore Vote alogorith
 * Time compolexity O(n)*/



public class ArrayMajorityElement {

    public static void main(String[] args) {
       int[] array1 =  {10,4,4,4,2,4,21};
       int[] array2 =  {10,4,10,8,2,80,21};
       int[] array3 =  {90,42,90,90,22,90,90};
       
      System.out.println("Majority Elemnt of Array 1 is " + getMajorityElement(array1));
      System.out.println("Majority Elemnt of Array 2 is " + getMajorityElement(array2));

       System.out.println("Majority Elemnt of Array 3 is " + getMajorityElement(array3));

       
       
       
    }

    //use binary search to find peak element
    private static int getMajorityElement(int[] array) {
        int maxCount=0;
        if(array.length ==0){
            return -1;//no element
        }
        int count =1;
        int majorityElement =array[0];
        
        for(int i=1;i<array.length;i++){
            if(majorityElement == array[i]){
                count++;
            }else{
                count--;
                if(count==0){
                    majorityElement = array[i]; 
                    count =1;
                }
            }
        }
        
        if(count >0){
            for(int i= 0;i<array.length;i++){
                if(array[i]==majorityElement){
                    maxCount++;
                }
            }
        }else{
            return -1;
        }
        
     
        return maxCount > array.length/2 ? majorityElement:-1;
    }
    


}
