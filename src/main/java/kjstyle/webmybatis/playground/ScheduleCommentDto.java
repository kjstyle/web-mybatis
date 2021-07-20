package kjstyle.webmybatis.playground;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleCommentDto {

    private long schedulerKey;
    private String content;
    private String nickname;
    private LocalDateTime createUtc;

    @Builder
    public ScheduleCommentDto(long schedulerKey, String content, String nickname, LocalDateTime createUtc) {
        this.schedulerKey = schedulerKey;
        this.content = content;
        this.nickname = nickname;
        this.createUtc = createUtc;
    }
}
