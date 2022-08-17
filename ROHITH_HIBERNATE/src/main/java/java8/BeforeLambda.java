package java8;

interface Call {
	public void calling();
	public int prints(int no);
}

public class BeforeLambda implements Call{

	
	public void calling() {
		
		System.out.println("calling...");
		
	}
	public static void main(String[] args) {
		Call c = new BeforeLambda();
		c.calling();
		System.out.println(c.prints(15));
	}
	@Override
	public int prints(int no) {
		// TODO Auto-generated method stub
		return no*no;
	}

}
