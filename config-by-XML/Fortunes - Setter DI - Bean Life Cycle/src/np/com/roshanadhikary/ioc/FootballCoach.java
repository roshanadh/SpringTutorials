package np.com.roshanadhikary.ioc;

public class FootballCoach implements Coach {

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
