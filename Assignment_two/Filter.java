package Filter_abstract;

public abstract class Filter{
			
		abstract boolean accept(String x);
		
		public static String[] filter(String[] a, Filter f) {
			String [] b = new String[a.length];
			for(int i = 0; i<a.length; i++) {
				if(f.accept(a[i])) {
					b[i] = a[i];
				}
			}
			return b;
		}
		
		
	

	
}
