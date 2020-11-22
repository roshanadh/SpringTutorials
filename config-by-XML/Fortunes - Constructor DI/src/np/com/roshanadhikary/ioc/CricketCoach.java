package np.com.roshanadhikary.ioc;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	public CricketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice cricket for 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}
}
