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
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((actors == null) ? 0 : actors.hashCode());
	result = prime * result + ((gen == null) ? 0 : gen.hashCode());
	result = prime * result + ((mainPlot == null) ? 0 : mainPlot.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	result = prime * result + year;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Item other = (Item) obj;
	if (actors == null) {
		if (other.actors != null)
			return false;
	} else if (!actors.equals(other.actors))
		return false;
	if (gen == null) {
		if (other.gen != null)
			return false;
	} else if (!gen.equals(other.gen))
		return false;
	if (mainPlot == null) {
		if (other.mainPlot != null)
			return false;
	} else if (!mainPlot.equals(other.mainPlot))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	if (year != other.year)
		return false;
	return true;
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
