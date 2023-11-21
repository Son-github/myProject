package com.son.project_a.controller;

import com.son.project_a.service.MealKitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("찾기 기능 컨트롤러")
@WebMvcTest(MealKitController.class)
class MealKitControllerTest {

    static Logger log = LoggerFactory.getLogger(MealKitControllerTest.class);

    private final MockMvc mvc;

    @MockBean private MealKitService mealKitService;

    MealKitControllerTest(@Autowired  MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 밀키트 리스트")
    @Test
    void givenNothing_whenRequestingMealKitView_thenReturnMealKitsView() throws Exception {
        // Given
        given(mealKitService.searchByMealKitNames(eq(null), eq(null), any(Pageable.class))).willReturn(Page.empty());

        // When & Then
        mvc.perform(get("/mealKits"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("/mealKits/index"))
                .andExpect(model().attributeExists("mealKits"));
        then(mealKitService).should().searchByMealKitNames(eq(null), eq(null), any(Pageable.class));

    }

}