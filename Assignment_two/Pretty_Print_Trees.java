package Visitorbase;

public class Pretty_Print_Trees<T> implements TreeVisitor<T, String> {

	boolean firstTime = true;
	int count = 1;

	@Override
	public String visit(Tree<T> t, String initialResult) {
		// VISIT TREE - START
		return t.accept(this, initialResult);
	}

	@Override
	public String visit(Leaf<T> l, String initialResult) {
		// VISIT LEAF

		initialResult = initialResult + "\n \t" + l.getValue();
		return initialResult;
	}

	@Override
	public String visit(Node<T> n, String initialResult) {
		// VISIT NODE
		if (firstTime) {
			firstTime = false;
		} else {
			initialResult = initialResult + " \n NODE " + count++ + ":";
		}
		for (Tree<T> child : n.getChildren()) {
			initialResult = child.accept(this, initialResult);
		}
		return initialResult;
	}

}
