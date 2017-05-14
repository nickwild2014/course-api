package com.java.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	List<TopicBean> topics = new ArrayList<> (Arrays.asList(new TopicBean("java", "subhash", "java developer"),
			new TopicBean("j2EE", "subhash", "java developer")));

	public List<TopicBean> getAllTopics() {
        logger.info("get all topic called");
        logger.warn("get all topic called");
        logger.error("get all topic called");
		return topics;
	}

	public TopicBean getTopic(String id) {
		return topics.stream().filter(e -> e.getId().equals(id)).findFirst().get();
	}

	public void addTopic(TopicBean topic) {
		topics.add(topic);
	}

	public void updateTopic(TopicBean topic, String id) {
		for(int i=0;i<topics.size(); i++ )
		{
			TopicBean t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	} 

}
