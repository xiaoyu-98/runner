package com.stx.runner.service.impl;

import com.stx.runner.dao.ExpressDao;
import com.stx.runner.entity.Express;
import com.stx.runner.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * 类描述:
 *
 * @author xiaoyu
 * on 2020/4/29
 */
@Service
public class ExpressServiceImpl implements ExpressService {
    @Autowired
    ExpressDao expressDao;

    @Override
    public int insertExpress(Express express,Integer id) {
        Date date = new Date();
        System.out.println(date);
        express.setCreateTime(date);
        return expressDao.insertExpress(express,id);
    }

    @Override
    public List<Express> getAllExpress(Integer id) {
        return expressDao.getAllExpress(id);
    }
}
