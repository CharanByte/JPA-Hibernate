package com.xworkz.project.constants;

import lombok.Getter;

@Getter
public enum ImagePath {
    IMAGE_PATH("D:\\img\\");

    private String path;

    ImagePath(String path){
        this.path=path;
    }

}
