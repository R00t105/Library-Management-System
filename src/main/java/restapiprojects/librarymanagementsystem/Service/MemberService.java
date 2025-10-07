package restapiprojects.librarymanagementsystem.Service;

import restapiprojects.librarymanagementsystem.DTO.MemberDto;
import java.util.List;
import java.util.Optional;

public interface MemberService {

    // CRUD
    List<MemberDto> getAllMembers();
    MemberDto getMemberById(int id);
    MemberDto addMember(MemberDto memberDto);
    MemberDto updateMember(int id, MemberDto memberDto);
    void deleteMember(int id);

    // Searching
    Optional<MemberDto> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

}
