
public class Package {
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private double basicFare;
	private int noOfDays;
	private double packageCost;
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
//write the required business logic methods as expected in the question description
	public void calculatePackageCost() {
		//fill your code here
		int discount=0;
		double gst,discount_result;
		double package_cost;
		int no_of_days=this.noOfDays;
	double basic_fare=this.basicFare;
	
	if(no_of_days<=5){
		 package_cost=((basic_fare*no_of_days));
		
		 gst=(package_cost*(12/100));
		
		this.packageCost=package_cost+gst;
	}
	else if(no_of_days>5 && no_of_days<=8){
		 discount=3;
		 package_cost=(double)((basic_fare*no_of_days));
		 discount_result=package_cost*(discount/100);
		 gst=(package_cost-discount_result)*(12/100);
		 
		 
		this.packageCost=(package_cost-discount_result)+gst;
	}
	else if(no_of_days>8 && no_of_days<=10){
		 discount=5;
		 package_cost=(double)((basic_fare*no_of_days));
		 discount_result=package_cost*(discount/100);
		 gst=(package_cost-discount_result)*(12/100);
		 
		 
		this.packageCost=(package_cost-discount_result)+gst;
		
	}
	else{
		
		
		 discount=7;
		 package_cost=(double)((basic_fare*no_of_days));
		 discount_result=package_cost*(discount/100);
		 gst=(package_cost-discount_result)*(12/100);
		 
		 
		this.packageCost=(package_cost-discount_result)+gst;
		
	}
	
	
	}
	
	
}
