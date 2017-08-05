package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Topics;
import Service.topicService;

@ManagedBean(name = "topics")
@SessionScoped
public class TopicController {

	List<Topics> topics = null;

	Topics selectedTopics;
topicService topicService;
	@PostConstruct
	public void init() {
		topicService=new topicService();
		topics = topicService.getAll();

		selectedTopics = new Topics();

	}

	public void select(Topics topics) {
		this.selectedTopics = topics;
	}

	public void delete() {
		topics.remove(selectedTopics);
		topicService.delete(selectedTopics);
	}

	public void update() {
		topics.remove(this.selectedTopics);
		topics.add(selectedTopics);
//		this.selectedTopics = new Topics();
		System.out.println(selectedTopics.getId() + "   "+selectedTopics.getUsername());
		topicService.update(selectedTopics);
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
