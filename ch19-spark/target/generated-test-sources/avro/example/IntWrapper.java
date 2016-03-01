/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package example;  
@SuppressWarnings("all")
/** A record with a single int value field. */
@org.apache.avro.specific.AvroGenerated
public class IntWrapper extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"IntWrapper\",\"namespace\":\"example\",\"doc\":\"A record with a single int value field.\",\"fields\":[{\"name\":\"value\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public IntWrapper() {}

  /**
   * All-args constructor.
   */
  public IntWrapper(java.lang.Integer value) {
    this.value = value;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return value;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: value = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'value' field.
   */
  public java.lang.Integer getValue() {
    return value;
  }

  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(java.lang.Integer value) {
    this.value = value;
  }

  /** Creates a new IntWrapper RecordBuilder */
  public static example.IntWrapper.Builder newBuilder() {
    return new example.IntWrapper.Builder();
  }
  
  /** Creates a new IntWrapper RecordBuilder by copying an existing Builder */
  public static example.IntWrapper.Builder newBuilder(example.IntWrapper.Builder other) {
    return new example.IntWrapper.Builder(other);
  }
  
  /** Creates a new IntWrapper RecordBuilder by copying an existing IntWrapper instance */
  public static example.IntWrapper.Builder newBuilder(example.IntWrapper other) {
    return new example.IntWrapper.Builder(other);
  }
  
  /**
   * RecordBuilder for IntWrapper instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<IntWrapper>
    implements org.apache.avro.data.RecordBuilder<IntWrapper> {

    private int value;

    /** Creates a new Builder */
    private Builder() {
      super(example.IntWrapper.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(example.IntWrapper.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.value)) {
        this.value = data().deepCopy(fields()[0].schema(), other.value);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing IntWrapper instance */
    private Builder(example.IntWrapper other) {
            super(example.IntWrapper.SCHEMA$);
      if (isValidValue(fields()[0], other.value)) {
        this.value = data().deepCopy(fields()[0].schema(), other.value);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'value' field */
    public java.lang.Integer getValue() {
      return value;
    }
    
    /** Sets the value of the 'value' field */
    public example.IntWrapper.Builder setValue(int value) {
      validate(fields()[0], value);
      this.value = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'value' field has been set */
    public boolean hasValue() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'value' field */
    public example.IntWrapper.Builder clearValue() {
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public IntWrapper build() {
      try {
        IntWrapper record = new IntWrapper();
        record.value = fieldSetFlags()[0] ? this.value : (java.lang.Integer) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}