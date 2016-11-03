Spring的核心功能包括下面几个模块：
spring-core
spring-beans
spring-context
spring-context-support
spring-expression

其中spring-core和spring-beans提供了框架的最基本的能力，包括控制反转和依赖注入

spring-context模块依赖spring-core和spring-beans模块。继承了BeanFactory，添加了事件处理，国际化，资源装载，数据校验等功能。提供了多种Bean的访问方式。例如实现了ApplicationContext接口的多个类。

spring-context-support模块

