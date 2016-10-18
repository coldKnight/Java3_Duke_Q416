
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class WordPlay {
    
    public boolean isVowel(char ch){
        String vowels = "aeiouAEIOU";
        int idx = vowels.indexOf(ch);
        if(idx != -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        int strLen = phrase.length();
        for (int i=0; i<strLen; i++){
            if (isVowel(sb.charAt(i))){
                sb.setCharAt(i, ch);
            }
        }
        String replacedStr = sb.toString();
        return replacedStr;
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        char lowerCh = Character.toLowerCase(ch);
        char upperCh = Character.toUpperCase(ch);
        int strLen = phrase.length();
        for (int i=0; i<strLen; i++){
            if((sb.charAt(i) == upperCh) || (sb.charAt(i) == lowerCh)){
                //location is odd
                if(i%2 == 0){
                    sb.setCharAt(i, '*');
                }
                else{
                    sb.setCharAt(i, '+');
                }
            }
        }
        String emphasizedStr = sb.toString();
        return emphasizedStr;
    }
}