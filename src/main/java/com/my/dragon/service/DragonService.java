package com.my.dragon.service;

import com.my.dragon.dto.CreateDragonDTO;
import com.my.dragon.dto.DragonDTO;
import com.my.dragon.dto.DragonFilterDTO;
import com.my.dragon.dto.UpdateDragonDTO;
import com.my.dragon.model.Dragon;
import com.my.dragon.repository.DragonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class DragonService {

    @Autowired
    private DragonRepository dragonRepository;

    public List<Dragon> findByFilter(DragonFilterDTO dto) {
        //verifica se nome ou tipo existem para o filtro
        if (dto.getName() != null || dto.getType() != null) {
            return dragonRepository.findByNameOrType(dto.getName(), dto.getType());
        }

        return dragonRepository.findAll();
    }

    public Dragon createDragon(CreateDragonDTO dto) {

        Dragon dragon = new Dragon();
        dragon.setName(dto.getName());
        dragon.setType(dto.getType());
        dragon.setCreatedAt(LocalDate.now());

        Dragon savedDragon = dragonRepository.save(dragon);

        return savedDragon;
    }

    public Dragon findById(String id) {
        Optional<Dragon> optDragon = dragonRepository.findById(id);
        return optDragon.get();
    }

    public Dragon updateDragon(UpdateDragonDTO dto) {
        Optional<Dragon> optDragon = dragonRepository.findById(dto.getId());
        Dragon dragon = optDragon.get();
        dragon.setName(dto.getName());
        dragon.setType(dto.getType());

        Dragon savedDragon = dragonRepository.save(dragon);

        return savedDragon;
    }

    public void deleteDragon(String id) {
        dragonRepository.deleteById(id);
    }
}
