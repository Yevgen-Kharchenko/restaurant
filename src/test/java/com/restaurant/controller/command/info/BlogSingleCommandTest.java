package com.restaurant.controller.command.info;

import com.restaurant.controller.command.error.NotFoundCommand;
import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.BLOG_SINGLE_PAGE;
import static com.restaurant.controller.PageUrlConstants.NOT_FOUND_PAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BlogSingleCommandTest {
    @InjectMocks
    private BlogSingleCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnBlogSinglePage() {
        PageResponse result = instance.execute(request);

        assertThat(result.getUrl()).isEqualTo(BLOG_SINGLE_PAGE);
        assertThat(result.isRedirect()).isFalse();
    }
}