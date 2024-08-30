package minefantasy.mfr.registry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import minefantasy.mfr.api.heating.ForgeFuel;
import minefantasy.mfr.constants.Constants;
import minefantasy.mfr.util.FileUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ForgeFuelRegistry extends DataLoader {

    public static List<ForgeFuel> forgeFuel = new ArrayList<>();
    private static final String FORGE_FUEL_TYPES = "forge_fuel_types";

    public static final ForgeFuelRegistry INSTANCE = new ForgeFuelRegistry();

    private static final String TYPE = "forge fuel";
    private static final String DEFAULT_RECIPE_DIRECTORY = "assets/" + Constants.ASSET_DIRECTORY +"/registry";
    private static final String CUSTOM_RECIPE_DIRECTORY = "config/" + Constants.CONFIG_DIRECTORY +"/custom/registry";

    public void preInit() {
        createCustomDataDirectory(CUSTOM_RECIPE_DIRECTORY);
        loadRegistry(TYPE, DEFAULT_RECIPE_DIRECTORY, CUSTOM_RECIPE_DIRECTORY);
    }

    public void loadRegistryFiles(File source, String base, String type) {
        FileUtils.findFiles(source, base, (root, file) -> {
            String extension = FilenameUtils.getExtension(file.toString());

            if (!extension.equals(JSON_FILE_EXT)) {
                return;
            }

            Path relative = root.relativize(file);
            if (relative.getNameCount() > 1) {
                String modName = relative.getName(0).toString();
                String fileName = FilenameUtils.removeExtension(relative.getFileName().toString());

                if (!Loader.isModLoaded(modName) || !fileName.equals(FORGE_FUEL_TYPES)) {
                    return;
                }

                JsonObject jsonObject = fileToJsonObject(file, relative, type);
                parse(fileName, jsonObject);
            }
        });
    }

    @Override
    protected void parse(String name, JsonObject json) {
        JsonArray fuels = JsonUtils.getJsonArray(json, "fuels");

        for (JsonElement e : fuels) {
            JsonObject fuel = JsonUtils.getJsonObject(e, "");
            parseFuel(fuel);
        }
    }

    private void parseFuel(JsonObject json) {
        String name = JsonUtils.getString(json, "name");

        Item item = Item.getByNameOrId(JsonUtils.getString(json, "inputItem"));
        int inputItemMeta = JsonUtils.getInt(json, "inputItemMeta");
        ItemStack itemStack = new ItemStack(item, 1, inputItemMeta);

        JsonObject properties = JsonUtils.getJsonObject(json, "properties");
        float duration = JsonUtils.getFloat(properties, "duration");
        int baseHeat = JsonUtils.getInt(properties, "base_heat");
        boolean doesLight = JsonUtils.getBoolean(properties, "does_light");
        boolean isRefined = JsonUtils.getBoolean(properties, "is_refined");
        ForgeFuel fuel = new ForgeFuel(name, itemStack, duration, baseHeat, doesLight, isRefined);
        forgeFuel.add(fuel);
    }
}