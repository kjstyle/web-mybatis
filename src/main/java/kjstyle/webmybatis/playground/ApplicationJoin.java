package kjstyle.webmybatis.playground;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationJoin {

    public void joinSample() {
        List<ScheduleComment> scheduleCommentList = selectScheduleComment();
        List<Long> commentKeyList = scheduleCommentList.stream().map(sc -> sc.getCommentKey()).collect(Collectors.toList());

        String commentKeyListStringByComma = StringUtils.join(commentKeyList, ",");

        List<Comment> commentList = apiGetCommentListByCommentKeyList(commentKeyListStringByComma);

        Map<Long, Comment> commentMap = commentList.stream().collect(Collectors.toMap(Comment::getCommentKey, Function.identity()));

        List<ScheduleCommentDto> scheduleCommentDtoList = new ArrayList<>();

        for (ScheduleComment sc : scheduleCommentList) {
            Comment comment = commentMap.get(sc.getCommentKey());

            scheduleCommentDtoList.add(
                    ScheduleCommentDto.builder()
                        .schedulerKey(sc.getSchedulerKey())
                        .content(comment.getContent())
                        .nickname(comment.getNickname())
                        .createUtc(comment.getCreateUtc())
                    .build()
            );
        }
    }

    private List<ScheduleComment> selectScheduleComment() {
        List<ScheduleComment> scheduleCommentList = new ArrayList<>();
        scheduleCommentList.add(ScheduleComment.builder().schedulerKey(5L).commentKey(10L).build());
        scheduleCommentList.add(ScheduleComment.builder().schedulerKey(9L).commentKey(11L).build());
        scheduleCommentList.add(ScheduleComment.builder().schedulerKey(17L).commentKey(15L).build());
        return scheduleCommentList;
    }

    private List<Comment> apiGetCommentListByCommentKeyList(String commentKeyListStringByComma) {
        List<Comment> commentList = new ArrayList<>();
        commentList.add(Comment.builder().commentKey(15L).content("댓글3번").nickname("홍길동").createUtc(LocalDateTime.now().minusDays(10L)).build());
        commentList.add(Comment.builder().commentKey(11L).content("댓글2번").nickname("성춘향").createUtc(LocalDateTime.now().minusDays(3L)).build());
        commentList.add(Comment.builder().commentKey(10L).content("댓글1번").nickname("흥보").createUtc(LocalDateTime.now().minusDays(1L)).build());
        return commentList;
    }
}
