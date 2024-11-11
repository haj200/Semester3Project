package dao;

import java.util.List;

import beans.Feedback;

public interface FeedbackDao {

	
		void createFeedback(Feedback f);
		List<Feedback> feedbacks();
		void updateFeedback(Feedback f);
		void deleteFeedback(int id);
	}

