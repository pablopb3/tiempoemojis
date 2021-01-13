
package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "municipio",
    "stateSky"
})
public class ElTiempoPuntoEsMunicipalityWithWeather implements Serializable
{

    @JsonProperty("municipio")
    private ElTiempoPuntoEsMunicipality municipio;
    @JsonProperty("stateSky")
    private ElTiempoPuntoEsStateSky elTiempoPuntoEsStateSky;

    public ElTiempoPuntoEsMunicipalityWithWeather() {
    }

    public ElTiempoPuntoEsMunicipalityWithWeather(ElTiempoPuntoEsMunicipality municipio, ElTiempoPuntoEsStateSky elTiempoPuntoEsStateSky) {
        this.municipio = municipio;
        this.elTiempoPuntoEsStateSky = elTiempoPuntoEsStateSky;
    }

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -47704341848399565L;

    @JsonProperty("municipio")
    public ElTiempoPuntoEsMunicipality getMunicipio() {
        return municipio;
    }

    @JsonProperty("municipio")
    public void setMunicipio(ElTiempoPuntoEsMunicipality municipio) {
        this.municipio = municipio;
    }

   @JsonProperty("stateSky")
    public ElTiempoPuntoEsStateSky getStateSky() {
        return elTiempoPuntoEsStateSky;
    }

    @JsonProperty("stateSky")
    public void setStateSky(ElTiempoPuntoEsStateSky elTiempoPuntoEsStateSky) {
        this.elTiempoPuntoEsStateSky = elTiempoPuntoEsStateSky;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "ElTiempoPuntoEsMunicipalityResponse{" +
                "municipio=" + municipio +
                ", elTiempoPuntoEsStateSky=" + elTiempoPuntoEsStateSky +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ElTiempoPuntoEsMunicipalityWithWeather that = (ElTiempoPuntoEsMunicipalityWithWeather) o;

        return new EqualsBuilder().append(municipio, that.municipio).append(elTiempoPuntoEsStateSky, that.elTiempoPuntoEsStateSky).append(additionalProperties, that.additionalProperties).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(municipio).append(elTiempoPuntoEsStateSky).append(additionalProperties).toHashCode();
    }
}
