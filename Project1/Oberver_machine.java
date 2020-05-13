package Project;
import java.util.ArrayList;
/**
 * @author Rohullah Khorami & William Wahlberg
 * <h> Observer_machine</h> 
 * <p> observer_machine is a observer patern that 
 * updates all lists containing current furniture in the room</p>
 */
public class Oberver_machine {
	 ArrayList<Obeserver> mylist;
	 ArrayList<Labelpos> label_list;
	
	public Oberver_machine() {
		mylist = new ArrayList<>();
		label_list = new ArrayList<>();
	}
	/**
	 * <p>inserts a furniture and calls update
	 * @param Labelpos ins is the new furniture to be added </p>
	 */
	public void add_to_labellist(Labelpos ins) {
		label_list.add(ins);
		for(int i = 0; i< label_list.size() ; i++) {
			label_list.get(i).setId(i);
		}
		update();
	}
	public ArrayList<Labelpos> get_label_list() {
		return label_list;
	}
	public void attach(Obeserver input) {
		mylist.add(input);
	}
	/** 
	 * <h>Update() 
	 * <p>updates all classes that impliments observer
	 */
	public void update() {
		for(Obeserver temp : mylist) {
			temp.update(label_list);
		}
	}
	/**
	 * <h3>Remove_id</h3>
	 *  <p>Remove_id removes a furniture from labellist</p>
	 *  @param r
	 */
	
	public void Remove_id(int r) {
		
		label_list.remove(r);
		for(int i = 0; i< label_list.size() ; i++) {
			label_list.get(i).setId(i);
		}
		update();
	}
	
	public void set_new_list(ArrayList<Labelpos> list) {
		label_list = list;		
		update();
	}
	
}