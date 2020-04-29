package com.stx.runner.dao;

import com.stx.runner.entity.Express;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述:
 *
 * @author xiaoyu
 * on 2020/4/29
 */
@Repository
public interface ExpressDao {

    int insertExpress(@Param("express") Express express,@Param("id") Integer id);

    List<Express> getAllExpress(Integer id);
}
