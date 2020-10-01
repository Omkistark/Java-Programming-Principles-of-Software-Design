/*
 * Modify the code in the quakesWithFilter method in the EarthQuakeClient2 class to filter earthquakes using two criteria,
   those with magnitude between 4.0 and 5.0 and depth between -35000.0 and -12000.0. 
   You’ll need to use both the MagnitudeFilter and the DepthFilter. Use one and then use the other on the result from the first. 
   After writing this method, when you run your program on the file nov20quakedatasmall.atom, you will see the following two earthquakes meet that criteria:
(26.38, 142.71), mag = 5.50, depth = -12890.00, title = 91km SSE of Chichi-shima, Japan
(38.27, 142.53), mag = 4.60, depth = -30500.00, title = 109km E of Ishinomaki, Japan

  * Write a new void method named testMatchAllFilter in the EarthQuakeClient2 class.
  This method reads in earthquake data from a source and stores them into an ArrayList of type QuakeEntry. 
  Then it prints all the earthquakes and how many earthquakes that were from the source. 
  You should read in earthquakes from the small file nov20quakedatasmall.atom, 
  print all the earthquakes and also print how many there are. 
  After this works you should comment out the printing of all the earthquakes, but continue to print out the total number of earthquakes read in. 
  Then create a MatchAllFilter named maf and use the addFilter method to add three Filters
  to test the magnitude between 0.0 and 2.0, to test the depth between -100000.0 and -10000.0, and if the letter “a” is in the title. 
  Then use filter(list, maf) to use all three filters and print out the resulting list of earthquakes. 
  You will see the following two earthquakes meet that criteria:
(33.54, -116.66), mag = 0.30, depth = -10410.00, title = 2km SE of Anza, California
(63.25, -150.43), mag = 1.70, depth = -99900.00, title = 75km WSW of Cantwell, Alaska   
   
   * Write a new void method named testMatchAllFilter2 in the EarthQuakeClient2 class. 
   This method should be identical to the method testMatchAllFilter, but will create different Filters.
   You should read in earthquakes from the small file nov20quakedatasmall.atom.
   Then create a MatchAllFilter named maf, and use the addFilter method to add three Filters 
   to test the magnitude between 0.0 and 3.0, to test for the distance from Tulsa, Oklahoma at location (36.1314, -95.9372) 
   is less than 10000000 meters (10000 km), and if the substring “Ca” is in the title. 
   Then use filter(list, maf) to use all three filters and print out the resulting list of earthquakes. 
   You will see the following seven earthquakes meet that criteria:
(33.54, -116.66), mag = 0.30, depth = -10410.00, title = 2km SE of Anza, California
(63.44, -147.62), mag = 1.60, depth = -7400.00, title = 66km E of Cantwell, Alaska
(36.27, -121.66), mag = 2.00, depth = -7630.00, title = 28km SSE of Carmel Valley Village, California
(63.25, -150.43), mag = 1.70, depth = -99900.00, title = 75km WSW of Cantwell, Alaska
(35.00, -118.21), mag = 1.30, depth = 1010.00, title = Quarry Blast - 7km SSW of Mojave, California
(49.39, -120.44), mag = 2.40, depth = -20.00, title = Explosion - 8km SSE of Princeton, Canada
(34.05, -117.36), mag = 1.20, depth = 1040.00, title = Quarry Blast - 4km WNW of Grand Terrace, California

    * Modify the Filter interface to include a new method named getName that returns the name of the filter.
    The line added to the Filter interface should be: public String getName(); 
    What changes need to be made to all the Filter classes?
    The user should be able to specify what they want the name of the filter to be when they create a specific filter.
    For the MatchAllFilter class, a getName method should return a String of all the Filter names in its ArrayList.

    Add to the end of the method testMatchAllFilter a call to the MatchAllFilter getName method to print out all the Filter names used.
    For the example above, printing “Filters used are: “ followed by the call to getName could result in the output:
    Filters used are: Magnitude Depth Phrase
   
*/
import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 
{
    public EarthQuakeClient2() 
    {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) 
    { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() 
    { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "/EarthquakeFilterStarterProgram/data/nov20quakedatasmall.atom";
        String source = "/EarthquakeFilterStarterProgram/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        int count=0;
        /*
        Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } 
        */

       /*
          * Assignment 1
        Filter f1 = new MagnitudeFilter(4.0,5.0); 
        Filter f2 = new DepthFilter(-35000.0,-12000.0);
        ArrayList<QuakeEntry> filtered1  = filter(list, f1);
        ArrayList<QuakeEntry> filtered  = filter(filtered1, f2);

        */
       /*
        MatchAllFilter maf=new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(4.0,5.0));
        maf.addFilter(new DepthFilter(-35000.0,-12000.0));
        ArrayList<QuakeEntry> filtered  = filter(list, maf);
        for (QuakeEntry qe: filtered) 
        { 
            System.out.println(qe);
        }
        */
       /*
        * Practice Quiz ques 1
        MatchAllFilter maf=new MatchAllFilter();  
        Location loc = new Location(35.42, 139.43);
        maf.addFilter(new DistanceFilter(loc,10000000));
        maf.addFilter(new PhraseFilter("end","Japan"));
        ArrayList<QuakeEntry> filtered  = filter(list, maf);
        for (QuakeEntry qe: filtered) 
        { 
            System.out.println(qe);
            count++;
        }
        System.out.println("Number of Such Quakes: "+count);
        */
        /*
        
        MatchAllFilter maf=new MatchAllFilter();  
        maf.addFilter(new MagnitudeFilter(4.0,5.0));
        maf.addFilter(new DepthFilter(-35000.0,-12000.0));
        ArrayList<QuakeEntry> filtered  = filter(list, maf);
        for (QuakeEntry qe: filtered) 
        { 
            System.out.println(qe);
            count++;
        }
        System.out.println("Number of Such Quakes: "+count);
        */
       /*
        MatchAllFilter maf=new MatchAllFilter();  
        Location loc = new Location(39.7392, -104.9903);
        maf.addFilter(new DistanceFilter(loc,1000000));
        maf.addFilter(new PhraseFilter("end","a"));
        ArrayList<QuakeEntry> filtered  = filter(list, maf);
        for (QuakeEntry qe: filtered) 
        { 
            System.out.println(qe);
            count++;
        }
        System.out.println("Number of Such Quakes: "+count);
       */
       
        MatchAllFilter maf=new MatchAllFilter();  
        maf.addFilter(new MagnitudeFilter(3.5,4.5));
        maf.addFilter(new DepthFilter(-55000.0,-20000.0));
        ArrayList<QuakeEntry> filtered  = filter(list, maf);
        for (QuakeEntry qe: filtered) 
        { 
            System.out.println(qe);
            count++;
        }
        System.out.println("Number of Such Quakes: "+count);
       
    }
    
    public void testMatchAllFilter()
    {
        int count=0;
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "/EarthquakeFilterStarterProgram/data/nov20quakedatasmall.atom";
        String source = "/JAVA/EarthquakeFilterStarterProgram/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        /*
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0.0,2.0));
        maf.addFilter(new DepthFilter(-100000.0,-10000.0));
        maf.addFilter(new PhraseFilter("any","a"));
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        for(QuakeEntry qe : quakes)
        {
            System.out.println(qe);
            count++;
        }
        System.out.println("Filters used are:" + maf.getName());
        System.out.println("Number of Such Quakes: "+count);
        */
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(1.0,4.0));
        maf.addFilter(new DepthFilter(-180000.0,-30000.0));
        maf.addFilter(new PhraseFilter("any","o"));
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        for(QuakeEntry qe : quakes)
        {
            System.out.println(qe);
            count++;
        }
        System.out.println("Filters used are:" + maf.getName());
        System.out.println("Number of Such Quakes: "+count);
    }
    
    public void testMatchFilter2()
    { 
        int count=0;
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "/EarthquakeFilterStarterProgram/data/nov20quakedatasmall.atom";
        String source = "/EarthquakeFilterStarterProgram/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        /*
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0.0,3.0));
        Location loc = new Location(36.1314, -95.9372);
        maf.addFilter(new DistanceFilter(loc,10000000));
        maf.addFilter(new PhraseFilter("any","Ca"));
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        for(QuakeEntry qe : quakes)
        {
            System.out.println(qe);
            count++;
        }
        System.out.println("Filters used are:" + maf.getName());
        System.out.println("Number of Such Quakes: "+count);
        */
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0.0,5.0));
        Location loc = new Location(55.7308, 9.1153) ;
        maf.addFilter(new DistanceFilter(loc,3000000));
        maf.addFilter(new PhraseFilter("any","e"));
        ArrayList<QuakeEntry> quakes = filter(list,maf);
        for(QuakeEntry qe : quakes)
        {
            System.out.println(qe);
            count++;
        }
        System.out.println("Filters used are:" + maf.getName());
        System.out.println("Number of Such Quakes: "+count);
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "/EarthquakeFilterStarterProgram/data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
