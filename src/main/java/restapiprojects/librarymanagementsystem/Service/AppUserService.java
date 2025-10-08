package restapiprojects.librarymanagementsystem.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import restapiprojects.librarymanagementsystem.DTO.AppUserDto;
import restapiprojects.librarymanagementsystem.Mapper.AppUserMapper;
import restapiprojects.librarymanagementsystem.Model.AppUser;
import restapiprojects.librarymanagementsystem.Repository.AppUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(appUser.getRole())
                .build();
    }

    public AppUserDto addUser(AppUserDto appUserDto) {
        AppUser appUser = appUserMapper.toEntity(appUserDto);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("USER");
        AppUser savedUser = appUserRepository.save(appUser);
        return appUserMapper.toDto(savedUser);
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }


}
