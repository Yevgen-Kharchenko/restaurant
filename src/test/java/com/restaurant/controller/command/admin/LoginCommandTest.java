package com.restaurant.controller.command.admin;

import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.LOGIN_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LoginCommandTest {
    @InjectMocks
    private LoginCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnLoginPage() {
        PageResponse result = instance.performGet(request);

        assertThat(result.getUrl()).isEqualTo(LOGIN_PAGE);
        assertThat(result.isRedirect()).isFalse();
    }
}