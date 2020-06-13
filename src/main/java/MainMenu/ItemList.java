package MainMenu;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;


public class ItemList {
   private ArrayList<Item> items = new ArrayList<Item>();

public ItemList() {
	super();
}

public ItemList(ArrayList<Item> items) {
	this.items = items;
}

public ArrayList<Item> getItems() {
	return items;
}

public void setItems(ArrayList<Item> items) {
	this.items = items;
}  

public void addItem (Item it) {
   if(!items.contains(it))	
	   items.add(it);
}

public void removeItem (Item it) {
	if(items.contains(it))
		items.remove(it);
}

}
