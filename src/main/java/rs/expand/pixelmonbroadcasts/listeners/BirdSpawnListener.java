// Listens for people using bird shrines. Work in progress, currently commented out in production code.
package rs.expand.pixelmonbroadcasts.listeners;

// Remote imports.
import com.pixelmonmod.pixelmon.api.events.PlayerActivateShrineEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// Local imports.
//import static rs.expand.pixelmonbroadcasts.PixelmonBroadcasts.logBirdTrioSummons;
//import static rs.expand.pixelmonbroadcasts.PixelmonBroadcasts.showBirdTrioSummons;
import static rs.expand.pixelmonbroadcasts.utilities.PlaceholderMethods.iterateAndSendBroadcast;
import static rs.expand.pixelmonbroadcasts.utilities.PrintingMethods.getBroadcast;
import static rs.expand.pixelmonbroadcasts.utilities.PrintingMethods.printBasicMessage;

public class BirdSpawnListener
{
    /*@SubscribeEvent
    public void onActivateBirdShrineEvent(final PlayerActivateShrineEvent event)
    {
        // Create shorthand variables for convenience.
        final String broadcast;
        final EntityPlayer player = event.player;
        final String pokemonName = event.shrineType.name();
        final BlockPos location = event.player.getPosition();

        if (logBirdTrioSummons)
        {
            // Print a summon message to console.
            printBasicMessage
            (
                    "§5PBR §f// §ePlayer §6" + player.getName() +
                    "§e has summoned a §6" + pokemonName +
                    "§e in world \"§6" + player.getEntityWorld().getWorldInfo().getWorldName() +
                    "§e\", at X:§6" + location.getX() +
                    "§e Y:§6" + location.getY() +
                    "§e Z:§6" + location.getZ()
            );
        }

        if (showBirdTrioSummons)
        {
            // See which of the three birds we got.
            switch (event.shrineType)
            {
                case Articuno:
                    broadcast = getBroadcast("broadcast.summon.articuno"); break;
                case Moltres:
                    broadcast = getBroadcast("broadcast.summon.moltres"); break;
                default: // Three names in the enum, so just default to the rarest. Ensures a broadcast is always present.
                    broadcast = getBroadcast("broadcast.summon.zapdos"); break;
            }

            // Did we find a message? Iterate all available players, and send to those who should receive!
            if (broadcast != null)
            {
                iterateAndSendBroadcast(broadcast, null, player, false,
                        true, false, "summon.birdtrio", "showBirdTrioSummon");
            }
        }
    }*/
}
