package com.lilei.card.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.lilei.card.mapper.DownCountMapper;
import com.lilei.card.pojo.DownloadCount;
import com.lilei.card.service.DownCountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DownCountServiceImpl implements DownCountService {
    @Resource
    private DownCountMapper downCountMapper;
    @Override
    public Integer GetDownCount() {
        DownloadCount downloadCount = new DownloadCount();
        QueryWrapper<DownloadCount> queryWrapper = new QueryWrapper<>();
        downloadCount = downCountMapper.selectOne(queryWrapper);
        if (downloadCount !=null&& !ObjectUtils.isEmpty(downloadCount)){
            return downloadCount.getDownloadCount();
        }else {
            return -1;
        }

    }

    public void UpDownCount() {
        DownloadCount downloadCount = new DownloadCount();
        int count = GetDownCount();
        downloadCount.setDownloadCount(count);
        UpdateWrapper<DownloadCount> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("download_count",count+1);
        downCountMapper.update(null,updateWrapper);
    }
}
