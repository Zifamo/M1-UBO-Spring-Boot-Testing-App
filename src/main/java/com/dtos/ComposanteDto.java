package com.dtos;

import com.entities.Responsable;
import lombok.Data;

import java.util.List;


@Data
public class ComposanteDto {
    private Long Id;
    private String nomComposante;
    private List<Responsable> lesResponsables;
}
