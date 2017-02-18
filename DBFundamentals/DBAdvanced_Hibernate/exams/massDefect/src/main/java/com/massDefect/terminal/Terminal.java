package com.massDefect.terminal;

import com.massDefect.config.Config;
import com.massDefect.domain.dto.jsonDtos.*;
import com.massDefect.domain.dto.xmlDtos.AnomaliesXMLDto;
import com.massDefect.domain.dto.xmlDtos.AnomalyXMLDto;
import com.massDefect.io.interfaces.ConsoleIO;
import com.massDefect.parser.interfaces.FileParser;
import com.massDefect.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "JSONParser")
    private FileParser jsonParser;

    @Autowired
    @Qualifier(value = "XMLParser")
    private FileParser xmlParser;

    @Autowired
    private ConsoleIO consoleIO;

    @Autowired
    private AnomalyService anomalyService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private SolarSystemService solarSystemService;

    @Autowired
    private StarService starService;


    @Override
    public void run(String... strings) throws Exception {
        //Import
        this.importSolarSystemsFromJSON();
        this.importStarsFromJSON();
        this.importPlanetsFromJSON();
        this.importPersonsFromJSON();
        this.importAnomaliesFromJSON();
        this.importAnomalyVictimsFromJSON();
        this.importAnomaliesFromXML();


    }

    private void importSolarSystemsFromJSON() {
        SolarSystemImportJSONDto[] solarSystemImportJSONDtos = null;
        try {
            solarSystemImportJSONDtos = this.jsonParser.read(SolarSystemImportJSONDto[].class, Config.SOLAR_SYSTEM_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (SolarSystemImportJSONDto solarSystemImportJSONDto : solarSystemImportJSONDtos) {
            try {
                this.solarSystemService.create(solarSystemImportJSONDto);
                this.consoleIO.write(String.format("Successfully imported Solar System %s.", solarSystemImportJSONDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importStarsFromJSON() {
        StarImportJSONDto[] StarImportJSONDtos = null;
        try {
            StarImportJSONDtos = this.jsonParser.read(StarImportJSONDto[].class, Config.STARS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (StarImportJSONDto starImportJSONDto : StarImportJSONDtos) {
            try {
                this.starService.create(starImportJSONDto);
                this.consoleIO.write(String.format("Successfully imported Star %s.", starImportJSONDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importPlanetsFromJSON() {
        PlanetImportJSONDto[] planetImportJSONDtos = null;
        try {
            planetImportJSONDtos = this.jsonParser.read(PlanetImportJSONDto[].class, Config.PLANETS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (PlanetImportJSONDto planetImportJSONDto : planetImportJSONDtos) {
            try {
                this.planetService.create(planetImportJSONDto);
                this.consoleIO.write(String.format("Successfully imported Planet %s.", planetImportJSONDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importPersonsFromJSON() {
        PersonImportJSONDto[] personImportJSONDtos = null;
        try {
            personImportJSONDtos = this.jsonParser.read(PersonImportJSONDto[].class, Config.PERSONS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (PersonImportJSONDto personImportJSONDto : personImportJSONDtos) {
            try {
                this.personService.create(personImportJSONDto);
                this.consoleIO.write(String.format("Successfully imported Person %s.", personImportJSONDto.getName()));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importAnomaliesFromJSON() {
        AnomalyImportJSONDto[] anomalyImpotJSONDtos = null;
        try {
            anomalyImpotJSONDtos = this.jsonParser.read(AnomalyImportJSONDto[].class, Config.ANOMALY_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (AnomalyImportJSONDto anomalyImpotJSONDto : anomalyImpotJSONDtos) {
            try {
                this.anomalyService.create(anomalyImpotJSONDto);
                this.consoleIO.write(String.format("Successfully imported Anomaly."));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importAnomalyVictimsFromJSON() {
        AnomalyVictimImportJSONDto[] anomalyVictimsDtos = null;
        try {
            anomalyVictimsDtos = this.jsonParser.read(AnomalyVictimImportJSONDto[].class, Config.ANOMALY_VICTIMS_IMPORT_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (AnomalyVictimImportJSONDto anomalyVictimsDto : anomalyVictimsDtos) {
            try {
                this.anomalyService.fillVictims(anomalyVictimsDto);
                this.consoleIO.write(String.format("Successfully imported Anomaly."));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }

    private void importAnomaliesFromXML() {
        AnomaliesXMLDto anomaliesXMLDto = null;

        try {
            anomaliesXMLDto = this.xmlParser.read(AnomaliesXMLDto.class, Config.ANOMALIES_IMPORT_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (AnomalyXMLDto anomalyXMLDto : anomaliesXMLDto.getAnomalies()) {
            try {
                this.anomalyService.create(anomalyXMLDto);
                this.consoleIO.write(String.format("Successfully imported Anomaly."));
            } catch (Exception e) {
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }




}
