package alkemy.challenge.Challenge.Alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alkemy.challenge.Challenge.Alkemy.model.ActivityModel;
import alkemy.challenge.Challenge.Alkemy.repository.ActivityRepository;

@Service
public class ActivityServiceImplements implements IActivityService{

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<ActivityModel> listAll() {
		return (List<ActivityModel>) activityRepository.findAll();
	}

	@Override
	public void save(ActivityModel activityModel) {
		activityRepository.save(activityModel);

	}

	@Override
	public ActivityModel searchId(Long id) {
		return activityRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		activityRepository.deleteById(id);

	}

}
