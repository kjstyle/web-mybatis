package kjstyle.webmybatis.repository;

import kjstyle.webmybatis.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member selectMemberOne(long memberNo);
}