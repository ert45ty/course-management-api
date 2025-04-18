package vn.ert45ty.coursemanagement.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageDomain<T> {
    private int pageNo;

    private int pageSize;

    private Long totalElements;

    private int totalPages;

    private List<T> items;
}
