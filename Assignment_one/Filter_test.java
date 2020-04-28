
public class Filter_test {
	public static void main(String [] args) {
		String [] c = {"Tjo", "Puf" , "puff" , "krille" ,"56"};
		
		Filter f = new mega_filter();
		
		String [] test_filter = f.filter(c,f);
		f.filtering(test_filter);
	}
}
