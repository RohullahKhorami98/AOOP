
public interface Filter {
	boolean accept(String x);

	String[] filter(String[] a, Filter f);

	void filtering(String[] test);
}

class mega_filter implements Filter {

	@Override
	public boolean accept(String x) {

		if (x.length() <= 3) {
			return true;
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] filter(String[] a, Filter f) {
		String[] b = new String[a.length];
		
		for (int i = 0; i < a.length; i++) {
			if (f.accept(a[i])) {
				b[i] = a[i];
			}
		}

		return b;
	}

	@Override
	public void filtering(String[] test) {
		for (int i = 0; i < test.length; i++) {
			if (test[i] != null) {
				System.out.println(test[i]);
			}
		}
	}

}