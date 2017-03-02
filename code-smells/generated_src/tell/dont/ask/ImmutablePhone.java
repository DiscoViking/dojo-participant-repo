package tell.dont.ask;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Phone}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePhone.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutablePhone.of()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Phone"})
public final class ImmutablePhone implements Phone {
  private final String phoneNumber;

  private ImmutablePhone(String phoneNumber) {
    this.phoneNumber = Objects.requireNonNull(phoneNumber, "phoneNumber");
  }

  private ImmutablePhone(ImmutablePhone original, String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return The value of the {@code phoneNumber} attribute
   */
  @Override
  public String phoneNumber() {
    return phoneNumber;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Phone#phoneNumber() phoneNumber} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for phoneNumber
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePhone withPhoneNumber(String value) {
    if (this.phoneNumber.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "phoneNumber");
    return new ImmutablePhone(this, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePhone} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePhone
        && equalTo((ImmutablePhone) another);
  }

  private boolean equalTo(ImmutablePhone another) {
    return phoneNumber.equals(another.phoneNumber);
  }

  /**
   * Computes a hash code from attributes: {@code phoneNumber}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + phoneNumber.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Phone} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Phone{"
        + "phoneNumber=" + phoneNumber
        + "}";
  }

  /**
   * Construct a new immutable {@code Phone} instance.
   * @param phoneNumber The value for the {@code phoneNumber} attribute
   * @return An immutable Phone instance
   */
  public static ImmutablePhone of(String phoneNumber) {
    return new ImmutablePhone(phoneNumber);
  }

  /**
   * Creates an immutable copy of a {@link Phone} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Phone instance
   */
  public static ImmutablePhone copyOf(Phone instance) {
    if (instance instanceof ImmutablePhone) {
      return (ImmutablePhone) instance;
    }
    return ImmutablePhone.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePhone ImmutablePhone}.
   * @return A new ImmutablePhone builder
   */
  public static ImmutablePhone.Builder builder() {
    return new ImmutablePhone.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePhone ImmutablePhone}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_PHONE_NUMBER = 0x1L;
    private long initBits = 0x1L;

    private String phoneNumber;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Phone} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Phone instance) {
      Objects.requireNonNull(instance, "instance");
      phoneNumber(instance.phoneNumber());
      return this;
    }

    /**
     * Initializes the value for the {@link Phone#phoneNumber() phoneNumber} attribute.
     * @param phoneNumber The value for phoneNumber 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = Objects.requireNonNull(phoneNumber, "phoneNumber");
      initBits &= ~INIT_BIT_PHONE_NUMBER;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePhone ImmutablePhone}.
     * @return An immutable instance of Phone
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePhone build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePhone(null, phoneNumber);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_PHONE_NUMBER) != 0) attributes.add("phoneNumber");
      return "Cannot build Phone, some of required attributes are not set " + attributes;
    }
  }
}
