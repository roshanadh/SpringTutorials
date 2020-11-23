package np.com.roshanadhikary.ioc;

import org.springframework.context.annotation.*;

// specify the below class is a configuration class
@Configuration
// specify the source of properties file
@PropertySource("classpath:sports.properties")
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
		return new FootballCoach();
	}

	@Bean
	public Coach cricketCoach() {
		return new CricketCoach();
	}
}
