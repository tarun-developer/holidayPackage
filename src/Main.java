
import java.io.IOException;
import java.util.*;
public class Main {

	public static void main(String[] args)  throws IOException {

		//fill your code here
		TravelAgency t=new TravelAgency();
		List<Package>p=new ArrayList<Package>();
		p=t.findPackagesWithMinimumNumberOfDays();
		for(Package i:p){
			System.out.println(i.getPackageId() +i.getSourcePlace() + i.getDestinationPlace()+i.getBasicFare()+i.getNoOfDays() +" "+i.getPackageCost());
		}
		
	}

}
