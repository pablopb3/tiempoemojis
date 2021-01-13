
package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CODIGOINE",
    "ID_REL",
    "COD_GEO",
    "CODPROV",
    "NOMBRE_PROVINCIA",
    "NOMBRE",
    "POBLACION_MUNI",
    "SUPERFICIE",
    "PERIMETRO",
    "CODIGOINE_CAPITAL",
    "NOMBRE_CAPITAL",
    "POBLACION_CAPITAL",
    "HOJA_MTN25",
    "LONGITUD_ETRS89_REGCAN95",
    "LATITUD_ETRS89_REGCAN95",
    "ORIGEN_COORD",
    "ALTITUD",
    "ORIGEN_ALTITUD",
    "DISCREPANTE_INE"
})
public class ElTiempoPuntoEsMunicipality implements Serializable
{

    @JsonProperty("CODIGOINE")
    private String cODIGOINE;
    @JsonProperty("ID_REL")
    private String iDREL;
    @JsonProperty("COD_GEO")
    private String cODGEO;
    @JsonProperty("CODPROV")
    private String cODPROV;
    @JsonProperty("NOMBRE_PROVINCIA")
    private String nOMBREPROVINCIA;
    @JsonProperty("NOMBRE")
    private String nOMBRE;
    @JsonProperty("POBLACION_MUNI")
    private Integer pOBLACIONMUNI;
    @JsonProperty("SUPERFICIE")
    private Double sUPERFICIE;
    @JsonProperty("PERIMETRO")
    private Integer pERIMETRO;
    @JsonProperty("CODIGOINE_CAPITAL")
    private String cODIGOINECAPITAL;
    @JsonProperty("NOMBRE_CAPITAL")
    private String nOMBRECAPITAL;
    @JsonProperty("POBLACION_CAPITAL")
    private String pOBLACIONCAPITAL;
    @JsonProperty("HOJA_MTN25")
    private String hOJAMTN25;
    @JsonProperty("LONGITUD_ETRS89_REGCAN95")
    private Double lONGITUDETRS89REGCAN95;
    @JsonProperty("LATITUD_ETRS89_REGCAN95")
    private Double lATITUDETRS89REGCAN95;
    @JsonProperty("ORIGEN_COORD")
    private String oRIGENCOORD;
    @JsonProperty("ALTITUD")
    private Integer aLTITUD;
    @JsonProperty("ORIGEN_ALTITUD")
    private String oRIGENALTITUD;
    @JsonProperty("DISCREPANTE_INE")
    private Integer dISCREPANTEINE;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1120426612697550255L;

    public ElTiempoPuntoEsMunicipality() {}

    @JsonProperty("CODIGOINE")
    public String getCODIGOINE() {
        return cODIGOINE;
    }

    @JsonProperty("CODIGOINE")
    public void setCODIGOINE(String cODIGOINE) {
        this.cODIGOINE = cODIGOINE;
    }

    @JsonProperty("ID_REL")
    public String getIDREL() {
        return iDREL;
    }

    @JsonProperty("ID_REL")
    public void setIDREL(String iDREL) {
        this.iDREL = iDREL;
    }

    @JsonProperty("COD_GEO")
    public String getCODGEO() {
        return cODGEO;
    }

    @JsonProperty("COD_GEO")
    public void setCODGEO(String cODGEO) {
        this.cODGEO = cODGEO;
    }

    @JsonProperty("CODPROV")
    public String getCODPROV() {
        return cODPROV;
    }

    public Integer getProvinceCode() {
        return Integer.valueOf(getCODPROV());
    }

    public Integer getMunicipalityCode() {
        return Integer.valueOf(getCODIGOINE().substring(0, 5));
    }

    @JsonProperty("CODPROV")
    public void setCODPROV(String cODPROV) {
        this.cODPROV = cODPROV;
    }

    @JsonProperty("NOMBRE_PROVINCIA")
    public String getNOMBREPROVINCIA() {
        return nOMBREPROVINCIA;
    }

    @JsonProperty("NOMBRE_PROVINCIA")
    public void setNOMBREPROVINCIA(String nOMBREPROVINCIA) {
        this.nOMBREPROVINCIA = nOMBREPROVINCIA;
    }

    @JsonProperty("NOMBRE")
    public String getNOMBRE() {
        return nOMBRE;
    }

    @JsonProperty("NOMBRE")
    public void setNOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
    }

    @JsonProperty("POBLACION_MUNI")
    public Integer getPOBLACIONMUNI() {
        return pOBLACIONMUNI;
    }

    @JsonProperty("POBLACION_MUNI")
    public void setPOBLACIONMUNI(Integer pOBLACIONMUNI) {
        this.pOBLACIONMUNI = pOBLACIONMUNI;
    }

    @JsonProperty("SUPERFICIE")
    public Double getSUPERFICIE() {
        return sUPERFICIE;
    }

    @JsonProperty("SUPERFICIE")
    public void setSUPERFICIE(Double sUPERFICIE) {
        this.sUPERFICIE = sUPERFICIE;
    }

    @JsonProperty("PERIMETRO")
    public Integer getPERIMETRO() {
        return pERIMETRO;
    }

    @JsonProperty("PERIMETRO")
    public void setPERIMETRO(Integer pERIMETRO) {
        this.pERIMETRO = pERIMETRO;
    }

    @JsonProperty("CODIGOINE_CAPITAL")
    public String getCODIGOINECAPITAL() {
        return cODIGOINECAPITAL;
    }

    @JsonProperty("CODIGOINE_CAPITAL")
    public void setCODIGOINECAPITAL(String cODIGOINECAPITAL) {
        this.cODIGOINECAPITAL = cODIGOINECAPITAL;
    }

    @JsonProperty("NOMBRE_CAPITAL")
    public String getNOMBRECAPITAL() {
        return nOMBRECAPITAL;
    }

    @JsonProperty("NOMBRE_CAPITAL")
    public void setNOMBRECAPITAL(String nOMBRECAPITAL) {
        this.nOMBRECAPITAL = nOMBRECAPITAL;
    }

    @JsonProperty("POBLACION_CAPITAL")
    public String getPOBLACIONCAPITAL() {
        return pOBLACIONCAPITAL;
    }

    @JsonProperty("POBLACION_CAPITAL")
    public void setPOBLACIONCAPITAL(String pOBLACIONCAPITAL) {
        this.pOBLACIONCAPITAL = pOBLACIONCAPITAL;
    }

    @JsonProperty("HOJA_MTN25")
    public String getHOJAMTN25() {
        return hOJAMTN25;
    }

    @JsonProperty("HOJA_MTN25")
    public void setHOJAMTN25(String hOJAMTN25) {
        this.hOJAMTN25 = hOJAMTN25;
    }

    @JsonProperty("LONGITUD_ETRS89_REGCAN95")
    public Double getLONGITUDETRS89REGCAN95() {
        return lONGITUDETRS89REGCAN95;
    }

    @JsonProperty("LONGITUD_ETRS89_REGCAN95")
    public void setLONGITUDETRS89REGCAN95(Double lONGITUDETRS89REGCAN95) {
        this.lONGITUDETRS89REGCAN95 = lONGITUDETRS89REGCAN95;
    }

    @JsonProperty("LATITUD_ETRS89_REGCAN95")
    public Double getLATITUDETRS89REGCAN95() {
        return lATITUDETRS89REGCAN95;
    }

    @JsonProperty("LATITUD_ETRS89_REGCAN95")
    public void setLATITUDETRS89REGCAN95(Double lATITUDETRS89REGCAN95) {
        this.lATITUDETRS89REGCAN95 = lATITUDETRS89REGCAN95;
    }

    @JsonProperty("ORIGEN_COORD")
    public String getORIGENCOORD() {
        return oRIGENCOORD;
    }

    @JsonProperty("ORIGEN_COORD")
    public void setORIGENCOORD(String oRIGENCOORD) {
        this.oRIGENCOORD = oRIGENCOORD;
    }

    @JsonProperty("ALTITUD")
    public Integer getALTITUD() {
        return aLTITUD;
    }

    @JsonProperty("ALTITUD")
    public void setALTITUD(Integer aLTITUD) {
        this.aLTITUD = aLTITUD;
    }

    @JsonProperty("ORIGEN_ALTITUD")
    public String getORIGENALTITUD() {
        return oRIGENALTITUD;
    }

    @JsonProperty("ORIGEN_ALTITUD")
    public void setORIGENALTITUD(String oRIGENALTITUD) {
        this.oRIGENALTITUD = oRIGENALTITUD;
    }

    @JsonProperty("DISCREPANTE_INE")
    public Integer getDISCREPANTEINE() {
        return dISCREPANTEINE;
    }

    @JsonProperty("DISCREPANTE_INE")
    public void setDISCREPANTEINE(Integer dISCREPANTEINE) {
        this.dISCREPANTEINE = dISCREPANTEINE;
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
        return new ToStringBuilder(this).append("cODIGOINE", cODIGOINE).append("iDREL", iDREL).append("cODGEO", cODGEO).append("cODPROV", cODPROV).append("nOMBREPROVINCIA", nOMBREPROVINCIA).append("nOMBRE", nOMBRE).append("pOBLACIONMUNI", pOBLACIONMUNI).append("sUPERFICIE", sUPERFICIE).append("pERIMETRO", pERIMETRO).append("cODIGOINECAPITAL", cODIGOINECAPITAL).append("nOMBRECAPITAL", nOMBRECAPITAL).append("pOBLACIONCAPITAL", pOBLACIONCAPITAL).append("hOJAMTN25", hOJAMTN25).append("lONGITUDETRS89REGCAN95", lONGITUDETRS89REGCAN95).append("lATITUDETRS89REGCAN95", lATITUDETRS89REGCAN95).append("oRIGENCOORD", oRIGENCOORD).append("aLTITUD", aLTITUD).append("oRIGENALTITUD", oRIGENALTITUD).append("dISCREPANTEINE", dISCREPANTEINE).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dISCREPANTEINE).append(hOJAMTN25).append(sUPERFICIE).append(aLTITUD).append(cODIGOINECAPITAL).append(oRIGENCOORD).append(cODGEO).append(nOMBREPROVINCIA).append(nOMBRECAPITAL).append(oRIGENALTITUD).append(iDREL).append(pOBLACIONCAPITAL).append(cODPROV).append(nOMBRE).append(lATITUDETRS89REGCAN95).append(additionalProperties).append(pOBLACIONMUNI).append(cODIGOINE).append(pERIMETRO).append(lONGITUDETRS89REGCAN95).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ElTiempoPuntoEsMunicipality) == false) {
            return false;
        }
        ElTiempoPuntoEsMunicipality rhs = ((ElTiempoPuntoEsMunicipality) other);
        return new EqualsBuilder().append(dISCREPANTEINE, rhs.dISCREPANTEINE).append(hOJAMTN25, rhs.hOJAMTN25).append(sUPERFICIE, rhs.sUPERFICIE).append(aLTITUD, rhs.aLTITUD).append(cODIGOINECAPITAL, rhs.cODIGOINECAPITAL).append(oRIGENCOORD, rhs.oRIGENCOORD).append(cODGEO, rhs.cODGEO).append(nOMBREPROVINCIA, rhs.nOMBREPROVINCIA).append(nOMBRECAPITAL, rhs.nOMBRECAPITAL).append(oRIGENALTITUD, rhs.oRIGENALTITUD).append(iDREL, rhs.iDREL).append(pOBLACIONCAPITAL, rhs.pOBLACIONCAPITAL).append(cODPROV, rhs.cODPROV).append(nOMBRE, rhs.nOMBRE).append(lATITUDETRS89REGCAN95, rhs.lATITUDETRS89REGCAN95).append(additionalProperties, rhs.additionalProperties).append(pOBLACIONMUNI, rhs.pOBLACIONMUNI).append(cODIGOINE, rhs.cODIGOINE).append(pERIMETRO, rhs.pERIMETRO).append(lONGITUDETRS89REGCAN95, rhs.lONGITUDETRS89REGCAN95).isEquals();
    }

}
