package MainMenu;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = Movie.class, name = "movie"), 
		  @Type(value = Series.class, name = "series") 
		})

public abstract class Item {
  protected String title;
  protected String gen;
  protected int year;
  protected String mainPlot;
  protected ArrayList<String> actors=new ArrayList<String>();
public Item() {
	super();
	
}
public Item(String title, String gen, int year, String mainPlot, ArrayList<String> actors) {
	super();
	this.title = title;
	this.gen = gen;
	this.year = year;
	this.mainPlot = mainPlot;
	this.actors = actors;
}



@Override
public String toString() {
	return "Item [title=" + title + ", gen=" + gen + ", year=" + year + ", mainPlot=" + mainPlot + ", actors=" + actors
			+ "]";
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getGen() {
	return gen;
}
public void setGen(String gen) {
	this.gen = gen;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getMainPlot() {
	return mainPlot;
}
public void setMainPlot(String mainPlot) {
	this.mainPlot = mainPlot;
}
public ArrayList<String> getActors() {
	return actors;
}
public void setActors(ArrayList<String> actors) {
	this.actors = actors;
}


  
  
  
}
