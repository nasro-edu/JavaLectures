package Lecture1;
public class Location {
	double  longitude, latitude;
	
	public double getLatitude() {
		return latitude;
	}
	public Location(double longitude, double latitude) {
		setLatitude(longitude, latitude) ;
	}
	public Location(Location loc) {
	setLatitude(loc.longitude, loc.latitude);
	}
	public void setLatitude(double longitude, double latitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String toString () {return "(long, alt)="+longitude + ","+latitude+")";}
}
