package com.ibeetl.admin.core.dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import com.ibeetl.admin.core.entity.Goods;



@SqlResource("goods")
public interface GoodsDao extends BaseMapper<Goods> {


}
