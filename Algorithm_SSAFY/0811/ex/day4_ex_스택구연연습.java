public class day4_ex_���ñ������� {

	public static int s[] = new int [10];
	public static int top = -1;

	public static void main(String[] args) 
	{

		s[++top] = 1;
		s[++top] = 2;
		s[++top] = 3;
		System.out.println(s[top--]);
		System.out.println(s[top--]);
		System.out.println(s[top--]);
		
	}
}
