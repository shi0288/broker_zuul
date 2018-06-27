package com.xyauto.interact.broker.zuul.util.duiba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class AssembleTool {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssembleTool.class);

    public static String assembleUrl(String url, Map<String, String> params) {
        if (!url.endsWith("?")) {
            url += "?";
        }
        int i = 0;
        for (String key : params.keySet()) {

            LOGGER.info("AssembleTool key:" + key);
            if (!StringUtils.isEmpty(params.get(key))) {
                try {
                    i++;
                    url += key + "=" + URLEncoder.encode(params.get(key), "utf-8");
                    if (i < params.size()) {
                        url += "&";
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        LOGGER.info("AssembleTool url:" + url);
        return url;
    }

}
