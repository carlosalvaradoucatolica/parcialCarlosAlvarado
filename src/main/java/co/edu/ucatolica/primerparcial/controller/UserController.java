package co.edu.ucatolica.primerparcial.controller;

import co.edu.ucatolica.primerparcial.dto.UserResponseDTO;
import co.edu.ucatolica.primerparcial.model.User;
import co.edu.ucatolica.primerparcial.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    //Crear usuario
    @PostMapping("new/user")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

}
