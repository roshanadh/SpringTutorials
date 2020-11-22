package np.com.roshanadhikary.ioc;

import org.springframework.context.support.*;

public class BeanLifeCycleDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycleApplicationContext.xml");

		// Singleton scoped beans
		FootballCoach coach1 = context.getBean("footballCoach", FootballCoach.class);
		FootballCoach coach2 = context.getBean("footballCoach", FootballCoach.class);
		// should print same reference for both objects
		System.out.println(coach1);
		System.out.println(coach2);

		// Prototype scoped beans
		CricketCoach cricketCoach1 = context.getBean("cricketCoach", CricketCoach.class);
		CricketCoach cricketCoach2 = context.getBean("cricketCoach", CricketCoach.class);
		// should print different reference for each object
		System.out.println(cricketCoach1);
		System.out.println(cricketCoach2);

		context.close();
	}
}
