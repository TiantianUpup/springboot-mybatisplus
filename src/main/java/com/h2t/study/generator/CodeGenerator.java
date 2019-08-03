package com.h2t.study.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;

/**
 * mybatisplus代码生成器
 *
 * @author hetiantian
 * @date 2019/08/02 22:08
 * @version 1.0
 */
public class CodeGenerator {
    /**
     * 包名
     */
    private static final String PACKAGE_NAME = "com.h2t.study";

    /**
     * 项目名
     */
    private static final String MODULE_NAME = "springboot-mybatisplus";

    /**
     * 代码生成路径
     */
    private static final String SAVE_DIR = "G:\\mp-test";

    /**
     * 代码注释作者
     */
    private static final String AUTHOR = "hetiantian";

    /**
     * 数据库基本信息
     * */
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";

    /**
     * 数据库名、密码
     */
    private static final String DATABASE = "rbac";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "daydayup01";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE
            + "?useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC&useSSL=false";

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //设置代码生成路径
        gc.setOutputDir(SAVE_DIR);
        //支持文件重写
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        //生成result map
        // XML ResultMap
        gc.setBaseResultMap(true);
        //生成java mysql字段映射
        // XML columList
        gc.setBaseColumnList(true);
        //设置注释作者
        gc.setAuthor(AUTHOR);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        dsc.setUrl(URL);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 全局大写命名 ORACLE 注意
        // strategy.setCapitalMode(true);
        // 此处可以修改为您的表前缀(生成时将其去除)
        //strategy.setTablePrefix(new String[]{"openapi_"});
        // strategy.setTablePrefix(new String[]{"mgc_theme_"});

        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);

        // 需要生成的表
        // strategy.setInclude(new String[] { "user" });
        // 排除生成的表
//        strategy.setExclude(new String[]{"y_copy_openapi_api", "y_copy_openapi_api_group",
//                "y_copyopenapi_api_param", "openapi_api_auth", "openapi_app_access"});

        // 自定义实体父类
//        strategy.setSuperEntityClass(PACKAGE_NAME + "." + MODULE_NAME + ".po.BaseLogicDeleteEntity");
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns(new String[]{"deleted", "gmt_create", "gmt_modified"});

        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");

        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类

        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_NAME);
        pc.setModuleName(MODULE_NAME);
        pc.setEntity("po");
        pc.setXml("mapper");
        pc.setController("controller");
        pc.setService("service");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }
}
