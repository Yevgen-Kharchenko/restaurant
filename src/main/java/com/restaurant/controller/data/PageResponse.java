package com.restaurant.controller.data;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class PageResponse {
    @NonNull
    private String url;
    private boolean redirect;

    public String getUrl() {
        return url;
    }

    public boolean isRedirect() {
        return redirect;
    }

}
