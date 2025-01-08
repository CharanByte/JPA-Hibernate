package com.xworkz.project.restcontroller;

import com.xworkz.project.constants.ImagePath;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class ImageRestController {
    @ResponseBody
    @RequestMapping("/photo/{image}")
    public byte[] testPhoto(@PathVariable String image) throws IOException{
        FileInputStream fis=new FileInputStream(ImagePath.IMAGE_PATH.getPath()+image);
        return IOUtils.toByteArray(fis);
    }
}
