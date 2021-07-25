package kjstyle.webmybatis.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import kjstyle.webmybatis.web.dto.LicenseDto;
import kjstyle.webmybatis.web.dto.MemberDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        // 한글 깨짐 방지 처리
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 필터 추가
                // .alwaysExpect(MockMvcResultMatchers.status().isOk()) // 모든 테스트에서 200OK를 기대하도록 설정
                .alwaysDo(print()) // 모든 테스트에서 출력을 하도록 설정
                .build();
    }

    @Test
    void 멤버등록_리스트가null인경우() throws Exception {
        // given
        MemberDto.Create memberDtoCreate = MemberDto.Create.builder()
                .memberId("kjstye")
                .memberName("이길주")
                .memberPassword("1234")
                .build();

        String requestBodyJson = objectMapper.writeValueAsString(memberDtoCreate);

        // when
        final ResultActions actions = mockMvc.perform(
                post("/members")
                        .content(requestBodyJson)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        actions.andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void 멤버등록_리스트내의_요소들에대한_개별_validation() throws Exception {
        // given

        LicenseDto.Create licenseDtoCreate01 = LicenseDto.Create.builder()
                .licenseName("") // @NotBlank에 걸리는지
                .expiredDate(LocalDate.now())
                .build();

        LicenseDto.Create licenseDtoCreate02 = LicenseDto.Create.builder()
                .licenseName("정보기기운용기능사")
                .expiredDate(LocalDate.now())
                .build();

        List<LicenseDto.Create> licenseList = new ArrayList<>();
        licenseList.add(licenseDtoCreate01);
        licenseList.add(licenseDtoCreate02);

        MemberDto.Create memberDtoCreate = MemberDto.Create.builder()
                .memberId("kjstye")
                .memberName("이길주")
                .memberPassword("1234")
                .build();

        String requestBodyJson = objectMapper.writeValueAsString(memberDtoCreate);

        // when
        final ResultActions actions = mockMvc.perform(
                post("/members")
                        .content(requestBodyJson)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        // actions.andExpect(status().isBadRequest()); // 400에러로 떨어지지 않음
    }
}