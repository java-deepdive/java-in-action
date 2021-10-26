package kr.seok.generic.config;

import java.util.List;

class ConfigCreator {

    Object createConfig(List<Config> configList) {
        configList.forEach(config ->
                System.out.println("config = " + config.getClass()));
        return configList;
    }

}