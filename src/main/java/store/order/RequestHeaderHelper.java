package store.order;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

class RequestHeaderHelper {
    static String idAccount() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
            .getRequest().getHeader("id-account");
    }
}