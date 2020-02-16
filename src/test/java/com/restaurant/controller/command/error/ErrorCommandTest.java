package com.restaurant.controller.command.error;

import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ERROR_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ErrorCommandTest {

    @InjectMocks
    private ErrorCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnErrorPage() {
        PageResponse result = instance.execute(request);

        assertThat(result.getUrl()).isEqualTo(ERROR_PAGE);
        assertThat(result.isRedirect()).isFalse();
    }
}