package com.stx.runner.service;

import com.stx.runner.entity.Express;

import java.util.List;

/**
 * @author boyi on 2020/4/29
 */
public interface ExpressService {

    int insertExpress(Express express,Integer id);

    List<Express> getAllExpress(Integer id);
}
