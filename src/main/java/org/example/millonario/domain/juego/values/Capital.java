package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capital implements ValueObject<Integer> {
    private final Integer capital;

    public Capital(Integer capital) {
        if(capital<0){
            throw new IllegalArgumentException("El capital tiene que ser un numero positivo");
        }
        this.capital = Objects.requireNonNull(capital, "El capita es requerido");
    }

    public Capital aumentar(Integer aumentar){
        if(aumentar<0){
            throw new IllegalArgumentException("El aumento tiene que se run numero positivo");
        }
        return new Capital(this.capital +aumentar);
    }

    @Override
    public Integer value() {
        return this.capital;
    }
}
