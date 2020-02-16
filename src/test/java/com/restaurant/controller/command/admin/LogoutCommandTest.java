package com.restaurant.controller.command.admin;

import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.HOME_PAGE;
import static com.restaurant.controller.PageUrlConstants.NOT_FOUND_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LogoutCommandTest {
    @InjectMocks
    private LogoutCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnHomePageAfterLogout() {
        PageResponse result = instance.execute(request);

        assertThat(result.getUrl()).isEqualTo(HOME_PAGE);
        assertThat(result.isRedirect()).isTrue();
    }
}