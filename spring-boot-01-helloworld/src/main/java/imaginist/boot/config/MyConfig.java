package imaginist.boot.config;

import imaginist.boot.bean.Pet;
import imaginist.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1. @Bean 方法注册的组件默认是单实例的
 * 2. MyConfig类本身也是一个组件
 * 3. proxyBeanMethods:代理bean方法,true的情况下，无论调用多少遍内部函数user01，获取的都是代理对象（单例的）
 *      Full(proxyBeanMethods = true) 组件依赖
 *      Lite(proxyBeanMethods = false)
 *      没有组件依赖的情况，采用false，Lite模式，速度快；反之采用Full模式
 */
@Configuration(proxyBeanMethods = true)  // 告诉SpringBoot这是一个配置类
public class MyConfig {

    @Bean  // 给容器中添加组件，以方法名作为组件的ID
    public User user01(){
        User user = new User("zhangsan", 18);
        user.setTomcat(tomcat());
        return user;
    }

    @Bean("tom")  // 自定义名字
    public Pet tomcat(){
        return new Pet("tomcat");
    }
}
