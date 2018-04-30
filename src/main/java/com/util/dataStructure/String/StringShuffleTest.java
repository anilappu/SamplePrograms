package com.util.dataStructure.String;

/*
 * Write a method that takes three strings and returns true if the third string is a valid shuffle of the first and second strings. 

In order to be a valid shuffle, the third string should satisfy the below two rules. 

rule 1 - all the characters from first and second should be in shuffle
rule 2 - the order of characters in the first and second string should be preserved.

Examples - 
checkForValidShuffe("abc", "xyz", "abxycz") // returns true as order is maintained and all the characters from both first and second strings are in the third string.

checkForValidShuffe("abc", "xyz", "axybcz") // returns true as order is maintained and all the characters from both first and second strings are in the third string.

checkForValidShuffe("abc", "xyz", "axycbz") // returns false as c comes before b.

checkForValidShuffe("abc", "xyz", "abxyz") // returns false as not all the characters from the first string are in the third string, 'c' is missing.

 */

public class StringShuffleTest {
    
    public static void main(String[] args) {
        System.out.println("is Valid Shufflle :checkForValidShuffle(\"abc\", \"xyz\", \"abxycz\" )" + checkForValidShuffle("abc", "xyz", "abxycz" ));
        System.out.println("is Valid Shufflle :checkForValidShuffle(\"abc\", \"xyz\", \"axycbz\" )" + checkForValidShuffle("abc", "xyz", "axycbz" ));
        System.out.println("is Valid Shufflle :checkForValidShuffle(\"abc\", \"xyz\", \"abxyz\" )" + checkForValidShuffle("abc", "xyz", "abxyz" ));
    }

    private static boolean checkForValidShuffle(String string1, String string2, String string3) {
        if(string1.length() + string2.length() != string3.length()){
            return false;
        }
        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();
        char[] str3 = string3.toCharArray();
        
        int str1Ctr =0;
        int str2Ctr =0;
        
        for(int i=0;i<str3.length;i++){
            if(str1Ctr <str1.length && str3[i]== str1[str1Ctr]){
                str1Ctr++;
                continue;
            }else if(str2Ctr <str2.length && str3[i]== str2[str2Ctr]){
                str2Ctr++;
                continue;
            }else{
                return false;
            }
        }
        
        return str1Ctr == str1.length && str2Ctr==str2.length; //mean its a valid Shuffle
    }

}
