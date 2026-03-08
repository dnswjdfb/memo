package kr.hs.after.memo.service;

import kr.hs.after.memo.dao.memoDAO2;
import kr.hs.after.memo.dto.memoDTO;
import kr.hs.after.memo.dto.memoDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class memoServiceimpl2 implements memoService2{
    @Autowired
    private memoDAO2 dao;
    @Override
    public void insertMemo(memoDTO2 dto) {
        dao.insertMemo(dto);
    }

    @Override
    public List<memoDTO2> select() {
        return dao.select();
    }

    @Override
    public void delete(int idx) {
        dao.delete(idx);
    }

    @Override
    public void update(memoDTO2 dto) {
        dao.update(dto);
    }

    @Override
    public memoDTO2 selectId(String id) {
        return dao.selectId(id);
    }


}
