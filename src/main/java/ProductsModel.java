import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductsModel {
	
	
	
//Method to supply List of all product 
public List<Product> findAll(){
		
		try {	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
				List<Product> result = new ArrayList<Product>();
				result.add(new Product("Ph", "iPhone" , 1000, 4, new Date()));
				result.add(new Product("TV", "SONY-Oled" , 3000, 3, sdf.parse("2016-10-20")));
				result.add(new Product("Ac", "Generel" , 8000, 5, sdf.parse("2016-10-20")));
				result.add(new Product("Pc", "Acer-Laptop" , 8000, 5, sdf.parse("2016-10-20")));
				return result;
				
			} catch (Exception e) {
				return null;
			}
		}





}
