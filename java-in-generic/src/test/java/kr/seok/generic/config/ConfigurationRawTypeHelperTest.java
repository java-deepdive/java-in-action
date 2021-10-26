package kr.seok.generic.config;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ConfigurationRawTypeHelperTest {

    private final ConfigurationRawTypeHelper configurationHelper = new ConfigurationRawTypeHelper();

    @Test
    void testCase1() {
        ArrayList<DynamicConfig> configs = new ArrayList<>();
        configs.add(new DynamicConfig());
        configs.add(new DynamicConfig());
        configurationHelper.createConfiguration(configs);
    }

    @Test
    void testCase2() {
        ArrayList<Config> configs = new ArrayList<>();
        configs.add(new DynamicConfig());
        configs.add(new DynamicConfig());
        configurationHelper.createConfiguration(configs);
    }

//    @Test
//    void testCase3() {
//        List<Config> configs = new ArrayList<>();
//        configs.add(new DynamicConfig());
//        configs.add(new DynamicConfig());
//        configurationHelper.createConfiguration(configs);
//    }
//
//    @Test
//    void testCase4() {
//        List<DynamicConfig> configs = new ArrayList<>();
//        configs.add(new DynamicConfig());
//        configs.add(new DynamicConfig());
//        configurationHelper.createConfiguration(configs);
//    }
}