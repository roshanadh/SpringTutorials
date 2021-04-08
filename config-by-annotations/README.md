# Spring Configuration using Annotations

Spring Configuration using Annotation relies on classes annotated with `@Component` and a component-scan path.<br>
We still need to create an XML configuration file, but we can skip the bean definitions.

## XML Schema
We populate the XML file (can be named anything, we use `applicationContext.xml` for convenience) with the following:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

  <context:component-scan base-package="np.com.roshanadhikary.ioc" />

</beans>
```

With the `<context:component-scan>` tag and its `base-package` attribute, we specify the base package inside which Spring's runtime will scan for classes annotated with `@Component`.<br>
These components are then used as bean definitions by the Spring container.

## Bean Definitions
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
## Depenendency Injection
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
