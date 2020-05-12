import java.util.ArrayList;

public class Oberver_machine {
	 ArrayList<Obeserver> mylist;
	 ArrayList<Labelpos> label_list;
	
	public Oberver_machine() {
		mylist = new ArrayList<>();
		label_list = new ArrayList<>();
	}
	
	public void set_label_list(Labelpos temp) {
		label_list.add(temp);
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
	public void update() {
		for(Obeserver temp : mylist) {
			temp.update(label_list);
		}
	}
	
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