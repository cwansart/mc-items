package de.cwansart.mcitems;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Config {

    public static List<Item> getItemList() {
        Configuration configuration = new Configuration(new File(String.format("config/%s.cfg", McItems.MODID)));
        String[] defaultItemList = {
                "beastball_lid",
                "beastball_disc",
        };

        List<String> itemList;
        try {
            configuration.load();
            String category = "itemList";
            String key = "items";
            itemList = Arrays.asList(configuration.getStringList(key, category, defaultItemList, "Items that will be added."));
        } catch (Exception e) {
            System.err.printf("Failed to load %s's config file.%n", McItems.MODID);
            itemList = Arrays.asList(defaultItemList);
        } finally {
            configuration.save();
        }

        return itemList.stream()
                .map(item -> (new Item()).setRegistryName(McItems.MODID, item).setUnlocalizedName(item))
                .collect(Collectors.toList());
    }
}
