package tell.dont.ask;

import org.immutables.value.Value;

/**
 * Created by paulg on 3/2/17.
 */
@Value.Immutable
public interface Email {
    @Value.Parameter
    String emailAddress();

    default boolean isValid() { return emailAddress().contains("@"); }
}
