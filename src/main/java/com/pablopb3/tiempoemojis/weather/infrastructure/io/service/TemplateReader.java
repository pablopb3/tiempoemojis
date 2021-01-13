package com.pablopb3.tiempoemojis.weather.infrastructure.io.service;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemplateReader {

    private static Logger log = LoggerFactory.getLogger(TemplateReader.class);

    private static final String spainMapPath = "/templates/spain_map_template.txt";
    private static final String galiciaMapPath = "/templates/galicia_map_template.txt";

    public String readSpainTemplate() {
        return readTemplate(spainMapPath);
    }

    public String readGaliciaTemplate() {
        return readTemplate(galiciaMapPath);
    }

    private String readTemplate(String path) {
        String template = null;
        try {
            template = IOUtils.toString(this.getClass().getResourceAsStream(path), "UTF-8");
        } catch (Exception e) {
            log.error("Error while trying to read from {}: {}", path, e.getMessage());
        }
        return template;
    }

    public List<String> getAllGalicianMunicipalities() {
        return Arrays.asList(
                readGaliciaTemplate().replaceAll("[^a-zA-Z0-9;ñáéíóú ]", "").split(";")
        )
                .stream()
                .map(m -> m.trim())
                .filter(m -> StringUtils.isNotEmpty(m))
                .collect(Collectors.toList());
    }
}
