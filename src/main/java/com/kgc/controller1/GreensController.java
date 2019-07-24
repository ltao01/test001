package com.kgc.controller1;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Greens;
import com.kgc.service.GreensServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class GreensController {

    @Autowired
    private GreensServiceImpl service;

    @RequestMapping("/search")
    public String selectAll(Greens gs, @RequestParam(defaultValue = "1") Integer pageNum,
                            Model mav) {
        System.out.println(pageNum+"------------------当前页-----------------");
        PageInfo<Greens> greens = service.selectAll(pageNum);
        mav.addAttribute("pageInfo",greens);

        return "/show";
    }

//    图片上传
    //    实现文件上传
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(required = false, value = "bigHeadImg") MultipartFile file, HttpSession session) throws IOException {
//        1,获取图片的存贮路径
        System.out.println("---------------检测线-------------");
        String path = session.getServletContext().getRealPath("/imgs");
        System.out.println(path+"---------------图片路径-------------");
//2,获取文件名
        String filename = file.getOriginalFilename();
//        3,加唯一前缀
        filename = System.currentTimeMillis() + UUID.randomUUID().toString() + filename;
//        4,判断文件大小

        if (file.getSize() > 1048576) {
            System.out.println("文件太大");
        } else {
            try {
                File file1 = new File(path, filename);
//              file1是指定的路径和文件名
                if (!file1.exists()) {//判断文件夹是否存在
                    file1.mkdirs();//不存在就创建
                }
                file.transferTo(file1); //执行上传
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JSONObject json = new JSONObject();
        json.put("url", "/imgs/" + filename);//返回相对路径，名url
        return json.toJSONString();
    }
//    新增
    @RequestMapping("/add2")
    public String add2(Greens greens) {
        int i = service.add(greens);
        return "redirect:search"; //重定向 去 重查数据库 - show
    }
//删除
    @RequestMapping("/delete")
    public String delete(Integer id){
        System.out.println("*---------删除-------------");
       service.delete(id);
        return "redirect:search";
    }
//          修改
    @RequestMapping("/update")
    public String update(Greens greens){
        System.out.println(greens.toString()+"-----------------------------");
         service.update(greens);
        return "redirect:search";
    }

//    查询单条
    @RequestMapping("/select")
    public String selectById(Integer id,Model mav){
      Greens greens=  service.selectById(id);
      mav.addAttribute("greens",greens);
      return "/selectById";
    }


}
