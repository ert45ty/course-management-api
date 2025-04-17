package vn.ert45ty.coursemanagement.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageResponse<T> {
    private int pageNo;

    private int pageSize;

    private Long totalElements;

    private int totalPages;

    private T items;
}
