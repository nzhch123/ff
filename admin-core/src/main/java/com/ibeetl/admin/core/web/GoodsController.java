package com.ibeetl.admin.core.web;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ibeetl.admin.core.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.ibeetl.admin.core.service.GoodsService;
import java.io.IOException;
import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONObject;
import com.ibeetl.admin.core.util.doc.EXCEL;
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
    public void request(HttpServletRequest request, HttpServletResponse response, @RequestParam("name")String name, @RequestBody Goods goods) {
        goodservice.save(goods);
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuffer responseStrBuilder = new StringBuffer();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            
            
            System.out.println(responseStrBuilder);
            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());

            EXCEL.createExcel(jsonObject, name, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
    
    
    
    
    
  