package restapiprojects.librarymanagementsystem;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restapiprojects.librarymanagementsystem.DTO.AppUserDto;
import restapiprojects.librarymanagementsystem.Model.AppUser;
import restapiprojects.librarymanagementsystem.Service.AppUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok(appUserService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<AppUserDto> createUser(@RequestBody AppUserDto appUserDto) {
        return ResponseEntity.status(201).body(appUserService.addUser(appUserDto));
    }

}
