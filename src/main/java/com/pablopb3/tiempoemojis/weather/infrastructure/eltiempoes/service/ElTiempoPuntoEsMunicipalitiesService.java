package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElTiempoPuntoEsMunicipalitiesService {

    private static Logger log = LoggerFactory.getLogger(ElTiempoPuntoEsMunicipalitiesService.class);

    private ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService;

    public ElTiempoPuntoEsMunicipalitiesService(ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService) {
        this.elTiempoPuntoEsDownloadService = elTiempoPuntoEsDownloadService;
    }

    public List<ElTiempoPuntoEsMunicipality> getMunicipalitiesForProvince(Integer provinceCode) {
        return elTiempoPuntoEsDownloadService.downloadMunicipalitiesForProvince(provinceCode);
    }

}
