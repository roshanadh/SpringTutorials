package np.com.roshanadhikary.ioc;

import org.springframework.context.support.*;

public class BeanLifeCycleDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycleApplicationContext.xml");

		// Singleton scoped beans
		FootballCoach coach = context.getBean("footballCoach", FootballCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		// Prototype scoped beans
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		context.close();
	}
}
