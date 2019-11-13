package com.dong.demo.component;

import com.dong.demo.service.IReportPublicApiService;
import com.dong.demo.vo.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReportGlobal implements InitializingBean{

   /* @Resource
    private IReportPublicApiService iReportPublicApiService;*/

    public static Map reportWeightMap;          //缓急（特指机要文件缓急）
    public static Map webModuleMap;             //网站板块


    public static Map reportSendTypeMap;        //发文类型{9099e80f4b0d4464b66269f288bd9862=集团, 7fa0856b1a144a73aafa8f2f5a5e7679=股份}
    public static Map reportSendTemplateMap;    //发文模板{cc9090e89647430aa7fcd4a9e7f51b35=股份党委会议纪要, 5ae06f13917341a3ad59df7cced325dc=中设股份函, ffae46faf5cd4be190fe98d740241638=集团党委发文, 911d1fc36e5249f4a39044f0a4338e59=股份党委发文, 8a388590019b4845b5678940bcc5ae09=中南设计党函, 5e2b2da3203d49e3b24adffd98fc11e2=股份行政发文, 55eec468fb9745ecbd0ae6d01d0a8033=股份行政会议纪要, cecc9e65aff84c7aa5659560c6263750=中南设计资讯, b5e83ab10cb044c0af3ba8e2482afc36=中设股份党函, edf528f191494e0a934a479025284bb9=集团党委会议纪要, 22a8dd15c3c5481cb6f910c10814c839=集团行政会议纪要, 48d5a1d98f3946168733242102449aa5=中南设计函, b73c67e46bed4ff1ba225b5e29b4bed4=集团行政发文}
    public static Map reportSendProxyMap;       //发文代字{98f6dea88efb41d49db85ed6a3339549=中南设计监审, e4739405b6784b0a9b5dad50c8d42032=中南设计投, 8549ce3638574f7aa20754debde17082=中南设计政法, 5c933892968745b1a6a7aaa9c50c9a4e=中南设计人, 71aa9740c1c940098f19b0e760af7949=中南设计党, 7d615bd64ce44b489735808dd9c058c3=中南设计财, 18972d5aa1604013ac28fb03c5bc49f9=中设股份文, 2f54d72337b74164b39cb61d72db0737=中南设计函, c0db7295dcd84b999a3aebd9fb9725c2=中设股份政法, 05c5432e8ac8449f807f1844ad904f87=中南设计监, cf3200196a1449c1a39cfdaba9d96b89=中设股份经, e2589f0ac40340c0abd1d28ad1c9f25a=中南设计资讯, b45c0ae5b9684bb5b13be33417ae74aa=中设股份财, 096a33d22bbb4d58927d5ad469dfb1fe=中南设计党任, 5e23fe6cf3c244698464113e1db5fb04=中南设计文, 89f8f53243b04fccaaf1eb7a308ba2a9=中南设计党任, 41154a1afc8540e2b7916e4f8c709b43=中南设计党任, 577f4f128c27423b93df663a91207a32=中设股份办, 42eb34ec93624441a9915a5b7d0cdb02=中南设计党函, ba72a3a4b94c4d75a8a44239db77fc76=中设股份监, 4d81bd91ecec4808b0520ca1aff786e8=中设股份人, f9d3d8fda0bf469b84d01a887789643f=中南设计经, 44d59ad5861844779414966549fbd696=中设股份监审, ff19fadfa58f4ac5bcf76dc7070883ae=中设股份审, f779fdcb85e94cb29d4e916eb4cd2ef1=中南设计党办, f04a5023acbb4a1daa41c20512905ca9=中设股份党, f52d61be114a4dc8af736c04e6e5a6a4=党委会议纪要, dc7a8cbd9c3849d9bd4a9a05eb42be63=中设股份党办, 84439f21157e4860a073a01cbd1a2c50=中设股份投, ec0a7a5e11524f919708fa46ef00a4ca=中设股份党函, a6d2bf82516e4eb19c3952113dd89071=中南设计办, a33020357567403c8d620cfe182c5411=中设股份党任, cbf54da080e94983a596414d34b30cbd=中南设计技, 0b65c7435957474fa0e1e0390f7324ff=党委会议纪要}

    public static Map reportReceiveTypeMap;     //收文类型
    public static Map reportReceiveTemplateMap; //收文模板

    /*ReportGlobal.reportSendTypeMap==========>
    ReportGlobal.reportSendTemplateMap==========>ReportGlobal.reportSendProxyMap==========>
*/

    @Override
    public void afterPropertiesSet() throws Exception {
        //主要以查询数据库内容为主
        //this.setGlobalData();
    }

   /* public void setGlobalData() {
        DictionaryRV dictionaryRV = iReportPublicApiService.getPublicResource();
        reportWeightMap = new HashMap<Integer,String>();
        for(ReportWeight reportWeight : dictionaryRV.getReportWeights()){
            reportWeightMap.put(reportWeight.getDictValueInt(),reportWeight.getDictName());
        }

        webModuleMap = new HashMap<Integer,String>();
        for(WebModule webModule : dictionaryRV.getWebModules()){
            webModuleMap.put(webModule.getDictValueInt(),webModule.getDictName());
        }

        //{9099e80f4b0d4464b66269f288bd9862=集团, 7fa0856b1a144a73aafa8f2f5a5e7679=股份}
        reportSendTypeMap =  new HashMap<String,String>();
        for(ReportTypeV reportTypeV : dictionaryRV.getReportSendTypes()){
            reportSendTypeMap.put(reportTypeV.getReportTypeId(), reportTypeV.getReportTypeName());
        }

        reportSendTemplateMap = new HashMap<String,String>();
        for(ReportTypeV reportTypeV : dictionaryRV.getReportSendTypes()){
            for(ReportTemplate reportTemplate : reportTypeV.getReportTemplates()){
                reportSendTemplateMap.put(reportTemplate.getReportTemplateId(),reportTemplate.getReportTemplateName());
            }
        }

        reportSendProxyMap = new HashMap<String,String>();
        for(ReportTypeV reportTypeV : dictionaryRV.getReportSendTypes()){
            for(ReportTemplate reportTemplate : reportTypeV.getReportTemplates()){
                for(Proxy proxy : reportTemplate.getProxys()){
                    reportSendProxyMap.put(proxy.getProxyId(),proxy.getProxyName());
                }
            }
        }

        //收文的reportReceiveTypeMap集合
        reportReceiveTypeMap = new HashMap<String,String>();
        for(ReportTypeV reportReceiveType : dictionaryRV.getReportReceiveTypes()){
            reportReceiveTypeMap.put(reportReceiveType.getReportTypeId(),reportReceiveType.getReportTypeName());
        }

        reportReceiveTemplateMap = new HashMap<String,String>();
        for(ReportTypeV reportReceiveType : dictionaryRV.getReportReceiveTypes()){
            for(ReportTemplate reportReceiveTemplate : reportReceiveType.getReportTemplates()){
                reportReceiveTemplateMap.put(reportReceiveTemplate.getReportTemplateId(),reportReceiveTemplate.getReportTemplateName());
            }
        }

    }*/
}

