package com.example.TurismoaApplication.validaciones;

import org.springframework.stereotype.Component;

@Component
public class EmpresaValidacion {

    public Boolean validarNombre(String nombre){

        if(nombre.length()>30){
           return false;
        }else{
            return true;
        }

    }

}
