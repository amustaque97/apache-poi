package com.example.abc;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.*;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        String currPath = System.getProperty("user.dir");
        String portfolioFilePath = Paths.get(currPath, "portfolio.pptx").toString();
        String yourBigIdeaFilePath = Paths.get(currPath, "your-big-idea.pptx").toString();


        FileInputStream portfolio = new FileInputStream(portfolioFilePath);
        FileInputStream yourBigIdea = new FileInputStream(yourBigIdeaFilePath);

        XMLSlideShow portfolioSlide = new XMLSlideShow(portfolio);
        XMLSlideShow yourBigIdeaSlide = new XMLSlideShow(yourBigIdea);

        for (XSLFSlide slide: portfolioSlide.getSlides()) {
            XSLFSlide newSlide = yourBigIdeaSlide.createSlide();
            newSlide.importContent(slide);
        }

        yourBigIdeaSlide.write(new FileOutputStream("merged.pptx"));

    }
}