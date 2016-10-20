
/**
 * Write a description of WrodLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    
    public void countWordLengths(FileResource resource, int[] counts){
        
        for(String word : resource.words()){
            int len = word.length();
            char start = word.charAt(0);
            char end = word.charAt(len-1);
            if(!Character.isLetter(start)){
                len -= 1;
            }
            if(!Character.isLetter(end)){
                len -= 1;
            }
            counts[len] += 1;
        }
        
    }

    void testCountWordLengths(){
        FileResource file = new FileResource();
        int[] counts = new int[31];
        countWordLengths(file, counts);
        for(int i=0; i<counts.length; i++){
            System.out.println(i + " = " + counts[i]);
        }
        System.out.println("maxInd = " + indexOfMax(counts));
    }
    
    public int indexOfMax(int[] values){
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
}
