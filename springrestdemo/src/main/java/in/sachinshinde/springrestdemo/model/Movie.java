package in.sachinshinde.springrestdemo.model;

public class Movie {
	int id;
	String name;
	String genres;
	int budget;
	double imdbRating;

	public Movie() {
		super();
	}

	public Movie(int id, String name, String genres, int budget, double imdbRating) {
		super();
		this.id = id;
		this.name = name;
		this.genres = genres;
		this.budget = budget;
		this.imdbRating = imdbRating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double d) {
		this.imdbRating = d;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genres=" + genres + ", budget=" + budget + ", imdbRating="
				+ imdbRating + "]";
	}

}
