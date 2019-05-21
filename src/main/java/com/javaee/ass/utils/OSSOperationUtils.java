package com.javaee.ass.utils;

        import com.aliyun.oss.OSSClient;
        import com.javaee.ass.entity.enums.FileTypeEnum;
        import com.javaee.ass.entity.enums.RoleEnum;
        import com.javaee.ass.entity.role.StudentDO;
        import org.apache.poi.hssf.usermodel.HSSFCell;
        import org.apache.poi.hssf.usermodel.HSSFWorkbook;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import org.springframework.web.multipart.MultipartFile;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.List;
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
    public static String uploadCourseFile(FileTypeEnum type , File file , String courseId) {
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
            case 3 : { // FileTypeEnum.COURSE_EXPS
                objectNameStr.append("courses/exps/")
                        .append(courseId).append("/").append(generateDateFormat());
                url.append(objectNameStr);
                break;

            }
            case 4 : {
                objectNameStr.append("courses/testPapers/")
                        .append(courseId).append("/").append(generateDateFormat());
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
        } else {
            client.putObject(FinalVariablesUtils.OSS_BUCKET ,
                    objectNameStr.toString() ,
                    file
            );
            System.out.println("url:" + url);
        }
        return url.toString();
    }

    public static String uploadBlogGeneralFile(FileTypeEnum type , File file , String userId ,String launchTime){

        StringBuilder objectNameStr = new StringBuilder();
        StringBuilder url = new StringBuilder("https://")
                .append(FinalVariablesUtils.OSS_BUCKET)
                .append(".")
                .append(FinalVariablesUtils.OSS_ENDPOINT)
                .append("/");
        initialOSSClient();
        switch (type.getType()) {
            case 5 : {  // FileTypeEnum.BLOG_ATTACHMENT
                objectNameStr.append("blogs/blogAttachment/").append(userId).append("/").append(userId).append(launchTime);
                url.append(objectNameStr);
                break;
            }
            case 6 : { // FileTypeEnum.BLOG_CONTENT
                objectNameStr.append("blogs/blogContent/").append(userId).append("/").append(userId).append(launchTime);
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
//            tmpFile.deleteOnExit();
        } else {
            client.putObject(FinalVariablesUtils.OSS_BUCKET ,
                    objectNameStr.toString() ,
                    file
            );
            System.out.println("url:" + url);
//            tmpFile.deleteOnExit();
        }
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
            System.out.println(fileName);
            String filePrefix = fileName.toString().substring(fileName.lastIndexOf("."));
            try {
                tmpFile = File.createTempFile(UUID.randomUUID().toString() , filePrefix);
                mvcFile.transferTo(tmpFile);
                System.out.println("MultipartFile -> File 转化成功 / 临时文件名：" + tmpFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tmpFile;
    }
    /**
     * 格式化时间
     * @return 时间戳
     */
    private static String generateDateFormat() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        long now = System.currentTimeMillis();
        return format.format(now);
    }

    public static String uploadStuExpFiles(File file , int expId , String courseId , String stuId) {
        String objectNameStr = "courses/uploadExps/" +
                courseId +
                "/" +
                stuId +
                "_" +
                expId;
        StringBuilder url = new StringBuilder("https://")
                .append(FinalVariablesUtils.OSS_BUCKET)
                .append(".")
                .append(FinalVariablesUtils.OSS_ENDPOINT)
                .append("/")
                .append(objectNameStr);
        initialOSSClient();
        // 检查文件是否存在
        if (client.doesObjectExist(FinalVariablesUtils.OSS_BUCKET , objectNameStr , true)) {
            // 重传
            client.deleteObject(FinalVariablesUtils.OSS_BUCKET , objectNameStr); // 删除
            client.putObject(FinalVariablesUtils.OSS_BUCKET ,
                    objectNameStr.toString() ,
                    file
            ); // 重新上传
            System.out.println("url:" + url);
        } else {
            client.putObject(FinalVariablesUtils.OSS_BUCKET ,
                    objectNameStr.toString() ,
                    file
            );
            System.out.println("url:" + url);
        }
        return  url.toString();
    }

    /**
     * 批处理插入学生准备工作
     * @param file 文件
     * @return 学生list
     */
    public static List<StudentDO> patchPreparedStuData(File file) {
        List<StudentDO> patchList = new ArrayList<>();
        Workbook workbook = null;
        try {
            if (file.isFile() && file.exists()) {
                String[] prefixName = file.getName().split("\\.");
                if ("xls".equals(prefixName[1])) {
                    FileInputStream stream = new FileInputStream(file);
                    workbook = new HSSFWorkbook(stream);
                } else if ("xlsx".equals(prefixName[1])) {
                    workbook = new XSSFWorkbook(file);
                } else {
                    System.err.println("文件错误");
                    return patchList;
                }
            }

            Sheet sheet = Objects.requireNonNull(workbook).getSheetAt(0);

            int firstRow = sheet.getFirstRowNum() + 1; // 第一行为属性名
            int lastRow = sheet.getLastRowNum(); // 最后一行

            System.out.println(firstRow + " " + lastRow);

            // 遍历添加到List中

            for(int rIndex = firstRow ; rIndex <= lastRow ; rIndex++) {
                Row row = sheet.getRow(rIndex);
                StudentDO studentDO = new StudentDO();
                studentDO.setRole(RoleEnum.ROLE_STUDENT);
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                        Cell cell = row.getCell(cIndex);
                        if (cell != null) {
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            switch (cIndex) {
                                case 0 : {
                                    studentDO.setPkId(cell.toString());
                                    break;
                                }
                                case 1 : {
                                    studentDO.setPassword(cell.toString());
                                    break;
                                }
                                case 3 : {
                                    studentDO.setNickName(cell.toString());
                                    break;
                                }
                                case 4 : {
                                    studentDO.setName(cell.toString());
                                    break;
                                }
                                case 5 : {
                                    studentDO.setMajorId(cell.toString());
                                }
                            }
                        }
                    }
                }
                patchList.add(studentDO);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  patchList;
    }

}
