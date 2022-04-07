package com.lilei.card.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


//在 springboot 应用启动时将 file 为前缀的属性与 pojo 类绑定，
// 也就是将 application.yml 中的 file.doc-dir 与 FileProperties 中的字段 docDir 做了绑定
@ConfigurationProperties(prefix = "file")
@Data
public class FileProperties {
    private String docDir;
}
