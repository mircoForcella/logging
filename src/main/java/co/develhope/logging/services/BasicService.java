package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BasicService {
    @Autowired
    Environment environment;

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicService.class);

    public int calculateExponent() {
        int n1 =  Integer.parseInt(environment.getProperty("customEnvs.n1"));
        int n2 =  Integer.parseInt(environment.getProperty("customEnvs.n2"));
        LOGGER.info("Starting calculation");
        int result = (int) Math.pow(n1,n2);
        LOGGER.info("Finished calculation");
        return result;
    }
}