package kjstyle.webmybatis.repository;

import kjstyle.webmybatis.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void selectMemberOne() {
        Member member = memberMapper.selectMemberOne(1L);
        Assertions.assertNotNull(member);
        Assertions.assertEquals("이길주", member.getMemberName());
    }
}