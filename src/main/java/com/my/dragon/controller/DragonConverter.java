package com.my.dragon.controller;

import com.my.dragon.dto.DragonDTO;
import com.my.dragon.model.Dragon;
import org.springframework.stereotype.Component;

@Component
public class DragonConverter {

    public DragonDTO toDTO(Dragon dragon) {
        DragonDTO dragonDTO = new DragonDTO();
        dragonDTO.setId(dragon.getId());
        dragonDTO.setName(dragon.getName());
        dragonDTO.setCreatedAt(dragon.getCreatedAt());
        dragonDTO.setType(dragon.getType());

        return dragonDTO;
    }



}
