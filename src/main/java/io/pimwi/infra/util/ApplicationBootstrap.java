package io.pimwi.infra.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ApplicationBootstrap {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationBootstrap.class);

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;

    @Inject
    DataGenerator dataGenerator;

    @PostConstruct
    public void bootstrap() {
        LOGGER.info("hibernate.hbm2ddl.auto = " + hbm2ddl);
        if (!"validate".equalsIgnoreCase(hbm2ddl) && !"update".equalsIgnoreCase(hbm2ddl) ) {
            dataGenerator.populateData();
        }
    }

}
