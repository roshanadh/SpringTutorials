package np.com.roshanadhikary.ioc;

import org.springframework.stereotype.*;

@Component
public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}
}
