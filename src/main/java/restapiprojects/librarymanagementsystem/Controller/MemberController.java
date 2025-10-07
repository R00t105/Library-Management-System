package restapiprojects.librarymanagementsystem.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restapiprojects.librarymanagementsystem.DTO.MemberDto;
import restapiprojects.librarymanagementsystem.Service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable int id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@Valid @RequestBody MemberDto memberDto) {
        return ResponseEntity.status(201).body(memberService.addMember(memberDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable int id, @Valid @RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(memberService.updateMember(id, memberDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted successfully");
    }

    @GetMapping("/search/by-email")
    public ResponseEntity<MemberDto> getByEmail(@RequestParam String email) {
        return memberService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
