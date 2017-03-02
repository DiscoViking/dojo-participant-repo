package tell.dont.ask;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Email}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEmail.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableEmail.of()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Email"})
public final class ImmutableEmail implements Email {
  private final String emailAddress;

  private ImmutableEmail(String emailAddress) {
    this.emailAddress = Objects.requireNonNull(emailAddress, "emailAddress");
  }

  private ImmutableEmail(ImmutableEmail original, String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * @return The value of the {@code emailAddress} attribute
   */
  @Override
  public String emailAddress() {
    return emailAddress;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Email#emailAddress() emailAddress} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for emailAddress
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEmail withEmailAddress(String value) {
    if (this.emailAddress.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "emailAddress");
    return new ImmutableEmail(this, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEmail} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEmail
        && equalTo((ImmutableEmail) another);
  }

  private boolean equalTo(ImmutableEmail another) {
    return emailAddress.equals(another.emailAddress);
  }

  /**
   * Computes a hash code from attributes: {@code emailAddress}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + emailAddress.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Email} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Email{"
        + "emailAddress=" + emailAddress
        + "}";
  }

  /**
   * Construct a new immutable {@code Email} instance.
   * @param emailAddress The value for the {@code emailAddress} attribute
   * @return An immutable Email instance
   */
  public static ImmutableEmail of(String emailAddress) {
    return new ImmutableEmail(emailAddress);
  }

  /**
   * Creates an immutable copy of a {@link Email} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Email instance
   */
  public static ImmutableEmail copyOf(Email instance) {
    if (instance instanceof ImmutableEmail) {
      return (ImmutableEmail) instance;
    }
    return ImmutableEmail.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEmail ImmutableEmail}.
   * @return A new ImmutableEmail builder
   */
  public static ImmutableEmail.Builder builder() {
    return new ImmutableEmail.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEmail ImmutableEmail}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_EMAIL_ADDRESS = 0x1L;
    private long initBits = 0x1L;

    private String emailAddress;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Email} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Email instance) {
      Objects.requireNonNull(instance, "instance");
      emailAddress(instance.emailAddress());
      return this;
    }

    /**
     * Initializes the value for the {@link Email#emailAddress() emailAddress} attribute.
     * @param emailAddress The value for emailAddress 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder emailAddress(String emailAddress) {
      this.emailAddress = Objects.requireNonNull(emailAddress, "emailAddress");
      initBits &= ~INIT_BIT_EMAIL_ADDRESS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableEmail ImmutableEmail}.
     * @return An immutable instance of Email
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEmail build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEmail(null, emailAddress);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_EMAIL_ADDRESS) != 0) attributes.add("emailAddress");
      return "Cannot build Email, some of required attributes are not set " + attributes;
    }
  }
}
