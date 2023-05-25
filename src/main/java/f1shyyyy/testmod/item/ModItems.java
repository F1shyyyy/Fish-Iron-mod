package f1shyyyy.testmod.item;

import f1shyyyy.testmod.TestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FISHIRON = registerItem("fish-iron",
            new Item(new FabricItemSettings()));
    public static final Item RAW_FISHIRON = registerItem("raw_fish-iron",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void  addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, FISHIRON);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_FISHIRON);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        addItemsToItemGroup();
    }

}
