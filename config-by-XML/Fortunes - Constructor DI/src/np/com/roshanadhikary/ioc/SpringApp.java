package np.com.roshanadhikary.ioc;

import org.springframework.context.support.*;

public class SpringApp {

	public static void main(String[] args) {
		// load the Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from the Spring Container
		// args ( beanID, type of bean)
		Coach coach = context.getBean("footballCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		// close the context
		context.close();
	}
}
