package np.com.roshanadhikary.ioc;

import org.springframework.beans.factory.annotation.*;

import javax.annotation.*;

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

	@PostConstruct
	// Custom bean init method: can have any name
	public void initialize() {
		System.out.println("Initializing footballCoach bean...");
	}

	@PreDestroy
	// @PreDestroy does not work with PROTOTYPE-scoped beans because such beans are ...
	// ... not completely managed by the IOC container
	// Custom bean destroy method: can have any name
	public void cleanup() {
		System.out.println("Destroying footballCoach bean...");
	}
}
