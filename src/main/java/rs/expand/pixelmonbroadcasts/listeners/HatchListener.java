// Listens for Pokémon hatching from eggs.
package rs.expand.pixelmonbroadcasts.listeners;

// Remote imports.
import com.pixelmonmod.pixelmon.api.events.EggHatchEvent;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// Local imports.
import static rs.expand.pixelmonbroadcasts.PixelmonBroadcasts.*;
import static rs.expand.pixelmonbroadcasts.utilities.PrintingMethods.*;
import static rs.expand.pixelmonbroadcasts.utilities.PlaceholderMethods.*;

public class HatchListener
{
    @SubscribeEvent
    public void onHatchEvent(final EggHatchEvent event)
    {
        // Create shorthand variables for convenience.
        final String broadcast;
        final EntityPlayer player = event.player;
        final BlockPos location = player.getPosition();
        final World world = player.getEntityWorld();
        final EntityPixelmon pokemon = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(event.nbt, world);

        if (pokemon.getIsShiny())
        {
            if (logShinyHatches)
            {
                // Print a hatch message to console.
                printBasicMessage
                (
                        "§5PBR §f// §dPlayer §5" + player.getName() +
                        "§d's shiny §5" + pokemon.getLocalizedName() +
                        "§d egg hatched in world \"§5" + world.getWorldInfo().getWorldName() +
                        "§d\" at X:§5" + location.getX() +
                        "§d Y:§5" + location.getY() +
                        "§d Z:§5" + location.getZ()
                );
            }

            if (showShinyHatches)
            {
                // Get a broadcast from the broadcasts config file, if the key can be found.
                broadcast = getBroadcast("broadcast.hatch.shiny");

                // Did we find a message? Iterate all available players, and send to those who should receive!
                if (broadcast != null)
                {
                    iterateAndSendBroadcast(broadcast, pokemon, player, hoverShinyHatches,
                            true, revealShinyHatches, "hatch.shiny", "showShinyHatch");
                }
            }
        }
        else
        {
            if (logNormalHatches)
            {
                // Print a hatch message to console.
                printBasicMessage
                (
                        "§5PBR §f// §dPlayer §5" + player.getName() +
                        "§d's normal §5" + pokemon.getLocalizedName() +
                        "§d egg hatched in world \"§5" + world.getWorldInfo().getWorldName() +
                        "§d\" at X:§5" + location.getX() +
                        "§d Y:§5" + location.getY() +
                        "§d Z:§5" + location.getZ()
                );
            }

            if (showNormalHatches)
            {
                // Get a broadcast from the broadcasts config file, if the key can be found.
                broadcast = getBroadcast("broadcast.hatch.normal");

                // Did we find a message? Iterate all available players, and send to those who should receive!
                if (broadcast != null)
                {
                    iterateAndSendBroadcast(broadcast, pokemon, player, hoverNormalHatches,
                            true, revealNormalHatches, "hatch.normal", "showNormalHatch");
                }
            }
        }
    }
}

