package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.infra.entities.Candidate;
import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class RequirementsDto {
    private Long id;
    private String description;

    public static List<RequirementsDto> of (List<Requiriments> requiriments){
        List<RequirementsDto> listToReturn = new ArrayList<>();
       requiriments.forEach(x -> {
           RequirementsDto dto = RequirementsDto.builder()
                   .description(x.getDescription())
                   .id(x.getId())
                   .build();
           listToReturn.add(dto);
       });
       return listToReturn;
    }

    public static RequirementsDto create(Requiriments requiriments) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(requiriments, RequirementsDto.class);
    }

}
