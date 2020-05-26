package com.xuan.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public class Byte2ObjectUtils {
	protected static final Logger log = LoggerFactory.getLogger(Byte2ObjectUtils.class);

	public static Object byteToObject(byte[] bytes) {
		Object object = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);			
			object = ois.readObject();
			return object;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					log.error("e:",e);
				}
			}
			if (bais != null) {
				try {
					bais.close();
				} catch (IOException e) {
					log.error("e:",e);
				}
			}
		}
		return null;
	}

	public static byte[] objectToByte(Object obj) {

		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos =null;;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			return bos.toByteArray();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					log.error("e:",e);
				}
			}
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					log.error("e:",e);
				}
			}
		}
		return null;
	}
}
