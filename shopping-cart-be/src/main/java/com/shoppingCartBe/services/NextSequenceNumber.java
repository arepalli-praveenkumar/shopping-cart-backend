/**
 * 
 */
package com.shoppingCartBe.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.shoppingCartBe.models.CustomSequences;

/**
 * @author praveen
 *
 */
@Service
public class NextSequenceNumber {

	@Autowired
	private MongoOperations mongo;

	public long getNextSequence(String seqName) {

		System.out.println("###:" + seqName);
		CustomSequences counter = mongo.findAndModify(query(where("sequenceID").is(seqName)),
				new Update().inc("seqenceNumber", 1), options().returnNew(true).upsert(true), CustomSequences.class);

		return !Objects.isNull(counter) ? counter.getSeqenceNumber() : 1;

	}
}
