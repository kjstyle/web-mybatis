package kjstyle.webmybatis.playground;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScheduleComment {
    private long schedulerKey;
    private long commentKey;
}
