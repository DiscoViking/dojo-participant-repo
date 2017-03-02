package tell.dont.ask;

import org.immutables.value.Value;

/**
 * Created by paulg on 3/2/17.
 */

@Value.Immutable
public interface Phone {
    @Value.Parameter
    String phoneNumber();

    default boolean isMobile() {
        return isValid() && phoneNumber().startsWith("07");
    }

    default boolean isLandLine() {
        return isValid() && !isMobile();
    }

    default boolean isValid() {
        return (phoneNumber() != null) && (phoneNumber().length() == 11);
    }
}
