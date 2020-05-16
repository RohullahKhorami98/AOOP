package Project1;
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
				+ "be bigger than 250 and less 1. Width can not be bigger than 200, and less than 1. ";
		info[0] = information;
		String chair = "The chair has different shapes and different colors";
		info[1] = chair;
		String bed = "The bed has different shapes and different colors";
		info[2] = bed;
		String soffa = "The soffa has different shapes and different colors";
		info[3] = chair;
		String light = "The light has different shapes and different colors";
		info[4] = chair;
		String tv = "The tv has different shapes and different colors";
		info[5] = chair;
		String wardrobe = "The wardrobe has different shapes and different colors";
		info[6] = wardrobe;
		
	}
}
