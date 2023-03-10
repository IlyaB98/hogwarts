package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class InfoServiceTest implements InfoService {
    @Value("${server.port.test}")
    private int serverPort;

    Logger logger = LoggerFactory.getLogger(InfoService.class);
    public int getPort() {
        logger.info("Was invoked method for get port (Test)");
        return serverPort;
    }

}
