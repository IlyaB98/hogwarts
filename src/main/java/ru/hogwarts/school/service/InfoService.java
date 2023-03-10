package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Value("${server.port}")
    private int serverPort;

    private static final Logger logger = LoggerFactory.getLogger(InfoService.class);
    public int getPort() {
        logger.info("Was invoked method for get port");
        return serverPort;
    }
}
