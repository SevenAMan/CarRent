package org.teamwe.carrent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.teamwe.carrent.controller.utils.Format;
import org.teamwe.carrent.utils.ReturnStatus;
import org.teamwe.carrent.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author FDws
 * Created on 2018/6/18 14:02
 */
@RestControllerAdvice
public class GlobalController {

    private static Logger log = LoggerFactory.getLogger(GlobalController.class);

    @ExceptionHandler(value = NumberFormatException.class)
    public Format paramConvertExceptionAdvice() {
        return new Format().code(ReturnStatus.FAILURE).message(StringUtil.PARAM_ILLEGAL);
    }

    @ExceptionHandler(value = Exception.class)
    public Format otherException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage());
        saveRequestInfo(request);
        return new Format().code(ReturnStatus.FAILURE).message(StringUtil.ERROR_OCCUR).addData("message",e.getMessage());
    }

    private void saveRequestInfo(HttpServletRequest request) {
        log.error("URI: " + request.getRequestURI());
        showParam(request);
        showHeaders(request);
        showSessionInfo(request.getSession());
    }

    private void showSessionInfo(HttpSession session) {
        if (session != null) {
            log.error("Session Information: ");
            Enumeration<String> ss = session.getAttributeNames();
            while (ss.hasMoreElements()) {
                String key = ss.nextElement();
                log.error(key + " : " + session.getAttribute(key));
            }
        }
    }

    private void showHeaders(HttpServletRequest request) {
        Enumeration<String> hh = request.getHeaderNames();
        log.error("Header Information: ");
        while (hh.hasMoreElements()) {
            String key = hh.nextElement();
            log.error(key + " : " + request.getHeader(key));
        }
    }

    private void showParam(HttpServletRequest request) {
        Map<String, String[]> rr = request.getParameterMap();
        log.error("Request parameters information: ");
        for (String key : rr.keySet()) {
            StringBuilder sb = new StringBuilder(key + " : [");
            for (String s : rr.get(key)) {
                sb.append(s).append(", ");
            }
            sb.append("]");
            log.error(sb.toString());
        }
    }
}
