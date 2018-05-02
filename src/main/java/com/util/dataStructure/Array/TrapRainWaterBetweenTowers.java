package com.util.dataStructure.Array;
/*
 * We have an array where each element represents height of a tower. If it starts raining,
 *  what is the amount of water 
 * that can be collected between the towers? Assumption is that the width of every tower is 1.
 * O(n) complexity
 */

public class TrapRainWaterBetweenTowers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] towerHeight = { 1, 5, 2, 3, 1, 7, 2, 4 };
        System.out.println("amount of water we can collect for array "+ getAmountOfWater(towerHeight) );

    }

    private static int getAmountOfWater(int[] array) {
        if(array.length==0 || array.length==1){
            return -1;
        }
        int [] rightHeight = new int[array.length];
        
        
        int amountOfWater=0;
        int maxleft=0;
        int maxright=0;
       // int[] maxRtHeight= new int[array.length-1];
        
        for(int i=array.length-1;i>=0;i--){
            if(array[i] >maxright){
                maxright =array[i];
                rightHeight[i]= maxright;
            }else{
                rightHeight[i]= maxright;
            }
        }
        
        for(int i=0 ;i< array.length;i++){
            amountOfWater = amountOfWater + Math.max(Math.min(maxleft,rightHeight[i])-array[i],0);
            if(array[i] > maxleft){
                maxleft=array[i];
                
            }
        }
        
        return amountOfWater;
    }

}
