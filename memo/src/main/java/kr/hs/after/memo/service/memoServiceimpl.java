package kr.hs.after.memo.service;

import kr.hs.after.memo.dao.memoDAO;
import kr.hs.after.memo.dto.memoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class memoServiceimpl implements memoService{
    @Autowired
    private memoDAO dao;
    @Override
    public void insert(memoDTO dto) {
        dao.insert(dto);
    }

    @Override
    public memoDTO listOne(int idx) {
        return dao.listOne(idx);
    }

    @Override
    public memoDTO loginSelect(String id) {
        return dao.loginSelect(id);
    }

}
