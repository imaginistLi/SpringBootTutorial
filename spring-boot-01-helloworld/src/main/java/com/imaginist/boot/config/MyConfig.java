package com.imaginist.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.imaginist.boot.bean.Car;
import com.imaginist.boot.bean.Pet;
import com.imaginist.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1. @Bean 方法注册的组件默认是单实例的
 * 2. MyConfig类本身也是一个组件
 * 3. proxyBeanMethods:代理bean方法,true的情况下，无论调用多少遍内部函数user01，获取的都是代理对象（单例的）
 *      Full(proxyBeanMethods = true) 组件依赖
 *      Lite(proxyBeanMethods = false)
 *      没有组件依赖的情况，采用false，Lite模式，速度快；反之采用Full模式
 */
// @ConditionalOnBean(name = "tom") // 条件装配：当容器中存在的tom组件时，才往容器中注入以下的组件
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  // 告诉SpringBoot这是一个配置类
@ImportResource("classpath:beans.xml")  // 加载Spring配置文件中的组件
@EnableConfigurationProperties(Car.class)  // 自动配置方式二：@EnableConfigurationProperties + @ConfigurationProperties
// 1. 开启Car的自动配置功能
// 2. 把Car这个组件自动注册到容器中
public class MyConfig {

    // @ConditionalOnBean(name = "tom")  // 条件装配：当容器中存在的tom组件时，才往容器中注入以下的组件
    @Bean  // 给容器中添加组件，以方法名作为组件的ID
    public User user01(){
        User user = new User("zhangsan", 18);
        user.setTomcat(tomcat());
        return user;
    }

    @Bean("tom")  // 自定义名字
    public Pet tomcat(){
        return new Pet("tomcat", 10.0);
    }
}
