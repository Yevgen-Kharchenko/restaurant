package com.restaurant.controller.command.error;

import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.UNDER_CONSTRUCTION_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UnderConstructionCommandTest {

    @InjectMocks
    private UnderConstructionCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnUnderConstructionPage() {
        PageResponse result = instance.execute(request);

        assertThat(result.getUrl()).isEqualTo(UNDER_CONSTRUCTION_PAGE);
        assertThat(result.isRedirect()).isFalse();
    }
}
