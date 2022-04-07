package com.lilei.card.service;

public interface DownCountService {
    /**
     * 查询下载次数
     * @return
     */
    public Integer GetDownCount();

    /**
     * 更新下载次数
     * 每调用一次接口，则调用一次此方法，使次数加一
     */
    public void UpDownCount();
}
