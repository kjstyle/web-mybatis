package kjstyle.webmybatis.web.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class MemberDto {

    private String memberId;

    private String memberName;

    private String memberPassword;

    private List<LicenseDto.Create> licenseList;

    @Builder
    public MemberDto(String memberId, String memberName, String memberPassword, List<LicenseDto.Create> licenseList) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.licenseList = licenseList;
    }

    @Getter
    public static class Create {

        @NotBlank
        private String memberId;

        @NotBlank
        private String memberName;

        @NotBlank
        private String memberPassword;

        @Valid
        private List<LicenseDto.Create> licenseList;

        @Builder
        public Create(String memberId, String memberName, String memberPassword, List<LicenseDto.Create> licenseList) {
            this.memberId = memberId;
            this.memberName = memberName;
            this.memberPassword = memberPassword;
            this.licenseList = licenseList;
        }
    }
}
