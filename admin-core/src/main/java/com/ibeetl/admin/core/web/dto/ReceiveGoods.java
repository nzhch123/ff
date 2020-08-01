package com.ibeetl.admin.core.web.dto;
import com.ibeetl.admin.core.entity.Goods;
import lombok.Data;

import java.util.List;


@Data
public class ReceiveGoods {
    private boolean success;
    private int  errorCode;
    private  String errorMsg;
    private List<Goods>  result;

}
