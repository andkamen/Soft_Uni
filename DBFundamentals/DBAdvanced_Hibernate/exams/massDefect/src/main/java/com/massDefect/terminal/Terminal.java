package com.massDefect.terminal;

import com.massDefect.domain.dto.jsonDtos.*;
import com.massDefect.parsers.JSONParser.JSONParserImpl;
import com.massDefect.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

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
        //File Paths
        String inputJsonFilePath = "D:\\Doc\\Kamen\\Soft_Uni\\DBFundamentals\\DBAdvanced_Hibernate\\exams\\massDefect\\src\\main\\resources\\files\\input\\json\\";
        String inputXmlFilePath = "D:\\Doc\\Kamen\\Soft_Uni\\DBFundamentals\\DBAdvanced_Hibernate\\exams\\massDefect\\src\\main\\resources\\files\\input\\xml\\";
        String outputJsonFilePath = "D:\\Doc\\Kamen\\Soft_Uni\\DBFundamentals\\DBAdvanced_Hibernate\\exams\\massDefect\\src\\main\\resources\\files\\output\\json\\";
        String outputXmlFilePath = "D:\\Doc\\Kamen\\Soft_Uni\\DBFundamentals\\DBAdvanced_Hibernate\\exams\\massDefect\\src\\main\\resources\\files\\output\\xml\\";


        JSONParserImpl jsonParserImpl = new JSONParserImpl();

        SolarSystemImportDto[] solarSystemImportDtos = jsonParserImpl.readFromJSON(SolarSystemImportDto[].class, inputJsonFilePath + "solar-systems.json");


        for (SolarSystemImportDto solarSystemDto : solarSystemImportDtos) {
            try {
                this.solarSystemService.create(solarSystemDto);
                System.out.println(String.format("Successfully imported Solar System %s.", solarSystemDto.getName()));
            } catch (NullPointerException npe) {
                System.out.println("Error: Invalid data.");
            }
        }


        StarImportDto[] starImportDtos = jsonParserImpl.readFromJSON(StarImportDto[].class, inputJsonFilePath + "stars.json");
        for (StarImportDto starImportDto : starImportDtos) {
            try {
                this.starService.create(starImportDto);
                System.out.println(String.format("Successfully imported Star %s.", starImportDto.getName()));
            } catch (NullPointerException npe) {
                System.out.println("Error: Invalid data.");
            }
        }

        PlanetImportDto[] planetImportDtos = jsonParserImpl.readFromJSON(PlanetImportDto[].class, inputJsonFilePath + "planets.json");
        for (PlanetImportDto planetImportDto : planetImportDtos) {
            try {
                this.planetService.create(planetImportDto);
                System.out.println(String.format("Successfully imported Planet %s.", planetImportDto.getName()));
            } catch (NullPointerException npe) {
                System.out.println("Error: Invalid data.");
            }
        }

        PersonImportDto[] personImportDtos = jsonParserImpl.readFromJSON(PersonImportDto[].class, inputJsonFilePath + "persons.json");
        for (PersonImportDto personImportDto : personImportDtos) {
            try {
                this.personService.create(personImportDto);
                System.out.println(String.format("Successfully imported Person %s.", personImportDto.getName()));
            } catch (NullPointerException npe) {
                System.out.println("Error: Invalid data.");
            }
        }

        AnomalyImportDto[] anomalyImportDtos = jsonParserImpl.readFromJSON(AnomalyImportDto[].class, inputJsonFilePath + "anomalies.json");
        for (AnomalyImportDto anomalyImportDto : anomalyImportDtos) {
            try {
                this.anomalyService.create(anomalyImportDto);
                System.out.println("Successfully imported Anomaly.");
            } catch (NullPointerException npe) {
                System.out.println("Error: Invalid data.");
            }
        }

        AnomalyVictimImportDto[] anomalyVictimImportDtos = jsonParserImpl.readFromJSON(AnomalyVictimImportDto[].class, inputJsonFilePath + "anomaly-victims.json");
        for (AnomalyVictimImportDto anomalyVictimImportDto : anomalyVictimImportDtos) {
            try {
                this.anomalyService.fillVictims(anomalyVictimImportDto);
            } catch (NullPointerException npe) {
            }
        }
    }
}
