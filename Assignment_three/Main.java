public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Tree<String> t = new Tree<String>("top", new Tree[] { new Tree<String>("sub1"), new Tree<String>("sub2"),
				new Tree<String>("sub3"), new Tree<String>("sub4.5"), new Tree<String>("sub") });
		Saver s = new Saver();
		String r = s.save(t);
		System.out.println(r);
	}
}
