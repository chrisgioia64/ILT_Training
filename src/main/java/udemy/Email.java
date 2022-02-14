package udemy;

public class Email {
	
	private int a;
	
	public void generate(String s) {
		System.out.println("generating email");
	}
	
	public static void main(String[] args) {
		Email em = new Email();
		em.generate("chris");
		
		int size = 10;
		int[] arr = new int[size];
		System.out.println(arr.length);
//		while (true) {
//			int[] i = new int[size];
//			System.out.println(i.length);
//			size = size * 2;
//		}
		
		int a = 1;
		for (int b = 0; b < 1; b++) {
			a = 5;
			System.out.println(a);
		}
		System.out.println(a);
	}

}
