

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the ad_table_sequences database table.
 * 
 */
@Entity
@Table(name="ad_table_sequences")
public class AdTableSequence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="TS_SEQUENCE_NAME")
	private String tsSequenceName;

	@Column(name="TS_SEQUENCE_VALUE")
	private BigInteger tsSequenceValue;

    public AdTableSequence() {
    }

	public String getTsSequenceName() {
		return this.tsSequenceName;
	}

	public void setTsSequenceName(String tsSequenceName) {
		this.tsSequenceName = tsSequenceName;
	}

	public BigInteger getTsSequenceValue() {
		return this.tsSequenceValue;
	}

	public void setTsSequenceValue(BigInteger tsSequenceValue) {
		this.tsSequenceValue = tsSequenceValue;
	}

}