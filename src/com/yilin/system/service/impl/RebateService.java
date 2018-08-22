package com.yilin.system.service.impl;

import com.yilin.app.domain.Rebate;
import com.yilin.system.service.IRebateService;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by cc on 2018/8/22.
 */
@Controller
public class RebateService implements IRebateService {
    @Override
    public Rebate findOne(int id) throws Exception {
        return null;
    }

    @Override
    public void addOne(Rebate rebate) throws Exception {

    }

    @Override
    public void deleteOne(int id) throws Exception {

    }

    @Override
    public void editOne(Rebate rebate) throws Exception {

    }

    @Override
    public List<Rebate> findPage(int start, int pageSize) throws Exception {
        return null;
    }
}
