package com.web.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author david
 */
@Data
@Builder
public class MyMessage {

    private long count;
    private String name;

}
