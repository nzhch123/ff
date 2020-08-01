package com.ibeetl.admin.core.util.doc;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class  EXCEL {
	  public static void createExcel(JSONObject jsonObject,String name,HttpServletResponse response) {
	    	String[] heads= {"商品名称","商品ID","日期","商品收藏数","商品访客数","商品浏览量","支付订单数","支付转化率","支付件数","支付买家数","支付金额","成团订单数","成团件数","是否新款"};
	        SXSSFWorkbook workbook = new SXSSFWorkbook();// 创建一个Excel文件
	        SXSSFSheet sheet = workbook.createSheet();// 创建一个Excel的Sheet
	        SXSSFRow titleRow = sheet.createRow(0);//创建表头
	        for(int i=0;i<heads.length;i++){//表头赋值
	            titleRow.createCell(i).setCellValue(heads[i]);
	        }

	    	Integer n=jsonObject.size();
	    	JSONObject tf=JSONObject.parseObject((String) jsonObject.get(0));
	    	boolean p=(boolean)tf.get("success");
	    	
	    	try {
	        	int j=0;
	        	
	    		for(int x=0;x<n;x++)
	            {
	        		
	        		JSONObject number=JSONObject.parseObject((String) jsonObject.get(x));
	                JSONArray result =number.getJSONArray("result");
	                if (result.size() > 0) {//单元格赋值
	                	
	                    for (int i = 0; i < result.size(); i++) {
	                        
	                        JSONObject json = result.getJSONObject(i); // 遍历 jsonarray 
	                       
	                        if(json.get("goodsName")!=null)
	                        {
	                        	
	                        SXSSFRow row = sheet.createRow(j + 1);
	                        row.createCell(0).setCellValue(json.get("goodsName").toString());//商品名称
	                        row.createCell(1).setCellValue(json.get("goodsId").toString());//商品ID
	                        row.createCell(2).setCellValue(json.get("statDate").toString());//日期
	                        row.createCell(3).setCellValue(json.get("goodsFavCnt").toString());//商品收藏数
	                        row.createCell(4).setCellValue(json.get("goodsUv").toString());//商品访客数
	                        row.createCell(5).setCellValue(json.get("goodsPv").toString());//商品浏览量
	                        row.createCell(6).setCellValue(json.get("payOrdrCnt").toString());//支付订单数
	                        row.createCell(7).setCellValue(json.get("goodsVcr").toString());//支付转化率
	                        row.createCell(8).setCellValue(json.get("payOrdrGoodsQty").toString());//支付件数
	                        row.createCell(9).setCellValue(json.get("payOrdrUsrCnt").toString());//支付买家数
	                        row.createCell(10).setCellValue(json.get("payOrdrAmt").toString());//支付金额
	                        row.createCell(11).setCellValue(json.get("cfmOrdrCnt").toString());//成团订单数
	                        row.createCell(12).setCellValue(json.get("cfmOrdrGoodsQty").toString());//成团件数
	                        row.createCell(13).setCellValue(json.get("isNewstyle").toString());//是否新款*/
	                        j++;
	                        }

	                    }
	                }       
	    	}
			} finally {
				// TODO: handle finally clause
		        try {
		        	String path="/"+name+".xls";
		        	//OutputStream f=new FileOutputStream(path);
		        	//workbook.write(f);
		        	System.out.println("woc");				
		        	response.setContentType("application/ vnd.ms-excel");
		        	response.addHeader("Content-Disposition", "attachment; filename=test.xls");
		        	//response.setHeader("Access-Control-Allow-Origin", "*");
		        	OutputStream out1 = response.getOutputStream();
		            workbook.write(out1);
		            out1.flush();
		            
		            //f.flush();
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
			
			}
	    	

	    	   
	          
	            	
	    	



	}



