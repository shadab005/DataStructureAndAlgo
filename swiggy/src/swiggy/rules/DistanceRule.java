package swiggy.rules;

import swiggy.models.Assignment;
import swiggy.models.Location;

public class DistanceRule implements Rule{
	
	private final double EARTH = 6371;
	private final int AVG_SPEED =20; //speed = 20km/hr

	@Override
	public int contributionValue(Assignment assignment, int priority) {
		//less the time take more the cost
		//so we time is inversely proportional to prioritization cost
		double haversineEquivalent = getFirstMile(assignment); 
		double value = 1000/haversineEquivalent;
		return priority*Double.valueOf(value).intValue();
	}
	
	private double getFirstMile(Assignment a) {
		Location l1 = a.getOrder().getLocation();
		double x1 = l1.getLatitude();
		double y1 = l1.getLongitude();
		
		Location l2 = a.getDeliveryExecutive().getLocation();
		double x2 = l2.getLatitude();
		double y2 = l2.getLongitude();
		
		double dlat1=x1*(Math.PI/180);
        double dlong1=y1*(Math.PI/180);
        double dlat2=x2*(Math.PI/180);
        double dlong2=y2*(Math.PI/180);
        
        double dLong=dlong1-dlong2;
        double dLat=dlat1-dlat2;
        
        double aHarv= Math.pow(Math.sin(dLat/2.0),2.0)+Math.cos(dlat1)*Math.cos(dlat2)*Math.pow(Math.sin(dLong/2),2);
        double cHarv=2*Math.atan2(Math.sqrt(aHarv),Math.sqrt(1.0-aHarv));
        return (EARTH*cHarv)/AVG_SPEED;
		
	}

}
