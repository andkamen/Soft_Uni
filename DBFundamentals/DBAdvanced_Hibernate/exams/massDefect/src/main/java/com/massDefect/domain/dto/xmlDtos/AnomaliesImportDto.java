package com.massDefect.domain.dto.xmlDtos;

import com.massDefect.domain.dto.jsonDtos.AnomalyVictimImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomaliesImportDto implements Serializable {
    @XmlElement(name = "anomaly")
    private List<AnomalyWithVictimImportDto> anomalies;

    public List<AnomalyWithVictimImportDto> getAnomalies() {
        return this.anomalies;
    }

    public void setAnomalies(List<AnomalyWithVictimImportDto> anomalies) {
        this.anomalies = anomalies;
    }
}
