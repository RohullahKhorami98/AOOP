public class Labelpos {
	private Furniture label;
	
	private int x;
	private int y;
	
	public Labelpos() {
		
	}
	
	public Labelpos(Furniture label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public Furniture getLabel() {
		return label;
	}

	public void setLabel(Furniture label) {
		this.label = label;
	}

	public int getX() {
		return label.getX();
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return label.getY();
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
	
}
