package np.com.roshanadhikary.ioc;

import org.springframework.context.support.*;

public class BeanLifeCycleDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycleApplicationContext.xml");

		FootballCoach coach = context.getBean("footballCoach", FootballCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		context.close();
	}
}
