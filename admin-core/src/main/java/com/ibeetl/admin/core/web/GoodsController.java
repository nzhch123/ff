package com.ibeetl.admin.core.web;
import java.io.OutputStream;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.ibeetl.admin.core.entity.Goods;
import com.ibeetl.admin.core.web.dto.ReceiveGoods;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibeetl.admin.core.service.GoodsService;
import java.io.IOException;
import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ResponseBody
@RestController
public class GoodsController {
    /**
     *
     */
    @Autowired GoodsService goodservice;

    /*restful 部分*/


    @GetMapping("/hello")
    public String add(@Param("name")String name) throws Exception {
        //System.out.println(acc);
        return "success";
    }
    @CrossOrigin
    @PostMapping ("/goods")
    public void request(HttpServletResponse response,  @RequestBody ReceiveGoods goods) throws IOException {
        String name="mydata";
        if (goods!=null){
            List<Goods> all_goods=goods.getResult();

            for (int i = 0; i <all_goods.size() ; i++) {
                if (all_goods.get(i).getGoodsName()!=null)
                {
                    goodservice.save(all_goods.get(i));
                }

            }
        }


        try {
            if (goods!=null){
                createExcel(goods, name, response);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void createExcel(ReceiveGoods goods, String name, HttpServletResponse response) throws IOException {
        String[] heads= {"商品名称","商品ID","日期","商品收藏数","商品访客数","商品浏览量","支付订单数","支付转化率","支付件数","支付买家数","支付金额","成团订单数","成团件数","是否新款"};
        SXSSFWorkbook workbook = new SXSSFWorkbook();// 创建一个Excel文件
        SXSSFSheet sheet = workbook.createSheet();// 创建一个Excel的Sheet
        SXSSFRow titleRow = sheet.createRow(0);//创建表头
        for(int i=0;i<heads.length;i++){//表头赋值
            titleRow.createCell(i).setCellValue(heads[i]);
        }

        boolean p=goods.isSuccess();
        // boolean p=(boolean)tf.get("success");
        List<Goods> goodsList=goods.getResult();
        int n=goodsList.size();
        OutputStream out1=null;
        try {
            int j=0;

            for(int x=0;x<n;x++)
            {


               Goods goods1= goodsList.get(x);

                        if(goods1.getGoodsName()!=null)
                        {

                            SXSSFRow row = sheet.createRow(j + 1);
                            row.createCell(0).setCellValue(goods1.getGoodsName());//商品名称
                            row.createCell(1).setCellValue(goods1.getGoodsId());//商品ID
                            row.createCell(2).setCellValue(goods1.getStatDate());//日期
                            row.createCell(3).setCellValue(goods1.getGoodsFavCnt());//商品收藏数
                            row.createCell(4).setCellValue(goods1.getGoodsUv());//商品访客数
                            row.createCell(5).setCellValue(goods1.getGoodsPv());//商品浏览量
                            row.createCell(6).setCellValue(goods1.getPayOrdrCnt());//支付订单数
                            row.createCell(7).setCellValue(goods1.getGoodsVcr());//支付转化率
                            row.createCell(8).setCellValue(goods1.getPayOrdrGoodsQty());//支付件数
                            row.createCell(9).setCellValue(goods1.getPayOrdrUsrCnt());//支付买家数
                            row.createCell(10).setCellValue(goods1.getPayOrdrAmt());//支付金额
                            row.createCell(11).setCellValue(goods1.getCfmOrdrCnt());//成团订单数
                            row.createCell(12).setCellValue(goods1.getCfmOrdrGoodsQty());//成团件数
                            row.createCell(13).setCellValue(goods1.getIsNewstyle());//是否新款*/
                        }


            }
        } finally {
            // TODO: handle finally clause
            try {
                //String path="/"+name+".xls";
                //OutputStream f=new FileOutputStream(path);
                //workbook.write(f);

                response.setContentType("application/ vnd.ms-excel");
                response.addHeader("Content-Disposition", "attachment; filename=test.xls");
                //response.setHeader("Access-Control-Allow-Origin", "*");
                out1 = response.getOutputStream();
                workbook.write(out1);
                out1.flush();

                //f.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                out1.close();
            }
        }

    }
}
    
    
    
    
    
  