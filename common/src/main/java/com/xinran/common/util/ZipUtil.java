package com.xinran.common.util;

import cn.hutool.core.io.file.FileNameUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Zip文件工具类
 * @author xuehy
 * @since 2022/3/23
 */
public class ZipUtil extends cn.hutool.core.util.ZipUtil {

    //获取zip文件中的所有文件名(不包含路径)
    public static List<String> listFileNames(File file, Charset charset) throws Exception {
        ZipFile zipFile = new ZipFile(file, ZipFile.OPEN_READ, charset);
        return listFileNames(zipFile, (Integer) null);
    }

    //获取zip文件中的所有文件名(不包含路径)
    public static List<String> listFileNames(ZipFile zipFile, Integer maxSize) throws Exception {
        List<String> fileNameList = new ArrayList<>();
        for (ZipEntry zipEntry : Collections.list(zipFile.entries())) {
            if (!zipEntry.isDirectory()) {
                String fileName = FileNameUtil.getName(zipEntry.getName());
                if (maxSize != null) {
                    if (FileUtil.isMaximumExceeded(zipEntry, maxSize)) {
                        throw new Exception("文件大小超过上限(" + maxSize + "MB):" + fileName);
                    }
                }
                fileNameList.add(fileName);
            }
        }
        return fileNameList;
    }

}
