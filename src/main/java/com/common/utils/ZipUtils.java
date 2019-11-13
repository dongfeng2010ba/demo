package com.common.utils;

import com.dong.exception.RException;
import com.dong.enums.REnum;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: songguoxi
 * @Date: 2019/7/31
 * @Description: 文件压缩解压工具
 */

public class ZipUtils {

    private static  final Logger LOG = LoggerFactory.getLogger(ZipUtils.class);
    public static void unzip(String srcRarPath, String dstDirectoryPath,String unZipPassword) throws ZipException {
        try {
            File zipFile = new File(srcRarPath);
            ZipFile zFile = new ZipFile(zipFile);  // 首先创建ZipFile指向磁盘上的.zip文件
            zFile.setFileNameCharset("GBK");
            File destDir = new File(dstDirectoryPath);     // 解压目录
            if (zFile.isEncrypted()) {
                if(unZipPassword==null){
                    //解压密码为空时 使用默认解压密码,默认为""
                    unZipPassword="";
                }
                zFile.setPassword(unZipPassword.toCharArray());  // 设置密码
            }
            zFile.extractAll(dstDirectoryPath);      // 将文件抽出到解压目录(解压)
            List<net.lingala.zip4j.model.FileHeader> headerList = zFile.getFileHeaders();
            List<File> extractedFileList = new ArrayList<>();
            for (FileHeader fileHeader : headerList) {
                if (!fileHeader.isDirectory()) {
                    extractedFileList.add(new File(destDir, fileHeader.getFileName()));
                }
            }

            //后期用日志记录
            for (File f : extractedFileList) {
                LOG.info(f.getAbsolutePath() + "....");
            }
        } catch (ZipException e) {
            LOG.error("文件压缩错误，解压文件路径{}，解压目标路径{}",srcRarPath,dstDirectoryPath,e);
            throw e;
        }
    }


    /**
     *   对一个目录压缩，压缩文件和源目录同级
     * @param sourceDir 源目录
     * @param zipFileName 压缩文件名
     * @return
     */
    public static ZipFile createZipFile(String sourceDir,String zipFileName ) {
        //源目录
        File file=new File(sourceDir);
        //非目录
        if(!file.isDirectory()){
            throw  new RException(REnum.NOT_DIRECTORY);
        }
        //不存在
        if(!file.exists()){
            throw  new RException(REnum.FILE_NOT_EXISTS);
        }

        String  parentDir=file.getParent();

        // 创建zip包，指定了zip路径和zip名称
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(parentDir + File.separator + zipFileName);
            // 设置zip包的一些参数集合
            final ZipParameters parameters = new ZipParameters();
            // 压缩方式(默认值)
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            // 普通级别（参数很多）
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            // 加密级别
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            zipFile.addFolder(sourceDir,parameters);
        } catch (ZipException e) {
            LOG.error("文件压缩错误，压缩目录{}，压缩文件名{}",sourceDir,zipFileName,e);
            throw  new RException(REnum.ZIP_ERROR);
        }
        return  zipFile;

    }

    /**
     * 加密文件并导出
     *
     * @param files           要进行压缩的文件
     * @param passwordZip     压缩密码
     * @param templatePathZip 压缩包路径
     * @param fileName        压缩文件名
     * @return zip文件
     */
    public static ZipFile createZipFile(String passwordZip, String templatePathZip, String fileName, List<File> files) {
        try {
            // 创建zip包，指定了zip路径和zip名称
            final ZipFile zipFile = new ZipFile(templatePathZip + File.separator + fileName);
            // 向zip包中添加文件集合
            final ArrayList<File> fileAddZip = new ArrayList();
            File file1 = zipFile.getFile();
            // 判断是否存在
            if (file1.exists()) {
                file1.delete();
            }
//             向zip包中添加文件
            for (File file : files) {
                fileAddZip.add(file);
            }

            // 设置zip包的一些参数集合
            final ZipParameters parameters = new ZipParameters();
            // 是否设置密码（若passwordZip为空，则为false）
            if (null != passwordZip && !passwordZip.equals("")) {
                parameters.setEncryptFiles(true);
                // 压缩包密码
                parameters.setPassword(passwordZip);
            } else {
                parameters.setEncryptFiles(false);
            }
            // 压缩方式(默认值)
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            // 普通级别（参数很多）
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            // 加密级别
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            // 创建压缩包完成
            zipFile.createZipFile(fileAddZip, parameters);
            return zipFile;
        } catch (final ZipException e) {
            e.printStackTrace();
            return null;
        }

    }



}



