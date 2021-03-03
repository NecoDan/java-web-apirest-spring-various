package br.com.curso.web.apirest.spring.various.config;

//@Configuration
//@Slf4j
public class DataSourceConfig {

//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.driver-class-name:oracle.jdbc.pool.OracleDataSource}")
//    private String driverClassName;
//
//    @Primary
//    @Bean(name = "datasource")
//    public DataSource datasource() throws SQLException {
//        PoolDataSource pds = null;
//        try {
//            pds = PoolDataSourceFactory.getPoolDataSource();
//
//            pds.setConnectionFactoryClassName(driverClassName);
//            pds.setURL(url);
//            pds.setUser(username);
//            pds.setPassword(password);
//            pds.setInitialPoolSize(10);
//
//        } catch (SQLException ea) {
//            log.error("{}", "Error connecting to the database: " + ea.getMessage());
//        }
//
//        return pds;
//    }
//
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                       @Qualifier("datasource") DataSource dataSource) {
//        HashMap<String, Object> properties = new LinkedHashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "none");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//        return builder.dataSource(dataSource).properties(properties)
//                .packages("br.com.telefonica.jarvis.api.apuracao.*.model")
//                .build();
//    }
//
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
}
