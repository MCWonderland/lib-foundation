package org.mineacademy.fo.menu.config;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.model.ConfigItem;
import org.mineacademy.fo.settings.YamlConfig;

@Getter
public class MenuSection extends YamlConfig {

    private final String path;
    private final String title;
    private final int rows;
    private final int size;

    public MenuSection(String file, String sectionPrefix) {
        setPathPrefix(sectionPrefix);

        loadConfiguration(file);

        this.path = sectionPrefix;
        this.title = getString("Title");
        this.rows = getInteger("Rows");
        this.size = rows * 9;

        save();
    }

    public ItemStack getButtonItem(String buttonName) {
        return getConfigItem(buttonName).getItem();
    }

    public ConfigItem getConfigItem(String buttonName) {

        ConfigItem configItem = new ConfigItem(new ItemPath(getFileName(), getPathPrefix() + ".Buttons." + buttonName));

        return configItem;
    }

}
