package kjstyle.webmybatis.repository;

import kjstyle.webmybatis.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    Member selectMemberOne(long memberNo);

    List<Member> selectAll();
}