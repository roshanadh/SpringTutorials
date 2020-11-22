package np.com.roshanadhikary.ioc;

import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach {

	@Autowired
	@Qualifier("happyFortune")
	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run for 20 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// Custom bean init method: can have any name
	public void initialize() {
		System.out.println("Initializing beans...");
	}

	// Custom bean destroy method: can have any name
	public void cleanup() {
		System.out.println("Destroying beans...");
	}
}
