package java8.stream;

import java.util.ArrayList;
import java.util.List;

public class SortStream {

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
		
		//names.stream().sorted().forEach(x->System.out.println(x));
		//names.stream().filter(x->x.startsWith("a")).sorted().forEach(x->System.out.println(x));
		// if you don't want to modify original list and manuplate data  we can use map
		
		names.stream().map(x->x.toUpperCase()).forEach(x->System.out.println(x));
		
	}
}
