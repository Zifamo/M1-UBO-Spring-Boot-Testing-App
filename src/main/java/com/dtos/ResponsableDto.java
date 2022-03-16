package com.dtos;

import com.entities.Composante;
import lombok.Data;

@Data
public class ResponsableDto extends UtilisateurDto {

    private Composante maComposante;

}
