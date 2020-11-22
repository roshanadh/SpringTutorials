package np.com.roshanadhikary.ioc;

import org.springframework.context.support.*;

public class BeanLifeCycleDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycleApplicationContext.xml");

		// Prototype-scoped bean
		FootballCoach coach = context.getBean("footballCoach", FootballCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		// Singleton-scoped bean
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		context.close();
	}
}
