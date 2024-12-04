package com.mouse.effects;

import com.perfree.cache.OptionCacheService;
import com.perfree.plugin.commons.PluginUtils;
import com.perfree.plugin.proxy.HtmlRenderProxy;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class MouseEffectsHandle extends HtmlRenderProxy {

    @Resource
    private OptionCacheService optionCacheService;

    @Override
    public Document editFrontDocument(Document document, HttpServletResponse response, HttpServletRequest request) {
        if (request.getRequestURI().startsWith("/login") || request.getRequestURI().startsWith("/register")) {
            return document;
        }
        String jsName = optionCacheService.getDefaultValue("MOUSE_OFFECTS", "plugin_perfree-plugin-mouse-effects", "snow");
        document.body().append("<script src='/api/plugin-static/perfree-plugin-mouse-effects/"+jsName+".js'></script>");
        return document;
    }
}
