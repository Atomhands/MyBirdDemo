package com.niehao.model;

import cn.hutool.core.convert.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Page
 * Package: com.niehao.model
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/19 14:28
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private int pageIndex;
    private int pageSize;
    private String sortField;
    private String sortOrder;
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
