package com.pablopb3.tiempoemojis.weather.infrastructure.io.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

@Service
public class TemplateReader {

    public String readTemplate() throws Exception {
        return IOUtils.toString(this.getClass().getResourceAsStream("/templates/spain_city_map_template.txt"), "UTF-8");
    }
}
