package kr.hs.after.memo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class memoDTO {
    private int idx;
    private String id;
    private String pw;
    private String writer;
    private String name;
    private String email;
    private String memo;
    private LocalDateTime join_Date;

}
