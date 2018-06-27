package com.xyauto.interact.broker.zuul.util.cons;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shiqm on 2018-03-20.
 */

@Component
@ConfigurationProperties(prefix = "xyauto.cors")
public class CorsCons {

    private Set<String> allowed_origins = new HashSet<String>();


    public Set<String> getAllowed_origins() {
        return allowed_origins;
    }

    public void setAllowed_origins(Set<String> allowed_origins) {
        this.allowed_origins = allowed_origins;
    }
}
