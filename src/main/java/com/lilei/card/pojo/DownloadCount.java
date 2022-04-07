package com.lilei.card.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class DownloadCount implements Serializable {
    private Integer downloadCount;
}
