package kjstyle.webmybatis.domain;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Member {

    private long memberNo;

    @NonNull
    private String memberId;

    @NonNull
    private String memberName;

    @NonNull
    private String memberPassword;
}
