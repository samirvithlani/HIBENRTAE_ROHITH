package java8.stream;

import java.util.ArrayList;
import java.util.List;

public class FindFirstDemo {


	public static void main(String[] args) {

			List<String> names = new ArrayList<String>();
			names.add("raj");
			names.add("parth");
			names.add("neha");
			names.add("jaya");
			names.add("amit");
			names.add("ajay");
			names.add("akansh");
			names.add("ram");
		
			//names.stream().filter(x->x.startsWith("a")).forEach(x->System.out.println(x));
			String fm = names.stream().filter(x->x.startsWith("a")).findFirst().get();
			System.out.println(fm);
	}
}
