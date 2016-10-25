
/**
 * Write a description of TestCaesarClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarClass {
    public int[] countLetters(String input){
        int[] freqTable = new int[26];
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = input.length();
        char start = input.charAt(0);
        char end = input.charAt(len-1);
        for(int i=0; i<len; i++){
            char c = input.charAt(i);
            char cu = Character.toUpperCase(c);
            int idx = alphabets.indexOf(cu);
            if(idx != -1){
                freqTable[idx] += 1;
            }
        }
        return freqTable;
    }
    
    public int maxIndex(int[] values){
        int max = 0;
        int maxInd = 0;
        int ind = 0;
        for(int val : values){
            if(val > max){
                max = val;
                maxInd = ind;
            }
            ind += 1;
        }
        return maxInd;
    }
    
    public int getKey(String s){
        int eLoc = maxIndex(countLetters(s));
        int key = eLoc-5; //key is the index of guessed E - actual location of E
        return key; //this is the most probable key; its still a guess though
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String contents = fr.asString();
        CaesarCipher ccEncr = new CaesarCipher(18);
        String encrypted = ccEncr.encrypt(contents);
        System.out.println("Encrypted String : " + encrypted);
        String decrypted = ccEncr.decrypt(encrypted);
        System.out.println("Decrypted String : " + decrypted);
    }
}
