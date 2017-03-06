package com.javaWebExam.Utils;

import org.modelmapper.*;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Stateless
public class ModelParser {

    private ModelMapper modelMapper;

    public ModelParser() {
        this.modelMapper = new ModelMapper();
        this.modifyModelMapper();
    }

    private void modifyModelMapper(){
        Provider<Date> localDateProvider = new AbstractProvider<Date>() {
            @Override
            public Date get() {
                return new Date();
            }
        };

        Converter<String, Date> toStringDate = new AbstractConverter<String, Date>() {
            @Override
            protected Date convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(source, format);
                Date date = java.sql.Date.valueOf(localDate);
                return date;
            }
        };


        this.getModelMapper().createTypeMap(String.class, Date.class);
        this.getModelMapper().addConverter(toStringDate);
        this.getModelMapper().getTypeMap(String.class, Date.class).setProvider(localDateProvider);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
