package vn.ert45ty.coursemanagement.infrastructure.persistence.mapper;

import vn.ert45ty.coursemanagement.domain.model.PageDomain;
import vn.ert45ty.coursemanagement.presentation.dto.response.PageResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageMapper {
    public static <T, R> PageResponse<R> map(PageDomain<T> page, Function<T, R> mapper){
        List<R> mappedItems = page.getItems().stream()
                                .map(mapper)
                                .collect(Collectors.toList());
        return PageResponse.<R>builder()
                .pageNo(page.getPageNo())
                .pageSize(page.getPageSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .items(mappedItems)
                .build();
    }
}
