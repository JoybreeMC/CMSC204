
public class HashingLab {
		public static void main(String args[]) {
			int pk = 26;
			int n = 13;
			int i = pk % n;
			int q = pk/n;
			int o;
			if(q%n != 0) {
				o = q;
			}else {
				o = 19;
			}
			while(i ==1|| i ==5||i == 0||i == 10|| i == 8||i==3||i==6||i ==11) {
				System.out.print("A");
				i= (i + o) % n;
			}
			System.out.print(i);
		}
	

}
