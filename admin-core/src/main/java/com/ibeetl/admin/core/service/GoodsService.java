package com.ibeetl.admin.core.service;

import com.ibeetl.admin.core.dao.GoodsDao;
import com.ibeetl.admin.core.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsService extends CoreBaseService<Goods> {

   @Autowired
    private GoodsDao goodsDao;
    @Override
    public boolean save(Goods goods) {
        goodsDao.insert(goods);
        //return sqlManager.insert(goods) > 0;
        return true;
    }


}