package np.com.roshanadhikary.ioc;

public class SadFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is not such a lucky day!";
	}
}
