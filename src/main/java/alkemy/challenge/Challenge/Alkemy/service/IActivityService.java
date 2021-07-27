package alkemy.challenge.Challenge.Alkemy.service;

import java.util.List;

import alkemy.challenge.Challenge.Alkemy.model.ActivityModel;

public interface IActivityService {

	public List<ActivityModel> listAll();

	public void save(ActivityModel activity);

	public ActivityModel searchId(Long id);

	public void delete(Long id);
	
}
