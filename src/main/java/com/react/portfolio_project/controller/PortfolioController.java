package com.react.portfolio_project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import com.react.portfolio_project.model.PortfolioVO;
import com.react.portfolio_project.service.PortfolioService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*") // http://127.0.0.1 또는 localhost 다 사용하도록
@RestController
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;  

    // 전체 포트폴리오 조회
//    @RequestMapping("/getAllPortfolio")
//    public HashMap<String, Object> getAllPortfolio(){
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("portList", portfolioService.getAllPortfolio());
//        System.out.println(map);
//        return map; 
// 		ssss
//    }
    
    @RequestMapping("/getAllPortfolio/{memId}")
    public HashMap<String, Object> getAllPortfolio1(@PathVariable String memId){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("portList", portfolioService.getAllPortfolio(memId));
        //System.out.println(map);
        return map;
    }

    @RequestMapping("/insertPortfolio")
    public void insertPortfolio(PortfolioVO portfolioVO){
        portfolioService.insertPortfolio(portfolioVO);
    }

    @RequestMapping("/portfolioDetailView/{portNo}")
    public PortfolioVO portfolioDetailView(@PathVariable int portNo){
       // System.out.println(portfolioService.portfolioDetailView(portNo));
        return portfolioService.portfolioDetailView(portNo);
    }

    // delete
    @RequestMapping("/deletePortfolio/{portNo}")
    public void deletePortfolio(@PathVariable int portNo){
        portfolioService.deletePortfolio(portNo);
    }

    @RequestMapping("/updatePortfolio")
    public void updatePortfolio(PortfolioVO portfolioVO){
        portfolioService.updatePortfolio(portfolioVO);
    }

    // 파일 여러 개 업로드 처리
    @RequestMapping("/fileUploadMultiple")
    public String fileUploadMultiple(@RequestParam("uploadFileMulti") ArrayList<MultipartFile> files, Model model)
            throws IOException {

        String savedFileName = "";

        // 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치(프로젝트 외부에 저장)
        String uploadPath = "file:///Users/hyeonji/full_stack_study/upload/";

        // 여러 개의 파일 이름을 저장할 리스트 생성
        ArrayList<String> originalFilenameList = new ArrayList<String>();

        for (MultipartFile file : files) {
            // 2. 원본 파일 이름 알아오기
            String originalFileName = file.getOriginalFilename();

            // 파일 이름을 리스트에 추가
            originalFilenameList.add(originalFileName);

            // 3. 파일 이름 중복되지 않도록 이름 변경 : 서버에 저장할 이름 . UUID 사용
            UUID uuid = UUID.randomUUID();
            savedFileName = uuid.toString() + "_" + originalFileName;

            // 4. 파일 생성
            File file1 = new File(uploadPath + savedFileName);

            // 5. 서버로 전송
            file.transferTo(file1);
        }

        model.addAttribute("originalFilenameList", originalFilenameList);

        return "upload/fileUploadMultipleResult";
    }

    // 파일 다운로드 처리
    @RequestMapping("/fileDownload/{file}")
    public void fileDownload(@PathVariable String file, HttpServletResponse response) throws IOException {
        File f = new File("file:///Users/hyeonji/full_stack_study/upload", file);

        // file 다운로드 설정
        response.setContentType("application/download");
        response.setContentLength((int)f.length());
        response.setHeader("Content-Disposition", "attatchment;filename=\"" + file + "\"");

        // response 객체를 통해서 서버로부터 파일 다운로드
        OutputStream os = response.getOutputStream();

        // file 입력 객체 생성
        FileInputStream fis = new FileInputStream(f);
        FileCopyUtils.copy(fis, os);

        fis.close();
        os.close();
    }
}
