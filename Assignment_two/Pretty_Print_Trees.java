package Visitorbase;

public class Pretty_Print_Trees<T> implements TreeVisitor<T, String> {

	boolean firstTime = true;
	int depth;
	@Override
	public String visit(Tree<T> t, String initialResult) {
		// VISIT TREE - START
		depth = 0;
		return t.accept(this, initialResult);
	}

	@Override
	public String visit(Leaf<T> l, String initialResult) {
		// VISIT LEAF
		initialResult = initialResult + "\n";
		initialResult = initialResult + "\t" + l.getValue();
		return initialResult;
	}

	@Override
	public String visit(Node<T> n, String initialResult) {
		// VISIT NODE
		if (firstTime) {
			firstTime = false;
			depth--;
		} else {
			initialResult = initialResult + " \n";
			System.out.println(depth);
			for (int i = 0; i<depth;i++) {
				initialResult = initialResult + "\t";
			}
			initialResult = initialResult + "NODE:";
		}
		depth++;
		for (Tree<T> child : n.getChildren()) {
			initialResult = child.accept(this, initialResult);
		}
		depth--;
		return initialResult;
	}
}
