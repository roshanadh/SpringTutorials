package np.com.roshanadhikary.ioc;

public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}
}
