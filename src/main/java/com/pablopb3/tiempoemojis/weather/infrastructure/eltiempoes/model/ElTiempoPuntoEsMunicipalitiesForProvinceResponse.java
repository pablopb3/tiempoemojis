
package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "provincia",
    "codprov",
    "metadescripcion",
    "keywords",
    "municipios",
    "breadcrumb"
})
public class ElTiempoPuntoEsMunicipalitiesForProvinceResponse implements Serializable
{

    @JsonProperty("title")
    private String title;
    @JsonProperty("provincia")
    private String provincia;
    @JsonProperty("codprov")
    private String codprov;
    @JsonProperty("metadescripcion")
    private String metadescripcion;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("municipios")
    private List<ElTiempoPuntoEsMunicipality> elTiempoPuntoEsMunicipalities = null;
    @JsonProperty("breadcrumb")
    private List<ElTiempoPuntoEsBreadcrumb> elTiempoPuntoEsBreadcrumb = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2831489005482342976L;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("provincia")
    public String getProvincia() {
        return provincia;
    }

    @JsonProperty("provincia")
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @JsonProperty("codprov")
    public String getCodprov() {
        return codprov;
    }

    @JsonProperty("codprov")
    public void setCodprov(String codprov) {
        this.codprov = codprov;
    }

    @JsonProperty("metadescripcion")
    public String getMetadescripcion() {
        return metadescripcion;
    }

    @JsonProperty("metadescripcion")
    public void setMetadescripcion(String metadescripcion) {
        this.metadescripcion = metadescripcion;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("municipios")
    public List<ElTiempoPuntoEsMunicipality> getMunicipios() {
        return elTiempoPuntoEsMunicipalities;
    }

    @JsonProperty("municipios")
    public void setMunicipios(List<ElTiempoPuntoEsMunicipality> elTiempoPuntoEsMunicipalities) {
        this.elTiempoPuntoEsMunicipalities = elTiempoPuntoEsMunicipalities;
    }

    @JsonProperty("breadcrumb")
    public List<ElTiempoPuntoEsBreadcrumb> getBreadcrumb() {
        return elTiempoPuntoEsBreadcrumb;
    }

    @JsonProperty("breadcrumb")
    public void setBreadcrumb(List<ElTiempoPuntoEsBreadcrumb> elTiempoPuntoEsBreadcrumb) {
        this.elTiempoPuntoEsBreadcrumb = elTiempoPuntoEsBreadcrumb;
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
        return new ToStringBuilder(this).append("title", title).append("provincia", provincia).append("codprov", codprov).append("metadescripcion", metadescripcion).append("keywords", keywords).append("municipios", elTiempoPuntoEsMunicipalities).append("breadcrumb", elTiempoPuntoEsBreadcrumb).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metadescripcion).append(elTiempoPuntoEsMunicipalities).append(keywords).append(elTiempoPuntoEsBreadcrumb).append(codprov).append(additionalProperties).append(title).append(provincia).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ElTiempoPuntoEsMunicipalitiesForProvinceResponse) == false) {
            return false;
        }
        ElTiempoPuntoEsMunicipalitiesForProvinceResponse rhs = ((ElTiempoPuntoEsMunicipalitiesForProvinceResponse) other);
        return new EqualsBuilder().append(metadescripcion, rhs.metadescripcion).append(elTiempoPuntoEsMunicipalities, rhs.elTiempoPuntoEsMunicipalities).append(keywords, rhs.keywords).append(elTiempoPuntoEsBreadcrumb, rhs.elTiempoPuntoEsBreadcrumb).append(codprov, rhs.codprov).append(additionalProperties, rhs.additionalProperties).append(title, rhs.title).append(provincia, rhs.provincia).isEquals();
    }

}
