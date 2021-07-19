package kjstyle.webmybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class License {
    private long licenseNo;

    private String licenseName;

    private LocalDate expiredDate;
}
