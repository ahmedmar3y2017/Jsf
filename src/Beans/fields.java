package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class fields {

	private List<String> positions;
	private List<Experience> experiences = null;

	@PostConstruct
	public void init() {
		positions = new ArrayList<>();
		positions.add("backecnd developer");
		positions.add("froneecnd developer");
		positions.add("Fullstack developer");
		experiences = new ArrayList<Experience>();
		experiences.add(new Experience("", ""));
	}

	public String save() {

		return "result.xhtml?faces-redirect=true";
	}

	public void remove(Experience experience) {
		experiences.remove(experience);

	}

	public void add() {
		experiences.add(new Experience("", ""));
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<String> getPositions() {
		return positions;
	}

	public void setPositions(List<String> positions) {
		this.positions = positions;
	}

}
