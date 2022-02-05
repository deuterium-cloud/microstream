package cloud.deuterium.microstream.config;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;

import java.nio.file.Paths;

/**
 * Created by Milan Stojkovic 12-Oct-2021
 */
public class DB {

    public static DataRoot root = new DataRoot();
    public static EmbeddedStorageManager storageManager;
    private static final String LOCATION = "/volumes/microstream";

    static {
        DB.storageManager = EmbeddedStorage.start(
                DB.root,
                Paths.get(System.getenv("HOME") + DB.LOCATION)
        );
    }
}
