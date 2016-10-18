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
        
        //Compute the shifted alphabet
        //String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        //String shiftedLower = lowerAlphabet.substring(key)+lowerAlphabet.substring(0,key);
        
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
    
    public void testCaesar() {
        int key1 = 8;
        int key2 = 21;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encryptedTwice = encryptTwoKeys(message, key1, key2);
        System.out.println(encryptedTwice);
        String decryptedTwice = encryptTwoKeys(encryptedTwice, 26-key1, 26-key2);
        System.out.println(decryptedTwice);
    }
}

