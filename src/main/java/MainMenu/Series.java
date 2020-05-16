package MainMenu;

import java.util.ArrayList;

public class Series extends Item {
     private ArrayList<Integer> seasons=new ArrayList<Integer>();

	public Series() {
		super();
	}

	public Series(String title, String gen, int year, String mainPlot, ArrayList<String> actors,ArrayList<Integer> seasons) {
		super(title, gen, year, mainPlot, actors);
		this.seasons=seasons;
	}
    
	public String toString() {
		return "Series [seasons=" + seasons + ", title=" + title + ", gen=" + gen + ", year=" + year + ", mainPlot="
				+ mainPlot + ", actors=" + actors + "]";
	}

	public ArrayList<Integer> getSeasons() {
		return seasons;
	}

	public void setSeasons(ArrayList<Integer> seasons) {
		this.seasons = seasons;
	}
	
	
	
	
     
}
