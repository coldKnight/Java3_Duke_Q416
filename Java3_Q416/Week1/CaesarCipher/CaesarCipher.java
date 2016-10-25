import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        String shiftedLower = lowerAlphabet.substring(key)+lowerAlphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            else{
                idx = lowerAlphabet.indexOf(currChar);
                
                if(idx != -1){
                    char newChar = shiftedLower.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        int strLen = input.length();
        StringBuilder encryptedTwice = new StringBuilder(input);
        int key = 0;
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encryptedTwice.length(); i++) {
            
            if(i%2 == 0){
                key = key1;
            }
            else{
                key = key2;
            }
            
            //Compute the shifted alphabet
            String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
            String shiftedLower = lowerAlphabet.substring(key)+lowerAlphabet.substring(0,key);
            
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encryptedTwice.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encryptedTwice.setCharAt(i, newChar);
            }
            else{
                idx = lowerAlphabet.indexOf(currChar);
                
                if(idx != -1){
                    char newChar = shiftedLower.charAt(idx);
                    encryptedTwice.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encryptedTwice.toString();
        
    }
    
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
    
    public void testCaesar() {
        int key1 = 23;
        int key2 = 2;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        String encryptedTwice = encryptTwoKeys(message, key1, key2);
        System.out.println(encryptedTwice);
        String decryptedTwice = encryptTwoKeys(encryptedTwice, 26-key1, 26-key2);
        System.out.println(decryptedTwice);
    }
}