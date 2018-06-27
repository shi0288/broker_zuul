package com.xyauto.interact.broker.zuul.cloud;

import com.mcp.fastcloud.annotation.ServerName;
import com.xyauto.interact.broker.zuul.util.Result;
import feign.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by shiqm on 2018-03-09.
 */

@ServerName("QCDQ-QA-SP")
public interface MaterielCloud {

    @RequestLine("POST /materiel/receive")
    Result add(@QueryMap Map map);



    @RequestLine("POST /materiel/receive")
    @Body("name={name}" +
                    "&summary={summary}" +
                    "&content={content}" +
                    "&viewCount={viewCount}" +
                    "&agreeCount={agreeCount}" +
                    "&image={image}" +
                    "&contentType={contentType}" +
                    "&source={source}" +
                    "&type={type}" +
                    "&originalId={originalId}" +
                    "&publishTime={publishTime}" +
                    "&sourceName={sourceName}" +
                    "&categoryName={categoryName}" +
                    "&tag={tag}"+
                    "&taskId={taskId}"+
                    "&score={score}"+
                    "&cityIds={cityIds}"+
                    "&provinceIds={provinceIds}"+
                    "&cityName={cityName}"+
                    "&isJoinCar={isJoinCar}"+
                    "&brandIds={brandIds}"+
                    "&serialIds={serialIds}"+
                    "&dealerIds={dealerIds}"+
                    "&askType={askType}"+
                    "&askUid={askUid}"+
                    "&askId={askId}"
    )
    Result add(
            @Param("name")String name,
            @Param("summary")String summary,
            @Param("content")String content,
            @Param("viewCount")Integer viewCount,
            @Param("agreeCount")Integer agreeCount,
            @Param("image")String image,
            @Param("contentType")Short contentType,
            @Param("source")Short source,
            @Param("type")Short type,
            @Param("originalId")String originalId,
            @Param("publishTime")String publishTime,
            @Param("sourceName")String sourceName,
            @Param("categoryName")String categoryName,
            @Param("tag")String tag,
            @Param("taskId")String taskId,
            @Param("score")BigDecimal score,
            @Param("cityIds")String cityIds,
            @Param("provinceIds")String provinceIds,
            @Param("cityName")String cityName,
            @Param("isJoinCar")Short isJoinCar,
            @Param("brandIds")String brandIds,
            @Param("serialIds")String serialIds,
            @Param("dealerIds")String dealerIds,
            @Param("askType")Short askType,
            @Param("askUid")Long askUid,
            @Param("askId")Long askId
    );

    @RequestLine("GET /materiel/list")
    Result list(@QueryMap Map map);

    @RequestLine("GET /materiel/plist")
    Result plist(@QueryMap Map map);

    @RequestLine("GET /materiel/get")
    Result get(@QueryMap Map map);

    @RequestLine("GET /materiel/del")
    Result del(@QueryMap Map map);

    @RequestLine("GET /materiel/head")
    Result head();

}
