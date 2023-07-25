package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.lang.NonNull;

import java.util.UUID;

public class Car {
    private final UUID id;
    private final String modalName;
    @NonNull
    private final int apartmentNo;



    public Car(@JsonProperty("id") UUID id, @JsonProperty("modalName") String modalName, @JsonProperty("apartmentNo") int apartmentNo){
        this.id=id;
        this.modalName=modalName;
        this.apartmentNo=apartmentNo;



    }

    public String getModalName() {
        return modalName;
    }

    public UUID getId() {
        return id;
    }
    public int getApartmentNo() {
        return apartmentNo;
    }


}
