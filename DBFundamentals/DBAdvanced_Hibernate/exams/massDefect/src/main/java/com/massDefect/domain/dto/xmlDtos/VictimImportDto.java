package com.massDefect.domain.dto.xmlDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class VictimImportDto implements Serializable {

    @XmlElement(name = "name")
    private String name;
}
