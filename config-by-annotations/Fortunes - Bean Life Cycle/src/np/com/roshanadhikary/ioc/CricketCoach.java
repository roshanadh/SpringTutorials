package np.com.roshanadhikary.ioc;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.*;

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

	@PostConstruct
	// Custom bean init method: can have any name
	public void initialize() {
		System.out.println("Initializing cricketCoach bean...");
	}

	@PreDestroy
	// Custom bean destroy method: can have any name
	public void cleanup() {
		System.out.println("Destroying cricketCoach bean...");
	}
}
