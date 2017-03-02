package tell.dont.ask;

import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Patient}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePatient.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutablePatient.of()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Patient"})
public final class ImmutablePatient implements Patient {
  private final Email email;
  private final Phone phone;

  private ImmutablePatient(Optional<Email> email, Optional<Phone> phone) {
    this.email = email.orElse(null);
    this.phone = phone.orElse(null);
  }

  private ImmutablePatient(ImmutablePatient original, Email email, Phone phone) {
    this.email = email;
    this.phone = phone;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @Override
  public Optional<Email> email() {
    return Optional.ofNullable(email);
  }

  /**
   * @return The value of the {@code phone} attribute
   */
  @Override
  public Optional<Phone> phone() {
    return Optional.ofNullable(phone);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Patient#email() email} attribute.
   * @param value The value for email
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatient withEmail(Email value) {
    Email newValue = Objects.requireNonNull(value, "email");
    if (this.email == newValue) return this;
    return new ImmutablePatient(this, newValue, this.phone);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Patient#email() email} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for email
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatient withEmail(Optional<? extends Email> optional) {
    Email value = optional.orElse(null);
    if (this.email == value) return this;
    return new ImmutablePatient(this, value, this.phone);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Patient#phone() phone} attribute.
   * @param value The value for phone
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatient withPhone(Phone value) {
    Phone newValue = Objects.requireNonNull(value, "phone");
    if (this.phone == newValue) return this;
    return new ImmutablePatient(this, this.email, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Patient#phone() phone} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for phone
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePatient withPhone(Optional<? extends Phone> optional) {
    Phone value = optional.orElse(null);
    if (this.phone == value) return this;
    return new ImmutablePatient(this, this.email, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePatient} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePatient
        && equalTo((ImmutablePatient) another);
  }

  private boolean equalTo(ImmutablePatient another) {
    return Objects.equals(email, another.email)
        && Objects.equals(phone, another.phone);
  }

  /**
   * Computes a hash code from attributes: {@code email}, {@code phone}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(email);
    h += (h << 5) + Objects.hashCode(phone);
    return h;
  }

  /**
   * Prints the immutable value {@code Patient} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Patient{");
    if (email != null) {
      builder.append("email=").append(email);
    }
    if (phone != null) {
      if (builder.length() > 8) builder.append(", ");
      builder.append("phone=").append(phone);
    }
    return builder.append("}").toString();
  }

  /**
   * Construct a new immutable {@code Patient} instance.
   * @param email The value for the {@code email} attribute
   * @param phone The value for the {@code phone} attribute
   * @return An immutable Patient instance
   */
  public static ImmutablePatient of(Optional<Email> email, Optional<Phone> phone) {
    return new ImmutablePatient(email, phone);
  }

  /**
   * Creates an immutable copy of a {@link Patient} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Patient instance
   */
  public static ImmutablePatient copyOf(Patient instance) {
    if (instance instanceof ImmutablePatient) {
      return (ImmutablePatient) instance;
    }
    return ImmutablePatient.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePatient ImmutablePatient}.
   * @return A new ImmutablePatient builder
   */
  public static ImmutablePatient.Builder builder() {
    return new ImmutablePatient.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePatient ImmutablePatient}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private Email email;
    private Phone phone;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Patient} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Patient instance) {
      Objects.requireNonNull(instance, "instance");
      Optional<Email> emailOptional = instance.email();
      if (emailOptional.isPresent()) {
        email(emailOptional);
      }
      Optional<Phone> phoneOptional = instance.phone();
      if (phoneOptional.isPresent()) {
        phone(phoneOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link Patient#email() email} to email.
     * @param email The value for email
     * @return {@code this} builder for chained invocation
     */
    public final Builder email(Email email) {
      this.email = Objects.requireNonNull(email, "email");
      return this;
    }

    /**
     * Initializes the optional value {@link Patient#email() email} to email.
     * @param email The value for email
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder email(Optional<? extends Email> email) {
      this.email = email.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link Patient#phone() phone} to phone.
     * @param phone The value for phone
     * @return {@code this} builder for chained invocation
     */
    public final Builder phone(Phone phone) {
      this.phone = Objects.requireNonNull(phone, "phone");
      return this;
    }

    /**
     * Initializes the optional value {@link Patient#phone() phone} to phone.
     * @param phone The value for phone
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder phone(Optional<? extends Phone> phone) {
      this.phone = phone.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutablePatient ImmutablePatient}.
     * @return An immutable instance of Patient
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePatient build() {
      return new ImmutablePatient(null, email, phone);
    }
  }
}
