package com.xinran.common.util;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.xinran.common.constant.CmDateConst;
import com.xinran.common.constant.CmFileConst;
import com.xinran.common.constant.StrConst;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;

/**
 * @author xuehy
 * @since 2023/3/17
 */
public class FileUtil extends cn.hutool.core.io.FileUtil {

    public static final String FILE_TYPE_TXT = ".txt";
    public static final String FILE_TYPE_JPG = ".jpg";
    public static final String FILE_TYPE_PNG = ".png";

    //文件头信息(白名单)
    public static final HashMap<String, String> PIC_FILE_TYPES = new HashMap<>();

    static {
        //文件头信息
        PIC_FILE_TYPES.put(".jpg", "FFD8FF");
        PIC_FILE_TYPES.put(".png", "89504E47");
    }

    /**
     * 判断文件是否为空
     * @param file  {@link MultipartFile}
     * @return  文件是否为空
     */
    public static boolean isEmpty(MultipartFile file) {
        return file == null || file.isEmpty();
    }
    public static boolean isNotEmpty(MultipartFile file) {
        return !isEmpty(file);
    }

    /**
     * 判断文件大小是否超过上限
     * @param file      文件,不能为空
     * @param maxSize   最大大小(MB)
     * @return  是否超过大小上限
     */
    public static boolean isMaximumExceeded(MultipartFile file, Integer maxSize) {
        return (file.getSize() / ((2 << 19) * 1.0)) > maxSize;
    }
    public static boolean isMaximumExceeded(ZipEntry zipEntry, Integer maxSize) {
        return (zipEntry.getSize() / ((2 << 19) * 1.0)) > maxSize;
    }

    //保存图片文件
    public static Result checkAndSaveImg(MultipartFile file, String savePath) throws IOException {
        return checkAndSaveImg(file, savePath, CmFileConst.DEFAULT_MAX_SIZE);
    }
    public static Result checkAndSaveImg(MultipartFile file, String savePath, Integer maxSize) throws IOException {
        return FileUtil.checkAndSaveFile(file, savePath, CmFileConst.ALLOW_IMAGE_TYPES, maxSize);
    }

    //保存文件
    public static void transferFileToDest(MultipartFile file, File dest) throws IOException {
        //若父级不存在，则新建父级
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
    }

    /**
     * 将字符串写入文件(会覆盖原文件,字符集为UTF-8)
     * @param filePath  文件完整路径
     * @return  文件内容
     */
    public static StringBuilder readFile(String filePath) {
        if (StrUtil.isBlank(filePath)) {
            return null;
        }
        File file = new File(filePath);
        if (file.exists()) {
            FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
            return new StringBuilder(fileReader.readString());
        }
        return null;
    }

    /**
     * 将字符串写入文件(会覆盖原文件,字符集为UTF-8)
     * @param path  文件路径
     * @param fileName  文件名称
     * @param context   需要写入的信息
     * @return  文件完整路径
     */
    public static String writeFile(String path, String fileName, String context) {
        path = addSlash(path);
        File dest = new File(path + fileName);
        //若父级不存在，则新建父级
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        FileWriter writer = new FileWriter(dest, StandardCharsets.UTF_8);
        return writer.write(context).getAbsolutePath();
    }

    /**
     * 验证文件大小和格式是否符合要求,若符合要求,则保存文件
     * @param file      {@link MultipartFile}文件
     * @param savePath  文件保存路径,不用以/结尾,后面会跟上自动生成的文件名
     * @param maxSize   文件允许的最大大小,为空,则用默认大小2MB
     * @return          文件名称 eg.20230211_145820326.jpg
     * @throws IOException  IO异常
     */
    public static Result checkAndSaveFile(MultipartFile file, String savePath, String allowTypes, Integer maxSize) throws IOException {
        String fileName = file.getOriginalFilename();
        if (StrUtil.isBlank(fileName)) {
            return Result.errParam("文件名不能为空");
        }
        //判断文件类型
        String fileType = FileNameUtil.extName(fileName);
        if (!allowTypes.contains(fileType.toLowerCase())) {
            return Result.errFileType(fileType);
        }
        //判断文件大小
        if (ObjectUtil.isNull(maxSize)) {
            maxSize = CmFileConst.DEFAULT_MAX_SIZE;
        }
        if (FileUtil.isMaximumExceeded(file, maxSize)) {
            return Result.errFileSize(maxSize);
        }
        //判断是否以"/"结尾
        savePath = addSlash(savePath);
        //生成文件保存路径
        File dest = new File(savePath + CmDateConst.FILE_NAME_FORMAT_1.format(new Date()) + fileType);
        transferFileToDest(file, dest);
        return Result.success(dest.getName());
    }

    /**
     * 保存Base64图片
     * @param path      保存路径
     * @param fileName  文件名称
     * @param base64str 图片Base64值
     */
    public static void saveBase64Img(String path, String fileName, String base64str) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] bytes = decoder.decode(base64str);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            File dest = new File(path + StrConst.SLASH + fileName);
            //若父级不存在，则新建父级
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(dest);
            out.write(bytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将File对象转换为byte[]的形式
     * @param file 文件
     * @return 文件byte[]
     */
    public static byte[] FileToByte(File file) {
        FileInputStream fileInputStream = null;
        byte[] imgData = null;
        try {
            imgData = new byte[(int) file.length()];
            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(imgData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return imgData;
    }

    /**
     * 判断是否是图片
     * @param base64Image
     * @return
     */
    public static byte[] checkImage(String base64Image) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(base64Image);
            ByteArrayInputStream inputStream=new ByteArrayInputStream(bytes);
            Image image = ImageIO.read(inputStream);
            return image != null ? bytes : null;
        } catch(IOException ex) {
            return null;
        }
    }

    //判断路径是否以"/"结尾,如果不是,则在末尾加上"/"
    private static String addSlash(String path) {
        if (path.endsWith(StrConst.SLASH)) {
            return path;
        }
        return path + StrConst.SLASH;
    }

}
