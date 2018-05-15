package com.util.dataStructure.Array;

import java.util.HashMap;

public class MakeChange {

    public static long makeChange(int []coin,int money){
        return makeChange(coin,money,0,new HashMap<String,Long>());
    }
    
    private static long makeChange(int[] coin, int money, int index, HashMap<String, Long> coinMemoMap) {
       if(money==0)
           return 1;
        if(index >=coin.length)
           return 0;
        
        long ways=0;
        int amountWithChange=0;
        String key =money +"-"+index;
        if(coinMemoMap.containsKey(key)){
            return coinMemoMap.get(key);
        }
        while(amountWithChange <= money){
            int remaining = money-amountWithChange;
            ways =  ways + makeChange(coin, remaining, index, coinMemoMap);
            amountWithChange= amountWithChange + coin[index];
           
        }
        coinMemoMap.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
