package in.sachinshinde.springrestdemo.model;

public class Movie {
	int id;
	String name;
	String genres;
	int budget;
	float imdbRating;

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

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genres=" + genres + ", budget=" + budget + ", imdbRating="
				+ imdbRating + "]";
	}

}
