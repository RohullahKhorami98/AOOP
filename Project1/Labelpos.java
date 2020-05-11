
public class Labelpos {

	private int x;
	private int y;
	private int height;
	private int width;
	private int c ; 
	private int shape;
	private String name;
	private int id; 
	
	public Labelpos(int x, int y, int height, int width , int c, int shape , String name , int id ) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.c = c;
		this.shape = shape;
		this.name = name;
		this.id = id;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getShape() {
		return shape;
	}


	public void setShape(int shape) {
		this.shape = shape;
	}


	public int getC() {
		return c;
	}


	public void setC(int c) {
		this.c = c;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
