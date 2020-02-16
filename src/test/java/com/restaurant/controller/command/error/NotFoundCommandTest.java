package com.restaurant.controller.command.error;

import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.restaurant.controller.PageUrlConstants.NOT_FOUND_PAGE;
import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class NotFoundCommandTest {
    @InjectMocks
    private NotFoundCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnNotFoundPage() {
        PageResponse result = instance.execute(request);

        assertThat(result.getUrl()).isEqualTo(NOT_FOUND_PAGE);
        assertThat(result.isRedirect()).isFalse();
    }
}