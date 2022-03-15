package com.dtos;

import com.entities.Composante;
import com.entities.Utilisateur;
import lombok.Data;

@Data
public class ResponsableDto extends Utilisateur {

    private Composante maComposante;

}
