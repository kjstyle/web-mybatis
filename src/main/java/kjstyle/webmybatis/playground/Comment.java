package kjstyle.webmybatis.playground;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class Comment {
    private long commentKey;
    private String content;
    private String nickname;
    private LocalDateTime createUtc;

    @Builder
    public Comment(long commentKey, String content, String nickname, LocalDateTime createUtc) {
        this.commentKey = commentKey;
        this.content = content;
        this.nickname = nickname;
        this.createUtc = createUtc;
    }
}