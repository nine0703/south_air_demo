package com.csair.log_service_a.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogBean {

    // 日志唯一ID
    private Long id;
    // 日志标签
    private String tag;
    // 线程信息
    private String threadInfo;
    // 日志时间
    private Date time;


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", tag=\"" + tag + "\"" +
                "}";
    }

}   // Class end.
