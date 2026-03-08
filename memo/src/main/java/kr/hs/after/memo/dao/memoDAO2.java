package kr.hs.after.memo.dao;

import kr.hs.after.memo.dto.memoDTO2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface memoDAO2 {
    public void insertMemo(memoDTO2 dto);
    public List<memoDTO2> select();
    public void delete(int idx);
    public void update(memoDTO2 dto);
    public memoDTO2 selectId(String id);
}
