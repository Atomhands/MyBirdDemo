package com.iweb.dto;

import lombok.Data;

@Data
public class DataGrid<T> {
    private long total;
    private T data;
}
