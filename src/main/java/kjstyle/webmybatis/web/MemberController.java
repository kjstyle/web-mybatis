package kjstyle.webmybatis.web;

import kjstyle.webmybatis.domain.Member;
import kjstyle.webmybatis.repository.MemberMapper;
import kjstyle.webmybatis.web.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;

    @PostMapping("/members")
    public long createMember(@RequestBody @Valid MemberDto.Create memberCreateDto) {
        return 0L;
    }

    @GetMapping("/members")
    public List<MemberDto> getMemberList() {

        List<Member> memberList = memberMapper.selectAll();

        return memberList.stream()
                .map(
                        m -> MemberDto.builder()
                                .memberId(m.getMemberId())
                                .memberName(m.getMemberName())
                                .memberPassword(m.getMemberPassword())
                                .licenseList(null)
                        .build()
                ).collect(Collectors.toList());
    }
}