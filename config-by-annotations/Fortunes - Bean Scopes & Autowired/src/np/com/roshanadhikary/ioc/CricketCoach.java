package np.com.roshanadhikary.ioc;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class CricketCoach implements Coach {

	@Autowired
	@Qualifier("sadFortune")
	private FortuneService fortuneService;
	private String team;

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice cricket for 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
