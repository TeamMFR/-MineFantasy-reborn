package minefantasy.mfr.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import minefantasy.mfr.MineFantasyReborn;
import minefantasy.mfr.util.FileUtils;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;

public abstract class DataLoader {

	private static final String JSON_FILE_EXT = "json";

	public void loadRegistry(String type, String defaultDirectory, String configDirectory) {
		MineFantasyReborn.LOG.info("Loading " + type + " registry entries from config directory");
		loadRegistryFiles(new File(configDirectory), "", type);

		MineFantasyReborn.LOG.info("Loading default " + type + " registry entries");
		loadRegistryFiles(Loader.instance().activeModContainer().getSource(), defaultDirectory, type);
	}

	protected void createCustomDataDirectory(String directory) {
		// create custom data dirs if they don't exist
		File existTest = new File(directory);
		if (!existTest.exists()) {
			existTest.mkdirs();
		}
	}

	public void loadRegistryFiles(File source, String base, String type) {

		FileUtils.findFiles(source, base, (root, file) -> {
			String relative = root.relativize(file).toString();

			String name = FilenameUtils.removeExtension(relative).replaceAll("\\\\", "/");

			String extension = FilenameUtils.getExtension(file.toString());

			if (extension.equals(JSON_FILE_EXT)) {

				try {

					Reader reader = Files.newBufferedReader((file.toAbsolutePath()));

					Gson gson = new Gson();
					JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

					processRegistryEntry(name, jsonObject);
				}

				catch (Exception e) {
					MineFantasyReborn.LOG.error("Error loading MFR " + type + " registry file " + relative);
					e.printStackTrace();
				}
			}
		});
	}

	protected abstract boolean processRegistryEntry(String name, JsonObject json);
}
