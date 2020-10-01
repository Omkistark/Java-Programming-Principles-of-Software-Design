
/**
Write the class DepthFilter that implements Filter. 
This class should include private instance variables for a minimum and maximum depth,
a constructor to initialize those variables, and a satisfies method that returns true
if a QuakeEntry’s depth is between the minimum and maximum depths, or equal to one of them.
Otherwise it should return false.
 */
public class DepthFilter implements Filter
{
    private double depMin;
    private double depMax;
    public DepthFilter(double min,double max)
    { 
        depMin = min;
        depMax = max;
    } 

    public boolean satisfies(QuakeEntry qe) 
    { 
        //System.out.println((qe.getMagnitude() >= depMin)&&(qe.getMagnitude() <= depMax));
        return (qe.getDepth() >= depMin)&&(qe.getDepth() <= depMax); 
    }

    public String getName()
    {
        return("Depth");
    }
}
