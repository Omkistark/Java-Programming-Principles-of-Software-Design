
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class LargestQuakes 
{
    public int indexOfLargest(ArrayList<QuakeEntry> data)
    {
        QuakeEntry max=new QuakeEntry();
        int i=0,ans=0;
        for (QuakeEntry qe : data) 
        {
            //System.out.println("max "+max.getMagnitude()+" qe "+qe.getMagnitude() );
            if(qe.getMagnitude()>max.getMagnitude())
            {
                max=qe;
                ans=i;
            }
            i++;
        }
        return ans;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData,int howMany)
    {
        ArrayList<QuakeEntry> ret= new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData); 
        for(int j=0; j < howMany; j++)
        {
            int maxIndex = 0;
            for(int k=1; k < copy.size(); k++)
            {
                QuakeEntry quake = copy.get(k);
                if (quake.getMagnitude()>copy.get(maxIndex).getMagnitude())
                {
                    maxIndex = k;  
                }
            }  
            ret.add(copy.get(maxIndex));
            copy.remove(maxIndex);
        }
        return ret;
    }
    public void findLargestQuakes()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        // Insert appropriate Path in the next line
        String source = "/SearchingEarthquakeDataStarterProgram/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        //System.out.println("Largest quake at location "+indexOfLargest(list));
        ArrayList<QuakeEntry> answer  = getLargest(list,5);
        
        for (QuakeEntry qe : answer) 
        {
            System.out.println(qe);
        }
        
    }
}
