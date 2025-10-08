package restapiprojects.librarymanagementsystem.Mapper;

import org.mapstruct.Mapper;
import restapiprojects.librarymanagementsystem.DTO.AppUserDto;
import restapiprojects.librarymanagementsystem.Model.AppUser;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserDto toDto(AppUser appUser);
    AppUser toEntity(AppUserDto appUserDto);
}
