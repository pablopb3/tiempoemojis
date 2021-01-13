
package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latLng",
    "name",
    "URL",
    "temperature",
    "temperature_orig",
    "status",
    "text",
    "mobile",
    "community",
    "province"
})
public class ElTiempoPuntoEsCityWeather implements Serializable
{

    @JsonProperty("latLng")
    public List<Double> latLng = null;
    @JsonProperty("name")
    public String name;
    @JsonProperty("URL")
    public String url;
    @JsonProperty("temperature")
    public String temperature;
    @JsonProperty("temperature_orig")
    public Integer temperatureOrig;
    @JsonProperty("status")
    public String status;
    @JsonProperty("text")
    public Integer text;
    @JsonProperty("mobile")
    public Integer mobile;
    @JsonProperty("community")
    public String community;
    @JsonProperty("province")
    public Object province;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 324628290329423946L;

    public ElTiempoPuntoEsCityWeather() {}

    public ElTiempoPuntoEsCityWeather(List<Double> latLng, String name, String status) {
        this.latLng = latLng;
        this.name = name;
        this.status = status;
    }

    public List<Double> getLatLng() {
        return latLng;
    }

    public String getName() {
        return name;
    }

    public String getUrl() { return url; }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("latLng", latLng).append("name", name).append("uRL", url).append("temperature", temperature).append("temperatureOrig", temperatureOrig).append("status", status).append("text", text).append("mobile", mobile).append("community", community).append("province", province).append("additionalProperties", additionalProperties).toString();
    }

}
