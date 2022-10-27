package com.my.dragon.controller;

import com.my.dragon.dto.CreateDragonDTO;
import com.my.dragon.dto.DragonDTO;
import com.my.dragon.dto.DragonFilterDTO;
import com.my.dragon.dto.UpdateDragonDTO;
import com.my.dragon.model.Dragon;
import com.my.dragon.repository.DragonRepository;
import com.my.dragon.service.DragonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/dragons")
public class DragonController {

    @Autowired
    private DragonConverter dragonConverter;

    @Autowired
    private DragonService dragonService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/")
    @ApiOperation(value = "create Dragon")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message = "dragon created successfully"),
            @ApiResponse(code = 400, message = "resource not found"),
            @ApiResponse(code = 409, message = "dragon data has conflict"),
            @ApiResponse(code = 422, message = "Business error"),
            @ApiResponse(code = 500, message = "internal server error"),
    })
    public DragonDTO createDragon(@RequestBody CreateDragonDTO dto) {
        Dragon dragon = dragonService.createDragon(dto);
        DragonDTO dragonDTO = dragonConverter.toDTO(dragon);
        return dragonDTO;
    }

    @PutMapping("/")
    @ApiOperation(value = "update Dragon")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message = "dragon updated successfully"),
            @ApiResponse(code = 400, message = "resource not found"),
            @ApiResponse(code = 409, message = "dragon data has conflict"),
            @ApiResponse(code = 422, message = "Business error"),
            @ApiResponse(code = 500, message = "internal server error"),
    })
    public DragonDTO updateDragon(@RequestBody UpdateDragonDTO dto) {
        Dragon dragon = dragonService.updateDragon(dto);
        DragonDTO dragonDTO = dragonConverter.toDTO(dragon);
        return dragonDTO;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete Dragon")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 200, message = "dragon deleted successfully"),
            @ApiResponse(code = 404, message = "dragon not found"),
            @ApiResponse(code = 500, message = "internal server error"),
    })
    public void deleteDragon(@PathVariable String id) {
        dragonService.deleteDragon(id);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "get Dragon by Id")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code = 200, message = "dragon returned successfully"),
            @ApiResponse(code = 404, message = "Dragon not found"),
            @ApiResponse(code = 500, message = "internal server error"),
    })
    public DragonDTO getDragonById(@PathVariable String id) {
        Dragon dragon = dragonService.findById(id);
        DragonDTO dragonDTO = dragonConverter.toDTO(dragon);
        return dragonDTO;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "/find")
    @ApiOperation(value = "get Dragon by name/type or all")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code = 200, message = "dragons returned successfully"),
            @ApiResponse(code = 404, message = "none dragon was found"),
            @ApiResponse(code = 500, message = "internal server error"),
    })
    public List<DragonDTO> getDragons(@ModelAttribute DragonFilterDTO dto) {
        List<Dragon> dragons = dragonService.findByFilter(dto);
        List<DragonDTO> dragonsDTO = new ArrayList<DragonDTO>();

        for (Dragon dragon : dragons) {
            dragonsDTO.add(dragonConverter.toDTO(dragon));
        }

        return dragonsDTO;
    }


}
