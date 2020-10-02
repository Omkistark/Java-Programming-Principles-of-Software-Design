
/**
Write the class DistanceFilter that implements Filter.
This class should include private instance variables for a location and a maximum distance,
a constructor to initialize those variables, and a satisfies method that returns true if a 
QuakeEntry’s distance from the given location is less than the specified maximum distance. 
Otherwise it should return false.
 */
public class DistanceFilter implements Filter
{
    private Location myLocation;
    private double distMax;
    public DistanceFilter(Location loc,double max)
    { 
        myLocation = loc;
        distMax = max;
    } 

    public boolean satisfies(QuakeEntry qe) 
    { 
        return (myLocation.distanceTo(qe.getLocation()) < distMax); 
    }

    public String getName()
    {
        return("Distance");
    }
}
