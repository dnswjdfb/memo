package kr.hs.after.memo.dao;

import kr.hs.after.memo.dto.memoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface memoDAO {
    public void insert(memoDTO dto);
    public memoDTO listOne(int idx);
    public memoDTO loginSelect(String id);
    public void insertMemo(memoDTO dto);

}
