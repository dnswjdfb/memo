package kr.hs.after.memo.service;

import kr.hs.after.memo.dto.memoDTO;

public interface memoService {
    public void insert(memoDTO dto);
    public memoDTO listOne(int idx);
    public memoDTO loginSelect(String id);


}
