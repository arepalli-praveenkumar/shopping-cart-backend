/**
 * 
 */
package com.shoppingCartBe.models;

import java.math.BigInteger;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author praveen
 *
 */

@Document(collection = "customSequences")
public class CustomSequences {

	@Id
    private BigInteger _id;
	private String sequenceID ;
	private long seqenceNumber;
	
	
	
	/**
	 * @return the _id
	 */
	public BigInteger get_id() {
		return _id;
	}



	/**
	 * @param _id the _id to set
	 */
	public void set_id(BigInteger _id) {
		this._id = _id;
	}



	/**
	 * @return the sequenceID
	 */
	public String getSequenceID() {
		return sequenceID;
	}



	/**
	 * @param sequenceID the sequenceID to set
	 */
	public void setSequenceID(String sequenceID) {
		this.sequenceID = sequenceID;
	}



	/**
	 * @return the seqenceNumber
	 */
	public long getSeqenceNumber() {
		return seqenceNumber;
	}



	/**
	 * @param seqenceNumber the seqenceNumber to set
	 */
	public void setSeqenceNumber(long seqenceNumber) {
		this.seqenceNumber = seqenceNumber;
	}



	/**
	 * @param _id
	 * @param sequenceID
	 * @param seqenceNumber
	 */
	public CustomSequences(BigInteger _id, String sequenceID, long seqenceNumber) {
		super();
		this._id = _id;
		this.sequenceID = sequenceID;
		this.seqenceNumber = seqenceNumber;
	}
	
	
	
}
