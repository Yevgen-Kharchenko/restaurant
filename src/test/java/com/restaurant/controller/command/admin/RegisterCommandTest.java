package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.error.NotFoundCommand;
import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.NOT_FOUND_PAGE;
import static com.restaurant.controller.PageUrlConstants.REGISTER_PAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class RegisterCommandTest {
    @InjectMocks
    private RegisterCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnRegistrationPage() {
        PageResponse result = instance.performGet(request);

        assertThat(result.getUrl()).isEqualTo(REGISTER_PAGE);
        assertThat(result.isRedirect()).isFalse();
    }
}