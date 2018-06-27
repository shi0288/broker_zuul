package com.xyauto.interact.broker.zuul.controller;

import com.mcp.validate.annotation.Check;
import com.xyauto.interact.broker.zuul.cloud.MaterielCloud;
import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;

import static com.xyauto.interact.broker.zuul.enums.ResultCode.RABBIT_CONTENT_NULL;


/**
 * Created by shiqm on 2018-03-09.
 */

@RestController
@RequestMapping("/materiel")
public class MaterielController extends BaseController {

    @Autowired
    private MaterielCloud materielCloud;

    /**
     * 创建物料信息
     */
    @RequestMapping(value = "receive", method = RequestMethod.POST)
    public Result add(
            @Check(name = "物料标题", required = false, defaultValue = "") String name,
            @Check(name = "物料摘要", required = false, defaultValue = "") String summary,
            @Check(name = "内容", required = false, defaultValue = "") String content,
            @Check(name = "阅读数", required = false, defaultValue = "0") Integer viewCount,
            @Check(name = "点赞数", required = false, defaultValue = "0") Integer agreeCount,
            @Check(name = "封面图", required = false, defaultValue = "") String image,
            @Check(name = "物料文章类型", required = false, defaultValue = "1") Short contentType,
            @Check(name = "物料来源", required = false) Short source,
            @Check(name = "物料类型", required = false) Short type,
            @Check(name = "数据id", required = false, defaultValue = "") String originalId,
            @Check(name = "发布时间", required = false, defaultValue = "") String publishTime,
            @Check(name = "来源名称", required = false, defaultValue = "") String sourceName,
            @Check(name = "物料分类名称", required = false, defaultValue = "") String categoryName,
            @Check(name = "物料标签", required = false, defaultValue = "") String tag,
            @Check(name = "物料标识ID", required = false, defaultValue = "") String taskId,
            @Check(name = "物料文章评分", required = false, defaultValue = "0") BigDecimal score,
            @Check(name = "城市ID", required = false, defaultValue = "") String cityIds,
            @Check(name = "省份ID", required = false, defaultValue = "") String provinceIds,
            @Check(name = "城市名称", required = false, defaultValue = "") String cityName,
            @Check(name = "是否关联车型", required = false, defaultValue = "0") Short isJoinCar,
            @Check(name = "关联品牌", required = false, defaultValue = "") String brandIds,
            @Check(name = "关联车型", required = false, defaultValue = "") String serialIds,
            @Check(name = "关联经销商ID", required = false, defaultValue = "") String dealerIds,
            @Check(name = "问答类型", required = false, defaultValue = "0") Short askType,
            @Check(name = "经纪人ID", required = false, defaultValue = "0") Long askUid,
            @Check(name = "问答ID", required = false, defaultValue = "0") Long askId
    ) {
        if ("{content}".equals(content)) {
            return result.format(RABBIT_CONTENT_NULL);
        }
        content = content.replaceAll("\\\\", "");
        content = URLEncoder.encode(content).toString();
        name = name.replaceAll("\\\\", "");
        name = URLEncoder.encode(name).toString();
        result = materielCloud.add(
                name, summary, content, viewCount, agreeCount,
                image, contentType, source, type, originalId,
                publishTime, sourceName, categoryName, tag,
                taskId, score, cityIds, provinceIds, cityName,
                isJoinCar, brandIds, serialIds, dealerIds,
                askType, askUid, askId);
//        result = materielCloud.add(new HashMap() {{
//            put("name", name);
//            put("summary", summary);
//            put("content", content);
//            put("viewCount", viewCount);
//            put("agreeCount", agreeCount);
//            put("image", image);
//            put("contentType", contentType);
//            put("source", source);
//            put("type", type);
//            put("originalId", originalId);
//            put("publishTime", publishTime);
//            put("sourceName", sourceName);
//            put("categoryName", categoryName);
//            put("tag", tag);
//            put("taskId", taskId);
//            put("score", score);
//            put("cityIds", cityIds);
//            put("provinceIds", provinceIds);
//            put("cityName", cityName);
//            put("isJoinCar", isJoinCar);
//            put("brandIds", brandIds);
//            put("serialIds", serialIds);
//            put("dealerIds", dealerIds);
//            put("askType", askType);
//            put("askUid", askUid);
//            put("askId", askId);
//        }});
        return result;
    }


    /**
     * 物料列表max
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Result list(
            @Check(name = "经纪人id", required = false) Long broker_id,
            @Check(name = "来源", required = false) Long source,
            @Check(name = "max", required = false) String max,
            @Check(name = "limit", required = false) Integer limit
    ) {
        result = materielCloud.list(new HashMap() {{
            put("broker_id", broker_id);
            put("source", source);
            put("max", max);
            put("limit", limit);
        }});
        return result;
    }

    /**
     * 物料列表page
     */
    @RequestMapping(value = "plist", method = RequestMethod.GET)
    public Result plist(
            @Check(name = "经纪人id", required = false) Long broker_id,
            @Check(name = "来源", required = false) Long source,
            @Check(name = "max", required = false) Integer page,
            @Check(name = "limit", required = false) Integer limit
    ) {
        result = materielCloud.plist(new HashMap() {{
            put("broker_id", broker_id);
            put("source", source);
            put("page", page);
            put("limit", limit);
        }});
        return result;
    }

    /**
     * 物料详情
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result plist(
            @Check(name = "经纪人id", required = false) Long broker_id,
            @Check(name = "物料id", required = false) Long materiel_id

    ) {
        result = materielCloud.get(new HashMap() {{
            put("broker_id", broker_id);
            put("materiel_id", materiel_id);
        }});
        return result;
    }

    @RequestMapping(value = "del", method = RequestMethod.GET)
    public Result del(
            @Check(name = "经纪人id", required = false) Long broker_id,
            @Check(name = "物料id", required = false) Long materiel_id
    ) {
        result = materielCloud.del(new HashMap() {{
            put("broker_id", broker_id);
            put("materiel_id", materiel_id);
        }});
        return result;
    }


    @RequestMapping(value = "head", method = RequestMethod.GET)
    public Result head() {
        result = materielCloud.head();
        return result;
    }


}
