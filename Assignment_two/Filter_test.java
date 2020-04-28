package Filter_abstract;


public class Filter_test extends Filter{

	public static void main( String [] arg){
	String[] Test_arr = {"hello", "hej", "hi", "boo","Rohullah"};
	Filter_test f = new Filter_test();
	String[] filtering = filter(Test_arr, f);
	
	for(int i = 0; i < filtering.length; i++) {
		System.out.println(filtering[i]);
		}
	}
	
	
	
	@Override
	boolean accept(String x) {
		if(x.length() <= 3) {
			return true;
		}
		return false;
		
	}
}

