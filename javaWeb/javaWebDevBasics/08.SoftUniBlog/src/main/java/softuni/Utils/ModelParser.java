package softuni.Utils;

import org.modelmapper.ModelMapper;

import javax.ejb.Stateless;

@Stateless
public class ModelParser {

    private ModelMapper modelMapper;

    public ModelParser() {
        this.modelMapper = new ModelMapper();
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
