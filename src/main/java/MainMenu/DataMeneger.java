package MainMenu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DataMeneger {
   private ObjectMapper omap;
   
   public DataMeneger() {
	super();
	this.omap=new ObjectMapper();
    
}

public void writeItems(ItemList list) {
	 try {
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("database.json"), list);
	} catch (JsonGenerationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   }

 public ItemList readItems() {
	 ItemList il = null;
	 File f=new File("database.json");
	 if(!f.exists() || f.length()==0)
		 il=new ItemList();
	 else {
	  try {
	  il= omap.readerFor(ItemList.class).readValue(new File("database.json"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
	 return il;
}
 

 
}
