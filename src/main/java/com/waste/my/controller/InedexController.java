package com.waste.my.controller;

import com.waste.my.domain.UserModel;
import com.waste.my.util.Result;
import com.waste.my.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author wykun
 * @Date 2022/3/23 22:29
 */
@Controller
//@RequestMapping("/api/waster/")
public class InedexController {

    @GetMapping("login")
    public String createUser() {
        return "login";
    }

    @GetMapping("index")
    public String main() {
        return "index";
    }

    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }


    @GetMapping("admin-list")
    public String adminList() {
        return "admin-list";
    }

    @GetMapping("admin-add")
    public String adminAdd() {
        return "admin-add";
    }

    @GetMapping("admin-edit")
    public String adminEdit() {
        return "admin-edit";
    }

    @GetMapping("member-list")
    public String memberList() {
        return "member-list";
    }

    @GetMapping("order-list")
    public String orderList() {
        return "order-list";
    }

    @GetMapping("waste-list")
    public String wasteList() {
        return "waste-list";
    }

    //图片上传测试
    @ResponseBody
    @RequestMapping("upload")
    public Result upload(MultipartFile file, HttpServletRequest request){
          return ResultUtil.success();
//        String prefix="";
//        String dateStr="";
//        //保存上传
//        OutputStream out = null;
//        InputStream fileInput=null;
//        try{
//            if(file!=null){
//                String originalName = file.getOriginalFilename();
//                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
//                Date date = new Date();
//                String uuid = UUID.randomUUID()+"";
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                dateStr = simpleDateFormat.format(date);
//                String filepath = "D:\\images\\" + dateStr+"\\"+uuid+"." + prefix;
//                File files=new File(filepath);
//                //打印查看上传路径
//                System.out.println(filepath);
//                if(!files.getParentFile().exists()){
//                    files.getParentFile().mkdirs();
//                }
//                file.transferTo(files);
//                Map<String,Object> map2=new HashMap<>();
//                Map<String,Object> map=new HashMap<>();
//                map.put("code",0);
//                map.put("msg","");
//                map.put("data",map2);
//                map2.put("src","/images/"+ dateStr+"/"+uuid+"." + prefix);
//                return map;
//            }
//
//        }catch (Exception e){
//        }finally{
//            try {
//                if(out!=null){
//                    out.close();
//                }
//                if(fileInput!=null){
//                    fileInput.close();
//                }
//            } catch (IOException e) {
//            }
//        }
//        Map<String,Object> map=new HashMap<>();
//        map.put("code",1);
//        map.put("msg","");
//        return map;

    }

    @GetMapping("waste-add")
    public String wasteAdd() {
        return "waste-add";
    }

    @GetMapping("w-edit")
    public String wasteEdit() {
        return "w-edit";
    }


    @GetMapping("order-add")
    public String orderAdd() {
        return "order-add";
    }

    @GetMapping("order-edit")
    public String orderEdit() {
        return "order-edit";
    }


    @GetMapping("member-edit")
    public String memberEdit() {
        return "member-edit";
    }


    @GetMapping("member-add")
    public String memberADD() {
        return "member-add.html";
    }
}
