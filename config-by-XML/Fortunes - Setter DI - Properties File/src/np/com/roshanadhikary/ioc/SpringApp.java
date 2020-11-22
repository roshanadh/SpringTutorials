package np.com.roshanadhikary.ioc;

import org.springframework.context.support.*;

public class SpringApp {

	public static void main(String[] args) {
		// load the Spring configuration file: bring up the Spring Context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from the Spring Container
		// args ( beanID, type of bean required)
		Coach coach = context.getBean("footballCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		// Type casting since Coach type does not have getTeam method, just the CricketCoach does
		System.out.println(((CricketCoach) cricketCoach).getTeam());

		// close the context
		context.close();
	}
}
