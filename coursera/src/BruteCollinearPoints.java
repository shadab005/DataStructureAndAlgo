

public class BruteCollinearPoints {
   
   private Point[] points;
   public BruteCollinearPoints(Point[] points)// finds all line segments containing 4 points
   {
	  this.points = points;   
   }
   public int numberOfSegments()        // the number of line segments
   {
	   return 0;
   }
   public LineSegment[] segments()                // the line segments
   {
	   return null;
   }
}