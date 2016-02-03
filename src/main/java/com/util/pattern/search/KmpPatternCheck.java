package com.util.pattern.search;

public class KmpPatternCheck {

    public static void main(String[] args) {
        
        String StringtoSearch = "abcxabcdabcdabcysasasasaabcdabcy";
        String pattern = "abcdabcy";
        KmpPatternCheck kmpPattern = new KmpPatternCheck();
        String indexes = kmpPattern.KMP(StringtoSearch.toCharArray(), pattern.toCharArray());
        System.out.print(indexes);

    }

   /** Date 02/03/2016
    * @author Anil
    * 
    * KMP - O(n+M)
    * 
    * 
    */
    
    private String KMP(char[] charText, char[] pattern) {
        
        int[] tempArray = computeSuffixPrefixxArray(pattern);
        int i = 0,j=0;
        int patternLength = pattern.length;
        int index =0;
        String indexes ="";
        
        while(i<charText.length ){
            if(charText[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = tempArray[j-1];
                }else
                    i++;
            }
            if(j==patternLength){
                index = i - patternLength;
                indexes = indexes + ","+ index;
                j=0;
                index =0;
            }
        }
        
        return indexes;
    }


    /**
     * Compute  array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computeSuffixPrefixxArray(char pattern[]){
        int []tempArray = new int[pattern.length];
        int index =0;
        for(int i=1;i<pattern.length;){
            if(pattern[i] == pattern[index]){
                tempArray[i]= index + 1;
                index++;
                i++;
            }else{
                if(index!=0){
                    index = tempArray[index-1];
                }else{
                    tempArray[index]=0;
                    i++;
                }
            }
        }
        
        return tempArray;
        
    }

}
