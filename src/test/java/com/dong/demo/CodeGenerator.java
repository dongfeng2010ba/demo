package com.dong.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class  CodeGenerator {

    public static void main(String[] args) {

//        String[] include = new String[]{"cp_dictionary_data","cp_dictionary_sys","cp_node_employee","cp_report_read","cp_process_history","cp_process_node",
//                "cp_process_statistic","cp_report_attachment","cp_report_delete","cp_report_no","cp_report_read",
//                "cp_report_read_statistic","cp_report_read_summary","cp_report_receive","cp_report_refer","cp_report_remind","cp_report_send","cp_report_todo"};
        String[] include = new String[]{"cp_portal_column"};
//        String[] include = new String[]{"cp_node_employee"};
//        String[] include = new String[]{"test_message"};
        String packageName = "com.ceei";
        //模块名称
        String moduleName = "release";
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        /**全局配置****************************************************************************************************/
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("dlj");                                  //设置作者
        String projectPath = System.getProperty("user.dir");    //得到当前根目录的路径
        System.out.println("projectPath=====================>"+projectPath);
        gc.setOutputDir(projectPath + "/src/main/java");        //生成文件输出根目录
        gc.setOpen(false);                                      //生成完成后不弹出文件框
        // gc.setSwagger2(true);                                //实体属性 Swagger2Config 注解
        // 自定义文件命名，注意 %s 会自动填充表实体属性！设置文件的后缀名
        // gc.setMapperName("%sDao").setXmlName("%sMapper").setServiceImplName("%sService") .setServiceImplName("%sServiceDiy") .setControllerName("%sAction");
        mpg.setGlobalConfig(gc);
        /**数据源配置**************************************************************************************************/
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://mysql1.dev.ceei.com:32121/cp_release?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setUsername("root");
        dsc.setPassword("rootce");
        dsc.setDbType(DbType.MYSQL);//数据库类型
        // dsc.setSchemaName("public");
        mpg.setDataSource(dsc);
        /**包配置******************************************************************************************************/
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);//父包
        //其他默认包名service、service.impl、entity、controller、mapper.xml
        //pc.setMapper("dao");//指定DAO层的文件所在的包，默认在mapper包里边
        pc.setModuleName(moduleName);  //模块名
        mpg.setPackageInfo(pc);
        /**自定义配置**************************************************************************************************/
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        /**配置模板**************************************************************************************************/
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        /**策略配置****************************************************************************************************/
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);                  //数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        String tablePrefix = "cp_";
        strategy.setTablePrefix(tablePrefix);                                   //表的前缀，我的数据库表名都是以t_开头
        //strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setInclude(include);                                           // 需要生成的表
        // strategy.setExclude(new String[]{"test"});                           // 排除生成的表
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);                                  //生成的Controller类自带@RestController注解
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        /**************************************************************************************************************/
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
