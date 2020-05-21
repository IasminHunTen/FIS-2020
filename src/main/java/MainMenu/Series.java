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
	
	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((seasons == null) ? 0 : seasons.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		if (seasons == null) {
			if (other.seasons != null)
				return false;
		} else if (!seasons.equals(other.seasons))
			return false;
		return true;
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
