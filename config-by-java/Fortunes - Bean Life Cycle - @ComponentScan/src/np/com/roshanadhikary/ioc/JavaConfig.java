package np.com.roshanadhikary.ioc;

import org.springframework.context.annotation.*;

// specify the below class is a configuration class
@Configuration
// specify the path/base package to search for components [instead of specifying in the .xml file]
@ComponentScan("np.com.roshanadhikary.ioc")
public class JavaConfig {
}
