
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class TravelAgency {
    
    //write the required business logic methods as expected in the question description
	
	public List<Package> generatePackageCost(String filePath) throws InvalidPackageIdException {
		
		// Fill you code Here
		
		
		List<Package> p=new ArrayList<Package>();
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			f = new File(filePath);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s = null;
			String sp[];
			while ((s = br.readLine()) != null) {
				sp = s.split(",");
				try{
				if(validate(sp[0])){
				Package pd=new Package();
				pd.setPackageId(sp[0]);
				pd.setSourcePlace(sp[1]);
				pd.setDestinationPlace(sp[2]);
				pd.setBasicFare(Double.parseDouble(sp[3]));
				pd.setNoOfDays(Integer.parseInt(sp[4]));
				pd.calculatePackageCost();
				p.add(pd);
				}
			
				}
				catch (InvalidPackageIdException e) {
					
				e.getMessage();
				}
			
			
			
			}
			
			
			br.close();
			fr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
			
			return p;
	}
	
	public boolean validate(String packageId) throws InvalidPackageIdException {
		
    	// Fill you code Here
		
		if(packageId.matches("[0-9a-zA-Z]{3}[/]{1}[0-9a-zA-Z]{3}$")){
			return true;
		}
		else {
			
			throw new InvalidPackageIdException("Invalid Package Id");
		}
		

	}
	
	
	public List<Package> findPackagesWithMinimumNumberOfDays() {
		
		// Fill you code Here
		List<Package>l=new ArrayList<Package>();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection conn = new DBHandler().establishConnection();) {
			preparedStatement = conn.prepareStatement(
					"select * from package_details where no_of_days =(select min(no_of_days) from package_details)");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Package pd = new Package();
				pd.setPackageId(resultSet.getString(1));
				pd.setSourcePlace(resultSet.getString(2));
				pd.setDestinationPlace(resultSet.getString(3));
				pd.setNoOfDays(resultSet.getInt(4));
				pd.setPackageCost(resultSet.getDouble(5));
				l.add(pd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return l;
	}
}
