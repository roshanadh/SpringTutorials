# Spring Configuration using Java Classes
We need to create a Java class (for example, `JavaConfig`) that will serve as the configuration for the Spring container.

## Configuration with @ComponentScan
To specify the `JavaConfig` class as a Spring configuration, we need to annotate it with `@Configuration`.
```java
package np.com.roshanadhikary.ioc;

@Configuration
@ComponentScan("np.com.roshanadhikary.ioc")
public class JavaConfig {
}
```
With the `@ComponentScan` annotation and its argument, we specify the base package inside which Spring's runtime will scan for classes annotated with `@Component`.<br>
These components are then used as bean definitions by the Spring container.

### Bean Definitions
To define a bean from a class, we annotate the class with `@Component`.<br>
For example,
```java
package np.com.roshanadhikary.ioc;

@Component
public class FootballCoach {}
```

This is equivalent to the following XML configuration
```xml
<bean
  id="footballCoach"
  class="np.com.roshanadhikary.ioc.FootballCoach" />
```

Conventionally, Spring uses the *camelCase* form of a class name to identify a bean.<br>
If we need to override the default bean identifier, we can pass an argument to the `@Component` annotation:
```java
package np.com.roshanadhikary.ioc;

@Component("theCoach")
public class FootballCoach {}
```

This is equivalent to the following XML configuration
```xml
<bean
  id="theCoach"
  class="np.com.roshanadhikary.ioc.FootballCoach" />
```

## Configuration without @ComponentScan
Without the `@ComponentScan` annotation, we need to provide the bean definitions inside the Configuration class.
```java
package np.com.roshanadhikary.ioc;

@Configuration
public class JavaConfig {

	@Bean
	public FortuneService happyFortune() {
		return new HappyFortune();
	}

	@Bean
	public FortuneService sadFortune() {
		return new SadFortune();
	}

	@Bean
	public Coach footballCoach() {
		return new FootballCoach();
	}

	@Bean
	public Coach cricketCoach() {
		return new CricketCoach();
	}
}

```

With `@Bean` annotation, we define a bean where the method name (e.g., footballCoach) is used as the bean identifier.<br>
With this method of bean definition, we do not need to annotate classes with `@Component`.

## Dependency Injection
For dependency injection in a class, we can use the `@Autowired` annotation.<br>
If there are multiple candidate beans that can be injected, we need a `@Qualifier` annotation following `@Autowired` to instruct the Spring container on what bean to inject.

### Constructors
If we have two beans - happyFortune and sadFortune - we can use `@Qualifier` as following,
```java
@Autowired
@Qualifier("happyFortune")
public FootballCoach(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
}
```

In case we only have a single bean of type `FortuneService`, there's no need for `@Qualifier`.
```java
@Autowired
public FootballCoach(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
}
```

### Setters
The same principle applies to a setter-based dependency injection.<br>
If we have two beans - happyFortune and sadFortune - we can use `@Qualifier` as following,
```java
@Autowired
@Qualifier("happyFortune")
public void setFortuneService(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
}
```

In case we only have a single bean of type `FortuneService`, there's no need for `@Qualifier`.
```java
@Autowired
public void setFortuneService(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
}
```
