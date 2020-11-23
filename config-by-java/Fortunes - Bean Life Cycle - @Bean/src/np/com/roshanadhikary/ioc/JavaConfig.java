package np.com.roshanadhikary.ioc;

import org.springframework.context.annotation.*;

// specify the below class is a configuration class
@Configuration
public class JavaConfig {

	@Bean
	public FortuneService happyFortune() {
		return new HappyFortune();
	}

	@Bean
	public FortuneService sadFortune() {
		return new SadFortune();
	}

	@Bean
	public Coach footballCoach() {
		FootballCoach footballCoach = new FootballCoach();
		return footballCoach;
	}

	@Bean
	public Coach cricketCoach() {
		CricketCoach cricketCoach = new CricketCoach();
		cricketCoach.setFortuneService(
				sadFortune()
		);
		return cricketCoach;
	}
}
