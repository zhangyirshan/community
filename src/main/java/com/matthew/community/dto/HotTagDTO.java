package com.matthew.community.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/11/21 12:04
 * @Version 1.0
 */
@Data
public class HotTagDTO implements Comparable{
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
