package kr.seok.generic.config;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationRawTypeHelper {

    public Object createConfiguration(ArrayList data) {
        ConfigCreator configCreator = new ConfigCreator();
        return configCreator.createConfig(data);
    }

    public Object createConfiguration(List data) {
        ConfigCreator configCreator = new ConfigCreator();
        return configCreator.createConfig(data);
    }
}
