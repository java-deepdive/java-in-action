package kr.seok.generic.config;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationHelper {

//    public Object createConfiguration(List<Object> data) {
//        ConfigCreator configCreator = new ConfigCreator();
//        return configCreator.createConfig(data);
//    }

//    public Object createConfiguration(ArrayList<Object> data) {
//        ConfigCreator configCreator = new ConfigCreator();
//        return configCreator.createConfig(data);
//    }

//    public Object createConfiguration(ArrayList<DynamicConfig> data) {
//        ConfigCreator configCreator = new ConfigCreator();
//        return configCreator.createConfig(data);
//    }

    public Object createConfiguration(List<Config> data) {
        ConfigCreator configCreator = new ConfigCreator();
        return configCreator.createConfig(data);
    }

//    public Object createConfiguration(List<DynamicConfig> data) {
//        ConfigCreator configCreator = new ConfigCreator();
//        return configCreator.createConfig(data);
//    }

}
