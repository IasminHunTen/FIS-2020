package MainMenu;

import java.util.ArrayList;

public class Movie extends Item {

	public Movie() {
		super();
	}

	public Movie(String title, String gen, int year, String mainPlot, ArrayList<String> actors) {
		super(title, gen, year, mainPlot, actors);
		
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", gen=" + gen + ", year=" + year + ", mainPlot=" + mainPlot + ", actors="
				+ actors + "]";
	}  
}
