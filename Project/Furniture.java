
public class Furniture {

	String pathToImage;
	String info;

	
	public Furniture(String f) {
		pathToImage = f + ".png";
		info = f;
	}
	
	
	public String getPath() {
		return pathToImage;
	}
	
	public String getInfo() {
		return info;
	}
}
