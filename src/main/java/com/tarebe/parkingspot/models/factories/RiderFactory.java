package com.tarebe.parkingspot.models.factories;


import com.tarebe.parkingspot.dtos.RiderDto;
import com.tarebe.parkingspot.models.RiderModel;

public class RiderFactory {

    public static RiderModel convertToModel(RiderDto riderDto, RiderModel riderModel){
        riderModel.setName(riderDto.name());
        riderModel.setCnh(riderDto.cnh());
        return riderModel;
    }
}
