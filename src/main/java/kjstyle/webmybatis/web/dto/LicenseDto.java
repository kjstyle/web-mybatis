package kjstyle.webmybatis.web.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
public class LicenseDto {

    @NotBlank
    private String licenseName;

    @NotBlank
    private LocalDate expiredDate;

    @Builder
    public LicenseDto(String licenseName, LocalDate expiredDate) {
        this.licenseName = licenseName;
        this.expiredDate = expiredDate;
    }

    @Getter
    public static class Create {

        @NotBlank
        private String licenseName;

        @NotBlank
        private LocalDate expiredDate;

        @Builder
        public Create(String licenseName, LocalDate expiredDate) {
            this.licenseName = licenseName;
            this.expiredDate = expiredDate;
        }
    }

}
