package java8;

interface Changes {

	public String Data(String name, String lastname);
}

public class LamdaDemo3  {

	
	
	public static void main(String[] args) {
	
		Changes c = (x,y)->{
			
			return x.concat(y);
		};
		System.out.println(c.Data("ram", "raj"));
		
	}
	


}
