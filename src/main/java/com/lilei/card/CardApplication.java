package com.lilei.card;

import com.lilei.card.pojo.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//在启动类或其他配置类（@Configuration注解标记）上加入 @EnableConfigurationProperties 即可让 ConfigurationProperties 特性生效。
@EnableConfigurationProperties({FileProperties.class})
public class CardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardApplication.class, args);
    }

}
