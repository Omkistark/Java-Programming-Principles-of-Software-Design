import edu.duke.*;
import java.util.*;

public class MarkovRunnerWithInterface 
{
    public void runModel(IMarkovModel markov, String text, int size, int seed) 
    {
        markov.setTraining(text);
        markov.setRandom(seed);
    
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            //printOut(st);
        }
    }
    
    public void runMarkov() 
    {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 25;
        
        //MarkovZero mz = new MarkovZero();
        //runModel(mz, st, size, seed);
    
        //MarkovOne mOne = new MarkovOne();
        //runModel(mOne, st, size, seed);
        
        //MarkovFour mFour = new MarkovFour();
        //runModel(mFour, st, size, seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);

    }
    
    public void testHashMap()
    {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //String st = "yes-this-is-a-thin-pretty-pink-thistle";
        //int size = 50;
        //int seed = 42;
        
        int size = 1000;
        int seed = 615;
        //EfficientMarkovModel markov = new EfficientMarkovModel(2);
        EfficientMarkovModel markov = new EfficientMarkovModel(5);
        runModel(markov, st, size, seed);
        markov.printHashMapInfo();
    }

    public void compareMethods()
    {
        FileResource fr = new FileResource();
        String st1 = fr.asString();
        st1 = st1.replace('\n', ' ');

        String st2 = fr.asString();
        st1 = st2.replace('\n', ' ');

        int size = 1000;
        int seed = 42;
        
        long time1=System.nanoTime();
        EfficientMarkovModel markov1 = new EfficientMarkovModel(2);
        runModel(markov1, st1, size, seed);
        long final1=System.nanoTime()-time1;
        
        long time2=System.nanoTime();
        MarkovModel markov2 = new MarkovModel(2);
        runModel(markov2, st2, size, seed);
        long final2=System.nanoTime()-time2;
        
        System.out.println("EfficientMarkovModel: "+ final1);
        System.out.println("MarkovModel: "+ final2);
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
}
