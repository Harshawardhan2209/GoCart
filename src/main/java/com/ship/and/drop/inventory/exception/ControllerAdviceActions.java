//package com.ship.and.drop.inventory.exception;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.ResourceUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.ship.and.drop.inventory.model.ResponsePayload;
//
//import lombok.extern.slf4j.Slf4j;
//
//@ControllerAdvice
//@Slf4j
//public class ControllerAdviceActions {
//
//	@Value("classpath:ErrorCodes/ProfileErrorMapCodes/profile_error.properties")
//	private Resource profileErrorCode;
//
//	private Properties properties;
//
//	@ExceptionHandler(ProfileBaseException.class)
//	public ResponseEntity<ResponsePayload> handleNodataFoundException(
//			ProfileBaseException ex) {
//		ResponsePayload payload = new ResponsePayload();
//		if (!StringUtils.isEmpty(ex.getErrorCode())) {
//			Map<String, String> errorCause = handleExceptionWithCause(ex.getErrorCode(), ex.getApiName());
//			payload.setStatus("FAILED");
//			payload.setCode(errorCause.get("code"));
//			payload.setMessage(errorCause.get("message"));
//			payload.setDescription(errorCause.get("description"));
//			payload.setHttpErrorCode(HttpStatus.BAD_REQUEST);
//		} else {
//			payload.setStatus("FAILED");
//			payload.setCode(ex.getCustomException().getErrorCode());
//			payload.setMessage(ex.getCustomException().getMessage());
//			payload.setDescription(ex.getCustomException().getDescription());
//			payload.setHttpErrorCode(HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<>(payload, payload.getHttpErrorCode());
//	}
//
//	private Map<String, String> handleExceptionWithCause(String errorCode, String apiName) {
//		Map<String, String> messageUnderCause = new HashMap<>();
//		if (properties == null) {
//			properties = new Properties();
//			try {
//				properties.load(profileErrorCode.getInputStream());
//			} catch (IOException e) {
//				log.error("Error Main File Not Found");
//			}
//		}
//		Properties apiProps = new Properties();
//		try {
//			File file = ResourceUtils.getFile("classpath:ErrorCodes/ApiErrorMapCodes/" + apiName + ".properties");
//			if(file.exists())
//				apiProps.load(new FileInputStream(file));
//		} catch (FileNotFoundException e) {
//			log.error("Error API " + apiName + "File Not Found");
//		} catch (IOException e) {
//			log.error("Error API " + apiName + "File Not Found");
//		}
//
//		if (apiProps.containsKey(errorCode)) {
//			String errorMappedCode = apiProps.getProperty(errorCode);
//			messageUnderCause.put("code", properties.getProperty(errorMappedCode + ".code"));
//			messageUnderCause.put("message", properties.getProperty(errorMappedCode + ".message"));
//			messageUnderCause.put("description", properties.getProperty(errorMappedCode + ".description"));
//		}
//		return messageUnderCause;
//
//	}
//
//}
