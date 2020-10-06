
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        //MarkovWord markov = new MarkovWord(3); 
        MarkovWord markov = new MarkovWord(5); 
        //runModel(markov, st, 200,643); 
        //runModel(markov, st, 200,621); 
        runModel(markov, st, 200,844); 
    } 

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

    public void testHashMap()
    {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //String st = "this is a test yes this is really a test yes a test this is wow";
        //String st = "this is a test yes this is really a test";
        //int size = 500;
        int size = 50;
        //int seed = 42;
        //int seed = 371;
        //int seed = 65;
        //int seed = 792;
        int seed = 531;
        //EfficientMarkovWord markov = new EfficientMarkovWord(2);
        //EfficientMarkovWord markov = new EfficientMarkovWord(3);
        //EfficientMarkovWord markov = new EfficientMarkovWord(6);
        EfficientMarkovWord markov = new EfficientMarkovWord(5);
        
        runModel(markov, st, size, seed);
        System.out.println("\n\n Information:");
        markov.printHashMapInfo();
    }
    
    public void compareMethods()
    {
        FileResource fr = new FileResource(); 
        String st1 = fr.asString(); 
        st1 = st1.replace('\n', ' '); 
        String st2 = fr.asString(); 
        st2 = st2.replace('\n', ' ');
        int size = 100;
        int seed = 42;
        
        long t1=System.nanoTime();
        MarkovWord markov1 = new MarkovWord(2); 
        runModel(markov1, st1, size,seed); 
        long final1=System.nanoTime()-t1;
        
        long t2=System.nanoTime();
        EfficientMarkovWord markov2 = new EfficientMarkovWord(2);
        runModel(markov2, st2, size, seed);
        long final2=System.nanoTime()-t2;
        
        System.out.println("MarkovWord: "+final1);
        System.out.println("EfficientMarkovWord: "+final2);
    }
}
