package com.ibeetl.admin.core.service;

import com.ibeetl.admin.core.dao.GoodsDao;
import com.ibeetl.admin.core.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.core.dao.CoreAuditDao;
import com.ibeetl.admin.core.entity.CoreAudit;

@Service
@Transactional
public class GoodsService extends CoreBaseService<Goods> {

    @Autowired
    private GoodsDao goodsDao;


}