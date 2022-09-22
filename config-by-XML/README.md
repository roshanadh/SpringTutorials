# Spring Configuration using XML

When using an XML file for configuring a Spring application, we create a `.xml` file inside `/src/` directory.<br>

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

<!-- bean definitions here -->

</beans>
```

## Bean Definitions
To define a bean, we need to provide an `id` and a `class` attribute to the `<bean>` tag.<br>
The `id` attribute will be used to identify the bean and the `class` attribute requires the fully-qualfied class name of the bean.<br>
For example,
```xml
<bean
  id="footballCoach"
  class="np.com.roshanadhikary.ioc.FootballCoach" />
```

## Dependency Injection
### Constructors
For constructor-based injection, we can use the `<constructor-arg>` tag inside the bean definition, such as:
```xml
<bean id="happyFortune" class="np.com.roshanadhikary.ioc.HappyFortune" />
<bean
  id="footballCoach"
  class="np.com.roshanadhikary.ioc.FootballCoach">
  <constructor-arg ref="happyFortune" />
</bean>
```
This way, during the runtime, Spring IOC container injects the bean with `id` *happyFortune* into the corresponding constructor of *footballCoach* bean.<br>
For example, the constructor may look like:
```java
public FootballCoach(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
}
```

### Setters
For setter-based injection, we can use the `<property>` tag inside the bean definition, such as:
```xml
<bean id="happyFortune" class="np.com.roshanadhikary.ioc.HappyFortune" />
<bean
  id="footballCoach"
  class="np.com.roshanadhikary.ioc.FootballCoach">
  <property name="fortuneService" ref="happyFortune" />
</bean>
```
This way, during the runtime, Spring IOC container injects the bean with `id` *happyFortune* into the corresponding setter for the property named *fortuneService* of *footballCoach* bean.<br>
For example, the setter may look like:
```java
public void setFortuneService(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
}
```
