package com.restaurant.controller.command.info;

import com.restaurant.controller.data.PageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.RESERVATION_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ReservationCommandTest {
    @InjectMocks
    private ReservationCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnReservationPagGet() {
        PageResponse result = instance.performGet(request);

        assertThat(result.getUrl()).isEqualTo(RESERVATION_PAGE);
        assertThat(result.isRedirect()).isFalse();
    }

    @Test
    public void shouldReturnReservationPagGetPost() {
        PageResponse result = instance.performPost(request);

        assertThat(result.getUrl()).isEqualTo(RESERVATION_PAGE);
        assertThat(result.isRedirect()).isTrue();
    }
}
