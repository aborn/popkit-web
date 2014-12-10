package org.popkit.action;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.popkit.datatypes.enums.StatusCodeEnum;

import java.io.*;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author guobao.jiang
 * @date 12/8/14
 * @time 12:13 AM
 */
public class FileUploadAction extends BaseAction {
    private File upload;

    private String uploadFileName;

    private String server;

    private String path;

    @Override
    public String execute() throws Exception {
        if (upload == null || StringUtils.isBlank(uploadFileName)) {
            data.put("status", StatusCodeEnum.PARAM_ILLEGAL.getValue());
            data.put("info", "未选中任何文件!");
            response.getWriter().print(data.toString());
            return null;
        }

        String md5 = getFileMd5Value(upload);
        String md5Another = getFileMD5(upload);
        if (!md5.equals(md5Another)) {
            data.put("status", StatusCodeEnum.SUCCESS.getValue());
            data.put("md5", "error");
        } else {
            if (md5 != null) {
                data.put("status", StatusCodeEnum.SUCCESS.getValue());
                data.put("md5", md5);
            } else {
                data.put("status", StatusCodeEnum.FAILED.getValue());
            }
        }
        response.getWriter().print(data.toString());
        return null;
    }

    private String getFileMD5(File file) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            InputStream is = new FileInputStream(file);
            DigestUtils.md5Hex(is);
        } catch (NoSuchAlgorithmException e) {
            // do nothing
        } catch (IOException e) {
            // do nothing
        }
        return null;
    }

    private String getFileMd5Value(File file) throws FileNotFoundException{
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
