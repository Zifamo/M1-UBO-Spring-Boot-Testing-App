package com.entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Responsable extends Utilisateur {


    @ManyToOne
    private Composante maComposante;

}
