package io.pivotal.tg;

import com.google.common.collect.Maps;
//import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

//@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
/**
 * Overrides default error handling behaviour defined in <code>org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler</code>
 */
public class DefaultExceptionHandler {

    @RequestMapping(produces = {"application/vnd.pivotal-v1.0+json", "application/vnd.pivotal-v2.0+json"})
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public
    @ResponseBody
    Map<String, Object> handleUncaughtException(Exception ex) throws IOException {
        Map<String, Object> map = Maps.newHashMap();
        map.put("error", "Unknown Error");
        if (ex.getCause() != null) {
            map.put("cause", ex.getCause().getMessage());
        } else {
            map.put("cause", ex.getMessage());
        }
        return map;
    }

    @RequestMapping(produces = {"application/vnd.pivotal-v1.0+json", "application/vnd.pivotal-v2.0+json"})
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public
    @ResponseBody
    Map<String, Object> handleUnsupportedMediaTypeException(HttpMediaTypeNotSupportedException ex) throws IOException {
        Map<String, Object> map = Maps.newHashMap();
        map.put("error", "Unsupported Media Type");
        map.put("cause", ex.getLocalizedMessage());
        map.put("supported", ex.getSupportedMediaTypes());
        return map;
    }

    @RequestMapping(produces = {"application/vnd.pivotal-v1.0+json", "application/vnd.pivotal-v2.0+json"})
    @ExceptionHandler({MissingServletRequestParameterException.class,
            UnsatisfiedServletRequestParameterException.class,
            HttpRequestMethodNotSupportedException.class,
            ServletRequestBindingException.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public
    @ResponseBody
    Map<String, Object> handleRequestException(Exception ex) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("error", "Request Error");
        map.put("cause", ex.getMessage());
        return map;
    }

}
