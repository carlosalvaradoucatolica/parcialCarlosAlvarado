package co.edu.ucatolica.primerparcial.controller;

import co.edu.ucatolica.primerparcial.dto.UserResponseDTO;
import co.edu.ucatolica.primerparcial.model.User;
import co.edu.ucatolica.primerparcial.service.interfaces.IShiftComplementarioService;
import co.edu.ucatolica.primerparcial.service.interfaces.IShiftPosService;
import co.edu.ucatolica.primerparcial.service.interfaces.IShiftTrasladoService;
import co.edu.ucatolica.primerparcial.service.interfaces.IUserService;
import co.edu.ucatolica.primerparcial.util.Response;
import co.edu.ucatolica.primerparcial.util.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/shift")
public class ShiftController {

    @Autowired
    IShiftPosService posShiftService;
    @Autowired
    IShiftTrasladoService trasladoShiftService;
    @Autowired
    IShiftComplementarioService complemetarioShiftService;

    @PostMapping("")
    public ResponseEntity<Response> createShift(@RequestBody User user){
        if(user.getUserTypes().equals(UserTypes.TRASLADOS)){
            trasladoShiftService.newTrasladoShift(user);
        } else if (user.getUserTypes().equals(UserTypes.POS)){
            posShiftService.newPosShift(user);
        } else if (user.getUserTypes().equals(UserTypes.PLAN_COMPLEMENTARIO)){
            complemetarioShiftService.newComplementarioShift(user);
        }
            return new ResponseEntity<Response>(
                    Response.builder()
                            .timeStampo(LocalDateTime.now())
                            .message("Tipo de usuario no valido")
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build()
                    ,HttpStatus.BAD_REQUEST
            );
        }
}



