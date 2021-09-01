package com.imaginist.boot;

import ch.qos.logback.core.db.DBHelper;
import com.imaginist.boot.bean.Pet;
import com.imaginist.boot.config.MyConfig;
import com.imaginist.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {

        // 1. Spring 应用启动
        ConfigurableApplicationContext run = SpringApplication.run(HelloWorldMainApplication.class, args);

        // 2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 3. 从容器中获取组件
        Pet tomcat01 = run.getBean("tom", Pet.class);
        Pet tomcat02 = run.getBean("tom", Pet.class);
        System.out.println(tomcat01 == tomcat02);

        MyConfig myConfig = run.getBean(MyConfig.class);
        System.out.println(myConfig);
        User user01 = myConfig.user01();
        User user02 = myConfig.user01();
        System.out.println(user01 == user02);

        // 4. 组件依赖
        User user = run.getBean("user01", User.class);
        Pet tomcat = run.getBean("tom", Pet.class);
        System.out.println(user.getTomcat() == tomcat); // true (proxyBeanMethods = true) 组件依赖

        // 5. @Import获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        System.out.println(run.getBean(DBHelper.class));

        // 6. @ImportResource方法测试
        System.out.println(run.getBean("haha"));
        System.out.println(run.getBean("hehe"));

        System.out.println(run.getBeanDefinitionCount());
    }
}
