package np.com.roshanadhikary.ioc;

import org.springframework.context.annotation.*;

public class SpringApp {

	public static void main(String[] args) {
		// Since we have no XML file, bring up the Spring Context using the Configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		Coach footballCoach = context.getBean("footballCoach", FootballCoach.class);
		Coach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);

		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());

		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());

		context.close();
	}
}
