package vn.ert45ty.coursemanagement.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Builder
public class PageResponse<T> {
    private int pageNo;

    private int pageSize;

    private Long totalElements;

    private int totalPages;

    private List<T> items;
}
