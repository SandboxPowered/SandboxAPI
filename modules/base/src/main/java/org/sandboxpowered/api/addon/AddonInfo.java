package org.sandboxpowered.api.addon;

import com.electronwill.nightconfig.core.Config;
import com.github.zafarkhaja.semver.Version;
import org.sandboxpowered.api.util.Identity;

import java.util.List;
import java.util.Map;

public interface AddonInfo {
    /**
     * @return The ID of this addon.
     */
    String getId();

    /**
     * @return The version of this addon as SemVer.
     */
    Version getVersion();

    /**
     * @return The display name of this addon.
     */
    String getTitle();

    /**
     * @return The description of this addon.
     */
    String getDescription();

    /**
     * @return A list of the authors of this addon.
     */
    List<String> getAuthors();

    /**
     * @return The URL for the home page of this addon.
     */
    String getUrl();

    /**
     * @return The loading side of this addon.
     */
    LoadingSide getSide();

    /**
     * @return A map of the names and versions of all addons this addon has a dependency on.
     */
    Map<String, String> getDependencies();

    /**
     * @return Any custom properties this addon defines.
     */
    Config getCustomProperties();

    /**
     * @return A map of platform identities to definite support states.
     */
    Map<String, Boolean> getPlatforms();

    /**
     * @param platform The platform to test for.
     * @return The level of support this addon has for the given platform.
     */
    PlatformSupport getPlatformSupport(Identity platform);

}
