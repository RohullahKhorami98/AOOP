
/**
 * 
 * @author Rohullah khorami & William Wahlberg
 * 
 * <h1> Information</h1>
 * <p1> This class gives information about furniture and also contians instruction for working on room.</p1>
 *
 */
public class Information {
	public String [] info = new String[7];
	public Information() {
		String information = "To select a Furniture from shoping list or in order to move a furniture\n "
				+ "Just left click on it & to delet it right click on it\n "
				+ "inputs for shape and color can not be nagative or zero, Height of the furniture can not \n"
				+ "be bigger than 250 and less 200. Width can not be bigger than 200, and less than 1."
				+ "Keep in mind that you can not inser furniture infront of door and windows ";
		info[0] = information;
	}
}
