
package ai.genesis.runtime;
import ai.genesis.api.Brain;
public class DefaultBrain implements Brain{
 public String think(String input){ return "Processed: "+input; }
}
