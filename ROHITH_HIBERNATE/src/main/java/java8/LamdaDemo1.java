package java8;

interface message {

	public void msg();
}

public class LamdaDemo1 {

	// lamda function can be create inside function
	public static void main(String[] args) {

		message m = () -> {

			System.out.println("message method called..");
		};
		m.msg();
		
	}
}
