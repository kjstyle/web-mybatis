package kjstyle.webmybatis.web;

import kjstyle.webmybatis.web.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @PostMapping("/members")
    public long createMember(@RequestBody @Valid MemberDto.Create memberCreateDto) {
        return 0L;
    }
}