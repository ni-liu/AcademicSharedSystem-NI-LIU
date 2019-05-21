package com.javaee.ass.utils;

import com.aliyun.oss.OSSClient;
import com.javaee.ass.entity.enums.FileTypeEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;


public class OSSOperationUtils {
    private static OSSClient client = null;
    private static File tmpFile = null;

    private static void initialOSSClient() {
        if (client == null) {
            client = new OSSClient(FinalVariablesUtils.OSS_ENDPOINT ,
                    FinalVariablesUtils.OSS_ACCESS_KEY_ID ,
                    FinalVariablesUtils.OSS_ACCESS_KEY_SECRET);
        }
    }

    /**
     * 上传课程文件 （不包括实验和模拟试卷） 支持重传
     * 文件统一用课程号作为key
     * @param type 上传文件目录
     * @param file 文件
     * @param courseId 课程号
     */
    public static String uploadCourseGeneralFile(FileTypeEnum type , File file , String courseId) {
        StringBuilder objectNameStr = new StringBuilder();
        StringBuilder url = new StringBuilder("https://")
                .append(FinalVariablesUtils.OSS_BUCKET)
                .append(".")
                .append(FinalVariablesUtils.OSS_ENDPOINT)
                .append("/");
        initialOSSClient();
        switch (type.getType()) {
            case 1 : {  // FileTypeEnum.COURSE_EXPS
                objectNameStr.append("courses/pic/").append(courseId);
                url.append(objectNameStr);
                break;
            }
            case 2 : { // FileTypeEnum.COURSE_OUTLINES
                objectNameStr.append("courses/outlines/").append(courseId);
                url.append(objectNameStr);
                break;
            }
        }
        // 检查文件是否存在
        if (client.doesObjectExist(FinalVariablesUtils.OSS_BUCKET , objectNameStr.toString() , true)) {
            // 重传
            client.deleteObject(FinalVariablesUtils.OSS_BUCKET , objectNameStr.toString()); // 删除
            client.putObject(FinalVariablesUtils.OSS_BUCKET ,
                    objectNameStr.toString() ,
                    file
            ); // 重新上传
            System.out.println("url:" + url);
            tmpFile.deleteOnExit();
        } else {
            client.putObject(FinalVariablesUtils.OSS_BUCKET ,
                    objectNameStr.toString() ,
                    file
            );
            System.out.println("url:" + url);
            tmpFile.deleteOnExit();
        }
        client.shutdown();
        return url.toString();
    }

    /**
     * MultipartFile 转换成 File
     * @param mvcFile 表单提交的文件
     * @return File
     */
    public static File transferMultipartFileType(MultipartFile mvcFile) {
        StringBuilder fileName = new StringBuilder();
        if (mvcFile != null) {
            fileName.append(mvcFile.getOriginalFilename());
            String filePrefix = fileName.toString().substring(fileName.lastIndexOf("."));
            try {
                tmpFile = File.createTempFile(UUID.randomUUID().toString() , filePrefix);
                mvcFile.transferTo(tmpFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tmpFile;
    }

}
