package kr.hs.after.memo.service;


import kr.hs.after.memo.dto.memoDTO2;

import java.util.List;

public interface memoService2 {
    public void insertMemo(memoDTO2 dto);
    public List<memoDTO2> select();
    public void delete(int idx);
    public void update(memoDTO2 dto);
    public memoDTO2 selectId(String id);
}
