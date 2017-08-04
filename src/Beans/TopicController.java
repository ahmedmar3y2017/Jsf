package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Topics;

@ManagedBean(name="topics")
@SessionScoped
public class TopicController {
	
	List<Topics> topics=null;
	
	Topics selectedTopics;
	
	@PostConstruct
	public void init() {
		topics=new ArrayList<>();
		topics.add(new Topics("java", "java", "java"));
		topics.add(new Topics("c++", "c++", "c++"));
		topics.add(new Topics("php", "php", "php"));
		selectedTopics=new Topics();
		
	}

	public void select(Topics topics) {
this.selectedTopics=topics;	
	}
	public void delete() {
topics.remove(selectedTopics);
	}
	
	public void update() {
this.selectedTopics=new Topics();
	}
	
	
	
	
	public Topics getSelectedTopics() {
		return selectedTopics;
	}




	public void setSelectedTopics(Topics selectedTopics) {
		this.selectedTopics = selectedTopics;
	}




	
	public List<Topics> getTopics() {
		return topics;
	}

	public void setTopics(List<Topics> topics) {
		this.topics = topics;
	}
	

}
