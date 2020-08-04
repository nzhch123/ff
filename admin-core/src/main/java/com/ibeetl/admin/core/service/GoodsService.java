package com.ibeetl.admin.core.service;

import com.ibeetl.admin.core.dao.GoodsDao;
import com.ibeetl.admin.core.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
@Service
@Transactional
public interface GoodsService extends JpaRepository<Goods,Integer> {


}