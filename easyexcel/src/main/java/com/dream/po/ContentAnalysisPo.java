package com.dream.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-05
 */
@Data
@AllArgsConstructor
public class ContentAnalysisPo {


    private String contentType;

    private String content;

    private String sensitiveWord;

    private Integer scanTime;

    private Integer tid;

    private Integer pid;






}
