package com.imaginist.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才能使用SpringBoot提供的强大功能
 */
//@Component // 自动配置方式一：@Component + @ConfigurationProperties

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
