package com.lilei.card.service;


import org.springframework.core.io.Resource;

public interface FileService {
    public Resource loadFileAsResource(String fileName);
}
