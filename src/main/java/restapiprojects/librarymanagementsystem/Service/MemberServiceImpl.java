package restapiprojects.librarymanagementsystem.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restapiprojects.librarymanagementsystem.DTO.MemberDto;
import restapiprojects.librarymanagementsystem.Exception.DuplicateMemberInfoException;
import restapiprojects.librarymanagementsystem.Exception.MemberNotFoundException;
import restapiprojects.librarymanagementsystem.Mapper.MemberMapper;
import restapiprojects.librarymanagementsystem.Model.Member;
import restapiprojects.librarymanagementsystem.Repository.MemberRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream().map(memberMapper::toDto).toList();
    }

    @Override
    public MemberDto getMemberById(int id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
        return memberMapper.toDto(member);
    }

    @Override
    public MemberDto addMember(MemberDto memberDto) {
        if (existsByEmail(memberDto.getEmail()) || existsByPhone(memberDto.getPhone())){
            throw new RuntimeException("EMAIL OR PHONE IS ALREADY USED");
        }
        Member member = memberMapper.toEntity(memberDto);
        Member savedMember = memberRepository.save(member);
        return memberMapper.toDto(savedMember);
    }

    @Override
    public MemberDto updateMember(int id, MemberDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
        if (!memberDto.getEmail().equals(member.getEmail()) && existsByEmail(memberDto.getEmail())) {
            throw new DuplicateMemberInfoException("EMAIL IS ALREADY USED");
        }
        if (!memberDto.getPhone().equals(member.getPhone()) && existsByPhone(memberDto.getPhone())) {
            throw new DuplicateMemberInfoException("PHONE IS ALREADY USED");
        }

        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPhone(memberDto.getPhone());

        Member savedMember = memberRepository.save(member);
        return memberMapper.toDto(savedMember);
    }

    @Override
    @Transactional
    public void deleteMember(int id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
        memberRepository.delete(member);
    }

    @Override
    public Optional<MemberDto> findByEmail(String email) {
        return memberRepository.findByEmail(email).map(memberMapper::toDto);
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return memberRepository.existsByPhone(phone);
    }

}
