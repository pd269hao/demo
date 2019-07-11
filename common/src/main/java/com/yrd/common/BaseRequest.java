package com.yrd.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2019/7/11
 **/
@Data
@Builder
public class BaseRequest {
    private String param;
}
